package br.com.ally.screenmatch.principal;

import br.com.ally.screenmatch.model.DadosEpisodio;
import br.com.ally.screenmatch.model.DadosSerie;
import br.com.ally.screenmatch.model.DadosTemporada;
import br.com.ally.screenmatch.model.Episodio;
import br.com.ally.screenmatch.service.ConsumoAPI;
import br.com.ally.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner =  new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConverteDados conversor = new ConverteDados();

    private final String ENDERECO;

    private final String APIKEY;

    public Principal() {
        ENDERECO = "https://www.omdbapi.com/?t=";
        APIKEY = "&apikey=f89702a4";
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da serie");
        var nomeSerie = scanner.nextLine();

        var json = consumoAPI.obterDadods(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i<= dados.totalTemporadas(); i++){
            json = consumoAPI.obterDadods(ENDERECO + nomeSerie.replace(" ", "+") +"&season="+i+ APIKEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

//        for(int i = 0; i<dados.totalTemporadas(); i++){
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for(int j = 0; j< episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\n top 5 episodios");

        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map( d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);
    }
}

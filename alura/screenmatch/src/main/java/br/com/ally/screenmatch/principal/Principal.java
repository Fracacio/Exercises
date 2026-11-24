package br.com.ally.screenmatch.principal;

import br.com.ally.screenmatch.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private Scanner scanner =  new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();

    private final String ENDERECO;

    private final String APIKEY;

    public Principal(String endereco, String apikey) {
        ENDERECO = "https://www.omdbapi.com/?t=";
        APIKEY = "&apikey=f89702a4";
    }

    public void exibeMenu(){
        System.out.println("Digite o nome da serie");
        var nomeSerie = scanner.nextLine();

        var json = consumoAPI.obterDadods(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
    }
}

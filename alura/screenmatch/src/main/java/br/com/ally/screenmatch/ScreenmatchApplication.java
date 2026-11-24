package br.com.ally.screenmatch;

import br.com.ally.screenmatch.model.DadosEpisodio;
import br.com.ally.screenmatch.model.DadosSerie;
import br.com.ally.screenmatch.service.ConsumoAPI;
import br.com.ally.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDadods("https://www.omdbapi.com/?t=gilmore+girls&apikey=f89702a4");

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoAPI.obterDadods("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=f89702a4");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}
}

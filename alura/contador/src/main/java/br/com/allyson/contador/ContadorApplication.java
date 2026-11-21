package br.com.allyson.contador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ContadorApplication implements CommandLineRunner {
	Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			SpringApplication.run(ContadorApplication.class, args);
		}

		@Override
		public void run(String... args){
			System.out.println("buft");
			int num = scanner.nextInt();

			if(num > 0) {
				for(int i = 1; i<=num; i++){
					System.out.println(i);
				}
			}
		}

}

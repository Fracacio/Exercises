package br.com.allyson.funcLambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@FunctionalInterface
interface Multiplicacao {
	int multiplicacao(int a, int b);
}

@FunctionalInterface
interface Primo {
	boolean primo(int n);
}

@SpringBootApplication
public class FuncLambdaApplication {

	public static void main(String[] args) {
		// Question 1
		Multiplicacao mult = (a,b) -> a * b;
		System.out.println(mult.multiplicacao(5,3));

		// Question 2
		Primo primo = (n) -> {
            return n % 2 != 0;
        };
		System.out.println(primo.primo(11));
		System.out.println(primo.primo(12));

	}

}

package br.com.allyson.funcLambda;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@FunctionalInterface
interface Multiplicacao {
	int multiplicacao(int a, int b);
}

@FunctionalInterface
interface Primo {
	boolean primo(int n);
}

@FunctionalInterface
interface ConverteMaiusculas {
	String converte(String f);
}

@SpringBootApplication
public class FuncLambdaApplication {

	public static void main(String[] args) {
		// Question 1
		Multiplicacao mult = (a,b) -> a * b;
		System.out.println(mult.multiplicacao(5,3));

		// Question 2
		Primo primo = (n) -> n % 2 != 0;
		System.out.println(primo.primo(11));
		System.out.println(primo.primo(12));

		// Question 3
		ConverteMaiusculas converteMaiusculas = (f -> f.toUpperCase(Locale.ROOT));
		System.out.println(converteMaiusculas.converte("cebola"));
	}

}

package br.com.allyson.funcLambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@FunctionalInterface
interface Multiplicacao {
	int multiplicacao(int a, int b);
}

@SpringBootApplication
public class FuncLambdaApplication {

	public static void main(String[] args) {
		Multiplicacao mult = (a,b) -> a * b;
		System.out.println(mult.multiplicacao(5,3));
	}

}

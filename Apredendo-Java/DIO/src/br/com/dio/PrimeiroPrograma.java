package br.com.dio;

import br.com.dio.model.Gato;

public class PrimeiroPrograma {

	public static void main(String[] args) {
		/*int a = 5;
		int b = 1;
		System.out.println("Hello Wordl! " + (a+b));*/
		
		Gato gato = new Gato();
		Livro livros =  new Livro();
		
		System.out.print(gato);
		System.out.print(livros);
	}

}

class Livro {
	private String nome;
	private String npag;
}
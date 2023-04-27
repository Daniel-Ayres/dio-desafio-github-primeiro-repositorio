package com.dio;

import com.dio.model.Gato;

public class PrimeiroPrograma {

	public static void main(String[] args) {
	
	 /*int a = 2;
	 int b = 3;
	 System.out.println("Hello Word!!" + (a+b));;*/
		
		Gato gato = new Gato();
		Livros livros  = new Livros();
		
		System.out.println(gato);
		System.out.println(livros);
	}

}

class Livros{
	private String nome;
	private String npag;
}
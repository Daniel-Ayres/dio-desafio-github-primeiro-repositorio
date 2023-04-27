package edu.daniel.segundasemana;

public class Usuario {
    public static void main (String [] args) throws Exception {
        SmartTv smartTv = new SmartTv();

        System.out.println("TV ligada ? " + smartTv.ligada);
        System.out.println("Canal Atual ? " + smartTv.canal);
        System.out.println("Volume atual ? " + smartTv.volume);
    }
}

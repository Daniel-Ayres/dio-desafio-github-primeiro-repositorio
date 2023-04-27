package edu.daniel.primeirasemana;
import javax.lang.model.util.ElementScanner6;

public class BoletimEstudantil {
    public static void main(String[] args) throws Exception {   
    
        int mediaFinal  = 8;
   
        if(mediaFinal<6)
        System.out.println("REPROVADO!!");
    
        else if(mediaFinal==6)
         System.out.println("PROVA MINERVA");
    
         else 
        System.out.println("APROVADO");
    }
}

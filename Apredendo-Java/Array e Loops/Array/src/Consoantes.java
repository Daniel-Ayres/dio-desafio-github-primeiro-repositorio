/*
Faça um Programa que leia um vetor de 6 caracteres,
e diga quantas consoantes foram lidas.
Imprima as consoantes.
*/
import java.util.Scanner;

public class Consoantes {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); //Abertura da entrada de fluxo de dados através do teclado
       
        String[] consoantes = new String[6]; //iniciando um arrays vazio com 6 posições

        int count = 0; //controla o loop
        int quantidadeDeConsoantes = 0; //armazena a quantidade de consoantes

        //loop
       
        do {
            System.out.print("Letra: "); //Peça uma letra e ira ler a letra
           
            String letra = scan.next(); //capture essa letra e atrubua a variável letra. Independente de ser vogal ou consoante

            //verificando se a  letra informada não e igual as vogais a, e, i, o ,u
            if (!(letra.equalsIgnoreCase("a") |
                    letra.equalsIgnoreCase("e") |
                    letra.equalsIgnoreCase("i") |
                    letra.equalsIgnoreCase("o") |
                    letra.equalsIgnoreCase("u"))) {
               
            /* caso a letra inserida pelo usuario 
            ela for consoante,a varial consoante 
            recebera a letra,e a variavel 
            quantidaDeConsoantes que foi 
            iniciada com  0 ,ira inserir 
            mais 1 cada consoante inserida pelo usuario .*/

                consoantes[count] = letra;
                quantidadeDeConsoantes++;
            }
            count++; //acrescente o valor 1 ao contador a cada loop
        } while (count < consoantes.length); //enquanto o contador tiver o valor menor que o tamanho do array

        System.out.print("Consoantes: "); //frase ilustrativa
        
        for (String consoante : consoantes) { //para cada consoante dentro do array consoantes
            
            if (consoante != null) //se o valor da consoante for diferente de null
                System.out.print(consoante + " "); //imprima a consoante
        }
        System.out.println("Quantidade de consoantes: " + quantidadeDeConsoantes);
    }
}
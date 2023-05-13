import javax.sound.sampled.SourceDataLine;

public class CaixaEletronico {
    public static void main(String[] args) {
        
        double saldo = 25.0;
        double valorSolicitado = 17.0;

        if (valorSolicitado < saldo){
            saldo = saldo - valorSolicitado;

            System.out.println("O seu saldo bancario e : " + saldo );
        }
    } 
     System.out.println("O seu saldo e de :  " + saldo);
}

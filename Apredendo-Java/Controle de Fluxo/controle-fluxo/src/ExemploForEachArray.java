
public class ExemploForEachArray {
    public static void main(String[] args) {
        
        // Define um array de strings com quatro nomes de alunos
        String alunos [] = {"Felipe" , "Carlos" , "João " ,"Andre"};
        
        // Usa o loop foreach para percorrer cada elemento do array
        for (String aluno : alunos) {
           
            // Imprime uma mensagem com o nome do aluno atual
            System.out.println("Nome do aluno é : " + aluno);
        }
    }
}

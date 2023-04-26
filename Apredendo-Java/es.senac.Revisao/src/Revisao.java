
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Professor;
import dao.ProfessorDAO;
import model.Aluno;
import dao.AlunoDAO;

public class Revisao {
/*
    public static void main(String[] args) {
        Matricula mat = new Matricula();
        mat.setIdAluno(1);
        mat.setIdCurso(2);
        mat.setValor(225);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataMatricula;
        try {
            dataMatricula = sdf.parse("05/01/2021");
            mat.setDataMatricula(dataMatricula);
        } catch (Exception e) {
            System.out.println("Erro ao formatar a data!");
        }
        
        mat.setIdMatricula(4);
        
        MatriculaDAO dao = new MatriculaDAO();
        if (dao.update(mat)) {
            System.out.println("Matricula deletada com sucesso!");
        } else {
            System.out.println("Ops...Algo deu errado");
        }*/
    
    /*public static void main(String[] args) {

         AlunoDAO dao = new AlunoDAO();
    dao.read().forEach((aluno) -> {
        System.out.println("ID: " + aluno.getIdAluno());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("E-mail: " + aluno.getEmail());
    });
    }*/
    
    public static void main(String[] args) {

        ProfessorDAO dao = new ProfessorDAO();
        dao.read().forEach((professor) -> {
        System.out.println("ID: " + professor.getIdProfessor());
        System.out.println("Nome: " + professor.getNome());
        System.out.println("E-mail: " + professor.getEmail());
    });
    }
    
}
    

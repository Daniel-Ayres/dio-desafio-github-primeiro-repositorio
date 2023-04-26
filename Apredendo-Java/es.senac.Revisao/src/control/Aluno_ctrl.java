
package control;

import dao.AlunoDAO;
import java.util.List;
import model.Aluno;



public class Aluno_ctrl {
    
    public List<Aluno> select_all(){
        AlunoDAO dao = new AlunoDAO();
        return dao.read();
    } 
    public boolean validarDados(Aluno alu) {
        return !alu.getNome().isEmpty() &&
                !alu.getEmail().isEmpty() &&
                !alu.getTelefone().isEmpty() &&
                alu.getIdade() > 0;
    }
    
    public boolean salvarDados(Aluno alu) {
        boolean resp = false;
        if (validarDados(alu)) {
            resp = true;
            AlunoDAO dao = new AlunoDAO();
            resp=dao.create(alu);
        }
        return resp;
    }
}




package control;

import dao.ProfessorDAO;
import java.util.List;
import model.Professor;


public class Professor_ctrl {
     public List<Professor>  select_all(){
         ProfessorDAO dao = new ProfessorDAO();
        return dao.read();
    }  
}

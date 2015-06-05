/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.beans;

import com.jacksonf.bl.ProfessorBL;
import com.jacksonf.domain.Professor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean
@SessionScoped
public class ProfessorBean {

    private Professor professor;
    private final ProfessorBL professorBL;

    public ProfessorBean() throws Exception {
        this.professor = new Professor();
        this.professorBL = new ProfessorBL();
    }
    
   
    public List<Professor> listaProfessor() {        
        try {
            return professorBL.listar(professor);
        } catch(Exception e) {
            //Mensagem.error(e.getMessage());
            throw e;
        }        
    }
    

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String NovoProfessor() {
        this.professor = new Professor();
        return "editProfessor";
    }

    public String EditarProfessor(int id) {
        professor = professorBL.getById(id);
        return "editProfessor";
    }

    public String ExcluirProfessor(int id) {
        professorBL.excluir(professorBL.getById(id));
        return "professores";
    }

    public String PostProfessor() {
        professorBL.salvar(professor);    
        professor = new Professor();
        return "professores";
    }

}

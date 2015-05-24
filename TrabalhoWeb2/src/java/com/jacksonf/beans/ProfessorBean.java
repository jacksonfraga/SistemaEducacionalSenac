/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.beans;

import com.jacksonf.domain.Professor;
import java.util.ArrayList;
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
    private ArrayList<Professor> listaProfessor;
    

    public ArrayList<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(ArrayList<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }    
    
    public ProfessorBean() {
        this.professor = new Professor();
        this.listaProfessor = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Professor tmp = new Professor();
            tmp.setNome("Professor " + i);
            tmp.setId(listaProfessor.size() + 1);
            listaProfessor.add(tmp);
            
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public String NovoProfessor()
    {
        this.professor = new Professor();
        return "editProfessor";
    }
    
    public String EditarProfessor(int id)
    {        
        for (Professor item : listaProfessor) {
            if (item.getId() == id) {
                professor = item;
                return "editProfessor";
            }
        }
        return "editProfessor";        
    }
    
    public String ExcluirProfessor(int id)
    {        
        for (Professor item : listaProfessor) {
            if (item.getId() == id) {
                listaProfessor.remove(item);
                return "professors";
            }
        }
        return "professors";        
    }
    
    public String PostProfessor()
    {       
        if (professor.getId() == 0)
        {    
            professor.setId(listaProfessor.size() + 1);
            listaProfessor.add(professor);
        }
        return "professors";
    }
    
}

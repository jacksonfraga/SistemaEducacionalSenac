/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.beans;

import com.jacksonf.domain.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jackson
 */
@ManagedBean
@SessionScoped
public class AlunoBean {

    private Aluno aluno;
    private ArrayList<Aluno> listaAluno;
    

    public ArrayList<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(ArrayList<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }    
    
    public AlunoBean() {
        this.aluno = new Aluno();
        this.listaAluno = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Aluno tmp = new Aluno();
            tmp.setNome("Aluno " + i);
            tmp.setId(listaAluno.size() + 1);
            listaAluno.add(tmp);
            
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public String NovoAluno()
    {
        this.aluno = new Aluno();
        return "editAluno";
    }
    
    public String EditarAluno(int id)
    {        
        for (Aluno item : listaAluno) {
            if (item.getId() == id) {
                aluno = item;
                return "editAluno";
            }
        }
        return "editAluno";        
    }
    
    public String ExcluirAluno(int id)
    {        
        for (Aluno item : listaAluno) {
            if (item.getId() == id) {
                listaAluno.remove(item);
                return "alunos";
            }
        }
        return "alunos";        
    }
    
    public String PostAluno()
    {       
        if (aluno.getId() == 0)
        {    
            aluno.setId(listaAluno.size() + 1);
            listaAluno.add(aluno);
        }
        return "alunos";
    }
    
}

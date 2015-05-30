/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.beans;

import com.jacksonf.bl.AlunoBL;
import com.jacksonf.domain.Aluno;
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
    private final AlunoBL alunoBL;

    public AlunoBean() throws Exception {
        this.aluno = new Aluno();
        this.alunoBL = new AlunoBL();
    }
    
   
    public List<Aluno> listaAluno() {        
        try {
            return alunoBL.listar(aluno);
        } catch(Exception e) {
            //Mensagem.error(e.getMessage());
            throw e;
        }        
    }
    

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String NovoAluno() {
        this.aluno = new Aluno();
        return "editAluno";
    }

    public String EditarAluno(int id) {
        aluno = alunoBL.getById(id);
        return "editAluno";
    }

    public String ExcluirAluno(int id) {
        alunoBL.excluir(alunoBL.getById(id));
        return "alunos";
    }

    public String PostAluno() {
        alunoBL.salvar(aluno);    
        aluno = new Aluno();
        return "alunos";
    }

}

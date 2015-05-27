/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.dao;

import com.jacksonf.domain.Aluno;
import com.jacksonf.utils.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jackson
 */
public class AlunoDAO implements CrudGenerico<Aluno>  {

    private EntityManager em;

    public AlunoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ImobMVCJPAPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public void salvar(Aluno bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Aluno bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Aluno> listar(Aluno bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno consultar(Aluno bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

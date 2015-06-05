/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.dao;

import com.jacksonf.domain.Professor;
import com.jacksonf.utils.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 631210442
 */
public class ProfessorDAO implements CrudGenerico<Professor> {

    private EntityManager em;

    public ProfessorDAO() throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisEduPU");

            em = emf.createEntityManager();
        } catch (Exception e) {
            throw new Exception(String.format(">>>>>>>>>>>>> ERRO : %1$s", e.getMessage()));

        }

    }

    @Override
    public void salvar(Professor bean) {
        em.getTransaction().begin();
        try {
            em.merge(bean);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void excluir(Professor bean) {
        em.getTransaction().begin();        
        em.remove(getById(bean.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Professor> listar(Professor bean) {
        StringBuilder sb = new StringBuilder("select a from Professor a where 1=1");

        if (bean.getId() != 0) {
            sb.append("\r\nand a.id = :id");
        }

        if (bean.getNome() != null && !bean.getNome().isEmpty()) {
            sb.append("\r\nand a.nome = :nome");
        }

        sb.append("\r\norder by a.nome");

        Query qry = em.createQuery(sb.toString());

        if (bean.getId() != 0) {
            qry.setParameter("id", bean.getId());
        }

        if (bean.getNome() != null && !bean.getNome().isEmpty()) {
            qry.setParameter("nome", bean.getNome());
        }

        return qry.getResultList();
    }

    @Override
    public Professor consultar(Professor bean) {
        //return em.find(Professor.class, bean.getId()); 
        return getById(bean.getId());
    }

    public Professor getById(int id) {
        return em.find(Professor.class, id);
    }

}

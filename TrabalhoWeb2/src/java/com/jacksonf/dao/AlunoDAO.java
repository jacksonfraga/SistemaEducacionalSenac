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
import javax.persistence.Query;

/**
 *
 * @author Jackson
 */
public class AlunoDAO implements CrudGenerico<Aluno> {

    private EntityManager em;

    public AlunoDAO() throws Exception {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SisEduPU");

            em = emf.createEntityManager();
        } catch (Exception e) {
            throw new Exception(String.format(">>>>>>>>>>>>> ERRO : %1$s", e.getMessage()));

        }

    }

    @Override
    public void salvar(Aluno bean) {
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
    public void excluir(Aluno bean) {
        em.getTransaction().begin();
        //em.remove(em.find(Aluno.class, bean.getId()));
        em.remove(getById(bean.getId()));
        em.getTransaction().commit();
    }

    @Override
    public List<Aluno> listar(Aluno bean) {
        StringBuilder sb = new StringBuilder("select a from Aluno a where 1=1");

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
    public Aluno consultar(Aluno bean) {
        //return em.find(Aluno.class, bean.getId()); 
        return getById(bean.getId());
    }

    public Aluno getById(int id) {
        return em.find(Aluno.class, id);
    }

}

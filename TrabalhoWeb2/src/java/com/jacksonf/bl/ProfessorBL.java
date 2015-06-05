/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.bl;

import com.jacksonf.dao.ProfessorDAO;
import com.jacksonf.domain.Professor;
import com.jacksonf.utils.CrudGenerico;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class ProfessorBL implements CrudGenerico<Professor>{

    private ProfessorDAO alunoDAO;

    public ProfessorBL() throws Exception {
        alunoDAO = new ProfessorDAO();
    }
    
    
    
    @Override
    public void salvar(Professor bean) {
        alunoDAO.salvar(bean);
    }

    @Override
    public void excluir(Professor bean) {
        alunoDAO.excluir(bean);
    }

    @Override
    public List<Professor> listar(Professor bean) {
        return alunoDAO.listar(bean);
    }

    @Override
    public Professor consultar(Professor bean) {
        return alunoDAO.consultar(bean);
    }
    
    public Professor getById(int id) {
        return alunoDAO.getById(id);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.bl;

import com.jacksonf.dao.AlunoDAO;
import com.jacksonf.domain.Aluno;
import com.jacksonf.utils.CrudGenerico;
import java.util.List;

/**
 *
 * @author Jackson
 */
public class AlunoBL implements CrudGenerico<Aluno>{

    private AlunoDAO alunoDAO;

    public AlunoBL() throws Exception {
        alunoDAO = new AlunoDAO();
    }
    
    
    
    @Override
    public void salvar(Aluno bean) {
        alunoDAO.salvar(bean);
    }

    @Override
    public void excluir(Aluno bean) {
        alunoDAO.excluir(bean);
    }

    @Override
    public List<Aluno> listar(Aluno bean) {
        return alunoDAO.listar(bean);
    }

    @Override
    public Aluno consultar(Aluno bean) {
        return alunoDAO.consultar(bean);
    }
    
    public Aluno getById(int id) {
        return alunoDAO.getById(id);
    }
    
    
}

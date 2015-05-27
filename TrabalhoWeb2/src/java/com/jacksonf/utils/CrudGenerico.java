/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.utils;


import java.util.List;

/**
 *
 * @author Jackson
 * @param <T>
 */

public interface CrudGenerico<T> {
    
    public void salvar(T bean);
    public void excluir(T bean);
    public List<T> listar(T bean);
    public T consultar(T bean);
    
}

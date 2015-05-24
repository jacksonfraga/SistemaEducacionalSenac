/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jacksonf.beans;

import com.jacksonf.domain.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 631210442
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuario;

    public UsuarioBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String Login() {
        if (usuario.getUsernumber().equals("admin") && usuario.getPassword().equals("admin"))
            return "admin";
        else
            return "index?auth=false";

    }

}

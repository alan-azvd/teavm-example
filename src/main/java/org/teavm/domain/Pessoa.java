/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teavm.domain;

/**
 *
 * @author alan
 */
public class Pessoa {
    
    private String nome;
    private String email;
    
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }    
}

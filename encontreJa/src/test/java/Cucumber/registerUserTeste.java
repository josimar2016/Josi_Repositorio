/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pt.ua.encontreja.entity.User;

/**
 *
 * @author arrais
 */

public class registerUserTeste{
    
    private User user = new User();
    
    private String nome;
    private String email;
    private int telefone;
    private String local;
    private String pass;
    
   
    @Dado("^O nome Afonso$")
    public void o_nome_Afonso() throws Throwable {
    System.out.println("Cucumber.registerUserTeste.o_nome_Afonso()");
             nome = "afonso";
    
    }
    
    @Dado("^Email afonso@ua\\.pt$")
    public void email_afonso_ua_pt() throws Throwable {
    System.out.println("Cucumber.registerUserTeste.email_afonso_ua_pt()");
        email = "afonso@ua.pt";
    }
    
    @Dado("^Telefone (\\d+)$")
    public void telefone(int telefone) throws Throwable {
    System.out.println("Cucumber.registerUserTeste.telefone()");
        this.telefone = telefone;
    }
    
    @Dado("^Localizacao Aveiro$")
    public void localizacao_Aveiro() throws Throwable {
    System.out.println("Cucumber.registerUserTeste.localizacao_Aveiro()");
        local = "aveiro";
    }
    
    @Dado("^Password (\\d+)$")
    public void password(String password) throws Throwable {
    System.out.println("Cucumber.registerUserTeste.password()");
        pass = password;
    }
    
    @Quando("^Eu seleciono enviar$")
    public void eu_seleciono_enviar() throws Throwable {
    System.out.println("Cucumber.registerUserTeste.eu_seleciono_enviar()");
        user.setName(nome);
        user.setEmail(email);
        user.setPhone(telefone);
        user.setLocation(local);
        user.setPassWord(pass);
    }
    
    @Então("^Eu devo ficar registado com sucesso$")
    public void eu_devo_ficar_registado_com_sucesso() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerUserTeste.eu_devo_ficar_registado_com_sucesso()");
   

    }
    @Test 
    public void registerTest(){
        Assert.assertEquals(user.getEmail(), email);
        assertEquals("Nome não corresponde", user.getName(), nome);
        assertEquals("Password não corresponde", user.getPassWord(), pass);
        assertEquals("Phone não corresponde", user.getPhone(), telefone);
        assertEquals("Location não corresponde", user.getLocation(), local);
    }
    }
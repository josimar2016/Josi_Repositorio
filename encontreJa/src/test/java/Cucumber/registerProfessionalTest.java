/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pt.ua.encontreja.entity.Service;
import pt.ua.encontreja.entity.User;

/**
 *
 * @author arrais
 */
public class registerProfessionalTest {

    private User user = new User();

    private String nome;
    private String email;
    private int telefone;
    private String local;
    private String pass;

    private Service service = new Service();

    List<Service> serviceList;

    private String area;
    private String descricao;
    private double custo;
    private double custoDeslo;

    @Dado("^O nome maria$")
    public void o_nome_maria() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.o_nome_maria()");
        nome = "Maria";
    }

    @Dado("^Email maria@ua\\.pt$")
    public void email_maria_ua_pt() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.email_maria_ua_pt()");
        email = "maria@ua.pt";
    }

    @Dado("^Password qwerty$")
    public void password_qwerty() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.password_qwerty()");
        pass = "querty";
    }

    @Dado("^Area carpinteiro$")
    public void area_carpinteiro() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.area_carpinteiro()");
        area = "carpinteiro";
    }

    @Dado("^Descricao vontade de trabalhar$")
    public void descricao_vontade_de_trabalhar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.descricao_vontade_de_trabalhar()");
        descricao = "vontade de trabalhar";
    }

    @Dado("^Custo (\\d+)$")
    public void custo(double custo) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.custo()");
        this.custo = custo;
    }

    @Dado("^CustoDeslocacao (\\d+)$")
    public void custodeslocacao(double custoDeslocacao) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.custodeslocacao()");
        this.custoDeslo = custoDeslocacao;
    }

    @Quando("^Eu seleciono registarPro$")
    public void eu_seleciono_registarPro() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.registerProfessionalTest.eu_seleciono_registarPro()");
        user.setName(nome);
        user.setEmail(email);
        user.setPhone(telefone);
        user.setLocation(local);
        user.setPassWord(pass);

        service.setDescription(descricao);
        service.setFeePrice(custoDeslo);
        service.setHourPrice(custo);
        serviceList.add(service);

    }

    @Test
    public void registerProTest() {
        Assert.assertEquals(user.getEmail(), email);
        assertEquals("Nome não corresponde", user.getName(), nome);
        assertEquals("Password não corresponde", user.getPassWord(), pass);
        assertEquals("Phone não corresponde", user.getPhone(), telefone);
        assertEquals("Location não corresponde", user.getLocation(), local);

        //assertEquals(service.getFeePrice(), custoDeslo);;
        //assertEquals(service.getHourPrice(), custo);     
        assertEquals(service.getDescription(), descricao);

    }

}

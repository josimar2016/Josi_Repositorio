/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pt.ua.encontreja.entity.Category;
import pt.ua.encontreja.entity.Service;

/**
 *
 * @author arrais
 */
public class EncontrarProfissionalTest {
    
    private List<Service> serviceList;
    private Service service;
    private Category category = new Category();
    private String procuraCategoria;
    private String procuraLocal;
    
    protected void setUp() {
        service = new Service();
        //category = new Category();
    }
    
    @Dado("^O que preciso é de uma empregada de limpeza$")
    public void o_que_preciso_é_de_uma_empregada_de_limpeza() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.o_que_preciso_é_de_uma_empregada_de_limpeza()");
        
        procuraCategoria = "empregada Limpeza";
        category.setName(procuraCategoria);
        
    }
    
    @Dado("^Na localidade de Aveiro$")
    public void na_localidade_de_Aveiro() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.na_localidade_de_Aveiro()");
        procuraLocal = "aveiro";
    
        
        
    }
    
    @Quando("^Eu selecionar pesquisar$")
    public void eu_selecionar_pesquisar() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.eu_selecionar_pesquisar()");
        service.setCategory(category);
        
    }
    
    @Então("^Devo receber a informação que existe pelo menos uma empregada com o nome de maria amelia$")
    public void devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        
System.out.println("Cucumber.EncontrarProfissionalTest.devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia()");

    }
    
    @Test
    public void encontrarProfissionalTest() {
        assertEquals(category.getName(), procuraCategoria);
 
        
        
    }
}

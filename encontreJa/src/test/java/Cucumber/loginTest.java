/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cucumber;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import pt.ua.encontreja.dao.UserDAO;

public class loginTest {
    UserDAO userdao = new UserDAO();
    
    
        @Dado("^O meu email é afonso@ua.pt$")
    public void o_que_preciso_é_de_uma_empregada_de_limpeza() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
           System.out.println("Cucumber.loginTest.o_que_preciso_é_de_uma_empregada_de_limpeza()");

    }
    
    @Dado("^Password é 1212$")
    public void na_localidade_de_Aveiro() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.loginTest.na_localidade_de_Aveiro()");
    }
    
    @Quando("^Eu Selecionar Login$")
    public void eu_selecionar_pesquisar() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.loginTest.eu_selecionar_pesquisar()");
  }
    
    @Então("^O meu login vai ser efetuado com sucesso$")
    public void devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia() throws Throwable {
    // Write code here that turns the phrase above into concrete actions           
        System.out.println("Cucumber.loginTest.devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia()");

    }
    
}

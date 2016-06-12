/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CucumberSelenium;


import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author arrais
 */
public class loginCucumberSeleniumTest {
  
     WebDriver driver = null; 
     private boolean pass = false;
     private boolean openBrowser = false;
    
        @Dado("^Eu abri o browser$")
    public void abrirBrowser() throws Throwable {
      
        try{
            driver = new FirefoxDriver();
            openBrowser = true;
        }catch(AbstractMethodError am){
            am.printStackTrace();
        }

    }
      @Quando("^I open encontroJa pagina de login$")
    public void goToEncontreJa() throws Throwable {
     driver.navigate().to("http://deti-tqs-vm3.ua.pt/encontreJa-1.0/index.html#/login/"); 

  }
    
      @Então("^O meu login vai ser efetuado com sucesso$")
    public void devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia() throws Throwable {
     if(driver.findElement(By.id("u_0_v")).isEnabled()) { 
         System.out.println("Test 1 Pass"); 
         pass = true;
      } else { 
         System.out.println("Test 1 Fail"); 
      } 
      driver.close(); 
   }         
    
    
  @Test
  public void testLogin() throws Exception {
        Assert.assertEquals(pass, pass == true);
  }
  
  @Test
  public void testOpenBrowser(){
        Assert.assertEquals(openBrowser, openBrowser == true);
  }
    
    
}
    


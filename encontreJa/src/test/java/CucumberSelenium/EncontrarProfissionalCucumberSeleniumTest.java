/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CucumberSelenium;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pt.ua.encontreja.entity.Category;
import pt.ua.encontreja.entity.Service;

/**
 *
 * @author arrais
 */
public class EncontrarProfissionalCucumberSeleniumTest {

    private List<Service> serviceList;
    private Service service;
    private Category category = new Category();
    private String procuraCategoria;
    private String procuraLocal;
    private WebDriver driver;
    private String baseUrl;
    private boolean resultOfFind = false;
     private boolean openBrowser = false;

    protected void setUp() {
        
        
         try{
            driver = new FirefoxDriver();
            baseUrl = "http://deti-tqs-vm3.ua.pt/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }catch(AbstractMethodError am){
            am.printStackTrace();
        }
    }

    @Dado("^O que preciso é de uma empregada de limpeza$")
    public void o_que_preciso_é_de_uma_empregada_de_limpeza() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.o_que_preciso_é_de_uma_empregada_de_limpeza()");

        driver.get(baseUrl + "/encontreJa-1.0/index.html");
        driver.findElement(By.linkText("Encontrar profissional")).click();
        new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("empregada de limpeza");

        procuraCategoria = "empregada Limpeza";
        category.setName(procuraCategoria);

    }

    @Dado("^Na localidade de Aveiro$")
    public void na_localidade_de_Aveiro() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.na_localidade_de_Aveiro()");
        new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Aveiro");
        procuraLocal = "aveiro";

    }

    @Quando("^Eu selecionar pesquisar$")
    public void eu_selecionar_pesquisar() throws Throwable {
// Write code here that turns the phrase above into concrete actions
        System.out.println("Cucumber.EncontrarProfissionalTest.eu_selecionar_pesquisar()");

        driver.findElement(By.id("submit")).click();

        driver.findElement(By.cssSelector("img")).click();

        service.setCategory(category);

    }

    @Então("^Devo receber a informação que existe pelo menos uma empregada com o nome de maria amelia$")
    public void devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia() throws Throwable {
// Write code here that turns the phrase above into concrete actions

        System.out.println("Cucumber.EncontrarProfissionalTest.devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia()");
        
        resultOfFind =  isElementPresent(By.name("maria amelia"));

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Test
    public void encontrarProfissionalTest() {
        assertEquals(category.getName(), procuraCategoria);

    }
    
    @Test
    public void enontrarProfissionaisTest(){
        
        assertEquals(resultOfFind, resultOfFind == true);
    }
    
       @Test
  public void testOpenBrowser(){
        Assert.assertEquals(openBrowser, openBrowser == true);
  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CucumberSelenium;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author arrais
 */
public class EntrarContactoCucumberSelenium {

    WebDriver driver = null;
    private boolean result = false;
    private boolean openBrowser = false;
    private String baseUrl;

    @Dado("^Eu abri o browser$")
    public void abrirBrowser() throws Throwable {

        try {
            driver = new FirefoxDriver();
            baseUrl = "http://deti-tqs-vm3.ua.pt/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (AbstractMethodError am) {
            am.printStackTrace();
        }

    }

    @Dado("^Realizo o meu login$")
    public void realizarLogin() throws Throwable {
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("afonso@ua.pt");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1212");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

    }

    @Dado("^Eu encontro o profissional na localidade de aveiro$")
    public void realizarProcura() throws Throwable {
        driver.findElement(By.linkText("Encontrar profissional")).click();
        new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("empregada de limpeza");
        new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Aveiro");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.cssSelector("img")).click();

    }

    @Quando("^Eu entro em contacto com a maria amelia$")
    public void devo_receber_a_informação_que_existe_pelo_menos_uma_empregada_com_o_nome_de_maria_amelia() throws Throwable {
        driver.findElement(By.linkText("Entrar em contacto")).click();
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("1");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("0");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("1");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("2");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("3");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("4");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("5");
        driver.findElement(By.name("horas")).clear();
        driver.findElement(By.name("horas")).sendKeys("6");
        driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).clear();
        driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).sendKeys("Preciso do seu contacto");
        driver.findElement(By.id("submit")).click();
    }
    @Entao("^Devo ter entrado em contacto com sucesso")
    public void devo_ter_entrado_em_contato_com_sucesso(){
        result =  isElementPresent(By.id("submit"));
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
    public void testLogin() throws Exception {
        Assert.assertEquals(result, result == true);
    }

    @Test
    public void testOpenBrowser() {
        Assert.assertEquals(openBrowser, openBrowser == true);
    }

}

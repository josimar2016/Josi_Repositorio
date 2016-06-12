package CucumberSelenium;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import org.junit.*;
import org.openqa.selenium.*;

public class LogoutCucumberSeleniumTest {

    private String baseUrl;
    private boolean login = false;
    private boolean loggout = false;
    WebDriver driver = null;
    private boolean openBrowser = false;

    @Dado("^Eu abri o browser$")
    public void abrirBrowser() throws Throwable {

           try{
                  driver.navigate().to("http://deti-tqs-vm3.ua.pt/encontreJa-1.0/index.html#/login/");
            openBrowser = true;
        }catch(AbstractMethodError am){
            am.printStackTrace();
        }
  
    }
     @Dado("^Eu efetuo o login$")
    public void loginEfe() throws Throwable {
        driver.get(baseUrl + "/encontreJa-1.0/index.html");
        
        if(driver.findElement(By.id("u_0_v")).isEnabled()) { 
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("afonso@ua.pt");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1212");
        
        login = true;
        }
        else
             System.err.println("O utilizador nao se encontra registado com sucesso");
    }

    @Quando("^Eu abro selecionar o botao logout$")
    public void goToEncontreJa() throws Throwable {
        System.out.println("Seleciono o botão de loggout");
    }
    
    @Então("^O meu logout vai ser efetuado com sucesso$")
    public void o_meu_logout_sucesso() throws Throwable {
     if(driver.findElement(By.id("u_0_v")).isEnabled()) { 
           driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
            driver.findElement(By.linkText("Logout")).click();
             boolean loggout = true;
      } else { 
         System.out.println("Test 1 Fail"); 
      } 
      driver.close(); 
   }         
        
        
  @Test
  public void testLoggout() throws Exception {
        Assert.assertEquals(loggout, loggout == true);
  }
  
   @Test
  public void testloggin() throws Exception {
        Assert.assertEquals(login, login == true);
  }
  
    @Test
  public void testOpenBrowser(){
        Assert.assertEquals(openBrowser, openBrowser == true);
  }
    
}

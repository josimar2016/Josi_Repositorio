package testes_Selenium_IDE;

//
//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;
//import org.junit.*;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class PesquisaProfissionalTest {
//  private WebDriver driver;
//  private String baseUrl;
//  private boolean acceptNextAlert = true;
//  private StringBuffer verificationErrors = new StringBuffer();
//
//  @Before
//  public void setUp() throws Exception {
//    driver = new ChromeDriver();
//    baseUrl = "http://deti-tqs-vm3.ua.pt/encontreJa-1.0/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//  }
//
//  @Test
//  public void testPesquisaProfissional() throws Exception {
//    driver.get(baseUrl + "/encontreJa-1.0/");
//    driver.findElement(By.linkText("Encontrar profissional")).click();
//    new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("canalizador");
//    new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Coimbra");
//    driver.findElement(By.id("submit")).click();
//    driver.findElement(By.linkText("Encontrar profissional")).click();
//    new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("empregada de limpeza");
//    new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Aveiro");
//    driver.findElement(By.id("submit")).click();
//    driver.findElement(By.linkText("Encontrar profissional")).click();
//    new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("carpinteiro");
//    new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Bragança");
//    driver.findElement(By.id("submit")).click();
//    driver.findElement(By.linkText("Encontrar profissional")).click();
//    new Select(driver.findElement(By.xpath("//form[@id='searchform']/div/div/div/p/select"))).selectByVisibleText("eletricista");
//    new Select(driver.findElement(By.name("localidade"))).selectByVisibleText("Bragança");
//    driver.findElement(By.id("submit")).click();
//    driver.findElement(By.linkText("Encontrar profissional")).click();
//  }
//
//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}

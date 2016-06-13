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
//public class RegistoClienteTest {
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
//  public void testRegistoCliente() throws Exception {
//    driver.get(baseUrl + "/encontreJa-1.0/");
//    driver.findElement(By.linkText("Registo")).click();
//    driver.findElement(By.id("name")).clear();
//    driver.findElement(By.id("name")).sendKeys("Manuel dos Santos Barros");
//    driver.findElement(By.id("email")).click();
//    driver.findElement(By.id("email")).clear();
//    driver.findElement(By.id("email")).sendKeys("manuel_barros@gmail.com");
//    driver.findElement(By.id("phone")).clear();
//    driver.findElement(By.id("phone")).sendKeys("934568796");
//    driver.findElement(By.id("location")).clear();
//    driver.findElement(By.id("location")).sendKeys("Aveiro");
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys("manuelb");
//    driver.findElement(By.xpath("//button[@type='submit']")).click();
//    driver.findElement(By.linkText("Home")).click();
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

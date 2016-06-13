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
//public class EntrarEmContactoComProfissionalTest {
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
//  public void testEntrarEmContactoComProfissional() throws Exception {
//    driver.get(baseUrl + "/encontreJa-1.0/");
//    driver.findElement(By.linkText("Os nossos profissionais")).click();
//    driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[3]/div[4]/div/div/a/img")).click();
//    driver.findElement(By.linkText("Entrar em contacto")).click();
//    driver.findElement(By.xpath("(//a[contains(text(),'Login')])[2]")).click();
//    driver.findElement(By.id("email")).clear();
//    driver.findElement(By.id("email")).sendKeys("manuel_barros@gmail.com");
//    driver.findElement(By.id("password")).clear();
//    driver.findElement(By.id("password")).sendKeys("manuelb");
//    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
//    driver.findElement(By.linkText("Os nossos profissionais")).click();
//    driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[3]/div[4]/div/div/a/img")).click();
//    driver.findElement(By.linkText("Entrar em contacto")).click();
//    driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).clear();
//    driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).sendKeys("Necessitava de restaurar a canaliza");
//    driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).clear();
//    driver.findElement(By.xpath("//section[@id='content']/div/div/form/div/div/textarea")).sendKeys("Necessitava de restaurar a canalização da minha residência.");
//    driver.findElement(By.name("horas")).clear();
//    driver.findElement(By.name("horas")).sendKeys("4");
//    driver.findElement(By.id("submit")).click();
//    driver.findElement(By.linkText("ÁREA RESERVADA")).click();
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

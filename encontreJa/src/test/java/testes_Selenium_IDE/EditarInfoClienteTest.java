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
////import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//import static se_Test.BaseTest.sCaps;
//
//public class EditarInfoClienteTest {
//
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    protected static DesiredCapabilities sCaps;
//
//    @Before
//    @SuppressWarnings("empty-statement")
//    public void setUp() throws Exception {
//        sCaps = new DesiredCapabilities();
//        sCaps.setJavascriptEnabled(true);
//        sCaps.setCapability("takesScreenshot", false);
//        sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", "My User Agent - Chrome");
//        sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
//            "--web-security=false",
//            "--ssl-protocol=any",
//            "--ignore-ssl-errors=true",
//            "--webdriver-loglevel=DEBUG"
//        });
//        
//        
////        driver = new org.openqa.selenium.phantomjs.PhantomJSDriver(sCaps);
//        driver = new ChromeDriver();
//        baseUrl = "http://deti-tqs-vm3.ua.pt/encontreJa-1.0/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testEditarInfoCliente() throws Exception {
//        driver.get(baseUrl + "/encontreJa-1.0/index.html");
//        driver.findElement(By.linkText("Login")).click();
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("manuel_barros@gmail.com");
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("manuelb");
//        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
//        driver.findElement(By.linkText("ÁREA RESERVADA")).click();
//        driver.findElement(By.linkText("Editar informações")).click();
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys("Manuel dos Santos Barros dos Prazeres Cassandra");
//        driver.findElement(By.id("phone")).clear();
//        driver.findElement(By.id("phone")).sendKeys("934568777");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.linkText("ÁREA RESERVADA")).click();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}

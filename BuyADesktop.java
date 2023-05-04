import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BuyADesktop extends Util {

    // Initialise WebElement
    WebDriver driver;
    @BeforeClass
    // Annotation
//    @Test(priority = 1)
    // Create a method
    void homepage(){
        // Set upa a Path for a WebDriver
        System.setProperty("webdriver.chrome.driver","C:\\Software\\Driver\\Updated Drivers\\chromedriver.exe");
        // Instance for a WebDriver
        driver = new ChromeDriver();
        // Navigate to Webpage
        driver.get("https://demo.nopcommerce.com/");
        // Maximize window
        driver.manage().window().maximize();
    }
    @Test(priority = 2)
    void title(){
       String Title = driver.getTitle();
       Assert.assertEquals(Title,"nopCommerce demo store","Title page is incorrect");

    }
    @Test(priority = 3)
    void guest(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();

    }

    @Test(priority = 4)
    void desktop(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img")).click();
    }

    @Test(priority = 5)
    void lenovo(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img")).click();
    }

    @Test(priority = 6)
    void addToCart(){
        driver.findElement(By.id("add-to-cart-button-3")).click();
        // Verify that is been added or not
        WebElement cart = driver.findElement(By.id("add-to-cart-button-3"));
        Assert.assertTrue(cart.isDisplayed(),"Desktop successfully added on cart");
    }

    @Test(priority = 7)
    void shoppingCart(){
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]")).click();
        driver.findElement(By.id("updatecart")).click();
        // Update cart
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
    }
    @Test(priority = 8)
    void termsAndCondition(){

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("termsofservice")).click();
    }

    @Test(priority = 9)
    void checkout(){
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
    }

    @Test(priority = 10)
    void chGuest(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 11)
    void billing(){
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Nishant");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Dhanani");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("nishant.dhanani@gmail.com");
        driver.findElement(By.name("BillingNewAddress.Company")).sendKeys("abc ltd");
    }

    @Test(priority = 12)
    void country(){
        // Generic Method
        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
        SelectValueFromDropDown(selectCountry,"United Kingdom");
    }


    @Test(priority = 13)
    void state(){
        WebElement state = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]"));
        SelectValueFromDropDown(state,"Select state");
    }

    @Test(priority = 14)
    void city(){
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Leicester");
    }

    @Test(priority = 15)
    void address(){
        driver.findElement(By.name("BillingNewAddress.Address1")).sendKeys("267");
        driver.findElement(By.name("BillingNewAddress.ZipPostalCode")).sendKeys("abc");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("7867868797");
        driver.findElement(By.name("save")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
    }

    @Test(priority = 16)
    void payment(){
        driver.findElement(By.xpath("//*[@id=\"payment-method-block\"]/li[2]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
    }

    @Test(priority = 17)
    void cardDetails(){
        WebElement card = driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]"));
        SelectValueFromDropDown(card,"Discover");
    }
    @Test(priority = 18)
    void cardHolderDetails(){
        driver.findElement(By.name("CardholderName")).sendKeys("xys");
        driver.findElement((By.id("CardNumber"))).sendKeys("67567587688789");
    }

    @Test(priority = 19)
    void expDate(){
        WebElement Month = driver.findElement(By.id("ExpireMonth"));
        WebElement Year = driver.findElement(By.id("ExpireYear"));
        SelectValueFromDropDown(Month,"10");
        SelectValueFromDropDown(Year,"2031");
    }

    @Test(priority = 20)
    void cvv(){
        driver.findElement(By.id("CardCode")).sendKeys("535");
    }
    @AfterClass
  //  @Test(priority = 21)
    void close(){
        driver.close();
    }






}

package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    public static WebDriver driver;

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        //Open URL
        driver.get("https://www.sky.com/");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"sp_message_iframe_474555\"]")));
        driver.findElement(By.xpath("//button[@title='Agree']")).click();


    }

    @When("^I navigate to 'Deals'$")
    public void i_navigate_to_deals() {

        driver.navigate().to("https://www.sky.com/deals");

    }

    @Then("^the user should be on the https://www\\.sky\\.com/deals$")
    public void user_in_deals_page() {
        //Expected Title
        String expectedTitle = "Sky Deals";

        //Get Title of current Page
        String actualTitle = driver.getTitle();
        System.out.println("Title fetched: " + actualTitle);
    }

//    @Then("^I should see a text saying that 'Sorry, we did not recognise either your username or password$")
//    public void i_see_text(){
//
//
//        String t = "Sorry, we did not recognise either your username or password";
//
//        if( driver.getPageSource().contains("Sorry, we did not recognise either your username or password")) {
//
//            System.out.println("Expected text is obtained");
//
//        } else {
//            System.out.println("Expected text is not obtained");
//        }
//
//
//    }

    @When("^I try to sign in with invalid credentials$")
    public void i_try_to_sign_in_with_invalid_credentials() {

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div[4]/a")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/form/div/div[1]/input")).sendKeys("g.midland@yahoo.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div[1]/div[2]/form/div/div[2]/input")).sendKeys("password");


    }

    @Then("^I should see a text saying that 'Sorry, we did not recognise either your username or password'$")
    public void iShouldSeeATextSayingThatSorryWeDidNotRecogniseEitherYourUsernameOrPassword() {
        String t = "Sorry, we did not recognise either your username or password";

        if (driver.getPageSource().contains("Sorry, we did not recognise either your username or password")) {

            System.out.println("Expected text is obtained");

        } else {
            System.out.println("Expected text is not obtained");
        }
    }

    @Given("^I am on the 'https://www.sky.com/deals' page$")
    public void i_am_on_the_deals_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.sky.com/deals");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"sp_message_iframe_474555\"]")));
        driver.findElement(By.xpath("//button[@title='Agree']")).click();
    }

    @Then("^I see a list of deals with a price to it$")
    public void i_see_alist_of_deals() {

        String t = "Sky Deals";

        // getPageSource() to get page source
        if (driver.getPageSource().contains("Sky Deals")) {

            System.out.println("Text:" + t + " is present.");
        } else {
            System.out.println("Text: " + t + "is not present. ");

        }
    }
}

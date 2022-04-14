package com.golfstore.endToEnd.loginSteps;

import com.golfstore.endToEnd.SeleniumConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Steps {

    private final WebDriver driver;
    private final String baseUrl;

    public Steps() {
        SeleniumConfig seleniumConfig = new SeleniumConfig();
        driver = seleniumConfig.getDriver();
        baseUrl = seleniumConfig.getBaseUrl();
    }

    @When("they enter correct username")
    public void theyEnterCorrectUsername() {
        driver.get(baseUrl+"login.html");
        WebElement idField = driver.findElement(By.id("idField"));
        idField.sendKeys("markclancey@cgl.staff.com");

    }

    @And("they enter correct password")
    public void theyEnterCorrectPassword() {
        WebElement passwordField = driver.findElement(By.id("passwordField"));
        passwordField.sendKeys("manager3281!");
    }

    @Then("they are navigated to the staff page")
    public void theyAreNavigatedToTheStaffPage() {
        WebElement signInButton = driver.findElement(By.id("loginButton"));
        signInButton.click();
        driver.close();
    }



}

package com.b4value.step_definitions;

import com.b4value.pages.Homepage;
import com.b4value.pages.JobsPage;
import com.b4value.utilities.ConfigurationReader;
import com.b4value.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class homePage_StepDefs  extends Homepage {


    JobsPage jobsPage = new JobsPage();
    static String globalText;

    @Given("I am on the b4value website")
    public void i_am_on_the_b4value_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("b4valueURL"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(cookie)); // Wait until cookie is visible
        cookie.click();

        wait.until(ExpectedConditions.elementToBeClickable(jobsBtn)); // Wait until jobsBtn is clickable
        jobsBtn.click();
    }

    @Then("I should click the Jobs button on the page")
    public void i_should_click_the_jobs_button_on_the_page() {
        assertTrue("Jobs button was not found", jobsBtn.isDisplayed());
        jobsBtn.click();
    }

    @Then("I should click zum b4 Job Portal on Jobs page")
    public void i_should_click_zum_b4_job_portal_on_jobs_page() {
      //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
      //  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(JobsPage.iframe));

     //   assertTrue("Zum b4 Job Portal button was not found", JobsPage.jobPortalBtn.isDisplayed());
        JobsPage.jobPortalBtn.click();
    }


    @When("I enter {string} in the search input")
    public void i_enter_in_the_search_input(String text) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://jobportal.b4value.net/de');");
        Driver.getDriver().switchTo().window("https://jobportal.b4value.net/de");
        System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

        if (Driver.getDriver().getCurrentUrl().contains("jobPortal")) {
            JobsPage.searchInput.sendKeys(Keys.ENTER);
            globalText = text;
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(JobsPage.searchInput)); // Wait until searchInput is visible
        }
    }

    @And("I click the search button")
    public void i_click_the_search_button() {

        JobsPage.searchInput.sendKeys(((globalText)+Keys.ENTER));

    }


    @Then("I should see relevant search results")
    public void i_should_see_relevant_search_results() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(JobsPage.firstResultTitle)); // Wait until firstResultTitle is visible
        String firstResult = JobsPage.firstResultTitle.getText();
        assertTrue("Relevant search results were not found", firstResult.startsWith(globalText));
        Driver.closeDriver();
    }





}



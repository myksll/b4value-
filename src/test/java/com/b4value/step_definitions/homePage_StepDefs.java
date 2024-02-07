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

    @Given("I am on the b4value website")
    public void i_am_on_the_b4value_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("b4valueURL"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();

        wait.until(ExpectedConditions.elementToBeClickable(jobsBtn));
        jobsBtn.click();
    }

    @When("I  click the Jobs button on the page")
    public void i_should_click_the_jobs_button_on_the_page() {
        assertTrue("Jobs button was not found", jobsBtn.isDisplayed());
        jobsBtn.click();
    }

    @And("I click zum b4 Job Portal on Jobs page")
    public void i_should_click_zum_b4_job_portal_on_jobs_page() {

        JobsPage.jobPortalBtn.click();
    }


    @Then("I should see  search results related to joboffer")
    public void i_should_see_relevant_search_results() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(JobsPage.jobPortaliFRAME));


        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait2.until(ExpectedConditions.visibilityOf(JobsPage.firstResultTitle));
        String firstResult = JobsPage.firstResultTitle.getText();
        assertTrue("Relevant search results were not found", firstResult.isEmpty());

    }
}








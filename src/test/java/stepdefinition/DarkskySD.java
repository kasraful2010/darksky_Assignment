package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.AppiumWrapper;
import framework.page_object_model_web.DarkskyPage;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class DarkskySD {

    private DarkskyPage ds = new DarkskyPage();

    @Given("^I am on darksky website homepage$")
    public void iAmOnDarkskyHomePage() {
    }

    @When("^I clear search text field$")
    public void clearField() {
        ds.clearTextField();
    }

    @And("^I enter (.+) into the search field$")
    public void enterText(String text) {
        ds.sendText(text);
    }

    @And("^I click on search magnifying glass$")
    public void clickSearch() throws InterruptedException {
        ds.clickOnSearch();
    }

    @Then("^I verify current temperature is between low and high value$")
    public void verifyTemp() throws ParseException { ds.verifyTempRange();

    }

    //darksky-sprint
    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline(){ ds.verifyTimelineIsDisplayed(); }

}
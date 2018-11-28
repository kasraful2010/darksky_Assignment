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

    //darksky-sprint-task-1
    @Then("^I verify timeline is displayed with two hours incremented$")
    public void verifyTimeline(){ ds.verifyTimelineIsDisplayed(); }

    // darksky-sprint-task-2

    @When("^I expand today's timeline$")
    public void timeline() throws InterruptedException {ds.expandTimeLine(); }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyTempDisplayed(){ds.verifyLowAndHighTemp();}

    // darksky-sprint-task-3

    @When("^I click on Time Machine$")
    public void timeMachine ()throws InterruptedException{ds.clickOnTimeMachine();}

    @Then("^I verify date is selected to todays date$")
    public void DateSelected(){ds.verifyTodaysDate();}

}
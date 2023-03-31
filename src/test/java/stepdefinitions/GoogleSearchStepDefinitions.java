package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchStepDefinitions {

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {
        open("https://www.google.com");
    }

    @When("I search for {string}")
    public void iSearchFor(String query) {
        $("input[name='q']").val(query).pressEnter();
    }

    @Then("I should see search results")
    public void iShouldSeeSearchResults() {
        $("div#search").shouldBe(visible);
    }

    @And("I click on the first search result")
    public void iClickOnTheFirstSearchResult() {
        $("div#search a[href*='imdb.com']").click();
    }

    @Then("I should be on the IMDb homepage")
    public void iShouldBeOnTheImdbHomepage() {
        $("div#__next").shouldBe(visible);
        $("div#imdbHeader").shouldBe(visible);
    }
}

package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchStepDefinitions {

    private SelenideElement
            googleSearchBar = $("input[name='q']");

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {
        open("https://www.google.com");
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        $("#CXQnmb").shouldBe(visible)
                .$("#L2AGLb").as("button 'Accept cookies'")
                .click();
    }

    @When("I search for {string}")
    public void iSearchFor(String query) {
        googleSearchBar.setValue(query).pressEnter();
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
        $("#home_img_holder").shouldBe(visible);
        $("#suggestion-search").shouldBe(visible, enabled);
    }
}

package stepDefs;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.PolicyPage;
import pages.TravelInsurancePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class TravelInsurancePlanSteps {

    private final SelenideElement progressBar = $("div[class='content-loader loading']");
    private final SelenideElement insuredTravelerFirstName = $(byId("travelerFirstName0"));
    private final SelenideElement insuredTravelerLastName = $(byId("travelerLastName0"));
    private final SelenideElement insuredTravelerPersonalId = $(byId("travelerIdentityNumber0"));
    MainPage mainPage = new MainPage();
    TravelInsurancePage travelInsurancePage = new TravelInsurancePage();
    PolicyPage policyPage = new PolicyPage();

    @Given("open {string} homepage")
    public void open_homepage(String domainName) {
        mainPage.openPageAndAcceptCookies(domainName);

    }

    @Given("should select {string} category")
    public void should_select_category(String selectedCategory) {
        mainPage.openTravelFromMenuPanel(selectedCategory);

    }

    @When("expand Travel Destination dropdown list")
    public void expand_travel_destination_dropdown_list() {
        travelInsurancePage.openTravelDestinationList();
    }

    @When("select {string} from the Travel Destination popup")
    public void select_from_the_travel_destination_popup(String selectDestination) {
        travelInsurancePage.selectFinalDestinationFromPopup(selectDestination);
    }

    @When("select {string} button")
    public void select_button(String addCountry) {
        travelInsurancePage.addCountryButton(addCountry);
    }

    @When("select {string} from dropdown list")
    public void select_from_dropdown_list(String countryName) {
        travelInsurancePage.searchForIndiaAsCountry(countryName);
    }

    @Then("should see that {string} is set as final destination")
    public void should_see_that_is_set_as_final_destination(String countryName) {
        assertTrue($(byText(countryName)).shouldBe(visible).isDisplayed());
    }

    @Then("press button {string}")
    public void press_button(String submitCountry) {
        travelInsurancePage.submitSearchedCountry(submitCountry);
    }

    @When("expand Activities dropdown list")
    public void expand_activities_dropdown_list() {
        travelInsurancePage.openActivitiesList();
    }

    @When("select {string} as activity from the Activity Type popup")
    public void select_as_activity_from_the_activity_type_popup(String activityType) {
        travelInsurancePage.selectSportFromActivityTypePopup(activityType);
    }

    @Then("should see that {string} is set as activity")
    public void should_see_that_is_set_as_activity(String activityType) {
        assertTrue($(byText(activityType)).shouldBe(visible).isDisplayed());
    }

    @When("press {string}")
    public void press(String calculatePrice) {
        travelInsurancePage.pressCalculateTravelInsurancePrice(calculatePrice);
        progressBar.should(disappear, Duration.ofMillis(10000));
    }

    @Then("select {string} under Optimal+ plan")
    public void select_under_optimal_plan(String planName) {
        policyPage.chooseOptimalPlusAsPolicyPlan(planName);
    }

    @Then("open {string} reference")
    public void open_reference(String viewWhatInsured) {
        policyPage.openWhatCoveredPopup(viewWhatInsured);
    }

    @Then("should see that the {string} popup appeared")
    public void should_see_that_the_popup_appeared(String popupName) {
        assertTrue($(byText(popupName)).shouldBe(visible).isDisplayed());

    }

    @When("close this popup and press {string} button")
    public void close_this_popup_and_press_button(String continueButton) {
        policyPage.closeWhatCoveredPopupAndContinue(continueButton);
        progressBar.should(disappear, Duration.ofMillis(10000));
    }

    @Then("should see empty input fields")
    public void should_see_empty_input_fields() {
        assertTrue(insuredTravelerFirstName.shouldBe(visible).isDisplayed());
        assertTrue(insuredTravelerFirstName.getAttribute("data-store-value").isEmpty());

        assertTrue(insuredTravelerLastName.shouldBe(visible).isDisplayed());
        assertTrue(insuredTravelerLastName.getAttribute("data-store-value").isEmpty());


        assertTrue(insuredTravelerPersonalId.shouldBe(visible).isDisplayed());
        assertTrue(insuredTravelerPersonalId.getAttribute("data-store-value").isEmpty());
    }
}

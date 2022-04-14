package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TravelInsurancePage {
    private final SelenideElement travelDestinationList = $(byId("regionalSelectorRegion-open"));
    private final SelenideElement adCountryButton = $(byId("regionalSelectorCountry-addCountry"));
    //    private final SelenideElement countrySearchField = $(byId("regionalSelectorCountry-typedValue"));
    private final SelenideElement indiaFromSearchList = $("button[data-value='Indija']");
    private final SelenideElement applyButton = $(byId("regionalSelectorCountry-applyButton"));
    private final SelenideElement activitiesList = $(byId("travelActivities-open"));
    private final SelenideElement sportAsActivity = $(byId("travelActivities-popup-select-option-3"));
    private final SelenideElement calculatePriceButton = $("button[data-type='travelSubmit']");

    public TravelInsurancePage openTravelDestinationList() {
        travelDestinationList.scrollTo();
        travelDestinationList.click();
        return this;
    }

    public TravelInsurancePage selectFinalDestinationFromPopup(String selectDestination) {
        $(byText(selectDestination)).click();
        return this;
    }

    public TravelInsurancePage addCountryButton(String addCountry) {
        $(byText(addCountry)).click();
        return this;
    }

    public TravelInsurancePage searchForIndiaAsCountry(String countryName) {
        $(byId("regionalSelectorCountry-typedValue")).setValue(countryName);
        $(byText(countryName)).click();
        return this;
    }

    public TravelInsurancePage submitSearchedCountry(String submitCountry) {
        $(byText(submitCountry)).click();
        return this;
    }

    public TravelInsurancePage openActivitiesList() {
        activitiesList.click();
        return this;
    }

    public TravelInsurancePage selectSportFromActivityTypePopup(String submitCountry) {
        $(byText(submitCountry)).click();
        return this;
    }

    public TravelInsurancePage pressCalculateTravelInsurancePrice(String calculatePrice) {
        $(byText(calculatePrice)).click();
        return this;
    }
}
package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement cookiesPopup = $("div[class='cookie-notice strong']");
    private final SelenideElement acceptButton = $(byText("Atļaut"));

    public MainPage() {
    }

    public void openPageAndAcceptCookies(String url) {
        open("https://www." + url + ".lv");

        if (cookiesPopup.isDisplayed()) {
            acceptButton.shouldBe(Condition.visible).click();
            acceptButton.should(Condition.disappear);
        }
    }

    public TravelInsurancePage openTravelFromMenuPanel(String label) {
        $(byText(label)).click();
        return new TravelInsurancePage();
    }
}

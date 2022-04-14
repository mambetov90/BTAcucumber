package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PolicyPage {

    public PolicyPage chooseOptimalPlusAsPolicyPlan(String planName) {
        Selenide.executeJavaScript("arguments[0].click();", $x("//div[text()='Optimālā+']//following::button[text()='" + planName + "'    ]"));
        return this;
    }

    public PolicyPage openWhatCoveredPopup(String viewWhatInsured) {
        Selenide.executeJavaScript("arguments[0].click();", $x("//div[text()='Optimālā+']//following::span[text()='" + viewWhatInsured + "']"));
        return this;
    }

    public PolicyPage closeWhatCoveredPopupAndContinue(String continueButton) {
        $("button[class='popup-close close']").click();
        $(byText(continueButton)).click();

        return this;
    }
}

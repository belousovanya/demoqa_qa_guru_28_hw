package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OutputTextBoxComponent {
    private final SelenideElement userNameOutput = $("#output #name"),
            userEmailOutput = $("#output #email"),
            currentAddressOutput = $("#output #currentAddress"),
            permanentAddressOutput = $("#output #permanentAddress");

    public OutputTextBoxComponent checkUserNameOutput(String value) {
        userNameOutput.shouldHave(text(value));
        return this;
    }

    public OutputTextBoxComponent checkUserEmailOutput(String value) {
        userEmailOutput.shouldHave(text(value));
        return this;
    }

    public OutputTextBoxComponent checkCurrentAddressOutput(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public OutputTextBoxComponent checkPermanentAddressOutput(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}

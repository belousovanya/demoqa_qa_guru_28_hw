package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public SelenideElement resultHeader = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive");

    public ResultTableComponent checkResultHeader(String value) {
        resultHeader.shouldHave(exactText(value));
        return this;
    }

    public ResultTableComponent checkResultTable(String key, String value) {
        resultTable.$(byText(key)).sibling(0).shouldHave(exactText(value));
        return this;
    }

    public ResultTableComponent tableDoesntExist() {
        resultTable.shouldNotBe(exist);
        return this;
    }
}
package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.OutputTextBoxComponent;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    OutputTextBoxComponent outputTextBoxComponent = new OutputTextBoxComponent();

    @Test
    public void fillFormTest() {
        textBoxPage.openTextBoxPage()
                .setUserNameInput("Anna")
                .setUserEmailInput("example@example.com")
                .setCurrentAddressInput("Some street 1")
                .setPermanentAddressInput("Some street 2")
                .clickSubmitButton();

        outputTextBoxComponent.checkUserNameOutput("Anna")
                .checkUserEmailOutput("example@example.com")
                .checkCurrentAddressOutput("Some street 1")
                .checkPermanentAddressOutput("Some street 2");

    }

}

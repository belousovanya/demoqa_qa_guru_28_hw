package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openRegistrationPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirthInput(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;

    }

    public RegistrationPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
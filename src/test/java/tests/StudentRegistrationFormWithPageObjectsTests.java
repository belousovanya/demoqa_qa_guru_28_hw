package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;

@Disabled
public class StudentRegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    public void successfulRegistrationTest() {
        registrationPage.openRegistrationPage()
                .setFirstNameInput("Anna")
                .setLastNameInput("Bel")
                .setUserEmailInput("example@example.com")
                .setGenderWrapper("Female")
                .setUserNumberInput("7999999999")
//                .setDateOfBirthInput("23", "August", "1985")
                .setSubjectsInput("Maths")
                .setHobbiesWrapper("Reading")
                .setUploadPicture("photo.jpg")
                .setCurrentAddressInput("Some street 1")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmitButton();

        resultTableComponent.checkResultHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", "Anna Bel")
                .checkResultTable("Student Email", "example@example.com")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "7999999999")
                .checkResultTable("Date of Birth", "23 August,1985")
                .checkResultTable("Subjects", "Maths")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "photo.jpg")
                .checkResultTable("Address", "Some street 1")
                .checkResultTable("State and City", "Uttar Pradesh Agra");
    }

    @Test
    public void successfulRegistrationUsingRequiredFieldsTest() {
        registrationPage.openRegistrationPage()
                .setFirstNameInput("Anna")
                .setLastNameInput("Bel")
                .setGenderWrapper("Female")
                .setUserNumberInput("7999999999")
                .clickSubmitButton();

        resultTableComponent.checkResultHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", "Anna Bel")
                .checkResultTable("Gender", "Female")
                .checkResultTable("Mobile", "7999999999");
    }

    @Test
    public void RegistrationWithoutFirstNameTest() {
        registrationPage.openRegistrationPage()
                .setLastNameInput("Bel")
                .setGenderWrapper("Female")
                .setUserNumberInput("7999999999")
                .clickSubmitButton();

        resultTableComponent.tableDoesntExist();

    }
}


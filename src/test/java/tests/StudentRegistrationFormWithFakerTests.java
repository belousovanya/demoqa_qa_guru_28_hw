package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;
import utils.TestData;

public class StudentRegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    TestData testData = new TestData();

    @Test
    public void successfulRegistrationWithFakerTest() {
        registrationPage.openRegistrationPage()
                .setFirstNameInput(testData.firstName)
                .setLastNameInput(testData.lastName)
                .setUserEmailInput(testData.userEmail)
                .setGenderWrapper(testData.userGender)
                .setUserNumberInput(testData.userNumber)
                .setDateOfBirthInput(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubjectsInput(testData.subjects)
                .setHobbiesWrapper(testData.userHobbies)
                .setUploadPicture(testData.uploadUserPicture)
                .setCurrentAddressInput(testData.userCurrentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmitButton();

        resultTableComponent.checkResultHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTable("Student Email", testData.userEmail)
                .checkResultTable("Gender", testData.userGender)
                .checkResultTable("Mobile", testData.userNumber)
                .checkResultTable("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth + "," + testData.userBirthYear)
                .checkResultTable("Subjects", testData.subjects)
                .checkResultTable("Hobbies", testData.userHobbies)
                .checkResultTable("Picture", testData.uploadUserPicture)
                .checkResultTable("Address", testData.userCurrentAddress)
                .checkResultTable("State and City", testData.state + " " + testData.city);
    }

    @Test
    public void successfulRegistrationUsingRequiredFieldsWithFakerTest() {
        registrationPage.openRegistrationPage()
                .setFirstNameInput(testData.firstName)
                .setLastNameInput(testData.lastName)
                .setGenderWrapper(testData.userGender)
                .setUserNumberInput(testData.userNumber)
                .clickSubmitButton();

        resultTableComponent.checkResultHeader("Thanks for submitting the form")
                .checkResultTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTable("Gender", testData.userGender)
                .checkResultTable("Mobile", testData.userNumber);
    }

    @Test
    public void RegistrationWithoutFirstNameWithFakerTest() {
        registrationPage.openRegistrationPage()
                .setLastNameInput(testData.lastName)
                .setGenderWrapper(testData.userGender)
                .setUserNumberInput(testData.userNumber)
                .clickSubmitButton();

        resultTableComponent.tableDoesntExist();
    }
}

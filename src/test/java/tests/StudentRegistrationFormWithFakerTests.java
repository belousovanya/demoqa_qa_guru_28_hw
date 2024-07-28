package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;
import utils.TestData;

import static io.qameta.allure.Allure.step;

@Tag("smoke")
public class StudentRegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    TestData testData = new TestData();

    @Test
    public void successfulRegistrationWithFakerTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openRegistrationPage();
        });

        step("Заполнить поля", () -> {
            registrationPage
                    .removeBanner()
                    .setFirstNameInput(testData.firstName)
                    .setLastNameInput(testData.lastName)
                    .setUserEmailInput(testData.userEmail)
                    .setGenderWrapper(testData.userGender)
                    .setUserNumberInput(testData.userNumber)
                    .setDateOfBirthInput(testData.userBirthDate)
                    .setSubjectsInput(testData.subjects)
                    .setHobbiesWrapper(testData.userHobbies)
                    .setUploadPicture(testData.uploadUserPicture)
                    .setCurrentAddressInput(testData.userCurrentAddress)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .clickSubmitButton();
        });

        step("Проверка результатов", () -> {
            resultTableComponent.checkResultHeader("Thanks for submitting the form")
                    .checkResultTable("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultTable("Student Email", testData.userEmail)
                    .checkResultTable("Gender", testData.userGender)
                    .checkResultTable("Mobile", testData.userNumber)
                    .checkResultTable("Date of Birth", testData.userBirthDate)
                    .checkResultTable("Subjects", testData.subjects)
                    .checkResultTable("Hobbies", testData.userHobbies)
                    .checkResultTable("Picture", testData.uploadUserPicture)
                    .checkResultTable("Address", testData.userCurrentAddress)
                    .checkResultTable("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    public void successfulRegistrationUsingRequiredFieldsWithFakerTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openRegistrationPage();
        });

        step("Заполнить обязательные поля", () -> {
            registrationPage
                    .removeBanner()
                    .setFirstNameInput(testData.firstName)
                    .setLastNameInput(testData.lastName)
                    .setGenderWrapper(testData.userGender)
                    .setUserNumberInput(testData.userNumber)
                    .clickSubmitButton();
        });

        step("Проверка результатов", () -> {
            resultTableComponent.checkResultHeader("Thanks for submitting the form")
                    .checkResultTable("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResultTable("Gender", testData.userGender)
                    .checkResultTable("Mobile", testData.userNumber);
        });
    }

    @Test
    public void RegistrationWithoutFirstNameWithFakerTest() {
        step("Открыть форму регистрации", () -> {
            registrationPage.openRegistrationPage();
        });

        step("Заполнить поля без имени", () -> {
            registrationPage
                    .removeBanner()
                    .setLastNameInput(testData.lastName)
                    .setGenderWrapper(testData.userGender)
                    .setUserNumberInput(testData.userNumber)
                    .clickSubmitButton();
        });

        step("Проверить отсутствие таблицы результатов", () -> {
            resultTableComponent.tableDoesntExist();
        });
    }
}
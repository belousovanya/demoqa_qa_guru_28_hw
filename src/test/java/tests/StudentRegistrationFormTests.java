package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Bel");
        $("#userEmail").setValue("example@example.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        // Проверка ожидаемого результата

        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Anna Bel"),
                Condition.text("Student Email example@example.com"),
                Condition.text("Gender Female"),
                Condition.text("Mobile 7999999999"),
                Condition.text("Date of Birth 02 February,2002"),
                Condition.text("Subjects Maths"),
                Condition.text("Hobbies Reading"),
                Condition.text("Picture photo.jpg"),
                Condition.text("Address Some street 1"),
                Condition.text("State and City Uttar Pradesh Agra")
        );
    }
}

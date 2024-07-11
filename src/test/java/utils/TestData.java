package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestData {

    private Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = getUserGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userBirthDate = getUserBirthDate();
    public String subjects = getSubjects();
    public String userHobbies = getUserHobbies();
    public String uploadUserPicture = getUserPicture();
    public String userCurrentAddress = faker.address().fullAddress();
    public String state = getState();
    public String city = getCity(state);

    private String getUserGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    private String getUserBirthDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        Date date = faker.date().birthday();
        return formatter.format(date);
    }

    private String getSubjects() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce",
                "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies"};
        return faker.options().option(subjects);
    }

    private String getUserHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    private String getUserPicture() {
        String[] pictures = {"photo.jpg", "photo-1.png"};
        return faker.options().option(pictures);
    }

    private String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    private String getCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return "";
        }
    }
}
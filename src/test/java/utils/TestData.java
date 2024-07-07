package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = getUserGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userBirthYear = getUserYearOfBirth();
    public String userBirthMonth = getUserMonthOfBirth();
    public String userBirthDay = getUserDayOfBirth(userBirthYear, userBirthMonth);
    public String subjects = getSubjects();
    public String userHobbies = getUserHobbies();
    public String uploadUserPicture = getUserPicture();
    public String userCurrentAddress = faker.address().fullAddress();
    public String state = getState();
    public String city = getCity(state);

    public String getUserGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String getUserMonthOfBirth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return faker.options().option(months);
    }

    public String getUserYearOfBirth() {
        int year = faker.number().numberBetween(1900, 2100);
        return Integer.toString(year);
    }

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public String getUserDayOfBirth(String year, String month) {
        int day = 0;
        int yearInt = Integer.parseInt(year);

        if (month.equals("February")) {
            if (isLeapYear(yearInt)) {
                day = faker.number().numberBetween(1, 30);
            } else {
                day = faker.number().numberBetween(1, 29);
            }
        } else if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
            day = faker.number().numberBetween(1, 31);
        } else {
            day = faker.number().numberBetween(1, 32);
        }
        return String.format("%02d", day);
    }


    public String getSubjects() {
        String[] subjects = {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce",
                "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies"};
        return faker.options().option(subjects);
    }

    public String getUserHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String getUserPicture() {
        String[] pictures = {"photo.jpg", "photo-1.png"};
        return faker.options().option(pictures);
    }

    public String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public String getCity(String state) {
        String city = "";
        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Haryana")) {
            city = faker.options().option("Karnal", "Panipat");
        } else if (state.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }

}



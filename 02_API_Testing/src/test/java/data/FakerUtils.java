package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FakerUtils {

    private static final Faker faker = new Faker(new Locale("en-ZA"));

    public static LocalDate randomDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(
            LocalDate.now().plusDays(
                faker.number().numberBetween(1,30))
        .format(formatter));
    }
    public static LocalDate randomDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.plusDays(faker.number().numberBetween(1,30));
    }

    public static String randomFirstName(){
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static int randomPrice() {
        return faker.number().numberBetween(50, 5000);
    }

    public static String randomAdditionalNeeds() {
        return faker.options().option("Breakfast", "Lunch", "Dinner", "None");
    }
}

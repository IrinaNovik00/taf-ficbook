package net.ficbook.irinanovik.ui.data;

import com.github.javafaker.Faker;

public class RandomData {
    private static Faker faker = new Faker();
    public static String getRandomLogin(){
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword(){
        return faker.internet().password();
    }
}

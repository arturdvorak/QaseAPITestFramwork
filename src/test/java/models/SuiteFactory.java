package models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class SuiteFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Suite getSuite() {
        return Suite.builder()
                .title(usFaker.company().name())
                .position(1)
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .build();
    }
}

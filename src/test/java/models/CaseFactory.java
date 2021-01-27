package models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class CaseFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Case getCase(int suiteId) {
        return Case.builder()
                .id(1)
                .title(usFaker.company().name())
                .position(1)
                .suite_id(suiteId)
                .description(usFaker.company().catchPhrase())
                .preconditions(usFaker.lorem().word())
                .postconditions(usFaker.lorem().word())
                .build();
    }
}

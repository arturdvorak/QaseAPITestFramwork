package models;

import com.github.javafaker.Faker;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ProjectFactory {
    static Faker usFaker = new Faker(new Locale("en-US"));

    public Project getProject() {
        return Project.builder().title(usFaker.company().name())
                .description(usFaker.company().name())
                .code(usFaker.lorem().word() + "A")
                .access("all")
                .group("Test123")
                .build();
    }
}

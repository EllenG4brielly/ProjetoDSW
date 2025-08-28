package br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories;

import com.github.javafaker.Faker; //biblioteca para criar dados falsos
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository { //simulação de BD

    private List<User> internalDataset = new ArrayList<>();

    public UserRepository() {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++){ //criar 100 usuarios

            User user = new User(UUID.randomUUID(),
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.internet().password(8,16)
            );
        this.internalDataset.add(user);

    }
}

public List<User> findAll() {
    return this.internalDataset.stream().toList();
}
}


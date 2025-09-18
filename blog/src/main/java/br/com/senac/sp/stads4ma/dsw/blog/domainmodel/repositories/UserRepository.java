package br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories;

import java.util.*;

import com.github.javafaker.Faker; //biblioteca para criar dados falsos
import org.springframework.stereotype.Component;

@Component
public class UserRepository { //simulação de BD

    private Set<User> internalDataset = new HashSet<>();

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

    public User findById(UUID id) {
        if( this.internalDataset.contains(this.forgeUser(id))){
            List<User> users = this.internalDataset.stream().toList();
            return users.get(
                    users.indexOf(
                            this.forgeUser(id)
                    )
            );
        }
        return null;
    }

    public boolean removeById(UUID id) {
        User user = this.findById(id);
        if(user != null)
            return this.internalDataset.remove(user);
        return false;
    }

    private static User forgeUser(UUID id) {
        return new User(id);
    }

    public User create(User user) {
        if(this.internalDataset.add(user))
            return user;
        return null;
    }
}



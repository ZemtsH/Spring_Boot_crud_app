package com.example.spring.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.spring.models.User;
import com.example.spring.repositories.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        createUser("Vasya", "Pupkin", "v.pupkin@example.com", "1234567890", "password1");
        createUser("Petya", "Petushok", "p.petushok@example.com", "9876543210", "password2");
        createUser("Katya", "Kotik", "k.kotik@example.com", "0123456789", "password3");
    }

    private void createUser(String name, String lastName, String email, String phoneNumber, String password) {
        if (userRepository.findByName(name) == null) {
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setPassword(password);
            userRepository.save(user);
        }
    }
}
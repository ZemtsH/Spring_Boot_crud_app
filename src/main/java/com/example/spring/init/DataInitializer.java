package com.example.spring.init;

import com.example.spring.models.User;
import com.example.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setName("Vasya");
        user1.setLastName("Pupkin");
        user1.setEmail("v.pupkin@example.com");
        user1.setPhoneNumber("1234567890");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Petya");
        user2.setLastName("Petushok");
        user2.setEmail("p.petushok@example.com");
        user2.setPhoneNumber("9876543210");
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Katya");
        user3.setLastName("Kotik");
        user3.setEmail("k.kotik@example.com");
        user3.setPhoneNumber("0123456789");
        userRepository.save(user3);
    }
}

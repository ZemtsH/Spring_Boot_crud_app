package com.example.spring.service;
import com.example.spring.models.User;
import com.example.spring.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testTableCreationOnDrop() {
        userRepository.deleteAll();
        userRepository.flush();

        User user = new User();
        user.setName("Vasya");
        user.setLastName("Vasin");
        user.setEmail("v.vasin@example.com");
        user.setPhoneNumber("1234567890");
        userRepository.save(user);
    }
}
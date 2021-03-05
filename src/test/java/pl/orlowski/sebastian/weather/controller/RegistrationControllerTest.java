package pl.orlowski.sebastian.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetRegistrationPageException() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().is(200));
    }

    @Test
    @Transactional
    void shouldCreateNewUserException() throws Exception {
        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("testtest123");
        user.setPassword("Test12345");
        user.setEmail("testtest@test.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(201));
    }

    @Test
    void shouldThrowWrongEmailFormatException() throws Exception {
        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("testtest123");
        user.setPassword("Test12345");
        user.setEmail("testtesttest.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(403))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("Wrong email format!"));
    }

    @Test
    void shouldThrowWrongUsernameException() throws Exception {
        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("aaa");
        user.setPassword("Test12345");
        user.setEmail("testtest@test.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(403))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("Username must have 5 - 15 characters length and contain (Aa-zZ 0-9 characters)."));
    }

    @Test
    void shouldThrowWrongPasswordException() throws Exception {
        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("testtest123");
        user.setPassword("test12345");
        user.setEmail("testtest@test.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(403))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("This password is too weak! Must contain 8-30 characters and at least one upper character!"));
    }

    @Test
    @Transactional
    void shouldThrowEmailIsExistException() throws Exception {
        UserRegistrationDto userTest = new UserRegistrationDto();
        userTest.setUsername("testtest33123");
        userTest.setPassword("Test12343335");
        userTest.setEmail("testtest@gmail.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userTest)))
                .andExpect(status().is(201));

        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("testtest123");
        user.setPassword("Test12345");
        user.setEmail("testtest@gmail.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(400))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("This email is already exist: " + user.getEmail()));
    }

    @Test
    @Transactional
    void shouldThrowUsernameIsExistException() throws Exception {
        UserRegistrationDto userTest = new UserRegistrationDto();
        userTest.setUsername("testtest123");
        userTest.setPassword("Test12343335");
        userTest.setEmail("testtest123@gmail.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userTest)))
                .andExpect(status().is(201));

        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("testtest123");
        user.setPassword("Test12345");
        user.setEmail("testtest@gmail.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(400))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("This user is already exist: " + user.getUsername()));
    }

    @Test
    void shouldThrowEmptyValueException() throws Exception {
        UserRegistrationDto user = new UserRegistrationDto();
        user.setUsername("");
        user.setPassword("Test12345");
        user.setEmail("testtest@test.com");

        mockMvc.perform(post("/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().is(403))
                .andExpect(mvcResult -> jsonPath("$.message")
                        .value("Value cannot be empty!"));
    }
}
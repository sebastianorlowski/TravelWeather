package pl.orlowski.sebastian.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.TripRepository;
import pl.orlowski.sebastian.weather.service.TripService;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = "/insert_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/drop_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TripController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    @WithMockUser(username = "testtest1", password = "Test12345")
//    void shouldReturnOneTrip() throws Exception{
//
//
//        mockMvc.perform(get("/api/v1/trips")
//                .contentType(MediaType.APPLICATION_JSON)
//                .andExpect(status().is(200))
//                .andExpect(mvcResult -> jsonPath("$.message"));
//    }

//    @Test
//    @WithMockUser(username = "test", password = "test", roles = "USER")
//    @Transactional
//    void shouldCreateTrip() throws Exception {
//        Trip trip = new Trip();
//        trip.setName("Trip to USA");
//
//        mockMvc.perform(post("/api/v1/trips")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(trip)))
//                .andExpect(status().is(201))
//                .andExpect(mvcResult -> jsonPath("$.message"));
//    }
}

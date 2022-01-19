package com.pjatk.donuts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DonutControllerIT {
  @Autowired private MockMvc mockMvc;

  @Test
  void shouldGetExample() throws Exception {
    mockMvc
        .perform(get("/donut/example"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    "{\"id\":null,\"name\":\"Example Donut\",\"shape\":\"ROUND\",\"filling\":\"ROSE\",\"icing\":\"CYAN\",\"weightInGrams\":100.0,\"calorieCount\":350.0,\"glutenFree\":false}"));
  }

  @Test
  void shouldGetExampleWithName() throws Exception {
    mockMvc
        .perform(get("/donut/example-with-name").param("name", "test"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    "{\"id\":null,\"name\":\"test\",\"shape\":\"ROUND\",\"filling\":\"ROSE\",\"icing\":\"CYAN\",\"weightInGrams\":100.0,\"calorieCount\":350.0,\"glutenFree\":false}"));
  }

  @Test
  void shouldGetNew() throws Exception {
    mockMvc
        .perform(
            get("/donut/new")
                .param("name", "test")
                .param("shape", "ROUND")
                .param("filling", "ROSE")
                .param("icing", "PINK")
                .param("weightInGrams", "200")
                .param("calorieCount", "700")
                .param("isGlutenFree", "false"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(
            content()
                .string(
                    "{\"id\":1,\"name\":\"test\",\"shape\":\"ROUND\",\"filling\":\"ROSE\",\"icing\":\"PINK\",\"weightInGrams\":200.0,\"calorieCount\":700.0,\"glutenFree\":false}"));
  }
}

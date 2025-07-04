package com.wipro.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class StudentControllerMockMvcTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new StudentController())
                .setViewResolvers(viewResolver()) // View Resolver setup for JSP
                .build();
    }

    private InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Test
    void testPostStudentForm() throws Exception {
        mockMvc.perform(post("/saveStudent")
                        .param("studentId", "101")
                        .param("studentName", "John Doe"))
                .andExpect(status().isOk())
                .andExpect(view().name("display"))
                .andExpect(model().attributeExists("xyz"))
                .andExpect(model().attribute("xyz", hasProperty("stid", is(101))))
                .andExpect(model().attribute("xyz", hasProperty("stname", is("John Doe"))));
    }

    @Test
    void testPostStudentForm_WithEmptyName() throws Exception {
        mockMvc.perform(post("/saveStudent")
                        .param("studentId", "101")
                        .param("studentName", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("display"))
                .andExpect(model().attributeExists("xyz"))
                .andExpect(model().attribute("xyz", hasProperty("stid", is(101))))
                .andExpect(model().attribute("xyz", hasProperty("stname", is(""))));
    }
}

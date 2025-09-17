package com.nie.csd.controllersTests;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import com.nie.csd.controllers.ProductController;
import org.junit.jupiter.api.Test;

@WebMvcTest(ProductController.class)
public class ProductControllerTestClass {
    
    // @Autowired
    // ProductController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("HELLO"));
        
    }
}

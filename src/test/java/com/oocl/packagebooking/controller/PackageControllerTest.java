package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.PackageBase;
import com.oocl.packagebooking.service.PackageBaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PackageController.class)
public class PackageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageBaseService packageBaseService;

    @Test
    void should_add_a_package() throws Exception{
        PackageBase testPackage = new PackageBase("1270032154","Dean","13365482484",20);
        String postData = "{\n" +
                "\t\"trackingNumber\":\"1270032154\",\n" +
                "\t\"recipient\" :\"Dean\",\n" +
                "\t\"phoneNumber\": \"13365482484\",\n" +
                "\t\"weight\":20\n" +
                "}";
        when(packageBaseService.save(ArgumentMatchers.any())).thenReturn(testPackage);
        ResultActions resultActions = mockMvc.perform(post("/packages").contentType(MediaType.APPLICATION_JSON).content(postData));
        resultActions.andExpect(status().isOk());
    }


}
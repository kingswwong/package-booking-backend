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

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
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

    @Test
    void should_find_all_package() throws Exception{
        PackageBase testPackage1 = new PackageBase("12700321541","Dean1","13365482484",20);
        PackageBase testPackage2 = new PackageBase("12700321542","Dean2","13365482484",30);
        PackageBase testPackage3 = new PackageBase("12700321543","Dean3","13365482484",40);

        when(packageBaseService.findAll()).thenReturn(Arrays.asList(testPackage1,testPackage2,testPackage3));
        ResultActions resultActions = mockMvc.perform(get("/packages"));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)));
    }

    @Test
    void should_update_a_package_status_to() throws Exception{
        PackageBase testPackage1 = new PackageBase("12700321541","Dean1","13365482484",20);
        testPackage1.setStatus(1);
        testPackage1.setAppointmentTime(new Date());
        String postData = "{\n" +
                "\t\"trackingNumber\":\"13364523\",\n" +
                "\t\"appointmentTime\": \"321654545455\"\n" +
                "}";
        when(packageBaseService.findByAppointmentAndUpdate(ArgumentMatchers.any())).thenReturn(testPackage1);
        ResultActions resultActions = mockMvc.perform(post("/packages/appointment").contentType(MediaType.APPLICATION_JSON).content(postData));
        resultActions.andExpect(status().isOk());
    }

    @Test
    void should_find_list_by_status() throws Exception{
        PackageBase testPackage1 = new PackageBase("12700321541","Dean1","13365482484",20);
        PackageBase testPackage2 = new PackageBase("12700321542","Dean2","13365482484",30);

        testPackage1.setStatus(0);
        testPackage2.setStatus(1);
        when(packageBaseService.findAllByStatus(ArgumentMatchers.anyInt())).thenReturn(Arrays.asList(testPackage1));
        ResultActions resultActions = mockMvc.perform(get("/packages?status=0"));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));
    }
}
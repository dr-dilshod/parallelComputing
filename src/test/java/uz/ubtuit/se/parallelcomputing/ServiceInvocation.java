/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.ubtuit.se.parallelcomputing;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dilshod
 */
public class ServiceInvocation {
    
    public ServiceInvocation() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddDoctor() throws UnirestException {
        Doctor d = new Doctor(); // This is your own object
        d.setFirstName("Ruslanbek");
        d.setLastName("Berdiev");
        d.setLogin("eshmat");
        d.setPassword("peshmat");
        d.setBirthDate(Date.valueOf("1995-01-01"));
        d.setAddress("Khonqa City");
        Gson serializer = new Gson();
        HttpResponse<String> response;
        //Unirest.setObjectMapper(new GsonObjectMapper());
        response = Unirest.put("http://192.168.0.19:9998/api/doctor/AddDoctor").
                header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(serializer.toJson(d))
                .asString();
    }
    @Test
    public void testGetDoctor() throws UnirestException {
        HttpResponse<String> response;
        //Unirest.setObjectMapper(new GsonObjectMapper());
        response = Unirest.get("http://localhost:8080/TestProject/webresources/uz.ubtuit.se.hrd.testproject.doctor/count").
                header("Content-Type", "text/plain")
                .asString();
        System.out.println("Natija == " + response.getBody());
    } 
}

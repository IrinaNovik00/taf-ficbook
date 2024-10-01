package net.ficbook.irinanovik.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.ficbook.irinanovik.ui.data.RandomData;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class Api {
    @Test
    public void testGetRequest(){
            RestAssured.baseURI = Paths.BASE_URL;
            Response response =  when().get(Paths.START_URL);
        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }

    @Test
    public void testFormDataInLoginForm() {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("login", RandomData.getRandomLogin());
        formParam.put("password", RandomData.getRandomPassword());
        formParam.put("remember", "true");
        Response response =
        given().
                config(RestAssured.config().
                        encoderConfig(encoderConfig().
                                encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                formParams(formParam).
                headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                when().
                post(Paths.BASE_URL + Paths.LOGIN_URL);
        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }

    @Test
    public void testEmptyFormDataInLoginForm() {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("login", "");
        formParam.put("password", "");
        formParam.put("remember", "true");
        Response response =
                given().
                        config(RestAssured.config().
                                encoderConfig(encoderConfig().
                                        encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                        formParams(formParam).
                        headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                        when().
                        post(Paths.BASE_URL + Paths.LOGIN_URL);
        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }

    @Test
    public void testEmptyLoginFormDataInLoginForm() {
        Map<String, String> formParam = new HashMap<>();
        formParam.put("login", "");
        formParam.put("password", RandomData.getRandomPassword());
        formParam.put("remember", "true");
        Response response =
                given().
                        config(RestAssured.config().
                                encoderConfig(encoderConfig().
                                        encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                        formParams(formParam).
                        headers("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>").
                        when().
                        post(Paths.BASE_URL + Paths.LOGIN_URL);
        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
    }

}

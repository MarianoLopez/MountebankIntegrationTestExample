package com.z.mounte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;


class MessageResourceTest extends BaseIntegrationTest{

    @Test
    @DisplayName("Should do http GET to / and retrieve the message response")
    void getMessage() throws Exception {
        given()
        .when()
            .get("/")
        .then()
            .status(OK)
            .body("message", is("Hello from Mountebank"));
    }
}
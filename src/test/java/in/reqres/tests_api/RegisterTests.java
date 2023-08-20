package in.reqres.tests_api;

import in.reqres.models.PostRegisterBodyModel;
import in.reqres.models.PostRegisterResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTests extends TestBase{

    @Test
    @Tag("ApiTests")
    void postCreateUserTest() {
        PostRegisterBodyModel register = new PostRegisterBodyModel();
        register.setEmail("eve.holt@reqres.in");
        register.setPassword("pistol");

        PostRegisterResponseModel postRegisterResponseModel = step("Make request", () ->

                given(postRegisterRequestSpec)
                        .body(register)
                        .when()
                        .post("/register")
                        .then()
                        .spec(postRegisterResponseSpec)
                        .extract().as(PostRegisterResponseModel.class));

        step("Check response", () -> {
            assertEquals("4", postRegisterResponseModel.getId());
            assertEquals("QpwL5tke4Pnpja7X4", postRegisterResponseModel.getToken());
        });
    }
}

package in.reqres.tests_api;

import in.reqres.models.LoginBodyModel;
import in.reqres.models.LoginResponseModel;
import in.reqres.models.PostUnsuccessfulLoginBodyModel;
import in.reqres.models.PostUnsuccessfulLoginResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API_Tests")
@Feature("Authorizations")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Успешный логин")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void postSuccessfulLoginTest() {

        LoginBodyModel authData = new LoginBodyModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseModel loginResponse = step("Make request", () ->
                given(requestSpec)
                        .body(authData)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpecWithStatusCode200)
                        .extract().as(LoginResponseModel.class));

        step("Check response", () ->
                assertEquals("QpwL5tke4Pnpja7X4", loginResponse.getToken()));

    }

    @Test
    @DisplayName("Неуспешный логин")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void postUnsuccessfulLoginTest() {

        PostUnsuccessfulLoginBodyModel postUnsuccessfulLoginBodyModel = new PostUnsuccessfulLoginBodyModel();
        postUnsuccessfulLoginBodyModel.setEmail("peter@klaven");

        PostUnsuccessfulLoginResponseModel postUnsuccessfulLoginResponseModel = step("Make request", () ->
                given(requestSpec)
                        .body(postUnsuccessfulLoginBodyModel)
                        .when()
                        .post("/login")
                        .then()
                        .spec(postUnsuccessfulLoginResponseSpecWithStatusCode400)
                        .extract().as(PostUnsuccessfulLoginResponseModel.class));

        step("Check response", () ->
                assertEquals("Missing password", postUnsuccessfulLoginResponseModel.getError()));
    }
}

package in.reqres.tests_api;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import in.reqres.models.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static in.reqres.specs.Specifications.*;

@Epic("API_Tests")
@Feature("Authorizations")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Успешный логин")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void postSuccessfulLoginTest() {

        LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModel loginResponse = step("Make request", () ->
                given(loginRequestSpec)
                        .body(authData)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponseLombokModel.class));

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
                given(postUnsuccessfulLoginRequestSpec)
                        .body(postUnsuccessfulLoginBodyModel)
                        .when()
                        .post("/login")
                        .then()
                        .spec(postUnsuccessfulLoginResponseSpec)
                        .extract().as(PostUnsuccessfulLoginResponseModel.class));

        step("Check response", () ->
                assertEquals("Missing password", postUnsuccessfulLoginResponseModel.getError()));
    }
}

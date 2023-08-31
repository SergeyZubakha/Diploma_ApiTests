package in.reqres.tests_api;

import in.reqres.models.PostRegisterBodyModel;
import in.reqres.models.PostRegisterResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.postRegisterResponseSpecWithStatusCode200;
import static in.reqres.specs.Specifications.requestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API_Tests")
@Feature("Registrations")
public class RegisterTests extends TestBase {

    @Test
    @DisplayName("Регистрация нового пользователя")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.CRITICAL)
    void postCreateUserTest() {
        PostRegisterBodyModel register = new PostRegisterBodyModel();
        register.setEmail("eve.holt@reqres.in");
        register.setPassword("pistol");

        PostRegisterResponseModel postRegisterResponseModel = step("Make request", () ->

                given(requestSpec)
                        .body(register)
                        .when()
                        .post("/register")
                        .then()
                        .spec(postRegisterResponseSpecWithStatusCode200)
                        .extract().as(PostRegisterResponseModel.class));

        step("Check response", () -> {
            assertEquals("4", postRegisterResponseModel.getId());
            assertEquals("QpwL5tke4Pnpja7X4", postRegisterResponseModel.getToken());
        });
    }
}

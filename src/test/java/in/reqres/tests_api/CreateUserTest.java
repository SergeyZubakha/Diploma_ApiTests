package in.reqres.tests_api;

import in.reqres.models.PostCreateBodyModel;
import in.reqres.models.PostCreateResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.postCreateResponseSpecWithStatusCode201;
import static in.reqres.specs.Specifications.requestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API_Tests")
@Feature("CreateUser")
public class CreateUserTest extends TestBase {
    @Test
    @DisplayName("Создание нового юзера")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
    void postCreateUserTest() {
        PostCreateBodyModel newUser = new PostCreateBodyModel();
        newUser.setName("morpheus");
        newUser.setJob("leader");

        PostCreateResponseModel postCreateResponseModel = step("Make request", () ->

                given(requestSpec)
                        .body(newUser)
                        .when()
                        .post("/users")
                        .then()
                        .spec(postCreateResponseSpecWithStatusCode201)
                        .extract().as(PostCreateResponseModel.class));

        step("Check response", () -> {
            assertEquals("morpheus", postCreateResponseModel.getName());
            assertEquals("leader", postCreateResponseModel.getJob());
        });
    }
}

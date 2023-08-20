package in.reqres.tests_api;

import in.reqres.models.PostCreateBodyModel;
import in.reqres.models.PostCreateResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.postCreateRequestSpec;
import static in.reqres.specs.Specifications.postCreateResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest extends TestBase {
    @Test
    @Tag("ApiTests")
    void postCreateUserTest() {
        PostCreateBodyModel newUser = new PostCreateBodyModel();
        newUser.setName("morpheus");
        newUser.setJob("leader");

        PostCreateResponseModel postCreateResponseModel = step("Make request", () ->

                given(postCreateRequestSpec)
                        .body(newUser)
                        .when()
                        .post("/users")
                        .then()
                        .spec(postCreateResponseSpec)
                        .extract().as(PostCreateResponseModel.class));

        step("Check response", () -> {
            assertEquals("morpheus", postCreateResponseModel.getName());
            assertEquals("leader", postCreateResponseModel.getJob());
        });

    }
}

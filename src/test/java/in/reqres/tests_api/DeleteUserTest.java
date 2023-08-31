package in.reqres.tests_api;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specifications.deleteResponseSpecWithStatusCode204;
import static in.reqres.specs.Specifications.requestSpec;
import static io.restassured.RestAssured.given;

public class DeleteUserTest extends TestBase {
    @Test
    @DisplayName("Удаление юзера")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
    void deleteUserTest() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(deleteResponseSpecWithStatusCode204);
    }
}

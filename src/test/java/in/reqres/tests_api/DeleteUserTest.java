package in.reqres.tests_api;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static in.reqres.specs.Specifications.deleteRequestSpec;
import static in.reqres.specs.Specifications.deleteResponseSpec;
import static io.restassured.RestAssured.given;

public class DeleteUserTest extends TestBase{
    @Test
    @DisplayName("Удаление юзера")
    @Owner("s.zubakha")
    @Severity(SeverityLevel.NORMAL)
    void deleteUserTest() {
        given()
                .spec(deleteRequestSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(deleteResponseSpec);
    }
}

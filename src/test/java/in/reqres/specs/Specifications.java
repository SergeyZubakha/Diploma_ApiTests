package in.reqres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static in.reqres.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Specifications {
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON);
    public static ResponseSpecification loginResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/success-login-response-schems.json"))
            .build();

    public static ResponseSpecification getUser2ResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/getUsers-response-schemas.json"))
            .build();

    public static ResponseSpecification postCreateResponseSpecWithStatusCode201 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .expectBody(matchesJsonSchemaInClasspath("schemas/postCreate-response-schemas.json"))
            .build();

    public static ResponseSpecification postUnsuccessfulLoginResponseSpecWithStatusCode400 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath("schemas/postUnsuccessfulLogin-response-schemas.json"))
            .build();

    public static ResponseSpecification getUsersResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/status-response-schema.json"))
            .build();

    public static ResponseSpecification postRegisterResponseSpecWithStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/postRegister-response-schemas.json"))
            .build();

    public static ResponseSpecification deleteResponseSpecWithStatusCode204 = new ResponseSpecBuilder()
            .log(STATUS)
            .expectStatusCode(204)
            .build();
}

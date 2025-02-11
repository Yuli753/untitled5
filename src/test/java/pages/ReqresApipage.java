package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqresApipage {
    private String baseUrl = "https://reqres.in/";
    private static Response response;

    public void setEndpoint(String endpoint) {
        RestAssured.baseURI = baseUrl + endpoint;
    }

    public Response sendGetRequest() {
        response = given()
                .when()
                .get()
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response sendPOSTRequest(String requestBody) {
        response = given()
                .header("Content-Type", "Application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract()
                .response();
        return response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getBodyResponse() {
        return response.getBody().asString();
    }
}

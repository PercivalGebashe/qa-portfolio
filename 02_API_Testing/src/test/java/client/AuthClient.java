package client;

import config.ConfigManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.auth.AuthRequest;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseClient{
    public AuthClient(RequestSpecification requestSpec) {
        super(requestSpec);
    }

    public Response createToken(){

        String baseUrl = ConfigManager.getBaseUrl();

        AuthRequest authRequest = new AuthRequest(
                ConfigManager.getAuthUsername(),
                ConfigManager.getAuthPassword()
        );

        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(authRequest)
                .post("/auth");
    }
}

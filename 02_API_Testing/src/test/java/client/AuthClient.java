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

        String baseUrl = ConfigManager.get("base.url");

        AuthRequest authRequest = new AuthRequest(
                ConfigManager.get("auth.username"),
                ConfigManager.get("auth.password")
        );

        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(authRequest)
                .post("/auth");
    }
}

package client;

import config.ConfigManager;
import filter.AllureLoggingFilter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    private RequestSpecFactory(){}

    public static RequestSpecification create(){
        return new RequestSpecBuilder()
            .setBaseUri(ConfigManager.getBaseUrl())
            .setContentType(ContentType.JSON)
            .addFilter(new AllureLoggingFilter())
            .addHeader("Accept", "application/json")
            .build();
    }

    public static RequestSpecification addHeader(
            RequestSpecification requestSpecification,
            String headerName,
            String headerValue)
    {
        Header header = new Header(headerName, headerValue);
        return requestSpecification.header(header);
    }


}

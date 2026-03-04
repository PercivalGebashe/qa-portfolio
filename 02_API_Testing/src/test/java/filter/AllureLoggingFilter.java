package filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AllureAttachmentManager;

public class AllureLoggingFilter implements Filter {

    private static final Logger logger =
            LoggerFactory.getLogger(AllureLoggingFilter.class);

    private final boolean debugEnabled =
            Boolean.parseBoolean(System.getProperty("debug", "false"));

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        long start = System.currentTimeMillis();

        Response response = ctx.next(requestSpec, responseSpec);

        long duration = System.currentTimeMillis() - start;

        boolean shouldAttach =
                debugEnabled || response.statusCode() >= 400;

        if (shouldAttach) {

            String requestDetails = buildRequestLog(requestSpec);
            String responseDetails = buildResponseLog(response, duration);

            // Attach to Allure
            AllureAttachmentManager.attachText("HTTP Request", requestDetails);
            AllureAttachmentManager.attachJson("HTTP Response",
                    response.getBody().asPrettyString());

            logger.info("Request/Response attached to Allure report.");
        }

        logger.info("{} {} -> {} ({} ms)",
                requestSpec.getMethod(),
                requestSpec.getURI(),
                response.statusCode(),
                duration);

        return response;
    }

    private String buildRequestLog(FilterableRequestSpecification requestSpec) {

        StringBuilder sb = new StringBuilder();

        sb.append("Method: ").append(requestSpec.getMethod()).append("\n");
        sb.append("URI: ").append(requestSpec.getURI()).append("\n");

        if (requestSpec.getBody() != null) {
            sb.append("Body:\n").append(requestSpec.getBody().toString()).append("\n");
        }

        return sb.toString();
    }

    private String buildResponseLog(Response response, long duration) {

        return "Status: " + response.statusCode() + "\n" +
                "Time: " + duration + " ms\n" +
                "Body:\n" + response.getBody().asPrettyString();
    }
}
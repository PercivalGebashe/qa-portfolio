package mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class ResponseMapper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private ResponseMapper(){}

    public static <T> T map(Response response, Class<T> clazz){
        try{
            return OBJECT_MAPPER.readValue(
                    response.getBody().asString(),
                    clazz
            );
        }catch (Exception e){
            throw new RuntimeException("Failed to deserialize response info: " + clazz.getSimpleName(), e);
        }
    }
}

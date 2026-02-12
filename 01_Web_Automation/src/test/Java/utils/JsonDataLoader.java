package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import context.TestRunContext;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonDataLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T loadWithContext(String path, Class<T> clazz, TestRunContext context){
        try(InputStream ins =
                    JsonDataLoader.class
                        .getClassLoader()
                        .getResourceAsStream(path)){
            if(ins == null){
                throw new RuntimeException("Test data file not found: " + path);
            }

            String json = new String(ins.readAllBytes(), StandardCharsets.UTF_8);
            json = json.replace("{{REF}}", context.getReference());
            return mapper.readValue(ins, clazz);

        }catch (Exception e){
            throw new RuntimeException("Failed to load test data: " + path);
        }
    }
}

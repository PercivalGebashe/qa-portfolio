package config;

public enum Environment {
    DEV,
    TEST,
    STAGING;

    public static Environment from(String value){
        if(value == null) return DEV;

        try {
            return Environment.valueOf(value.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Invalid environment: " + value);
        }
    }
}

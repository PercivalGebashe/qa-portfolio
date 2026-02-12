package context;

public class TestRunContext {

    private final String reference;

    public TestRunContext() {
        this.reference = generateReference();
    }

    private String generateReference() {
        int number = 100000 + (int)(Math.random() * 900000);
        return String.valueOf(number);
    }

    public String getReference() {
        return reference;
    }
}

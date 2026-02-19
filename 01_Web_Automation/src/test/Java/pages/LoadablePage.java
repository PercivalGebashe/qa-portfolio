package pages;

public interface LoadablePage {

    void waitUntilLoaded();
    boolean isLoaded();
}

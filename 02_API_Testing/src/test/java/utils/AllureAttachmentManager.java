package utils;

import io.qameta.allure.Allure;

public class AllureAttachmentManager {

    private AllureAttachmentManager() {}

    public static void attachJson(String name, String content) {
        Allure.addAttachment(name, "application/json", content, ".json");
    }

    public static void attachText(String name, String content) {
        Allure.addAttachment(name, "text/plain", content);
    }
}
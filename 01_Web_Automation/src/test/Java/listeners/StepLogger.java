package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import utils.ExtentTestManager;
import utils.ScreenshotUtils;

import java.util.HashMap;
import java.util.Map;

public class StepLogger implements ConcurrentEventListener {

    private final Map<String, Long> startTimes = new HashMap<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    private void stepStarted(TestStepStarted event) {
        startTimes.put(event.getTestStep().getId().toString(), System.currentTimeMillis());
    }

    private void stepFinished(TestStepFinished event) {

        if (!(event.getTestStep() instanceof PickleStepTestStep step))
            return;

        String stepId = event.getTestStep().getId().toString();
        long duration =
                System.currentTimeMillis() - startTimes.getOrDefault(stepId, 0L);

        String stepText =
                step.getStep().getKeyword() +
                        step.getStep().getText();

        Status status = mapStatus(event.getResult().getStatus());

        try {
            if (status == Status.FAIL) {

                String screenshot = ScreenshotUtils.captureBase64();

                ExtentTestManager.getTest().log(
                        status,
                        stepText + " (" + duration + " ms)",
                        MediaEntityBuilder
                                .createScreenCaptureFromBase64String(screenshot)
                                .build()
                );

            } else {
                ExtentTestManager.getTest()
                        .log(status, stepText + " (" + duration + " ms)");
            }

        } catch (Exception e) {
            ExtentTestManager.getTest()
                    .log(Status.WARNING, "Screenshot failed");
        }
    }

    private Status mapStatus(io.cucumber.plugin.event.Status cucumberStatus) {
        return switch (cucumberStatus) {
            case PASSED -> Status.PASS;
            case FAILED -> Status.FAIL;
            case SKIPPED -> Status.SKIP;
            default -> Status.INFO;
        };
    }
}
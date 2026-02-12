package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class Vacancy {

    private String vacancyName;
    private String jobTitle;
    private String hiringManager;
    private String numberOfPositions;

    public Vacancy() {}

    public String getVacancyName() {
        return vacancyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public String getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setHiringManager(String hiringManager) {
        this.hiringManager = hiringManager;
    }

    public void setNumberOfPositions(String numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public static Vacancy fromJson(String fileName, TestRunContext context){
        return JsonDataLoader.loadWithContext(
                "testdata/vacancy/" + fileName,
                Vacancy.class,
                context
        );
    }
}

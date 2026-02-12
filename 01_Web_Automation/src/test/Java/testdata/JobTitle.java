package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class JobTitle {
    private String jobTitle;

    public JobTitle(){}

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public static JobTitle fromJson(String fileName, TestRunContext context){
        return JsonDataLoader.loadWithContext(
                "testdata/jobTitle/" + fileName,
                JobTitle.class,
                context
        );
    }
}

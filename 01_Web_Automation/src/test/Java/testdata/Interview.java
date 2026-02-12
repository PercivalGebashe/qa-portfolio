package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class Interview {
    private String title;
    private String interviewer;
    private String date;
    private String time;

    public Interview(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static Interview fromJson(String fileName, TestRunContext context){
        return JsonDataLoader.loadWithContext(
                "testdata/interview/" + fileName,
                Interview.class,
                context);
    }
}

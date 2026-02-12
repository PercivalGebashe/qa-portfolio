package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class Candidate {
    private String jobTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String vacancyName;

    public Candidate(){

    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public static Candidate fromJson(String fileName, TestRunContext context){
        return JsonDataLoader.loadWithContext(
                "testdata/candidate/" + fileName,
                Candidate.class,
                context
        );
    }
}

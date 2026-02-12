package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class AdminUser {
    private String employeeName;
    private String username;
    private String password;
    private String role;
    private String status;

    public AdminUser(){

    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static AdminUser fromJson(String fileName, TestRunContext context){
        return JsonDataLoader.loadWithContext(
                "testdata/adminUser/" + fileName,
                AdminUser.class,
                context
        );
    }
}

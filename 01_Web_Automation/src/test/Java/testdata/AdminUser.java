package testdata;

import context.TestRunContext;
import utils.JsonDataLoader;

public class AdminUser {
    private String employeeFirstName;
    private String employeeLastName;
    private String username;
    private String password;
    private String role;
    private String status;

    public AdminUser(){

    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
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

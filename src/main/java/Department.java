/**
 * Created by daniel on 6/9/17.
 */
public class Department {
    private String departmentName;
    private String departmentNumber;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(String departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Department(String departmentName, String departmentNumber) {
        this.departmentName = departmentName;
        this.departmentNumber = departmentNumber;
    }
}

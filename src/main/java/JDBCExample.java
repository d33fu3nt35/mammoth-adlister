import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 6/9/17.
 */
public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Config config = new Config();
        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );

//        insertExample(connection);
        List<Department> departments = selectExample(connection);
        for (Department department : departments) {
            System.out.println(department.getDepartmentName());
            System.out.println(department.getDepartmentNumber());
        }
    }

    public static void insertExample(Connection connection) throws SQLException {

        Statement stmt = connection.createStatement();

        String query = "INSERT INTO departments(dept_no, dept_name) VALUES";

        query += "('d011', 'Payroll')";

        stmt.execute(query);

    }

    public static List<Department> selectExample(Connection connection) throws SQLException {

        String query = "SELECT * FROM departments";
        System.out.println(query);

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Department> departments = new ArrayList<>();

        while(rs.next()) {

           String departmentName = rs.getString("dept_name");
           String departmentNumber = rs.getString("dept_no");
            Department d = new Department(departmentName, departmentNumber);
            departments.add(d);
        }

        return departments;

    }

}

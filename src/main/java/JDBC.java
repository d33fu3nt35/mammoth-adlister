//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class JDBCExample {
//
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Config config = new Config();
//
//        Connection connection = DriverManager.getConnection(
//                config.getUrl(),
//                config.getUsername(),
//                config.getPassword()
//        );
//        // instead of static methods, these will eventually live in a DAO
////        insertExample(connection);
//        List<Department> departments = selectExample(connection);
//        // instead of printing to the console, we could pass this to a jsp
//        for (Department department : departments) {
//            System.out.println(department.getDepartmentName());
//            System.out.println(department.getDepartmentNumber());
//        }
//    }
//
//    public static void insertExample(Connection connection) throws SQLException {
//        Statement stmt = connection.createStatement();
//
//        // these strings could come from a POST request
//        // that is, an HTML form (or AJAX request)
//        String deptNo = "'d011'"; // request.getParameter("deptNo");
//        String deptName = "'Payroll'";
//
//        String query = "INSERT INTO departments(dept_no, dept_name) VALUES";
//        query += "(" + deptNo + ", " + deptName + ")";
//        stmt.execute(query);
//    }
//
//
//    // obtain a list of department objects
//    public static List<Department> selectExample(Connection connection) throws SQLException {
//        String query = "SELECT * FROM departments";
//        System.out.println(query);
//
//        Statement stmt = connection.createStatement();
//
//        ResultSet rs = stmt.executeQuery(query);
//
//        List<Department> departments = new ArrayList<>();
//
//        // move the cursor through the results
//        // this while loop will run once for each row in the results
//        while(rs.next()) {
//            String departmentName = rs.getString("dept_name");
//            String departmentNumber = rs.getString("dept_no");
//            Department d = new Department(departmentName, departmentNumber);
//            departments.add(d);
//        }
//
//        return departments;
//    }
//
//}
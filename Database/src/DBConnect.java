import java.sql.*;

public class DBConnect {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";
    public static void main(String[] args) {
        Connection connect = null;
        String sql = "SELECT * FROM employees";
        String prsql = "INSERT INTO employees (employees_name,employees_position,employees_salary) VALUES (?,?,?)";

        try {
            connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement st = connect.createStatement();
            PreparedStatement prSt = connect.prepareStatement(prsql);
            ResultSet data = st.executeQuery(sql);
            while(data.next()) {
                System.out.println();
                System.out.println("ID: " + data.getInt("employees_id"));
                System.out.println("Name: " + data.getString("employees_name"));
                System.out.println("Position: " + data.getString("employees_position"));
                System.out.println("Salary: " + data.getInt("employees_salary"));
                System.out.println("=================");
            }
            data.close();
            st.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
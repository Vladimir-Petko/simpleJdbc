import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tasks", "postgres", "postgres");
        if (con != null){
            System.out.println("connection ok");
        }else{
            System.out.println("no connection");
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

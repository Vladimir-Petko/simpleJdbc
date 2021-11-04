import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

    DatabaseConnector databaseConnector = new DatabaseConnector();
    databaseConnector.getNewConnection();
    }

}

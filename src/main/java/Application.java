import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    private static final String TABLE = "tasks";

    public static void main(String[] args) {

        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection connection = databaseConnector.getNewConnection();
        if (connection != null) {
            System.out.println("connection ok");
            if (!checkSchema(connection)) {
                createSchema(connection);
            }
        } else {
            System.out.println("no connection");
        }

        createSchema(connection);

    }

    private static boolean createSchema(Connection connection) {
        boolean result = false;
        String createSchema = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + "task_id VARCHAR(50) NOT NULL, "
                + "task_name VARCHAR(50) NOT NULL, "
                + "task_description VARCHAR(100) NOT NULL, "
                + "create_date TIMESTAMP "
                + ")";
        try (
                PreparedStatement ps = connection.prepareStatement(createSchema)) {
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean checkSchema(Connection connection){
        boolean result = false;

        return result;
    }
}

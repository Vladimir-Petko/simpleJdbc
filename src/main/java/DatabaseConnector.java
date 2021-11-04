import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    public Connection getNewConnection() {
        Connection connection;
        try (InputStream in = DatabaseConnector.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties config = new Properties();
            config.load(in);
            // Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            if (connection != null){
                System.out.println("connection ok");
            }else{
                System.out.println("no connection");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection;
    }
}

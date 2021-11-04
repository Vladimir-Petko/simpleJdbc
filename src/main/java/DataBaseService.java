import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBaseService {
    private static final Random RN = new Random();

    public DataBaseService() {
    }

    public void add(Task task, String table, Connection connection) {
        task.setId(this.generateId(RN));
        String insertTableSQL = "INSERT INTO " + table + " (task_id, task_name, task_description, create_date) VALUES" + "(?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(insertTableSQL)) {
            ps.setString(1, task.getId());
            ps.setString(2, task.getName());
            ps.setString(3, task.getDescription());
            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> findAll(String table, Connection connection) {
        List<Task> result = new ArrayList<>();
        //todo
        return result;
    }

    private String generateId(Random rn) {
        return String.valueOf(System.currentTimeMillis() + rn.nextInt(100));
    }
}

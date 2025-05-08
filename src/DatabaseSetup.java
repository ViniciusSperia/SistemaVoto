import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void initialize() {
        String sql1 = "CREATE TABLE IF NOT EXISTS candidates (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "number INTEGER UNIQUE NOT NULL," +
                "party TEXT NOT NULL," +
                "votes INTEGER DEFAULT 0" +
                ");";


        String sql2 = "CREATE TABLE IF NOT EXISTS votes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "candidate_number INTEGER NOT NULL," +
                "voter_id TEXT NOT NULL UNIQUE," +
                "FOREIGN KEY (candidate_number) REFERENCES candidates(number)" +
                ");";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql1);
            stmt.execute(sql2);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}

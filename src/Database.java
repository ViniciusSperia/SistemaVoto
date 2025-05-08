import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;

public class Database {
    private static final String DB_FOLDER = "database";
    private static final String DB_PATH = DB_FOLDER + "/voting.sqlite";
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    public static Connection getConnection() throws SQLException {
        ensureDatabaseFolderExists();
        return DriverManager.getConnection(URL);
    }

    private static void ensureDatabaseFolderExists() {
        File folder = new File(DB_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
}
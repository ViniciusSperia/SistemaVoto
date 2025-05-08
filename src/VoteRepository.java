import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoteRepository {

    public boolean hasAlreadyVoted(String voterId) {
        String sql = "SELECT 1 FROM votes WHERE voter_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, voterId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error checking voter: " + e.getMessage());
            return false;
        }
    }

    public boolean registerVote(int candidateNumber, String voterId) {
        String insertVote = "INSERT INTO votes (candidate_number, voter_id) VALUES (?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertVote)) {

            stmt.setInt(1, candidateNumber);
            stmt.setString(2, voterId);
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Error registering vote: " + e.getMessage());
            return false;
        }
    }
}

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {

    public boolean save(Candidate candidate) {
        String sql = "INSERT INTO candidates (name, number, party, votes) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, candidate.getName());
            stmt.setInt(2, candidate.getNumber());
            stmt.setString(3, candidate.getParty());
            stmt.setInt(4, candidate.getVotes());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Log apenas, sem System.out.println aqui
            System.err.println("Error saving candidate: " + e.getMessage());
            return false;
        }
    }

    public List<Candidate> findAll() {
        List<Candidate> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int number = rs.getInt("number");
                String party = rs.getString("party");
                int votes = rs.getInt("votes");

                candidates.add(new Candidate(id, name, number, party, votes));
            }

        } catch (SQLException e) {
            System.err.println("Error loading candidates: " + e.getMessage());
        }

        return candidates;
    }

    public Candidate findByNumber(int number) {
        String sql = "SELECT * FROM candidates WHERE number = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String party = rs.getString("party");
                int votes = rs.getInt("votes");

                return new Candidate(id, name, number, party, votes);
            }

        } catch (SQLException e) {
            System.err.println("Error finding candidate: " + e.getMessage());
        }

        return null;
    }

    public boolean updateVotes(int number, int newVoteCount) {
        String sql = "UPDATE candidates SET votes = ? WHERE number = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newVoteCount);
            stmt.setInt(2, number);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating votes: " + e.getMessage());
            return false;
        }
    }

    public boolean existsByNumber(int number) {
        String sql = "SELECT 1 FROM candidates WHERE number = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            System.err.println("Error checking candidate existence: " + e.getMessage());
            return false;
        }
    }
}

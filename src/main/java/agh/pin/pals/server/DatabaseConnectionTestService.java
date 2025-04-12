package agh.pin.pals.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectionTestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String testConnection() {
        try {
            // Try running a simple query to check the connection
            String sql = "SELECT 1";
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
            if (result != null && result == 1) {
                return "Database connection successful!";
            } else {
                return "Failed to verify database connection!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Database connection failed: " + e.getMessage();
        }
    }
}

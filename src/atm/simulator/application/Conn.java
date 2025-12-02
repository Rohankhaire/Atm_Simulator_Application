package atm.simulator.application;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Connect to PostgreSQL database
            c = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/AtmSimulatorSystem",
                "postgres",
                "0000"
            );

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/javacrud?useSSL=false&useTimezone=True&serverTimezone=UTC&allowPublicKeyRetrieval=True";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }

}

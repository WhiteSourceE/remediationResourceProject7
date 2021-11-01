package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

public class SqlUtils {

  public static Connection getJDBCConnection() {
    try {
      return DriverManager.getConnection("jdbc:sqlserver://myserver.database.windows.net:1433;");
    } catch (SQLException exception) {
      return null;
    }
  }

  public static Connection getSafeConnection() {
    try {
      return DriverManager.getConnection("jdbc:sqlserver://SandBox:1433;");
    } catch (SQLException exception) {
      return null;
    }
  }

  public static Statement getStatement() throws SQLException {
    return getJDBCConnection().createStatement();
  }

  public static String getUser(HttpServletRequest req, String prefix) {
    return req.getParameter("User_1");
  }

  public static String pad(String user) {
    return "user_" + user;
  }
}

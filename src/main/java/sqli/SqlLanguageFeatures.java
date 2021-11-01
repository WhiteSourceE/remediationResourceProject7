package sqli;

import static utils.SqlUtils.getJDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

public class SqlLanguageFeatures {
  HttpServletRequest request;

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

  void languageFeatures1() throws SQLException {

    String sql;
    String userid = request.getParameter("userid");
    Connection connection = getJDBCConnection();
    try (Statement statement = connection.createStatement()) {
      sql = "SELECT first_name FROM user_data WHERE userid = '"
          + userid + "'";
      statement.executeQuery(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  void languageFeatures2() throws SQLException {

    Connection dbConnection = null;
    PreparedStatement sqlStatement = null;
    String data = Integer.parseInt(request.getParameter("index")) == 1 ?
        "id_" + request.getParameter("one") : "id_" + request.getParameter("two");
    dbConnection = getJDBCConnection();

    sqlStatement = dbConnection.prepareStatement(
        "insert into users (status) values ('updated') where name='" + data + "'");

    sqlStatement.execute();
  }
}

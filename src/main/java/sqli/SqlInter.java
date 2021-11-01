package sqli;

import static utils.SqlUtils.getJDBCConnection;
import static utils.SqlUtils.pad;

import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

public class SqlInter {

  HttpServletRequest request;

  public void sqlInter1() throws SQLException {
    final String input = request.getParameter("user_id");
    Sql sql = new Sql() {
      public String getSql() {
        return "safe_" + input;
      }

      @Override
      public String getNameQuery(String name) {
        return " AND name = '" + name + "'";
      }

      @Override
      public String getUserIdOrDefault(String userId) {
        return null;
      }
    };
    Statement statement = getJDBCConnection().createStatement();
    statement.executeQuery("SELECT first_name FROM user_data WHERE userid = '" + sql.getSql() + "'");
  }

  public void sqlInter2() throws SQLException {
    final String input = request.getParameter("user_id");
    Statement statement = getJDBCConnection().createStatement();
    statement.executeQuery("SELECT first_name FROM user_data WHERE userid = '" + pad(input) + "'");
  }

  public void sqlInter3() throws SQLException {
    final String input = request.getParameter("user_id");
    Statement statement = getJDBCConnection().createStatement();
    statement.executeQuery("SELECT first_name FROM user_data WHERE userid = '" + padLocal(input) + "'");
  }

  public void sqlInter4a() throws SQLException {
    final String input = request.getParameter("user_id");
    sqlInter4b(pad(input));
  }

  public void sqlInter4b(String input) throws SQLException {
    Statement statement = getJDBCConnection().createStatement();
    statement.executeQuery("SELECT first_name FROM user_data WHERE userid = '" + input + "'");
  }

  private String padLocal(String input) {
    return "ID_" + input;
  }

  interface Sql {

    String getSql();

    String getNameQuery(String name);

    String getUserIdOrDefault(String userId);
  }
}

package sqli;

import static utils.SqlUtils.getJDBCConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import utils.UserData;

public class SqlScope {

  HttpServletRequest request;

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

  public ResultSet sqlScope1()
      throws SQLException {
    String adminId = "";
    if (request != null) {
      UserData userData = new UserData();
      userData.setUserId(request.getParameter("userId"));
      adminId = "admin_" + userData.getUserId();
    }
    Statement statement = getJDBCConnection().createStatement();
    String sql = "SELECT first_name FROM user_data WHERE userid = '" + adminId + "'";
    return statement.executeQuery(sql);
  }
}

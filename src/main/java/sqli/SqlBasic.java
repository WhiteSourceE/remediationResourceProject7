package sqli;

import static utils.SqlUtils.getJDBCConnection;
import static utils.SqlUtils.getSafeConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SqlBasic {
  private HttpServletRequest request;

  @PostMapping("/sqlTest1")
  public void sqlBasic1() {
    String ip = request.getParameter("ip");
    try {
      Statement statement = getJDBCConnection().createStatement();
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip
              + "')";
      statement.execute(sql);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest2")
  public void sqlBasic2() {
    String ip = request.getParameter("ip");
    try {
      Statement statement = getJDBCConnection().createStatement();
      statement.execute(
          "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip
              + "')");
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest3")
  public void sqlBasic3() {
    String ip = request.getParameter("ip");
    try {
      String sql =
          "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip
              + "')";
      getJDBCConnection().createStatement().execute(sql);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest4")
  public void sqlBasic4() {
    String ip = request.getParameter("ip");
    try {
      getJDBCConnection().createStatement().execute(
          "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip
              + "')");
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest5")
  public void sqlBasic5() throws SQLException {
    UUID id = UUID.randomUUID();
    String ip = request.getParameter("ip");
    String randomId = id.toString();
    String value = "VALUE('" + randomId + "','" + ip + "')";
    Connection connection = getJDBCConnection();
    Statement statement = connection.createStatement();
    int i = 0;
    String sql = "INSERT INTO banned_ip(id, ip) ";
    sql += value;
    statement.execute(sql);
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest6")
  public void sqlBasic6() throws SQLException {
    UUID id = UUID.randomUUID();
    String ip = request.getParameter("ip");
    String randomId = id.toString();
    String value = "VALUE('" + randomId + "','" + ip + "')";
    Connection connection = getJDBCConnection();
    Statement statement = connection.createStatement();
    int i = 0;
    String sql = "INSERT INTO banned_ip(id, ip) " + value;
    statement.execute(sql);
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest7")
  public void sqlBasic7(boolean b) throws SQLException {
    UUID id = UUID.randomUUID();
    String ip = request.getParameter("ip");
    String randomId = id.toString();
    String value = "VALUE('" + randomId + "','" + ip + "')";
    Statement statement;
    if (b) {
      statement = getJDBCConnection().createStatement();
    } else {
      statement = getSafeConnection().createStatement();
    }
    int i = 0;
    String sql = "INSERT INTO banned_ip(id, ip) " + value;
    statement.execute(sql);
    System.out.print("sdfsf");
  }

  @PostMapping("/sqlTest8")
  public void sqlBasic8() throws SQLException {
    UUID id = UUID.randomUUID();
    String ip = request.getParameter("ip");
    String randomId = id.toString();
    String value = "VALUE('" + randomId + "','" + ip + "')";
    Statement statement = getJDBCConnection().createStatement();
    Statement statement2 = getSafeConnection().createStatement();
    int i = 0;
    String sql = "INSERT INTO banned_ip(id, ip) " + value;
    statement.execute(sql);
    System.out.print("sdfsf");
  }

  @PostMapping("/setRequest")
  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

}

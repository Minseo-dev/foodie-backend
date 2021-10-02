package foodie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {
  private static Connection conn = null;

  public void init() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection setConnection() {
    try {
      return DriverManager.getConnection(
          "jdbc:postgresql://localhost:5434/foodie",
          "minseo",
          "minseo"
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}

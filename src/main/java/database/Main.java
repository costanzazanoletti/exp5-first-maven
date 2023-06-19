package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;

public class Main {

  private final static String URL = "jdbc:mysql://localhost:3306/db_aeroporto";
  private final static String USER = "root";
  private final static String PASSWORD = "rootpassword";

  public static void main(String[] args) {
    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
      System.out.println("Connected!");
      System.out.println(connection.getCatalog());

      System.out.println(StringUtils.leftPad("ciao", 8, "$"));
    } catch (SQLException e) {
      System.out.println("Unable to connect to database");
      e.printStackTrace();
    }
  }

}

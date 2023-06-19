package cms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class UserListTest {

  private UserList userList;

  @BeforeAll
  static void setup() {
    System.out.println("Before all tests");
  }

  @BeforeEach
  void init() {
    System.out.println("Before each test");
    // prima di ogni test inizializzo userList con una UserList vuota
    userList = new UserList();
  }

  @Test
  @DisplayName("Test aggiungi 2 utenti")
  void addUser() {
    // aggiungo un utente a userList
    userList.addUser("Max", 20);
    userList.addUser("Will", 19);
    assertEquals(2, userList.getUsers().size());
  }

  @Test
  @DisplayName("Test fallisci aggiungi utente con nome vuoto")
  void addInvalidUserName() {
    // aggiungo un utente non valido
    assertThrows(InvalidUserNameException.class, () -> userList.addUser("", 40));
  }

  @Test
  @DisplayName("Test fallisci aggiungi utente minorenne")
  void addInvalidUserAge() {
    // aggiungo un utente non valido
    assertThrows(InvalidUserAgeException.class, () -> userList.addUser("Max", 12));
  }

  @Test
  void seachUserByName() {
    List<User> resultList = userList.seachUserByName("max");
    assertEquals(0, resultList.size());

    // aggiungo un utente a userList
    userList.addUser("Max", 20);
    userList.addUser("Will", 19);
    userList.addUser("Dustin", 19);
    userList.addUser("Nancy", 19);
    resultList = userList.seachUserByName("an");
    assertEquals("Nancy", resultList.get(0).getName());
    assertEquals(0, userList.seachUserByName("Ciao").size());
  }

  @AfterEach
  void clear() {
    System.out.println("After each test");
  }

  @AfterAll
  static void close() {
    System.out.println("At the end of all tests");
  }
}
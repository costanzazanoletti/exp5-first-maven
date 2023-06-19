package cms;

import java.util.ArrayList;
import java.util.List;

public class UserList {

  private List<User> users;

  public UserList() {
    users = new ArrayList<>();
  }

  public UserList(List<User> users) {
    this.users = users;
  }

  public List<User> getUsers() {
    return users;
  }

  // metodo per aggiungere un utente alla lista (solo users con nome not null e age >= 18)
  public void addUser(String name, int age)
      throws InvalidUserAgeException, InvalidUserNameException {
    // valido che il nome non sia null o empty
    if (!isValidName(name)) {
      throw new InvalidUserNameException(name);
    }
    // valido che age non sia < 18
    if (!isValidAge(age)) {
      throw new InvalidUserAgeException(Integer.toString(age));
    }
    // aggiungo lo User alla lista
    users.add(new User(name, age));
  }

  // metodo per ricercare utenti per nome
  public List<User> seachUserByName(String keyword) {
    // creo la lista risultato vuota
    List<User> result = new ArrayList<>();
    // itero sugli users
    for (User user : users) {
      // se lo user corrente nel nome contiene la stringa di ricerca
      if (user.getName().contains(keyword)) {
        // aggiungo lo user alla lista risultato
        result.add(user);
      }
    }
    return result;
  }

  private boolean isValidName(String input) {
    return input != null && !input.isBlank();
  }

  private boolean isValidAge(int input) {
    return input >= 18;
  }
}

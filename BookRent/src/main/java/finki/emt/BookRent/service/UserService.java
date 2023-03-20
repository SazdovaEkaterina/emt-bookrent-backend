package finki.emt.BookRent.service;

import finki.emt.BookRent.model.User;
import finki.emt.BookRent.model.enumerations.Role;

public interface UserService{

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

}

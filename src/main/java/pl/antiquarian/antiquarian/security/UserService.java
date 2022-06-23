package pl.antiquarian.antiquarian.security;

import pl.antiquarian.antiquarian.model.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}

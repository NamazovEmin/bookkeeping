package az.namazov.bookkeeping.service;

import java.util.List;

import az.namazov.bookkeeping.entity.User;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    User save(User user);
}

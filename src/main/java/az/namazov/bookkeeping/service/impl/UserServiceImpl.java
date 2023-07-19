package az.namazov.bookkeeping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import az.namazov.bookkeeping.entity.Role;
import az.namazov.bookkeeping.entity.User;
import az.namazov.bookkeeping.enums.user.UserStatus;
import az.namazov.bookkeeping.exception.NotFoundException;
import az.namazov.bookkeeping.repozitory.RoleRepository;
import az.namazov.bookkeeping.repozitory.UserRepository;
import az.namazov.bookkeeping.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new NotFoundException("Current User Role not found"));
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(UserStatus.ACTIVE);

        User registredUser = userRepository.save(user);

        log.info("IN register - user : {} successfully registered", registredUser);

        return registredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        log.info("IN getAll - {} users found", userList.size());
        return null;
    }

    @Override
    public User findByUsername(String username) {
        User finedUser = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with user name = " + username + " not found"));
        log.info("IN findByUsername - user {} found by username: {}", finedUser, username);
        return finedUser;
    }

    @Override
    public User findById(Long id) {
        User finedUser = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with user id = " + id + " not found"));
        log.info("IN findByID - user {} found by ID: {}", finedUser, id);
        return finedUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}

package az.namazov.bookkeeping;

import java.util.List;

import org.springframework.stereotype.Component;

import az.namazov.bookkeeping.entity.Role;
import az.namazov.bookkeeping.entity.User;
import az.namazov.bookkeeping.enums.user.UserStatus;
import az.namazov.bookkeeping.repozitory.RoleRepository;
import az.namazov.bookkeeping.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Starter {

    private final RoleRepository roleRepository;
    private final UserService userService;
    public Starter(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        addRole();
        addUser();
    }

    private void addRole() {
        Role user = new Role();
        user.setName("USER");
        user.setStatus(UserStatus.ACTIVE);
        roleRepository.save(user);
        log.info("IN addRole - user : {} successfully added", user);

        Role admin = new Role();
        admin.setName("ADMIN");
        admin.setStatus(UserStatus.ACTIVE);
        roleRepository.save(admin);
        log.info("IN addRole - admin : {} successfully added", admin);
    }

    private void addUser() {
        User user = new User();
        user.setUserName("test");
        user.setFirstName("emin");
        user.setLastName("namazov");
        user.setEmail("eveningdelivery@gmail.com");
        user.setPassword("test");
        user.setRoles(List.of(roleRepository.findByName("USER").orElseThrow()));
        User savedUser = userService.save(user);

        log.info("IN addUser - User : {} successfully added", savedUser);
    }
}

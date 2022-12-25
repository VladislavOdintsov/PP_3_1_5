package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsersWithRoles() {

        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");


        roleService.saveRole(role1);
        roleService.saveRole(role2);

        Set<Role> set1 = new HashSet<>();
        set1.add(role1);
        set1.add(role2);
        Set<Role> set2 = new HashSet<>();
                set2.add(role2);

        User user1 = new User("admin", "admin", 25,  "admin@mail.ru", "adminpass", set1 );
        User user2 = new User("user1", "user1", 35,  "user1@mail.ru", "userpass1", set2 );

        userService.saveUser(user1);
        userService.saveUser(user2);

    }
}

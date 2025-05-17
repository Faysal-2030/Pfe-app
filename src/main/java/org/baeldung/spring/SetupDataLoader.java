package org.baeldung.spring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.baeldung.persistence.dao.PrivilegeRepository;
import org.baeldung.persistence.dao.RoleRepository;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.Privilege;
import org.baeldung.persistence.model.Role;
import org.baeldung.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

        private boolean alreadySetup = false;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PrivilegeRepository privilegeRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;


        // API


        @Override
        @Transactional
        public void onApplicationEvent(final ContextRefreshedEvent event) {
                if (alreadySetup) {
                        return;
                }

                // Create privileges
                final Privilege superAdminPrivilege = createPrivilegeIfNotFound("SUPERADMIN_PRIVILEGE");
                final Privilege adminPrivilege = createPrivilegeIfNotFound("ADMIN_PRIVILEGE");
                final Privilege clientPrivilege = createPrivilegeIfNotFound("CLIENT_PRIVILEGE");
                final Privilege userPrivilege = createPrivilegeIfNotFound("USER_PRIVILEGE");
                final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
                final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
                final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");
                final Privilege HebergementsAdminPrivilege = createPrivilegeIfNotFound("HEBERGEMENTS_ADMIN_PRIVILEGE");

                // Define privilege groups
                final List<Privilege> superAdminPrivileges = new ArrayList<>(
                                Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege, superAdminPrivilege));
                                
                final List<Privilege> HebergementsAdminPrivileges = new ArrayList<>(
                                Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege, superAdminPrivilege));

                final List<Privilege> adminPrivileges = new ArrayList<>(
                                Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege, adminPrivilege));

                final List<Privilege> userPrivileges = new ArrayList<>(
                                Arrays.asList(readPrivilege, passwordPrivilege, clientPrivilege));
                

                // Create roles
                final Role superAdminRole = createRoleIfNotFound("ROLE_SUPERADMIN", superAdminPrivileges);
                final Role HebergementsAdminRole = createRoleIfNotFound("ROLE_CLIENT_HEBERGEMENT", HebergementsAdminPrivileges);
                final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
                final Role userRole = createRoleIfNotFound("ROLE_CLIENT", userPrivileges);
                // == create initial user
                createUserIfNotFound("fayssal@sigma.ma", "Fayssal", "Sigma", "Optimisation1,",
                                new ArrayList<Role>(Arrays.asList(HebergementsAdminRole)));

                createUserIfNotFound("superadmin@sigma.ma", "Superadmin", "Sigma", "Optimisation1,",
                                new ArrayList<Role>(Arrays.asList(superAdminRole)));
                createUserIfNotFound("youmougamer@gmail.com", "Admin", "Sigma", "Optimisation1,",
                                new ArrayList<Role>(Arrays.asList(adminRole)));;
                createUserIfNotFound("client@sigma.ma", "Client", "Sigma", "Optimisation1,",
                                new ArrayList<Role>(Arrays.asList(userRole)));

                // Save prestations

                alreadySetup = true;
        }

        @Transactional
        public Privilege createPrivilegeIfNotFound(final String name) {
                Privilege privilege = privilegeRepository.findByName(name);
                if (privilege == null) {
                        privilege = new Privilege(name);
                        privilege = privilegeRepository.save(privilege);
                }
                return privilege;
        }

        @Transactional
        public Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
                Role role = roleRepository.findByName(name);
                if (role == null) {
                        role = new Role(name);
                }
                role.setPrivileges(privileges);
                role = roleRepository.save(role);
                return role;
        }

        @Transactional
        public User createUserIfNotFound(final String email, final String firstName, final String lastName,
                        final String password, final Collection<Role> roles) {
                User user = userRepository.findByEmail(email);
                if (user == null) {
                        user = new User();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        user.setPassword(passwordEncoder.encode(password));
                        user.setEmail(email);
                        user.setEnabled(true);
                }
                user.setRoles(roles);
                user = userRepository.save(user);
                return user;
        }

}
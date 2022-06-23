package pl.antiquarian.antiquarian.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.antiquarian.antiquarian.mail.EmailServiceImpl;
import pl.antiquarian.antiquarian.model.Role;
import pl.antiquarian.antiquarian.model.User;
import pl.antiquarian.antiquarian.repository.RoleRepository;
import pl.antiquarian.antiquarian.repository.UserRepository;
import pl.antiquarian.antiquarian.security.UserService;

import javax.mail.MessagingException;
import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmailServiceImpl emailService;


    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        emailService.send(user.getEmail(), emailService.createMessage(user.getUsername()));
        userRepository.save(user);
    }
}

package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.entity.Department;
import net.skhu.entity.User;
import net.skhu.model.UserRegistration;
import net.skhu.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createEntity(UserRegistration userRegistration) {
        User user = new User();
        user.setUserid(userRegistration.getUserid());
        user.setPassword(userRegistration.getPasswd1());
        user.setName(userRegistration.getName());
        user.setEmail(userRegistration.getEmail());
        user.setDepartment(new Department());
        user.getDepartment().setId(userRegistration.getDepartmentId());
        user.setEnabled(true);
        user.setUserType("학생");
        return user;
    }

    public void save(UserRegistration userRegistration) {
        User user = createEntity(userRegistration);
        userRepository.save(user);
    }

}


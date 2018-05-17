package com.example.java_back.service;

import java.util.Set;

import com.example.java_back.Domain.User;
import com.example.java_back.Domain.security.UserRole;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);

}
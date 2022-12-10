package com.newProject.services;

import org.springframework.stereotype.Service;

import com.newProject.Dto.UserDto;
import com.newProject.Pojo.ResponseContent;
import com.newProject.models.User;

@Service
public interface UserService {

    public String addUsers(UserDto userDetail);

    public String updateUsers(User user);

    public UserDto fetchId(Long id);

    public UserDto fetchEmail(String email);

    public String deleteUser(Long id);

    public ResponseContent verifyANdLoginUser(UserDto userDeatil);
    
}

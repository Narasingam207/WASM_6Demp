package com.Ganesh.CopyCat.ServiceImp;

import com.Ganesh.CopyCat.Entity.User;
import com.Ganesh.CopyCat.Playload.UserDto;
import com.Ganesh.CopyCat.Repository.UserRepository;
import com.Ganesh.CopyCat.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User users= userDtotoEntity(userDto);
       User savedUsers= userRepository.save(users);
        return entityToDtoUser(savedUsers);
    }
    private User userDtotoEntity(UserDto userDto)
    {
        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmil());
        user.setPassword(userDto.getPassword());
        return  user;
    }
    private UserDto entityToDtoUser(User savedUser)
    {
UserDto userDto=new UserDto();
userDto.setId(savedUser.getId());
userDto.setName(savedUser.getName());
userDto.setEmil(savedUser.getEmail());
userDto.setPassword(savedUser.getPassword());
return userDto;

    }
}

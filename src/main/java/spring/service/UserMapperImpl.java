package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dto.UserResponseDto;
import spring.model.User;

@Component
public class UserMapperImpl implements UserMapper {
    private final UserService userService;

    @Autowired
    public UserMapperImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserResponseDto getUserResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}

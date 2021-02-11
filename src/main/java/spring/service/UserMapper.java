package spring.service;

import spring.dto.UserResponseDto;
import spring.model.User;

public interface UserMapper {
    UserResponseDto getUserResponseDto(User user);
}

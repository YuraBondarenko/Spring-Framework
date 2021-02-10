package spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.UserResponseDto;
import spring.model.User;
import spring.service.UserMapper;
import spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable(name = "userId") Long id) {
        return userMapper.getUserResponseDto(userService.getById(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::getUserResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String inject() {
        User firstUser = new User();
        firstUser.setName("first");
        User secondUser = new User();
        secondUser.setName("second");
        User thirdUser = new User();
        thirdUser.setName("third");
        User fourthUser = new User();
        fourthUser.setName("fourth");
        userService.add(firstUser);
        userService.add(secondUser);
        userService.add(thirdUser);
        userService.add(fourthUser);
        return "Insertion was successful";
    }
}

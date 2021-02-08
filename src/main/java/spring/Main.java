package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.User;
import spring.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User firstUser = new User();
        firstUser.setName("first");
        firstUser.setAge(12);
        userService.add(firstUser);
        userService.listUsers().forEach(System.out::println);
        User secondUser = new User();
        secondUser.setName("second");
        userService.add(secondUser);
        userService.listUsers().forEach(System.out::println);
    }
}

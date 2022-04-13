package com.ryan.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ryan.exception.RestException;
import com.ryan.model.FileInfo;
import com.ryan.model.User;
import org.assertj.core.util.Lists;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ryan
 * @version Id: UserController, v 0.1 2022/3/31 3:45 PM ryan Exp $
 */
@RestController
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {
//        return SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @GetMapping("/getCurrentUserDetail")
    public Object getCurrentUserDetail(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @GetMapping("/user")
    @JsonView(User.UserSimpleView.class)
    List<User> query(@RequestParam(name = "username", required = false, defaultValue = "tom") String username) {
        System.out.println(username);
        List<User> users = Lists.newArrayList();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }


    @GetMapping("/user/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    User getUserInfo(@PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setUsername("tome");
        user.setPassword("ssss");
        return user;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(r -> System.out.println(r.getDefaultMessage()));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthDay());

        user.setId("1");
        return user;
    }

    @PutMapping("/user/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {

            errors.getAllErrors().stream().forEach(r -> {
                FieldError fieldError = (FieldError) r;
                System.out.println(fieldError.getField() + " " + r.getDefaultMessage());
            });
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthDay());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/user/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }


}

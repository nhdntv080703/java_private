package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        List<UserDTO> userDTOS = userService.findAll();
        if(StringUtils.isNullOrEmpty(account)){
            return  "alertAccount";
        }
        else if(StringUtils.isNullOrEmpty(password)){
            return  "alertPassWord";
        }
        for(UserDTO user : userDTOS){
            if (account.equals(user.getUserName()) && password.equals(user.getPassWord()))
                return "redirect:/store";
        }
        return "alert";
    }

    @GetMapping("/store")
    public String about(Model model) {
        model.addAttribute("list", userService.findAll());
        return "about";
    }

    @GetMapping("/user")
    @ResponseBody
    public List<UserDTO> getAllUser(){
        return userService.findAll();
    }

    @GetMapping("/register")
    public String register(){
        return "about1";
    }

    @PostMapping("/register")
    public String register(UserDTO user){
        userService.createUser(user);
        return "redirect:/store";
    }

    @PostMapping("/user_delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/store";
    }

    @GetMapping("/user_put/{id}")
    public String putUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("list", userService.findById(id));
        return "update";
    }

    @PostMapping("/user_put")
    public String putUser(@ModelAttribute("list") UserDTO userDTO) {
        userService.updateUser(userDTO.getId(), userDTO);
        return "redirect:/store";
    }

}

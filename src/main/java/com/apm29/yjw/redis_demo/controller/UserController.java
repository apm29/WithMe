package com.apm29.yjw.redis_demo.controller;

import com.apm29.yjw.redis_demo.domain.BaseResp;
import com.apm29.yjw.redis_demo.domain.User;
import com.apm29.yjw.redis_demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find/all")
    @ResponseBody
    public List<User> all()  {
        return userService.all();
    }

    @GetMapping("/find/name/{name}")
    @ResponseBody
    public User findByName(@PathVariable("name") String name){
        return userService.byName(name);
    }

    @PostMapping(value = "/register",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResp<User> register(@RequestBody User user){
        System.out.println("user = [" + user + "]");
        return userService.save(user.getUserName());
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<User> userList = userService.all();
        model.addAttribute("users", userList);
        return "/hello";
    }

    @RequestMapping("/list2")
    public String  list2(Model model) {
        List<User> userList = userService.all();
        model.addAttribute("users", userList);
        throw new IllegalArgumentException("user error ");
    }

}

package com.cynapsys.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cynapsys.demo.models.User;
import com.cynapsys.demo.service.PoleService;
import com.cynapsys.demo.service.RoleService;
import com.cynapsys.demo.service.UserService;


@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PoleService poleService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getList() {
		return userService.getListUser();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addUtilisateur(@RequestBody User user) {
		user.setPole(poleService.findById(user.getPole().getId()));
		user.setRole(roleService.findById(user.getRole().getId()));
		user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
		userService.addUser(user);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
   	public User update(@RequestBody User user) {
		user.setPole(poleService.findById(user.getPole().getId()));
		user.setRole(roleService.findById(user.getRole().getId()));
		user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
		return userService.addUser(user);
   }
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
    public User findby(@PathVariable Integer id) {
		System.out.println("userPole  :"+userService.findById(id).getPole().getNomService());
		return userService.findById(id);  
	}
	  
	@RequestMapping(value="/email/{email}",method=RequestMethod.GET)
    public Optional<User> findbyEmail(@PathVariable String email) {
		return userService.findByEmail(email);  
	}
	  
	
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);  
    }
}

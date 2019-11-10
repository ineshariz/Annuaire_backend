package com.cynapsys.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cynapsys.demo.models.Role;
import com.cynapsys.demo.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Role> getListPoles(){
		return roleService.getListRole();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Role find(@PathVariable Integer id) {
		 return roleService.findById(id);
       
    }
}

package com.cynapsys.demo.service;

import java.util.List;
import com.cynapsys.demo.models.Role;

public interface RoleService {
	List<Role> getListRole();
	 Role findById(Integer id);
	
}

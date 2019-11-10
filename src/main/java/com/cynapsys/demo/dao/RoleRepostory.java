package com.cynapsys.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cynapsys.demo.models.Pole;
import com.cynapsys.demo.models.Role;


public interface RoleRepostory extends JpaRepository<Role, Integer>


{

}

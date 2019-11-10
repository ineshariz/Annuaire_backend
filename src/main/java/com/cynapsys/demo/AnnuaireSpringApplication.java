package com.cynapsys.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cynapsys.demo.service.UserService;
import com.cynapsys.demo.models.Pole;
import com.cynapsys.demo.models.User;
import com.cynapsys.demo.service.PoleService;
import com.cynapsys.demo.service.StorageService;

@EnableJpaAuditing
@SpringBootApplication
public class AnnuaireSpringApplication implements CommandLineRunner {
		
	@Resource
	StorageService storageService;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	PoleService polesService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		
		SpringApplication.run(AnnuaireSpringApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
		/*
		Pole pole= new Pole(20,"Web", true);
		polesService.addPole(pole);
		 User user = new User();
		 user.setNomPrenom("admin");
		 user.setPass(bCryptPasswordEncoder.encode("user"));
		 user.setEmail("admin@esprit.tn");
		 user.setPole(pole);
		 user.setCv("awesome");
		 user.setPhoto("awesome");

		 user.setNumTel("58052121");
		 userService.addUser(user);
		 */
		//storageService.deleteAll();
		//storageService.init();
	}
}

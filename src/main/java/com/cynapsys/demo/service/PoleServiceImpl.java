package com.cynapsys.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.demo.dao.PoleRepostory;
import com.cynapsys.demo.models.Pole;

@Service
public class PoleServiceImpl implements PoleService {
	
	@Autowired
	private PoleRepostory poleRepository;

	@Override
	public Pole addPole(Pole pole) {
		 return poleRepository.save(pole);
	}

	@Override
	public List<Pole> getListPole() {
		
		return poleRepository.findAll();
	}

	@Override
	public Pole findById(Integer id) {
	    return poleRepository.getOne(id);
	    
	}

	@Override
	public void deletePole(Integer id) {
	 Pole pole = findById(id);
	    if(pole != null){
	    	poleRepository.delete(pole);
	    }
	}

	@Override
	public List<Pole> getListPoleActivated() {
		return getListPole().stream()               
							.filter(user -> user.getEtat()==true)   
							.collect(Collectors.toList()); 
	}
}

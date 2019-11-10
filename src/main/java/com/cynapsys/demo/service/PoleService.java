package com.cynapsys.demo.service;

import java.util.List;

import com.cynapsys.demo.models.Pole;

public interface PoleService {
	Pole addPole(Pole pole);
	List<Pole> getListPole();
	List<Pole> getListPoleActivated();
	void deletePole(Integer id);
	 Pole findById(Integer id);
}

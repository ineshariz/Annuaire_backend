package com.cynapsys.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cynapsys.demo.models.Pole;
import com.cynapsys.demo.service.PoleService;

@RestController
@RequestMapping("/pole")
@CrossOrigin("*")
public class PoleController {
	
	@Autowired
	private PoleService poleService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Pole> getListPoles(){
		return poleService.getListPoleActivated();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public Pole addPoles(@RequestBody Pole pole) {
		
		poleService.addPole(pole);
		return pole;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Pole find(@PathVariable Integer id) {
		 return poleService.findById(id);
       
    }
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
   	public Pole update(@RequestBody Pole pole) {
		return poleService.addPole(pole);
   }
	
	@RequestMapping(value="/disable",method=RequestMethod.PUT)
   	public Pole disable(@RequestBody Pole pole) {
		if(pole.getEtat()==true)
			pole.setEtat(false);
		else
			pole.setEtat(true);
		return poleService.addPole(pole);
   }
	
   @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
   public void delete(@PathVariable Integer id) {
	   poleService.deletePole(id);
       
   }

}

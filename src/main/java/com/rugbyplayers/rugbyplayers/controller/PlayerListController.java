package com.rugbyplayers.rugbyplayers.controller;

import com.rugbyplayers.rugbyplayers.RugbyPlayer;
import com.rugbyplayers.rugbyplayers.RugbyPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PlayerListController {
	@Autowired
	private RugbyPlayerRepository rugbyPlayerRepository;

	@GetMapping("/playerlist")
	public ModelAndView modelAndView(@RequestParam String sortBy) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		switch(sortBy){
			
			case "id":
				modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
				modelAndView.addObject("checked1", "true");
				break;

			case "name":
				modelAndView.addObject("lista",rugbyPlayerRepository.findAllByOrderByName());
				modelAndView.addObject("checked2", "true");
				break;

			case "lastName":
				modelAndView.addObject("lista",rugbyPlayerRepository.findAllByOrderByLastName());
				modelAndView.addObject("checked3", "true");
				break;

			case "position":
				modelAndView.addObject("lista",rugbyPlayerRepository.findAllByOrderByPosition());
				modelAndView.addObject("checked4", "true");
				break;

			case "age":
				modelAndView.addObject("lista",rugbyPlayerRepository.findAllByOrderByAge());
				modelAndView.addObject("checked5", "true");
				break;
			
		}
		
		return modelAndView;
	}


	@PostMapping("/playerlist")
	public ModelAndView addPlayer(@ModelAttribute RugbyPlayer rugbyPlayer) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("rugbyPlayer", rugbyPlayer);
		rugbyPlayerRepository.save(rugbyPlayer);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

	@DeleteMapping("/playerlist/{id}")
	public ModelAndView deletePlayer(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		rugbyPlayerRepository.deleteById(id);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

	

	@PutMapping("/playerlist/{id}")
	public ModelAndView updatePlayer(@ModelAttribute RugbyPlayer rugbyPlayer) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		rugbyPlayerRepository.save(rugbyPlayer);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

	

	@PostMapping("/editPlayer")
	public ModelAndView updatePlayer(int id) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("id", id);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

}

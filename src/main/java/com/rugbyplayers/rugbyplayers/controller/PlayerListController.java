package com.rugbyplayers.rugbyplayers.controller;

import com.rugbyplayers.rugbyplayers.RugbyPlayer;
import com.rugbyplayers.rugbyplayers.RugbyPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerListController {
	@Autowired
	private RugbyPlayerRepository rugbyPlayerRepository;

	@GetMapping("/playerlist")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());

		return modelAndView;
	}

	@PostMapping("/addPlayer")
	public ModelAndView addPlayer(@ModelAttribute RugbyPlayer rugbyPlayer) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("rugbyPlayer", rugbyPlayer);
		rugbyPlayerRepository.save(rugbyPlayer);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/delPlayer")
	public ModelAndView deletePlayer(int id) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		rugbyPlayerRepository.deleteById(id);
		modelAndView.addObject("lista", rugbyPlayerRepository.findAll());
		return modelAndView;
	}

	

	@PostMapping("/updatePlayer")
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


	@PostMapping("/sortPlayer")
	public ModelAndView sortPlayer(int sort) {
		ModelAndView modelAndView2 = new ModelAndView("playerList");
		switch(sort) {
			case 1:
			
			modelAndView2.addObject("sort1", "true");
			modelAndView2.addObject("sort2", "false");
			modelAndView2.addObject("sort3", "false");
			modelAndView2.addObject("sort4", "false");
			modelAndView2.addObject("sort5", "false");
			modelAndView2.addObject("lista",rugbyPlayerRepository.findAllByOrderByName());
			break;
			case 2:
			
			modelAndView2.addObject("sort1", "false");
			modelAndView2.addObject("sort2", "true");
			modelAndView2.addObject("sort3", "false");
			modelAndView2.addObject("sort4", "false");
			modelAndView2.addObject("sort5", "false");
			modelAndView2.addObject("lista",rugbyPlayerRepository.findAllByOrderByLastName());
			break;
			case 3:
			
			modelAndView2.addObject("sort1", "false");
			modelAndView2.addObject("sort2", "false");
			modelAndView2.addObject("sort3", "true");
			modelAndView2.addObject("sort4", "false");
			modelAndView2.addObject("sort5", "false");
			modelAndView2.addObject("lista",rugbyPlayerRepository.findAllByOrderByPosition());
			break;
			case 4:
			
			modelAndView2.addObject("sort1", "false");
			modelAndView2.addObject("sort2", "false");
			modelAndView2.addObject("sort3", "false");
			modelAndView2.addObject("sort4", "true");
			modelAndView2.addObject("sort5", "false");
			modelAndView2.addObject("lista",rugbyPlayerRepository.findAllByOrderByAge());
			break;
			case 5:
			
			modelAndView2.addObject("sort1", "false");
			modelAndView2.addObject("sort2", "false");
			modelAndView2.addObject("sort3", "false");
			modelAndView2.addObject("sort4", "false");
			modelAndView2.addObject("sort5", "true");
			modelAndView2.addObject("lista",rugbyPlayerRepository.findAllByOrderById());
			break;
		}
		return modelAndView2;
	}

}

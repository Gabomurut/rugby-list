package com.rugbyplayers.rugbyplayers.controller;

import com.rugbyplayers.rugbyplayers.RugbyPlayer;
import com.rugbyplayers.rugbyplayers.RugbyPlayerRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerListController {

	@GetMapping("/playerlist")
	public ModelAndView modelAndView() {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("lista", RugbyPlayerRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/addPlayer")
	public ModelAndView addPlayer(@ModelAttribute RugbyPlayer rugbyPlayer) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("rugbyPlayer", rugbyPlayer);
		modelAndView.addObject("lista", RugbyPlayerRepository.findAll());
		RugbyPlayerRepository.newPlayer(rugbyPlayer);
		RugbyPlayerRepository.sortPlayers();
		return modelAndView;
	}

	@PostMapping("/delPlayer")
	public ModelAndView deletePlayer(int id) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		RugbyPlayerRepository.sortPlayers();
		modelAndView.addObject("lista", RugbyPlayerRepository.findAll());
		RugbyPlayerRepository.deletePlayer(id);
		return modelAndView;
	}

	@PostMapping("/updatePlayer")
	public ModelAndView updatePlayer(@ModelAttribute RugbyPlayer rugbyPlayer) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		RugbyPlayerRepository.sortPlayers();
		modelAndView.addObject("lista", RugbyPlayerRepository.findAll());
		RugbyPlayerRepository.updatePlayer(rugbyPlayer);
		return modelAndView;
	}

	@PostMapping("/editPlayer")
	public ModelAndView updatePlayer(int id) {
		ModelAndView modelAndView = new ModelAndView("playerList");
		modelAndView.addObject("lista", RugbyPlayerRepository.findAll());
		modelAndView.addObject("id", id);
		return modelAndView;
	}

}

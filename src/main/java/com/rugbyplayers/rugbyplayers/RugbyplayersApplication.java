package com.rugbyplayers.rugbyplayers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RugbyplayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(RugbyplayersApplication.class, args);
		RugbyPlayerRepository.newPlayer(1,"Gabo","Murut","Fullback",38);
		RugbyPlayerRepository.newPlayer(2,"Jose","Piñeiro","Flank",39);
		RugbyPlayerRepository.newPlayer(3,"Agustin","Pichot","Scrum Half",46);
		RugbyPlayerRepository.newPlayer(4,"Felipe","Contepomi","Fly Half",48);
		RugbyPlayerRepository.newPlayer(10,"Hugo","Porta","Fly Half",65);
		RugbyPlayerRepository.newPlayer(8,"Chino","Garcia","Capo",38);
		RugbyPlayerRepository.sortPlayers();


	}

}

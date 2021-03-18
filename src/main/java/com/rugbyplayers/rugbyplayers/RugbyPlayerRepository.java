package com.rugbyplayers.rugbyplayers;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RugbyPlayerRepository extends CrudRepository <RugbyPlayer, Integer> {
        
    List<RugbyPlayer> findAllByOrderByName();
    List<RugbyPlayer> findAllByOrderByLastName();
    List<RugbyPlayer> findAllByOrderByAge();
    List<RugbyPlayer> findAllByOrderByPosition();
    List<RugbyPlayer> findAllByOrderById();
}


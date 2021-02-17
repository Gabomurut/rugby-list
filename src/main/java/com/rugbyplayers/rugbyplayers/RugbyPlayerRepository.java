package com.rugbyplayers.rugbyplayers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RugbyPlayerRepository {

    static List<RugbyPlayer> rugbyPlayerList = new ArrayList<>();

    public static void newPlayer(int id, String name, String lastName, String position, int age) {
        RugbyPlayer newRugbyPlayer = new RugbyPlayer(id, name, lastName, position, age);
        rugbyPlayerList.add(newRugbyPlayer);
    }

    public static void newPlayer(RugbyPlayer rugbyPlayer) {
        rugbyPlayerList.add(rugbyPlayer);
    }

    public static void updatePlayer(RugbyPlayer rugbyPlayer){
        for (RugbyPlayer rugbyPlayerToEdit : rugbyPlayerList) {
            if (rugbyPlayerToEdit.getId() == rugbyPlayer.getId()) {
                rugbyPlayerToEdit.setName(rugbyPlayer.getName());
                rugbyPlayerToEdit.setLastName(rugbyPlayer.getLastName());
                rugbyPlayerToEdit.setPosition(rugbyPlayer.getPosition());
                rugbyPlayerToEdit.setAge(rugbyPlayer.getAge());
            }
        }
    }

    public static void deletePlayer(int id) {
        for (RugbyPlayer rugbyPlayer : rugbyPlayerList) {
            if (rugbyPlayer.getId() == id) {
                rugbyPlayerList.remove(rugbyPlayer);
                break;
            }
        }
    }

    static public List<RugbyPlayer> findAll() {

        return rugbyPlayerList;
    }

    public static RugbyPlayer findById(int id) {

        for (RugbyPlayer rugbyPlayer : rugbyPlayerList) {
            if (rugbyPlayer.getId() == id) {
                return rugbyPlayer;
            }
        }

        return null;

    }

    public static void sortPlayers() {
        rugbyPlayerList.sort(Comparator.comparing(RugbyPlayer::getId));

    }
}

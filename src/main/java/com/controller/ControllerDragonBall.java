package com.controller;

import com.service.DragonBallService;

import java.util.Collection;
import java.util.Objects;

public class ControllerDragonBall {
    private DragonBallService dragonBallService;

    public ControllerDragonBall(DragonBallService dragonBallService){
        this.dragonBallService = dragonBallService;
        this.dragonBallService.auth();
    }

    /**
     * Recebe o parametro que o usuário deseja saber sobre Dragon Ball e devolve para o bot
     * @param mensagem
     * @return
     */
    public String pesquisaDragonBall(String mensagem){
        StringBuilder retornoBot = new StringBuilder();
        Collection<Collection> retornoApi = null;
        switch (mensagem){
            case "Sagas":
            case "sagas":
                retornoApi = this.dragonBallService.getSagas();
                break;
            case "Personagens":
            case "personagens":
               retornoApi = this.dragonBallService.getCharacters();
                break;
            case "Planetas":
            case "planetas":
                retornoApi = this.dragonBallService.getPlanets();
                break;
            case "Espécies":
            case "espécies":
            case "Especies":
            case "especies":
                retornoApi = this.dragonBallService.getSpecies();
                break;
        }
        if(retornoApi != null){
            for(Collection collectionApi: retornoApi){
                for(Object linhaApi: collectionApi){
                    retornoBot.append(linhaApi).append("\n \n");
                }
            }
        }else{
            retornoBot.append("Não entendi...");
        }
        return retornoBot.toString();
    }
}

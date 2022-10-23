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

    public String pesquisaDragonBall(String mensagem){
        String retornoBot = "";
        Collection<Collection> retornoApi = null;
        if(Objects.equals(mensagem, "Sagas")){
            retornoApi = this.dragonBallService.getSagas();
        }
        return retornoApi.toString();
    }
}

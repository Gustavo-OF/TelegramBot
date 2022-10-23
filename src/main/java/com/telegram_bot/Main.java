package com.telegram_bot;

import com.controller.ControllerDragonBall;
import com.service.DragonBallService;
import com.service.TelegramService;
import com.controller.ControllerBot;
import com.controller.ControllerMensagem;

public class Main {
    /** Método principal que incicia o bot
     * @param args
     */
    public static void main(String[] args) {
        TelegramService telegramService = new TelegramService();
        DragonBallService dragonBallService = new DragonBallService();
        ControllerDragonBall controllerDragonBall = new ControllerDragonBall(dragonBallService);
        ControllerMensagem controllerMensagem = new ControllerMensagem(controllerDragonBall);
        ControllerBot controllerBot = new ControllerBot(telegramService, controllerMensagem);
        controllerBot.gerenciaMensagem();
    }
}
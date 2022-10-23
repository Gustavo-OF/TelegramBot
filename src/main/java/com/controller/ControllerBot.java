package com.controller;

import com.pengrad.telegrambot.model.Update;
import com.service.TelegramService;

import java.util.List;

public class ControllerBot {
    private TelegramService telegramService;
    private ControllerMensagem controllerMensagem;
    public ControllerBot(TelegramService telegramService, ControllerMensagem controllerMensagem){
        this.telegramService = telegramService;
        this.controllerMensagem = controllerMensagem;
    }

    public void gerenciaMensagem(){
        while(true){
            List<Update> updates = this.telegramService.verificaAtualizacoes();
            if(!updates.isEmpty()){
                for(Update update : updates){
                    this.telegramService.atualizaId(update);
                    String mensagem = this.telegramService.capturaMensagem(update);
                    String nomePessoa = update.message().from().firstName();
                    String resposta = this.controllerMensagem.analisaMensagem(mensagem, nomePessoa);
                    if(this.telegramService.enviaStatusEscrevendo(update)){
                        this.telegramService.enviaMensagem(update,resposta);
                    };
                }
            }
        }
    }
}

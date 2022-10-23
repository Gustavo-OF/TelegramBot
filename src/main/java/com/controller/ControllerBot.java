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

    /**
     * Método que fica monitorando novas mensagens e manda a resposta para o usuário
     */
    public void gerenciaMensagem(){
        while(true){
            List<Update> updates = this.telegramService.verificaAtualizacoes();
            if(!updates.isEmpty()){
                for(Update update : updates){
                    this.telegramService.atualizaId(update);
                    String mensagem = this.telegramService.capturaMensagem(update);
                    // Capturo o nome da pesssoa para usar no inicio da conversa e no fim
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

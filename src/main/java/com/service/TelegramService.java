package com.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

public class TelegramService {
    private final TelegramBot telegramBot;
    private int id = 0;

    public TelegramService(){
        this.telegramBot = new TelegramBot("");
    }

    /**
     * Método para retornar as mensagens pendentes por lista
     */
    public List<Update> verificaAtualizacoes(){
        GetUpdatesResponse updatesResponse = this.telegramBot.execute(new GetUpdates().limit(100).offset(this.id));
        return updatesResponse.updates();
    }

    public int atualizaId(Update update){
        this.id = update.updateId()+1;
        return id;
    }

    public String capturaMensagem(Update update){
        return update.message().text();
    }

    public boolean enviaStatusEscrevendo(Update update){
        BaseResponse baseResponse = this.telegramBot.execute(
                new SendChatAction(update.message().chat().id(),ChatAction.typing.name())
        );
        return baseResponse.isOk();
    }

    public boolean enviaMensagem(Update update, String mensagem){
        SendResponse sendResponse = this.telegramBot.execute(
                new SendMessage(update.message().chat().id(),mensagem)
        );
        return sendResponse.isOk();
    }





}

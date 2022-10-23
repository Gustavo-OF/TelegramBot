package com.controller;

import com.service.DragonBallService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerMensagem {
    //  Propriedade que utilizo para guardar o estado da conversa
    private String estado;
    private ControllerDragonBall controllerDragonBall;
    public ControllerMensagem(ControllerDragonBall controllerDragonBall){
        this.controllerDragonBall = controllerDragonBall;
    }

    /**
     * Recebe a mensagem que foi enviada pelo usuário e classifica de acordo com o tipo dela
     * @param mensagem
     * @return
     */
    public String analisaTipoMensagem(String mensagem){
        Pattern saudacoes = Pattern.compile("Olá|Ola|Oi|Bom dia|Boa tarde|Boa noite", Pattern.CASE_INSENSITIVE);
        Pattern despedida = Pattern.compile("Tchau|Até mais|Adeus|xau", Pattern.CASE_INSENSITIVE);
        Pattern dragonBall = Pattern.compile("Dragon|Dragon ball|Dragon ball z", Pattern.CASE_INSENSITIVE);
        Pattern agradecimento = Pattern.compile("Obrigado|Valeu|Thanks",Pattern.CASE_INSENSITIVE);

        Matcher encontraSaudacoes = saudacoes.matcher(mensagem);
        Matcher encontraDespedida = despedida.matcher(mensagem);
        Matcher encontraDragonBall = dragonBall.matcher(mensagem);
        Matcher encontraAgradecimento = agradecimento.matcher(mensagem);

        if(encontraSaudacoes.find()){
            return "Saudacoes";
        }else if(encontraDespedida.find()){
            return "Despedida";
        }else if(encontraDragonBall.find()){
            return "DragonBall";
        }else if(encontraAgradecimento.find()){
            return "Agradecimento";
        }else{
            return "Não encontrado";
        }
    }

    /**
     * Método que analisa a mensagem recebida e redireciona para a resposta de acordo
     * com o tipo da mensagem e o estado da conversa
     *
     * @param mensagem
     * @param nomePessoa
     * @return
     */
    public String analisaMensagem(String mensagem, String nomePessoa){
        String resposta = "";
        if(Objects.equals(this.estado, "DragonBall")){
            resposta = this.controllerDragonBall.pesquisaDragonBall(mensagem);
            this.estado = "";
        }else{
            switch (analisaTipoMensagem(mensagem)){
                case "Saudacoes":
                    resposta = enviaSaudacoes(nomePessoa);
                    break;
                case "DragonBall":
                    resposta = enviaDragonBall();
                    this.estado = "DragonBall";
                    break;
                case "Agradecimento":
                    resposta = enviaAgradecimento(nomePessoa);
                    break;
                case "Despedida":
                    resposta = enviaDespedida(nomePessoa);
                    break;
                default:
                    resposta = "Não entendi...";
            }
        }
        return resposta;
    }

    public String enviaAgradecimento(String nomePessoa){
        return "De nada, "+nomePessoa+"!";
    }

    /**
     * Envia uma mensagem de despedida para o usuário
     * @param nomePessoa
     * @return
     */
    public String enviaDespedida(String nomePessoa){
        return "Tchau, "+nomePessoa+"! Foi um prazer conversar com você, tenha um ótimo dia!";
    }

    /**
     * Inicia a conversa sobre Dragon Ball
     * @return
     */
    public String enviaDragonBall(){
        return "Sou especialista em Dragon Ball! Sobre o que você deseja saber? " +
                    " Posso falar sobre: Sagas, Planetas, Personagens ou Espécies";
    }

    /**
     * Envia uma mensagem de saudações para o usuário
     * @param nomePessoa
     * @return
     */
    public String enviaSaudacoes(String nomePessoa){
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        String parteDoDia = "";
        if(calendar.get(Calendar.HOUR_OF_DAY) >= 6 && calendar.get(Calendar.HOUR_OF_DAY) <= 12){
            parteDoDia = "Bom dia";
        }else if(calendar.get(Calendar.HOUR_OF_DAY) > 12 && calendar.get(Calendar.HOUR_OF_DAY) <= 18){
            parteDoDia = "Boa tarde";
        }else{
            parteDoDia = "Boa noite";
        }
        return "Olá, "+nomePessoa+". "+parteDoDia+"! Como posso te ajudar?";

    }
}

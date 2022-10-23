package com.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Auth;
import com.model.Saga;

public class DragonBallService {
    private final RequestService requestService;
    private final String url = "https://db-api-br.herokuapp.com/v1";

    private Auth authDragonBalll;
    public DragonBallService(){

        this.requestService = new RequestService();
        this.authDragonBalll = new Auth();
    }

    public void auth(){
        Auth auth = new Auth();
        try {
            String retorno = this.requestService.sendPOST(this.url+"/users/authenticate", auth);
            this.authDragonBalll = new Gson().fromJson(retorno, Auth.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Collection> getSagas(){
        String retornoApi = "";
        Collection<String> retornoSagas = new ArrayList<>();
        Collection<String> retornoDescricao = new ArrayList<>();
        Collection<Collection> retornoFinal = new ArrayList<>();
        try{
            retornoApi = this.requestService.sendGET(this.url+"/series",this.authDragonBalll.getAuthKey());
        }catch (IOException e) {
            retornoApi = e.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Type sagasCollection = new TypeToken<Collection<Saga>>(){}.getType();
        Collection<Saga> sagas = new Gson().fromJson(retornoApi, sagasCollection);
        for (Saga saga : sagas) {
            retornoSagas.add(saga.getName());
            retornoDescricao.add(saga.getDescription());
            retornoFinal.add(retornoSagas);
            retornoFinal.add(retornoDescricao);
        }
        return retornoFinal;
    }



}

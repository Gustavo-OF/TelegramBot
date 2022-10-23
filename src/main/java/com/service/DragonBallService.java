package com.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.model.*;

public class DragonBallService {
    private final RequestService requestService;
    private final String url = "https://db-api-br.herokuapp.com/v1";

    private Auth auth;
    public DragonBallService(){

        this.requestService = new RequestService();
        this.auth = new Auth();
    }

    /**
     * Faz a autenticação na API e salva o token de acesso.
     */
    public void auth(){
        Auth auth = new Auth();
        try {
            String retorno = this.requestService.sendPOST(this.url+"/users/authenticate", auth);
            this.auth = new Gson().fromJson(retorno, Auth.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna todas as sagas de Dragon Ball
     */
    public Collection<Collection> getSagas(){
        String retornoApi = "";
        Collection<String> retornoSagas = new ArrayList<>();
        Collection<Collection> retornoFinal = new ArrayList<>();
        try{
            retornoApi = this.requestService.sendGET(this.url+"/series",this.auth.getAuthKey());
        }catch (IOException e) {
            retornoApi = e.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Type sagasCollection = new TypeToken<Collection<Saga>>(){}.getType();
        Collection<Saga> sagas = new Gson().fromJson(retornoApi, sagasCollection);
        for (Saga saga : sagas) {
            retornoSagas.add(saga.getName());
            retornoSagas.add(saga.getDescription());
        }
        retornoSagas.add(sagas.iterator().next().getImage());
        retornoFinal.add(retornoSagas);
        return retornoFinal;
    }


    /**
     * Retorna todos os personagens de Dragon Ball
     * @return
     */
    public Collection<Collection> getCharacters() {
        String retornoApi = "";
        Collection<String> retornoPeronsagens = new ArrayList<>();
        Collection<Collection> retornoFinal = new ArrayList<>();
        try{
            retornoApi = this.requestService.sendGET(this.url+"/characters",this.auth.getAuthKey());
        }catch (IOException e) {
            retornoApi = e.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Type charactersCollection = new TypeToken<Collection<Personagem>>(){}.getType();
        Collection<Personagem> personagens = new Gson().fromJson(retornoApi, charactersCollection);
        for (Personagem personagem : personagens) {
            retornoPeronsagens.add(personagem.getName());

        }
        retornoFinal.add(retornoPeronsagens);
        return retornoFinal;
    }

    /**
     * Retorna todos os planetas de Dragon Ball
     * @return
     */
    public Collection<Collection> getPlanets() {
        String retornoApi = "";
        Collection<String> retornoPlanetas = new ArrayList<>();
        Collection<Collection> retornoFinal = new ArrayList<>();
        try{
            retornoApi = this.requestService.sendGET(this.url+"/planets",this.auth.getAuthKey());
        }catch (IOException e) {
            retornoApi = e.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Type charactersCollection = new TypeToken<Collection<Planeta>>(){}.getType();
        Collection<Planeta> planetas = new Gson().fromJson(retornoApi, charactersCollection);
        for (Planeta planeta : planetas) {
            retornoPlanetas.add(planeta.getName());
        }
        retornoFinal.add(retornoPlanetas);
        return retornoFinal;
    }

    /**
     * Retorna todas as espécies de Dragon Ball
     * @return
     */
    public Collection<Collection> getSpecies() {
        String retornoApi = "";
        Collection<String> retornoEspecies = new ArrayList<>();
        Collection<Collection> retornoFinal = new ArrayList<>();
        try{
            retornoApi = this.requestService.sendGET(this.url+"/species",this.auth.getAuthKey());
        }catch (IOException e) {
            retornoApi = e.getMessage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Type charactersCollection = new TypeToken<Collection<Especie>>(){}.getType();
        Collection<Especie> especies = new Gson().fromJson(retornoApi, charactersCollection);
        for (Especie especie : especies) {
            retornoEspecies.add(especie.getName());
            retornoEspecies.add(especie.getDescription());
        }
        retornoFinal.add(retornoEspecies);
        return retornoFinal;
    }
}

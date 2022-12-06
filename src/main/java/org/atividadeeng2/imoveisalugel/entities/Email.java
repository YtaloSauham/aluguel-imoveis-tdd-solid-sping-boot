package org.atividadeeng2.imoveisalugel.entities;

import org.atividadeeng2.imoveisalugel.interfaces.Notify;


public class Email implements Notify {

    public Email(){

    }

    @Override
    public String send(String titulo, String remetente, String corpoMensagem) {
       return "Titulo:"+titulo+"\n"+"Enviar para:"+remetente+"\n"+"Corpo da mensagem:"+corpoMensagem;
    }


}

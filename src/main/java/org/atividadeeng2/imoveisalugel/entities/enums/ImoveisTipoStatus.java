package org.atividadeeng2.imoveisalugel.entities.enums;

public enum ImoveisTipoStatus {

    APARTAMENTO(1),
    CASA(2);


    private int code;
    private ImoveisTipoStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ImoveisTipoStatus valueOf(int code){
        for(ImoveisTipoStatus value : ImoveisTipoStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("Invalid OrderStatus code");
    }



}

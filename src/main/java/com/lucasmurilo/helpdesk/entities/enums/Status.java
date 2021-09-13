package com.lucasmurilo.helpdesk.entities.enums;

public enum Status {
    ABERTO(1),
    ANDAMENTO(2),
    ENCERRADO(3);

    private Integer cod;

    Status(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static Status toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Status x : Status.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido!" + cod);
    }
}

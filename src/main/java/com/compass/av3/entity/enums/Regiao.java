package com.compass.av3.entity.enums;

public enum Regiao {
	NORTE("Norte"),
	NORDESTE("Nordeste"),
	CENTRO_OESTE("Centro-Oeste"),
	SUDESTE("Sudeste"),
	SUL("Sul");
	
	private String descricao;

	private Regiao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
    public static Regiao getEnum(String descricao) {
        if(descricao == null)
            throw new IllegalArgumentException();
        for(Regiao regiao : values())
            if(descricao.equalsIgnoreCase(regiao.getDescricao())) {
            	return regiao;            	
            } 
        throw new IllegalArgumentException();
    }
}


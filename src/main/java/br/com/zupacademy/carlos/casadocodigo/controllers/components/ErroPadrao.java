package br.com.zupacademy.carlos.casadocodigo.controllers.components;

public class ErroPadrao {

	String campo;
	String erro;

	public ErroPadrao(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}

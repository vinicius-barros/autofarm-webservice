package br.com.autofarm

enum TipoAcao {
	LIGAR_LAMPADAS('Ligar Lâmpadas'),
	DESLIGAR_LAMPADAS('Desligar Lâmpadas'),

	LIGAR_VENTILADORES('Ligar ventiladores'),
	DESLIGAR_VENTILADORES('Desligar ventiladores'),

	ABRIR_LONAS('Abrir lonas'),
	FECHAR_LONAS('Fechar lonas')

	String descricao

	TipoAcao(String descricao) {
		this.descricao = descricao
	}
}
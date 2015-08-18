package br.com.autofarm

enum TipoAcao {
	LIGAR_LAMPADA('Ligar Lâmpada'),
	DESLIGAR_LAMPADA('Desligar Lâmpada'),

	LIGA_VENTILADORES('Ligar ventiladores'),
	DESLIGAR_VENTILADORES('Desligar ventiladores'),

	ABRIR_LONA('Abrir lona'),
	FECHAR_LONA('Fechar lona')

	String descricao

	TipoAcao(String descricao) {
		this.descricao = descricao
	}
}
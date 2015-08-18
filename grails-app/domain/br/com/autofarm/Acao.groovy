package br.com.autofarm

class Acao {
	TipoAcao tipo
	Date horaInsercao
	Boolean sucesso
	Boolean manual

	static belongsTo = [granja: Granja]

	static constraints = {
	}
}

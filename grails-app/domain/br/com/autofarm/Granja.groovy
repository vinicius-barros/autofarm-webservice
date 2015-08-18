package br.com.autofarm

import grails.rest.Resource

@Resource(uri = '/api/granja', formats = ['json', 'xml'])
class Granja {
	String nome
	BigDecimal temperaturaAtual
	Boolean ventiladoresLigados
	Boolean lampadasLigadas
	Boolean lonaAberta

	static hasMany = [acoes: Acao]

	static constraints = {
		temperaturaAtual nullable: true
		ventiladoresLigados nullable: true
		lampadasLigadas nullable: true
		lonaAberta nullable: true
	}
}

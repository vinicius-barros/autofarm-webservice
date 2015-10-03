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
    List<Acao> acoes

    static constraints = {
        temperaturaAtual nullable: true
        ventiladoresLigados nullable: true
        lampadasLigadas nullable: true
        lonaAberta nullable: true
    }

    Acao registreAcao(TipoAcao tipoAcao, Boolean manual = true) {
        Acao acao = new Acao(tipo: tipoAcao, manual: manual, horaInsercao: Date.newInstance())
        addToAcoes(acao)
        acao
    }
}

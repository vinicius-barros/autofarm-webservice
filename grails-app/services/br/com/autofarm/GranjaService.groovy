package br.com.autofarm

import grails.transaction.Transactional

import static br.com.autofarm.TipoAcao.*

@Transactional
class GranjaService {

    def getGranjaPrincipal() {
        return Granja.get(1)
    }

    Acao ligueVentiladores(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(LIGAR_VENTILADORES)

        //TODO: Mover para resposta do arduino
        granja.ventiladoresLigados = true
        acao.sucesso = true

        granja.save()
        acao
    }

    Acao desligueVentiladores(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(DESLIGAR_VENTILADORES)

        //TODO: Mover para resposta do arduino
        granja.ventiladoresLigados = false
        acao.sucesso = true

        granja.save()
        acao
    }

    Acao ligueLampadas(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(LIGAR_LAMPADAS)

        //TODO: Mover para resposta do arduino
        granja.lampadasLigadas = true
        acao.sucesso = true

        granja.save()
        acao
    }

    Acao desligueLampadas(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(DESLIGAR_LAMPADAS)

        //TODO: Mover para resposta do arduino
        granja.lampadasLigadas = false
        acao.sucesso = true

        granja.save()
        acao
    }

    Acao abraLonas(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(ABRIR_LONAS)

        //TODO: Mover para resposta do arduino
        granja.lonaAberta = true
        acao.sucesso = true

        granja.save()
        acao
    }

    Acao fecheLonas(Long idGranja) {
        Granja granja = Granja.get(idGranja)
        Acao acao = granja.registreAcao(FECHAR_LONAS)

        //TODO: Mover para resposta do arduino
        granja.lonaAberta = false
        acao.sucesso = true

        granja.save()
        acao
    }
}

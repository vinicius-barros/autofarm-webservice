package br.com.autofarm

import grails.converters.JSON

class MainController {

    def granjaService

    static allowedMethods = ['registraTemperatura':'PUT' ]

    def index() {
        Granja granjaPrincipal = granjaService.granjaPrincipal

        [granja: granjaPrincipal]
    }

    def ligueVentiladores() {
        Long id = params.long('id')
        granjaService.ligueVentiladores(id)

        redirect action: 'index'
    }

    def desligueVentiladores() {
        Long id = params.long('id')
        granjaService.desligueVentiladores(id)

        redirect action: 'index'
    }

    def ligueLampadas() {
        Long id = params.long('id')
        granjaService.ligueLampadas(id)

        redirect action: 'index'
    }

    def desligueLampadas() {
        Long id = params.long('id')
        granjaService.desligueLampadas(id)

        redirect action: 'index'
    }

    def abraLonas() {
        Long id = params.long('id')
        granjaService.abraLonas(id)

        redirect action: 'index'
    }

    def fecheLonas() {
        Long id = params.long('id')
        granjaService.fecheLonas(id)

        redirect action: 'index'
    }

    def registraTemperatura () {

        Long id = params.long('id')
        BigDecimal temperatura = params.float('temperatura')

        granjaService.registraTemperatura ( id, temperatura)

        render text : [success: true] as JSON
    }
}

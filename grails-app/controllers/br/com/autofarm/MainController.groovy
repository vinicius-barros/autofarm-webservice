package br.com.autofarm

class MainController {

    def granjaService

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
}

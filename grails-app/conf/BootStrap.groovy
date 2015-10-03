import br.com.autofarm.Granja

class BootStrap {

    def init = { servletContext ->
        Granja granja = Granja.findOrCreateByNome('Granja do Vacilão')

        granja.with {
            temperaturaAtual = 35
            ventiladoresLigados = true
            lampadasLigadas = false
            lonaAberta = true
        }

        granja.save()
    }
    def destroy = {
    }
}

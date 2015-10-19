package br.com.autofarm

class Acao implements Comparable<Acao> {
    TipoAcao tipo
    Date horaInsercao
    Boolean sucesso
    Boolean manual

    static belongsTo = [granja: Granja]

    static constraints = {
        sucesso nullable: true
    }

    int compareTo(Acao o) {
        return this.horaInsercao.compareTo(o.horaInsercao)
    }
}

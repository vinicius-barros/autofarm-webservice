<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<div class="row" style="margin-top: 80px">
    <div class="col-md-12">
        <h1>${granja.nome}</h1>

        <p>
            Temperatura atual: <strong>${granja.temperaturaAtual}°C</strong>
        </p>
    </div>
</div>

<div class="row">
    <div class="col-md-4">
        <h2>Ventiladores</h2>

        <p>${granja.ventiladoresLigados ? 'Ligados' : 'Desligados'}</p>

        <p>
            <g:if test="${granja.ventiladoresLigados}">
                <g:link class="btn btn-danger" action="desligueVentiladores" id="${granja.id}">
                    Desligar
                </g:link>
            </g:if>
            <g:else>
                <g:link class="btn btn-success" action="ligueVentiladores" id="${granja.id}">
                    Ligar
                </g:link>
            </g:else>
        </p>
    </div>

    <div class="col-md-4">
        <h2>Lampadas</h2>

        <p>${granja.lampadasLigadas ? 'Ligadas' : 'Desligadas'}</p>

        <p>
            <g:if test="${granja.lampadasLigadas}">
                <g:link class="btn btn-danger" action="desligueLampadas" id="${granja.id}">
                    Desligar
                </g:link>
            </g:if>
            <g:else>
                <g:link class="btn btn-success" action="ligueLampadas" id="${granja.id}">
                    Ligar
                </g:link>
            </g:else>
        </p>
    </div>

    <div class="col-md-4">
        <h2>Lonas</h2>

        <p>${granja.lonaAberta ? 'Abertas' : 'Fechadas'}</p>

        <p>
            <g:if test="${granja.lonaAberta}">
                <g:link class="btn btn-danger" action="fecheLonas" id="${granja.id}">
                    Fechar
                </g:link>
            </g:if>
            <g:else>
                <g:link class="btn btn-success" action="abraLonas" id="${granja.id}">
                    Abrir
                </g:link>
            </g:else>
        </p>
    </div>
</div>

<div class="row" style="margin-top: 40px">
    <div class="col-md-12">

        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Ações da Granja</h3>
            </div>
            <g:if test="${granja.acoes}">
                <table class="table table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Horário</th>
                        <th>Origem</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${granja.acoes.sort().reverse()}" var="acao">
                        <tr class="${acao.sucesso ? 'success' : 'danger'}">
                            <td>${acao.tipo.descricao}</td>
                            <td><prettytime:display showTime="true" date="${acao.horaInsercao}" format="dd/MM/yyyy HH:mm:ss"/></td>
                            <td>${acao.manual ? 'Manual' : 'Automatico'}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </g:if>
            <g:else>
                <div class="panel-body">
                    Sem acoes
                </div>
            </g:else>
        </div>
    </div>
</div>
</body>
</html>
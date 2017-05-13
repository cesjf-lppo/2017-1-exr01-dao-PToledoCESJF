<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes do Pedido</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Detalhes do Pedido</h1>
        <div style="color: red;">${mensagem}</div>
        <form method="post">
            <input type="hidden" value="${pedido.id}" name="id"/>
            <div><label> Pedido: <input type="text" name="txtPedido" value="${pedido.pedido}" /></label> </div>
            <div><label> Dono: <input type="text" name="txtDono" value="${pedido.dono}" /></label> </div>
            <div><label> Valor: <input type="text" name="txtValor" value="${pedido.valor}" /></label> </div>
            <div><label> Nome: <input type="text" name="txtNome" value="${pedido.nome}" /></label> </div>
            <div><label> Atualizacao: <input type="text" name="txtAtualizacao" value="${pedido.atualizacao}" /></label> </div>
            <div><input type="submit" /></div>   
        </form>
    </body>
</html>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Pedido</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo Pedido!</h1>
        <div style="color: red;"> ${mensagem} </div>
        <form method="POST">
            <div><label>Pedido: <input type="text" name="txtPedido" placeholder="digite o Pedido"/></label></div>
            <div><label>Dono: <input type="text" name="txtDono" placeholder="digite o Dono"/></label></div>
            <div><label>Valor: <input type="text" name="txtValor" placeholder="digite o Valor"/></label></div>
            <div><label>Nome: <input type="text" name="txtNome" placeholder="digite o Nome"/></label></div>
            <div><input type="submit" /></div>
        </form>
    </body>
</html>

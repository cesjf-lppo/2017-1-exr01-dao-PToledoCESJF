package br.cesjf.lppo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private final PreparedStatement opListar;    

    public PedidoDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM pedido");
        
    }
    
    public List<Pedidos> listarTodos() throws Exception{
        try{
        List<Pedidos> pedidos = new ArrayList<>();
        
        ResultSet resultado = opListar.executeQuery();
        while (resultado.next()){
            Pedidos pedidoAtual = new Pedidos();
            pedidoAtual.setId(resultado.getLong("id"));
            pedidoAtual.setPedido(resultado.getLong("pedido"));
            pedidoAtual.setDono(resultado.getString("dono"));
            pedidoAtual.setValor(resultado.getDouble("valor"));
            pedidoAtual.setNome(resultado.getString("nome"));
            pedidoAtual.setAtualizacao(resultado.getDate("atualizacao"));
            pedidos.add(pedidoAtual);
        }
        return pedidos;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os contatos no banco!", ex);
        }
            
        }
    }



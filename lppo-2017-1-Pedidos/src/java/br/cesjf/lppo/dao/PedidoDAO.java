package br.cesjf.lppo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {

    private final PreparedStatement opListar;
    private final PreparedStatement opNovo;

    public PedidoDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM pedido");
        opNovo = conexao.prepareStatement("INSERT INTO pedido(pedido, dono, valor, nome) Values(?, ?, ?, ?)");
    }

    public List<Pedidos> listarTodos() throws Exception {
        try {
            List<Pedidos> pedidos = new ArrayList<>();

            ResultSet resultado = opListar.executeQuery();
            while (resultado.next()) {
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

    public void criarPedido(Pedidos novoPedido) throws Exception {
        try {
            opNovo.clearParameters();
            opNovo.setLong(1, novoPedido.getPedido());
            opNovo.setString(2, novoPedido.getDono());
            opNovo.setDouble(3, novoPedido.getValor());
            opNovo.setString(4, novoPedido.getNome());
            opNovo.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir novo pedido!", ex);
        }

    }
}

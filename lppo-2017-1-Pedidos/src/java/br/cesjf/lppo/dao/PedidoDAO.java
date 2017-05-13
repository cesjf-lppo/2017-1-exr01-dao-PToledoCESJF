package br.cesjf.lppo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PedidoDAO {

    private final PreparedStatement opListar;
    private final PreparedStatement opNovo;
    private final PreparedStatement opBuscaPorId;
    private final PreparedStatement opAtualiza;

    public PedidoDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM pedido");
        opNovo = conexao.prepareStatement("INSERT INTO pedido(pedido, dono, valor, nome) Values(?, ?, ?, ?)");
        opBuscaPorId = conexao.prepareStatement("SELECT * FROM pedido WHERE id = ?");
        opAtualiza = conexao.prepareStatement("UPDATE pedido SET pedido = ?, dono = ?, valor = ?, nome = ? WHERE id = ?"); // FALTA O CAMPO ATUALIZAÇÃO
        
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
                pedidoAtual.setAtualizacao(resultado.getTimestamp("atualizacao"));
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

    public Pedidos buscarPorId(Long id) throws Exception {
        try {
            Pedidos pedido = null;
            opBuscaPorId.clearParameters();
            opBuscaPorId.setLong(1, id);
            ResultSet resultado = opBuscaPorId.executeQuery();
            while(resultado.next()){
                pedido = new Pedidos();
                pedido.setId(resultado.getLong("id"));
                pedido.setPedido(resultado.getLong("pedido"));
                pedido.setDono(resultado.getString("dono"));
                pedido.setValor(resultado.getDouble("valor"));
                pedido.setNome(resultado.getString("nome"));
                pedido.setAtualizacao(resultado.getTimestamp("atualizacao"));
            }

            return pedido;
        } catch (SQLException ex) {
            throw new Exception("Erro ao buscar pedido no banco!", ex);
        }
    }

    public void atualizarPedido(Pedidos pedido) throws Exception {
        try{
            opAtualiza.clearParameters();
            opAtualiza.setLong(1, pedido.getPedido());
            opAtualiza.setString(2, pedido.getDono());
            opAtualiza.setDouble(3, pedido.getValor());
            opAtualiza.setString(4, pedido.getNome());
            //opAtualiza.setTimestamp(5, pedido.getAtualizacao());
            opAtualiza.setLong(5, pedido.getId());
            opAtualiza.executeUpdate();
            
        } catch(SQLException ex){
            throw new Exception("Erro ao atualizar pedido!"); 
        }
    }
}

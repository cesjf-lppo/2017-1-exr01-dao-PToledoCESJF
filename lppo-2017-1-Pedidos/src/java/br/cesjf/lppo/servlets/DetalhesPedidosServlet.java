package br.cesjf.lppo.servlets;

import br.cesjf.lppo.dao.PedidoDAO;
import br.cesjf.lppo.dao.Pedidos;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetalhesPedidosServlet", urlPatterns = {"/detalhes.html"})
public class DetalhesPedidosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        try {
            PedidoDAO dao = new PedidoDAO();
            Pedidos pedido = dao.buscarPorId(id);
            request.setAttribute("pedido", pedido);
            request.getRequestDispatcher("WEB-INF/detalhes-pedidos.jsp").forward(request, response);
        } catch (NumberFormatException ex) {
            response.sendRedirect("pedidos.html");
        } catch (Exception ex) {
            Logger.getLogger(DetalhesPedidosServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("pedidos.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            PedidoDAO dao;
            dao = new PedidoDAO();
            Pedidos pedido = dao.buscarPorId(id);
            
            pedido.setPedido(Long.parseLong(request.getParameter("txtPedido")));
            pedido.setDono(request.getParameter("txtDono"));
            pedido.setValor(Double.parseDouble(request.getParameter("txtValor")));
            pedido.setNome(request.getParameter("txtNome"));
            pedido.setAtualizacao(formataData.parse(request.getParameter("txtAtualizacao")));
            dao.atualizarPedido(pedido);
            response.sendRedirect("pedidos.html");
        } catch (NumberFormatException ex) {
            response.sendRedirect("pedidos.html");
        } catch (Exception ex) {
            Logger.getLogger(DetalhesPedidosServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("pedidos.html");
        }

    }

}

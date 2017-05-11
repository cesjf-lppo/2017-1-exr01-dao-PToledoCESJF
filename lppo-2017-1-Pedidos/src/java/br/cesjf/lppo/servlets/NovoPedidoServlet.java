package br.cesjf.lppo.servlets;

import br.cesjf.lppo.dao.PedidoDAO;
import br.cesjf.lppo.dao.Pedidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovoPedidoServlet", urlPatterns = {"/novo.html"})
public class NovoPedidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/novo-pedido.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pedidos novoPedido = new Pedidos();
        novoPedido.setPedido(Long.parseLong(request.getParameter("txtPedido")));
        novoPedido.setDono(request.getParameter("txtDono"));
        novoPedido.setValor(Double.parseDouble(request.getParameter("txtValor")));
        novoPedido.setNome(request.getParameter("txtNome"));
        
        try {
            PedidoDAO dao = new PedidoDAO();
            dao.criarPedido(novoPedido);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("WEB-INF/novo-pedido.jsp");
            
        }
        
        response.sendRedirect("pedidos.html");
        
    }
}

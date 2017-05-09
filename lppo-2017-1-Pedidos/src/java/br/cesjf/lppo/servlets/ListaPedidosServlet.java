/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.dao.Pedidos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "ListaPedidosServlet", urlPatterns = {"/pedidos.html"})
public class ListaPedidosServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedidos> pedidos;
        
    }
}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Contato> contatos;

        try {
           ContatoDAO dao = new ContatoDAO();
            contatos = dao.listAll();
        } catch (Exception ex) {
            Logger.getLogger(ListaContatosServlet.class.getName()).log(Level.SEVERE, null, ex);
            contatos = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("contatos", contatos);
        request.getRequestDispatcher("WEB-INF/lista-contatos.jsp").forward(request, response);
    }

 

}
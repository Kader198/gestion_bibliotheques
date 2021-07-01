package com.see.servlet;

import com.service.LivreService;
import entity.Livre;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LivreServlet", value = "/")
public class LivreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LivreService livreService = new LivreService();
        List<Livre> Livres = livreService.getAllLivre();
        request.setAttribute("livres",Livres);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get all the parameters from the view
        String libelle = request.getParameter("libelle");
        Double cout = Double.parseDouble(request.getParameter("cout"));
        int auteur = Integer.parseInt(request.getParameter("auteur"));

        Livre livre = new Livre(libelle,cout,auteur);


        LivreService livreService = new LivreService();
        livreService.addLivre(livre);
        request.setAttribute("success","Le livre à été bien ajouté");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}

package ru.belyaeva.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get listServlet");
        if (req.getParameter("btn") != null && req.getParameter("btn").equals("open")){
            req.setAttribute("id", req.getParameter("id"));
            System.out.println(req.getParameter("id"));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tempuser");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}

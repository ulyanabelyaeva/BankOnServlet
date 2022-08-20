package ru.belyaeva.servlet;

import ru.belyaeva.model.ModelUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put putServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/change.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put putServlet");
        ModelUser.getInstance().put(req.getParameter("name"), req.getParameter("last_name"),
                req.getParameter("series"), req.getParameter("number"), req.getParameter("password"));
        resp.sendRedirect("/user");
    }
}

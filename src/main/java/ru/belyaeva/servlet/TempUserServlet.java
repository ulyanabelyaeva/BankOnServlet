package ru.belyaeva.servlet;

import ru.belyaeva.entity.User;
import ru.belyaeva.model.ModelAllUsers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TempUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/tempuser.jsp");
        User user = ModelAllUsers.getInstance().search(Long.parseLong(req.getAttribute("id").toString()));
        req.setAttribute("user", user);
        requestDispatcher.forward(req, resp);
    }
}

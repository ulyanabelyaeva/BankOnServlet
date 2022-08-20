package ru.belyaeva.servlet;

import ru.belyaeva.entity.Role;
import ru.belyaeva.entity.User;
import ru.belyaeva.model.ModelAllUsers;
import ru.belyaeva.model.ModelUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get enterServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post enterServlet");

        User user = ModelAllUsers.getInstance().list().stream()
                .filter(u -> u.getName().equals(req.getParameter("name")) &&
                        u.getLastName().equals(req.getParameter("last_name")) &&
                        u.getPassword().equals(req.getParameter("pass")))
                .findFirst().orElse(new User());
        if (user.getName() != null){
            ModelUser.getInstance().setUser(user);
            if (user.getRole() == Role.ADMIN)
                resp.sendRedirect("/list");
            else
                resp.sendRedirect("/user");
        } else {
            req.setAttribute("wrongname", req.getParameter("name"));
            req.setAttribute("wronglastname", req.getParameter("last_name"));
            doGet(req, resp);
        }
    }
}

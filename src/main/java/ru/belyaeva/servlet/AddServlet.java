package ru.belyaeva.servlet;

import ru.belyaeva.entity.Role;
import ru.belyaeva.entity.Score;
import ru.belyaeva.entity.User;
import ru.belyaeva.model.ModelAllAdmins;
import ru.belyaeva.model.ModelAllUsers;
import ru.belyaeva.model.ModelUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get addServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post addServlet");
        /*Role role;*/
        User user;
        if (req.getParameter("role") != null){
            user = new User(Math.abs(new Random().nextLong()), req.getParameter("name"), req.getParameter("last_name"), req.getParameter("series"),
                    req.getParameter("number"), Role.ADMIN, req.getParameter("pass"),
                    new Score(Math.abs(new Random().nextLong()), new Date(), 0));
            ModelAllAdmins.getInstance().addNewAdmin(user);
            resp.sendRedirect("/list");
        }
            /*role = Role.ADMIN;*/
        else{
            user = new User(Math.abs(new Random().nextLong()), req.getParameter("name"), req.getParameter("last_name"), req.getParameter("series"),
                    req.getParameter("number"), Role.CLIENT, req.getParameter("pass"),
                    new Score(Math.abs(new Random().nextLong()), new Date(), 0));
            ModelAllUsers.getInstance().addNewUser(user);
            resp.sendRedirect("/user");
        }
            /*role = Role.CLIENT;*/

        ModelUser.getInstance().setUser(user);
    }
}

package ru.belyaeva.servlet;

import ru.belyaeva.model.ModelAllUsers;
import ru.belyaeva.model.ModelUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get userServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/user.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post userServlet");
        if (req.getParameter("btn").equals("exit")){
            ModelUser.getInstance().setUser(null);
            resp.sendRedirect("/");
        } else if (req.getParameter("btn").equals("move")) {
            String result = ModelAllUsers.getInstance().moveMoney(Long.parseLong(req.getParameter("receiveId")), Integer.parseInt(req.getParameter("money")));
            req.setAttribute("result", result);
            doGet(req, resp);
            resp.sendRedirect("/user");
        } else if(req.getParameter("btn").equals("topUp")){
            ModelAllUsers.getInstance().topUp(Long.parseLong(req.getParameter("receiveId")), Integer.parseInt(req.getParameter("money")));
            resp.sendRedirect("/user");
        } else if(req.getParameter("btn").equals("delete")){
            ModelAllUsers.getInstance().list().removeIf(u -> u.getId() == ModelUser.getInstance().getUser().getId());
            ModelUser.getInstance().setUser(null);
            resp.sendRedirect("/");
        } else if (req.getParameter("btn").equals("put")) {
            resp.sendRedirect("/put");
        }
    }

    /*@Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ModelAllUsers.getInstance().list().removeIf(u -> u.getId() == ModelUser.getInstance().getUser().getId());
        ModelUser.getInstance().setUser(null);
        resp.sendRedirect("/");

    }*/
}

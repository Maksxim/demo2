package com.example.demo2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Register", urlPatterns = "/register/*")
public class Register extends HttpServlet {

    private List<User> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/register/delete")) {
            String name = req.getParameter("name");
            System.out.println("User name to delete: " + name);
            User user = list.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
            if(user!= null) {
                list.remove(user);
            }

            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/list.jsp");
            req.setAttribute("list", list);
            reqDispatcher.forward(req, resp);
        } else {
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");

            if(name.isEmpty() || address.isEmpty() || email.isEmpty()){
                RequestDispatcher reqDispatcher = req.getRequestDispatcher("/save.jsp");
                reqDispatcher.include(req, resp);
            }else {
                list.add(new User(name, address, email));
                RequestDispatcher reqDispatcher = req.getRequestDispatcher("/data.jsp");
                reqDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/register/list")) {
            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/list.jsp");
            req.setAttribute("list", list);
            reqDispatcher.forward(req, resp);
        } else if(req.getRequestURI().equals("/register/delete")) {
            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/delete.jsp");
            reqDispatcher.forward(req, resp);
        } else {
            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/save.jsp");
            reqDispatcher.include(req, resp);
        }
    }
}
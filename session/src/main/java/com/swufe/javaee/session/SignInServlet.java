package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");


        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Administrator\\Desktop\\textFile.txt"))) {
            Optional<String> user = lines.filter(line -> {
                String[] list = line.split("");
                return list[0].equals(name) && list[1].equals(password);
            }).findAny();

            if (user.isPresent()) {
                req.getSession().setAttribute("user", name);
                resp.sendRedirect("index");
            } else {
                resp.sendRedirect("wrong.html");
            }


        }
    }

}
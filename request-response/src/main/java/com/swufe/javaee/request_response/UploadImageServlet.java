package com.swufe.javaee.request_response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadImageServlet", value = "/UploadImageServlet")
public class UploadImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getPart("Upload").write("C:C:\\Users\\Administrator\\Desktop.png");
        response.sendRedirect("success.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

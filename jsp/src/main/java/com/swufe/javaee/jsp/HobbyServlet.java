package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, List<String>> userHobby;
    @Override
    public void init() {
        userHobby = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        list1.add("skiing");
        list1.add("knitting");

        List<String> list2 = new ArrayList<>();
        list2.add("swimming");
        list2.add("running");

        List<String> list3 = new ArrayList<>();
        list3.add("singing");
        list3.add("dancing");


       userHobby.put("Bob", list1);
       userHobby.put("Jim", list1);
       userHobby.put("James", list1);
       userHobby.put("Tom", list2);
       userHobby.put("Fei", list2);
       userHobby.put("Jone", list2);
       userHobby.put("Fred", list3);
       userHobby.put("Pradeep", list3);
       userHobby.put("Philippe", list3);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
           if (v.contains(hobby)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MIGUEL
 */
@WebServlet(name = "MensajeBienvenida", urlPatterns = {"/MensajeBienvenida"})
public class MensajeBienvenida extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();

    // Verificar si existe una cookie con el nombre "visitante"
    Cookie cookies[] = request.getCookies();
    boolean existeCookie = false;
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("visitante")) {
          existeCookie = true;
          out.println("<h1>Gracias por visitarnos nuevamente</h1>");
          break;
        }
      }
    }

    // Si no existe la cookie, crearla
    if (!existeCookie) {
      Cookie cookie = new Cookie("visitante", "si");
      cookie.setMaxAge(60 * 60 * 24 * 365); // Caducidad: 1 año
      response.addCookie(cookie);
      out.println("<h1>Bienvenido a nuestro sitio web</h1>");
    }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PublicacionVo;
import model.PublicacionDao;


public class Servletnavegacion extends HttpServlet {
      
      PublicacionVo generoVo = new PublicacionVo();
    PublicacionDao generoDao=new PublicacionDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String pagina=req.getParameter("accion");
      switch (pagina) {
          case "instagram":
                System.out.println(pagina);
                req.getRequestDispatcher("views/face.jsp").forward(req, resp);
          break;
        
          case "facebook":
                System.out.println(pagina);
                req.getRequestDispatcher("views/face.jsp").forward(req, resp);
          break;
          default:
          System.out.println("VOLVER");
              break;
      }
       }
        }
    
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PublicacionVo;
import model.PublicacionDao;


public class ServletPublicaciones extends HttpServlet {
      
      PublicacionVo generoVo = new PublicacionVo();
    PublicacionDao generoDao=new PublicacionDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String pagina=req.getParameter("accion");
      switch (pagina) {
          case "formulario":
                System.out.println(pagina);
                req.getRequestDispatcher("views/components/formulario.jsp").forward(req, resp);
          break;
          case "listarPublicaciones":
                System.out.println("Entro a listar");
                mostrar(req,resp);
          break;
          case "VolverP":
                System.out.println(pagina);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
          break;
          default:
          System.out.println("VOLVER");
              break;
      }
    }
      private void mostrar(HttpServletRequest req, HttpServletResponse resp) {
            PublicacionVo generoVo=new PublicacionVo();
            PublicacionDao generoDao=new PublicacionDao();
            try {
                  List<PublicacionVo> arrayGeneros =generoDao.Listar();
                  req.setAttribute("generos", arrayGeneros);
                  req.getRequestDispatcher("views/components/listPublicaciones.jsp").forward(req, resp);
                  System.out.println("Datos listados correctamente");
                  
              } catch (Exception e) {
                  System.out.println("Hay problemas al listar los datos"+e.getMessage().toString());
              }
      }


protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Entro al Dopost");
      String accion=req.getParameter("accionForm");
      switch (accion) {
          case "agregar":
            agregar(req,resp);  
          break;
          case "eliminar":
            eliminar(req, resp);
          break;
          case "activar":
            activar(req, resp);
          break;
          case "inactivar":
            inactivar(req, resp);
          break;
          case "Actualizar":
            actualizar(req, resp);
          break;
          default:
              break;
      }
    }

     
      private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
            if (req.getParameter("idGenero")!=null) {
                  generoVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            if (req.getParameter("nombreGenero")!=null) {
                  generoVo.setNombreGenero(req.getParameter("nombreGenero"));
            }
            if (req.getParameter("estadoGenero")!=null) {
                  generoVo.setEstadoGenero(req.getParameter("estadoGenero"));
            } 
            try {
                  generoDao.actualizar(generoVo.getIdGenero() , generoVo.getNombreGenero() , generoVo.getEstadoGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("genero?accion=listarPublicaciones");
                  System.out.println("Información actualiada exitosamente");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
                 System.out.println("No se puede actualizar el registro"+e.getMessage());
            }
      }
      private void inactivar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.print( "entro a inactivar");
            if (req.getParameter("idGenero")!=null) {
                  generoVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            try {
                  generoDao.inactivar(generoVo.getIdGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("genero?accion=listarPublicaciones");
                  System.out.println("Genero Inactivado");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
                 System.out.println("No se puede eliminar el registro"+e.getMessage());
            }
      }
      private void activar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.print( "entro a inactivar");
            if (req.getParameter("idGenero")!=null) {
                  generoVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            try {
                  generoDao.activar(generoVo.getIdGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("genero?accion=listarPublicaciones");
                  System.out.println("Genero Inactivado");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
                 System.out.println("No se puede eliminar el registro"+e.getMessage());
            }
      }
      private void agregar(HttpServletRequest req, HttpServletResponse resp) {
            if (req.getParameter("nombreGenero")!=null ) {
                  generoVo.setNombreGenero((req.getParameter("nombreGenero"))); ;
            }
            String estado=req.getParameter("estadoGenero");
              System.out.println(estado);
            switch (estado) {
                  case "Activo":
                        generoVo.setEstadoGenero("Activo");
                        break;
                  case "Inactivo":
                        generoVo.setEstadoGenero("Inactivo");
                    
                        break;
            
                  default:
                        generoVo.setEstadoGenero("Inactivo");
                        break;
            }
              try {
                  generoDao.Registrar(generoVo);
                  System.out.println("El registro fue exitoso");
                  resp.sendRedirect("genero?accion=formGenero");
              } catch (Exception e) {
                  System.out.println("Error en la insercción del registro");
              }
      }
      private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            
            if (req.getParameter("idGeneroEliminar")!= null ) {
                  generoVo.setIdGenero(Integer.parseInt(req.getParameter("idGeneroEliminar")));
            }
            try {
                  generoDao.Eliminar(generoVo.getIdGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("genero?accion=listarPublicaciones");
                  System.out.println("Rol eliminado");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
                 System.out.println("No se puede eliminar el registro"+e.getMessage());
            }
      }
}

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuariosVo;
import model.UsuariosDao;


public class ServletUsuarios extends HttpServlet {
      
      UsuariosVo UsuariosVo = new UsuariosVo();
    UsuariosDao UsuariosDao=new UsuariosDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String pagina=req.getParameter("accion");
      switch (pagina) {
          case "formulario":
                System.out.println(pagina);
                req.getRequestDispatcher("views/components/formularioUsu.jsp").forward(req, resp);
          break;
          case "listarUsuarios":
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
            UsuariosVo UsuariosVo=new UsuariosVo();
            UsuariosDao UsuariosDao=new UsuariosDao();
            try {
                  List<UsuariosVo> arrayGeneros =UsuariosDao.Listar();
                  req.setAttribute("usuarios", arrayGeneros);
                  req.getRequestDispatcher("views/components/listUsuarios.jsp").forward(req, resp);
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
                  UsuariosVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            if (req.getParameter("nombreGenero")!=null) {
                  UsuariosVo.setNombreGenero(req.getParameter("nombreGenero"));
            }
            if (req.getParameter("estadoGenero")!=null) {
                  UsuariosVo.setEstadoGenero(req.getParameter("estadoGenero"));
            } 
            try {
                  UsuariosDao.actualizar(UsuariosVo.getIdGenero() , UsuariosVo.getNombreGenero() , UsuariosVo.getEstadoGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("genero?accion=listarUsuarios");
                  System.out.println("Información actualiada exitosamente");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede actualizar el registro "+e.getMessage());
                 System.out.println("No se puede actualizar el registro"+e.getMessage());
            }
      }
      private void inactivar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.print( "entro a inactivar");
            if (req.getParameter("idGenero")!=null) {
                  UsuariosVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            try {
                  UsuariosDao.inactivar(UsuariosVo.getIdGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("usuarios?accion=listarPublicaciones");
                  System.out.println("Genero Inactivado");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
                 System.out.println("No se puede eliminar el registro"+e.getMessage());
            }
      }
      private void activar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.print( "entro a inactivar");
            if (req.getParameter("idGenero")!=null) {
                  UsuariosVo.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
            }
            try {
                  UsuariosDao.activar(UsuariosVo.getIdGenero());
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
                  UsuariosVo.setNombreGenero((req.getParameter("nombreGenero"))); ;
            }
            String estado=req.getParameter("estadoGenero");
              System.out.println(estado);
            switch (estado) {
                  case "Activo":
                        UsuariosVo.setEstadoGenero("Activo");
                        break;
                  case "Inactivo":
                        UsuariosVo.setEstadoGenero("Inactivo");
                    
                        break;
            
                  default:
                        UsuariosVo.setEstadoGenero("Inactivo");
                        break;
            }
              try {
                  UsuariosDao.Registrar(UsuariosVo);
                  System.out.println("El registro fue exitoso");
                  resp.sendRedirect("usuarios?accion=formusuarios");
              } catch (Exception e) {
                  System.out.println("Error en la insercción del registro");
              }
      }
      private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
            
            if (req.getParameter("idGeneroEliminar")!= null ) {
                  UsuariosVo.setIdGenero(Integer.parseInt(req.getParameter("idGeneroEliminar")));
            }
            try {
                  UsuariosDao.Eliminar(UsuariosVo.getIdGenero());
                  req.setAttribute("proceso",true);
                  resp.sendRedirect("usuarios?accion=listarUsuarios");
                  System.out.println("Rol eliminado");
            } catch (Exception e) {
                  req.setAttribute("msg","No se puede eliminar el registro "+e.getMessage());
                 System.out.println("No se puede eliminar el registro"+e.getMessage());
            }
      }
}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class PublicacionDao {
     //Atributos para realizar operaciones sobre la base de datos
     Connection con; 
     PreparedStatement ps; 
     ResultSet rs; 
     String sql=null;
     int r;//cantidad de filas que devuelve una sentencia
    // 
    public int Registrar(PublicacionVo v) throws SQLException {
        //consulta preparada
        sql="INSERT INTO genero ( `nombreGenero`, `estadoGenero`) values (?,?)";
        try {
            con=Conexion.conectar();//abrir conexion
            //preparar sentencia
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getNombreGenero());
            ps.setString(2, v.getEstadoGenero());
            System.out.println(sql);
            ps.executeUpdate();

            ps.close(); //cerrar sentencia
            System.out.println("Se registro el genero en la base de datos");
        } catch (Exception e) {//definicion de objeto
            System.out.println("Error en el registro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexion
        }
        return r;
    }
    // Lista un arreglo
    public List<PublicacionVo> Listar() throws SQLException {
        // arraylist-almacena datos en memoria-guardar de manera diferente,forma dinamica
        List<PublicacionVo> ListaRoles= new ArrayList<>();
        sql="SELECT * FROM genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
               PublicacionVo row = new PublicacionVo();
               //Escribir en el setter de cada valor encontrado
               row.setIdGenero(rs.getInt("idGenero")); 
               row.setNombreGenero(rs.getString("nombreGenero")); 
               row.setEstadoGenero(rs.getString("estadoGenero")); 
               
               ListaRoles.add(row);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        } finally{
            con.close();
        }
        return ListaRoles;
    }
    public void Eliminar(int idRol) throws SQLException {
        sql="DELETE FROM genero WHERE idGenero="+idRol;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se elimino la publicacion exitosamente");

        } catch (Exception e) {
            System.out.println("Error al eliminar la publicacion "+e.getMessage().toString());
        }finally{
            con.close();
        }
    
    }
    public void activar(int id) throws SQLException {
        sql="UPDATE genero SET estadoGenero='Activo' WHERE idGenero="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se activo el genero exitosamente");

        } catch (Exception e) {
            System.out.println("Error al activar registro "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
    public void inactivar(int id) throws SQLException {
        sql="UPDATE `genero` SET `estadoGenero`='Inactivo' WHERE idGenero ="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se inactivo el genero exitosamente");

        } catch (Exception e) {
            System.out.println("Error al inactivar registro "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
    public void actualizar(int id, String genero, String estado) throws SQLException {
        sql="UPDATE `genero` SET `nombreGenero`='"+genero+"',`estadoGenero`='"+estado+"' WHERE idGenero="+id;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            System.out.print("Se actualizo el genero exitosamente");

        } catch (Exception e) {
            System.out.println("Error al inactivar registro "+e.getMessage().toString());
        }finally{
            con.close();
        }
    }
}

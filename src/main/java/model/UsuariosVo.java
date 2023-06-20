package model;

public class UsuariosVo {
    private int idGenero;
    private String nombreGenero;
    private String estadoGenero;
  
    
    // constructor vacio
    public UsuariosVo() {
        
    }


    public UsuariosVo(int idGenero, String nombreGenero, String estadoGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.estadoGenero = estadoGenero;
    }

    // metodos accesores
    public int getIdGenero() {
        return idGenero;
    }


    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }


    public String getNombreGenero() {
        return nombreGenero;
    }


    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }


    public String getEstadoGenero() {
        return estadoGenero;
    }


    public void setEstadoGenero(String estadoGenero) {
        this.estadoGenero = estadoGenero;
    }
    
   
    
  
   
   
}

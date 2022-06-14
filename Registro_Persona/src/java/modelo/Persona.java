package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Persona {
   //Atributos de la clase
    String dui;
    String apellidos;
    String nombres;
    
    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    Connection cnn;
    Statement state;
    ResultSet result;
    //El constructor lo utilizaremos para conectar con la base de datos,
    //Constructor de la clase
    public Persona(){
        try {
            Class.forName("com.mysql.jdbc.Driver");//Driver de la base de datos
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recurso_humano1?zeroDateTimeBehavior=convertToNull", "root", "");//url de la BD, user, pass
            //System.out.print("conxion existosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
             //System.out.print("error de conexion");
        }
    }
    public Persona(String dui, String apellidos,String nombres){
        this.dui=dui;
        this.apellidos = apellidos;
        this.nombres = nombres;    
    }
    
    
    public boolean insertarDatos(){
        try {
            String miQuery= "insert into tb_persona1 values('" + dui + "','" + apellidos + "','" + nombres + "');";
            int estado =0;//estado de la insercion
            state=cnn.createStatement();
            estado=state.executeUpdate(miQuery);
            if(estado==1){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    
    public ArrayList<Persona>consultarRegistros(){
        ArrayList<Persona>person=new ArrayList();
        try{
            String miQuery="select*from tb_persona1;";
            state=cnn.createStatement();
            result=state.executeQuery(miQuery);
            while(result.next()){
                
               person.add(new Persona(result.getString("dui_persona"),result.getString("apellido_persona"),result.getString("nombre_persona")));
            }
        }catch(SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return person;
    }

    public boolean Eliminar(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Persona> ConsultarR(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean Actualizar(Persona person) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

            
        
    
    //Generar los metodos set y get para los atributos//

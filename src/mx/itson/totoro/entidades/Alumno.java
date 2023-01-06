/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.totoro.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.crypto.Data;
import mx.itson.totoro.persistencia.Conexion;

/**
 *
 * @author Alejandra Medina
 */
public class Alumno {

    public static Alumno obtenerPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int id;
    private String nombre;
    private String apellidos;
    private String idCia;
    private Date fechaNacimiento;
    private String apodo;

    /**
     * obtiene una conexion hacia la base de datos por medio de los parametros relacionados
     * @return la conexion inicializada hacia la base de datos
     */
    public List<Alumno> obtenerTodos(){
        Conexion conect = new Conexion();
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection conexion = conect.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,nombre,apellidos, idCia, fechaNacimiento, apodo FROM alumno");
            
            while (resultSet.next()){
                Alumno alumno = new Alumno();
                alumno.setId(resultSet.getInt(1));
                alumno.setNombre(resultSet.getString(2));
                alumno.setApellido(resultSet.getString(3));
                alumno.setIdCia(resultSet.getString(4));
                alumno.setFechaNacimiento(resultSet.getDate(5));
                alumno.setApodo(resultSet.getString(6));
                
                alumnos.add(alumno);
            }
            
        }catch(Exception e){
            System.err.println("Ocurrio un error: "+e.getMessage());
            }
    return alumnos;
    }
    
    public boolean guardar (String nombre, String apellidos,String id, Data fechaNacimiento,String apodo  ){
        boolean resultado= false;
        Conexion Conexion = new Conexion();
        try{
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO alumno (nombre, apellidos, idCia, apodo) VALUE (?,?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString (1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, id);
            statement.setString(4, apodo);
            
            resultado= statement.getUpdateCount()== 1;
            conexion.close();
        }catch(Exception e){
            System.err.println("Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
    public int obtenerPorId(int id){
        try{
            Connection Conexion = Conexion.obtener();
            PreparedStatement statement = conexion.PreparedStatement("SELECT id,nombre,apellidos, idCia, fechaNacimiento, apodo FROM alumno WHERE id = ?");
        
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
            
        }
        
        }catch(Exception e){
            
        }
        return id;
    }

    public static boolean editar(int id, String nombre, String apellidos, String idCia, String apodo) throws SQLException{
        boolean resultado =false;
        try{
        Connection conexion = Conexion.obtener();
        String consulta = "UPDATE alumno SET nombre = ?, apellidos = ?, idCia=?, apodo=?, WHERE id=?";
         PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString (1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, idCia);
            statement.setString(4, apodo);
            statement.setInt(5, id);
            
            statement.execute();
            = statement.getUpdateCount();
            conexion.close();
        }catch(Exception e){
            System.err.println(e);
        }
    } 
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellido() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the idCia
     */
    public String getIdCia() {
        return idCia;
    }

    /**
     * @param idCia the idCia to set
     */
    public void setIdCia(String idCia) {
        this.idCia = idCia;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the apodo
     */
    public String getApodo() {
        return apodo;
    }

    /**
     * @param apodo the apodo to set
     */
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
}

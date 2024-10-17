package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConexionBBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelos.ModeloPersona;

public class DaoPersona {

	public static ObservableList<ModeloPersona> cargarListaPersonas(){
		ConexionBBDD connection;
        ObservableList<ModeloPersona> listadoDePersonas= FXCollections.observableArrayList();
        try {
			connection = new ConexionBBDD();
			String consulta = "SELECT nombre,apellidos,edad FROM Persona";
			 PreparedStatement pstmt = connection.getConnection().prepareStatement(consulta);
             ResultSet rs = pstmt.executeQuery();
             while (rs.next()) {
                 String nombre = rs.getString("nombre");
                 String apellidos = rs.getString("apellidos");
                 String edad = rs.getString("edad");
                 ModeloPersona mp = new ModeloPersona(nombre,apellidos,Integer.parseInt(edad));
                 listadoDePersonas.add(mp);

             }
             rs.close();
             connection.CloseConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listadoDePersonas;
	}
	
	public static void eliminar() {
		ConexionBBDD connection;
		try {
			connection = new ConexionBBDD();
			String consulta;
			PreparedStatement pstmt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean aniadir(ModeloPersona persona) {
		ConexionBBDD connection;
		int exito=0;
		try {
			connection = new ConexionBBDD();
			String consulta="INSERT INTO Persona (nombre,apellidos,edad) VALUES (?,?,?)";
			PreparedStatement pstmt;
			pstmt = connection.getConnection().prepareStatement(consulta);
			pstmt.setString(1, persona.getNombre());
			pstmt.setString(2, persona.getApellidos());
			pstmt.setInt(3, persona.getEdad());
			exito=pstmt.executeUpdate();
			connection.CloseConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito>0;
	}
	
	public static void modificar() {
		ConexionBBDD connection;
		try {
			connection = new ConexionBBDD();
			String consulta;
			PreparedStatement pstmt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

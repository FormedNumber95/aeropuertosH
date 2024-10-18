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
             pstmt.close();
             connection.CloseConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listadoDePersonas;
	}
	
	public static boolean eliminar(ModeloPersona p) {
		ConexionBBDD connection;
		int exito=0;
		try {
			connection = new ConexionBBDD();
			String consulta1="SELECT id FROM personas.Persona WHERE "
					+ "nombre=? AND apellidos=? AND edad=?";
			String consulta2="DELETE FROM Persona WHERE id=? ";
			PreparedStatement pstmt1= connection.getConnection().prepareStatement(consulta1);
			pstmt1.setString(1, p.getNombre());
			pstmt1.setString(2, p.getApellidos());
			pstmt1.setInt(3, p.getEdad());
			ResultSet rs = pstmt1.executeQuery();
			pstmt1.close();
			if (rs.next()) {
				String id=rs.getString("id");
				PreparedStatement pstmt2=connection.getConnection().prepareStatement(consulta2);
				pstmt2.setString(1, id);
				exito=pstmt2.executeUpdate();
				pstmt2.close();
			}
			else {
				return false;
			}
			connection.CloseConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exito>0;
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
			pstmt.close();
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

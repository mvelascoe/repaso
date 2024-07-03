package com.java.nombre.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.nombre.domain.model.Nombre;
import com.java.nombre.insfrastructure.NombreRepository;

public class NombreMySQLRepository implements NombreRepository{
    private final String url;
    private final String user;
    private final String password;
    
    public NombreMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void delete(int id_nombre) {
        try (Connection connection = DriverManager.getConnection(url, user,password)){
            String query = "DELETE FROM nombre WHERE id_nombre = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_nombre);
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
    }

    
    @Override
    public List<Nombre> finAll() {
        List<Nombre> nombre = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_nombre, nombre, edad, direccion, id_ciudad FROM nombre";
            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        Nombre name = new Nombre(
                            resultSet.getInt("id_nombre"),
                            resultSet.getString("nombre"), 
                            resultSet.getInt("edad"), 
                            resultSet.getString("direccion"), 
                            resultSet.getInt("id_ciudad"));
                        nombre.add(name);
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }return nombre;
    }
    


    @Override
    public Optional<Nombre> findById(int id_nombre) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void save(Nombre nombre) {
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO nombre (nombre, edad, direccion, id_ciudad) VALUES (?, ?, ?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, nombre.getNombre());
                statement.setInt(2, nombre.getEdad());
                statement.setString(3, nombre.getDireccion());
                statement.setInt(4, nombre.getId_ciudad());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Nombre nombre) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE nombre SET nombre = ?, edad = ?, direccion = ?, id_ciudad = ? WHERE id_nombre = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, nombre.getNombre());
                statement.setInt(2, nombre.getEdad());
                statement.setString(3, nombre.getDireccion());
                statement.setInt(4, nombre.getId_ciudad());
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

}

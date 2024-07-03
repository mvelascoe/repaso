package com.java.ciudad.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.ciudad.domain.model.Ciudad;
import com.java.ciudad.infrastructure.CiudadRepository;

public class CiudadMySQLRepository implements CiudadRepository{
    private final String url;
    private final String user;
    private final String password;

    public CiudadMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void delete(int id_ciudad) {
        try(Connection connection =DriverManager.getConnection(url,user, password)){
            String query = " DELETE FROM ciudad WHERE id_ciudad = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_ciudad);
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Ciudad> findAll() {
        List<Ciudad> ciudad = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_ciudad, nombre_ciudad, id_pais FROM ciudad";
            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultset = statement.executeQuery()){
                    while (resultset.next()){
                        Ciudad city = new Ciudad(
                            resultset.getInt("id_ciudad"),
                            resultset.getString("nombre"),
                            resultset.getInt("id_pais")
                        );
                        ciudad.add(city);
                    }
                }
        }catch (SQLException e){
            e.printStackTrace();
        }return ciudad;
    }

    @Override
    public Optional<Ciudad> findById(int id_ciudad) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void save(Ciudad ciudad) {
       try(Connection connection = DriverManager.getConnection(url,user,password)){
            String query = "INSERT INTO ciudad (nombre_ciudad),(id_pais) VALUES (?),(?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, ciudad.getNombre_cliudad());
                statement.setInt(1, ciudad.getId_Pais());
                statement.executeUpdate();
            }
       }catch(SQLException e){
        e.printStackTrace();
       }
        
    }

    @Override
    public void update(Ciudad ciudad) {
       try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE ciudad SET nombre_ciudad = ?, id_pais = ? WHERE id_ciudad = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, ciudad.getNombre_cliudad());
                statement.setInt(2, ciudad.getId_Pais());
                statement.executeUpdate();
            }
       }catch(SQLException e){
            e.printStackTrace();
       }
        
    }
}

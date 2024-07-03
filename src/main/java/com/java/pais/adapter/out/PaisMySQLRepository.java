package com.java.pais.adapter.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.java.pais.domain.model.Pais;
import com.java.pais.infrastructura.PaisRepository;

public class PaisMySQLRepository implements PaisRepository{
    private final String url;
    private final String user;
    private final String password;

    public PaisMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    @Override
    public void delete(int id_pais) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM paiS WHERE id_pais =?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_pais);
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

  @Override
    public Optional<Pais> finById(int id_pais) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    
    @Override
    public List<Pais> findAll() {
        List<Pais> pais = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_pais, nombre FROM pais";
            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        Pais country = new Pais (
                            resultSet.getInt("id_pais"),
                            resultSet.getString("nombre")
                        );pais.add(country);
                    }
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pais;
    }

    @Override
    public void save(Pais pais) {
       try (Connection connection = DriverManager.getConnection(url,user,password)){
            String query = "INSERT INTO pais (nombre) VALUES (?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getNombre());
                statement.executeUpdate();
            }
       }catch(SQLException e){
       e.printStackTrace();
       }
    }

    @Override
    public void update(Pais pais) {
        try(Connection connection = DriverManager.getConnection(url, user,password)){
            String query = "UPDATE pais SET nombre_pais = ? WHERE id_pais = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, pais.getNombre());
                statement.setInt(2, pais.getId_Pais());
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

}

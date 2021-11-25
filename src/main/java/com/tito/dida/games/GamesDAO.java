
package com.tito.dida.games;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GamesDAO {
    public static final String URL_CONEXION = "jdbc:h2:./GAMESBBDD";
    public static final String USUARIO_BDD = "root";
    public static final String PASSWRD_BDD= "";
    
    public GamesDAO(){
        crearTablaSiNoExiste();
      
        
    }

    private void crearTablaSiNoExiste() {
        try(Connection conexionDataBase = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD,PASSWRD_BDD)){
        Statement statement = conexionDataBase.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS games"+
                "(id INTEGER auto_increment,"+
                "nombre VARCHAR(255),"+
                "desarrollador VARCHAR(255),"+
                "descripcion VARCHAR(255),"+
                "valoracion VARCHAR(255),"+
                "plataforma VARCHAR(255),"+
                "pegi VARCHAR(255))";
        statement.executeUpdate(sql);
      }catch (Exception e){
          e.printStackTrace();
      }
    } 
    
    public void guardarOActualizar(Game game){
        System.out.println("ID ================================>" + game.getId());
        if(game.getId()==0){
            guardar(game);
        }else{
            editar(game);
        }
    }
    
    public void guardar(Game game){
        
        try(Connection conexionDataBase = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD,PASSWRD_BDD)){
        Statement statement = conexionDataBase.createStatement();
        String sql = "INSERT INTO games (nombre ,desarrollador, descripcion, valoracion, plataforma, pegi)VALUES('"+ game.getNombre() +"','"+ game.getDesarrollador() +"','"+ game.getDescripcion()+"','"+ game.getValoracion() +"','"+ game.getPlataforma() +"','"+ game.getPegi() +"')";
        statement.executeUpdate(sql);                                                
        }catch(Exception e){
             throw  new RuntimeException("ocurrio un error al guardar la informacion : "+ e.getMessage());
         }
    }
    
    public void editar(Game game){
        try (Connection conexionDataBase = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD, PASSWRD_BDD)){
         Statement statement = conexionDataBase.createStatement();
         String sql = "UPDATE games set nombre= '" + game.getNombre() + "', desarrollador = '" + game.getDesarrollador() + "', descripcion = '" +game.getDescripcion() + "', valoracion = '" + game.getValoracion() + "', plataforma = '" + game.getPlataforma() + "', pegi = '" + game.getPegi() + "'  WHERE id = " + game.getId();
         statement.executeUpdate(sql);                                                                                                                                                                                                                 
       } catch (Exception e){
           throw new RuntimeException("Ocurrió un error al actualizar la información: " + e.getMessage());
       }
    }
     
    public void eliminar(Game game){
        try(Connection conexionDataBase = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD,PASSWRD_BDD)){
        Statement statement = conexionDataBase.createStatement();
        String sql = "DELETE FROM games WHERE id = " + game.getId();
        statement.executeUpdate(sql);
         
        }catch ( Exception e){
            throw  new RuntimeException("ocurrio un error al eliminar la informacion : "+ e.getMessage());
        }
    }
    public List<Game> buscarTodos(){
        List<Game> games =new ArrayList<>();
        
        try(Connection conexionDataBase = DriverManager.getConnection(URL_CONEXION, USUARIO_BDD,PASSWRD_BDD)){
        Statement statement = conexionDataBase.createStatement();
        String sql = "SELECT * FROM games";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            
            Game game = new Game();
            game.setId(resultSet.getInt("id"));
            game.setNombre(resultSet.getString("nombre"));
            game.setDescripcion(resultSet.getString("descripcion"));
            game.setDesarrollador(resultSet.getString("desarrollador"));
            game.setValoracion(resultSet.getString("valoracion"));
            game.setPlataforma(resultSet.getString("plataforma"));
            game.setPegi(resultSet.getString("pegi"));
            
            games.add(game);
            }
        }catch(Exception e){
             throw  new RuntimeException("ocurrio un error al consultar la informacion : "+ e.getMessage());
         }
         return games;
    }
}

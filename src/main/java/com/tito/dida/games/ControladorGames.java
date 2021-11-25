package com.tito.dida.games;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorGames implements Initializable {
    
    @FXML
    TextField nombre;
    
    @FXML
    TextArea desarrollador;
    
    @FXML
    TextArea descripcion;
    
    @FXML
    TextArea valoracion;
    
    @FXML
    ComboBox <String> plataforma;
    
    @FXML
    ComboBox <String> pegi;
    
    @FXML
    TableView<Game>tablaJuegos;
    
    GamesDAO gamesDAO;
    
    int id = 0;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     gamesDAO= new GamesDAO();
     cargarJuegosAlmacen();
     List<Game>gamesFound = gamesDAO.buscarTodos();
     configurarComboBox();
     

    }
   
    @FXML
    public void guardar(){
       
       Game game = new Game();
       game.setId(id);
       game.setNombre(nombre.getText());
       game.setDesarrollador(desarrollador.getText());
       game.setDescripcion(descripcion.getText());
       game.setValoracion(valoracion.getText());
       game.setPlataforma(plataforma.getValue());
       game.setPegi(pegi.getValue());
       
       gamesDAO.guardarOActualizar(game);
       
       id = 0; 
       nombre.clear();
       desarrollador.clear();
       descripcion.clear();
       valoracion.clear();
       plataforma.setValue(" ");
       pegi.setValue("");
       cargarJuegosAlmacen();
    }
    
    @FXML
     public void editar(){
        
        Game game = tablaJuegos.getSelectionModel().getSelectedItem();
       
        nombre.setText(game.getNombre());
        desarrollador.setText(game.getDesarrollador());
        descripcion.setText(game.getDescripcion());
        valoracion.setText(game.getValoracion());
        plataforma.setValue(game.getPlataforma());
        pegi.setValue(game.getPegi());
        id = game.getId();
       // cargarJuegosAlmacen();
        
    }
     
    @FXML
    public void eliminar(){
        Game game = tablaJuegos.getSelectionModel().getSelectedItem();
        gamesDAO.eliminar(game);
        cargarJuegosAlmacen();
      
    }
    
    private void cargarJuegosAlmacen() {
 
    ObservableList<Game> games = FXCollections.observableArrayList();
    List<Game>gamesFound =gamesDAO.buscarTodos();
    games.addAll(gamesFound);
    tablaJuegos.setItems(games);
  
     }

    private void configurarComboBox() {
        plataforma.getItems().addAll("PS4", "Pc", "Switch", "Xbox");
        pegi.getItems().addAll("+3","+7","+12","+16","+18");
    }
    

}

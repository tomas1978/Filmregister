package com.mycompany.filmregister;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    FilmManager minaFilmer = new FilmManager();
    int aktuellFilm = 0;
    
    @FXML
    private TextField titelTextBox;

    @FXML
    private TextField regissörTextBox;

    @FXML
    private TextField längdTextBox;

    @FXML
    private TextField betygTextBox;
    
    @FXML
    private ListView<Film> filmerListView;
    
    @FXML
    void nyFilmAction(ActionEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/nyFilmScene.fxml"));
        Stage s = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        s.setTitle("Registrera ny film");
        s.setScene(scene);
        s.show();
    }

    @FXML
    void searchAction(ActionEvent event) {
        
    }

    @FXML
    void visaAllaAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/visaFilmerScene.fxml"));
        
        filmerListView.setItems(minaFilmer.getObsFilmLista());
        
        Stage s = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        s.setTitle("Visa filmer");
        s.setScene(scene);
        s.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Init run");
        filmerListView = new ListView<>();
    }    
    
    @FXML
    void läggTillFilmAction(ActionEvent event) {
        Film nyFilm = new Film(titelTextBox.getText(), regissörTextBox.getText(), 
                                Integer.parseInt(längdTextBox.getText()), 
                                Float.parseFloat(betygTextBox.getText()));
        minaFilmer.läggTillFilm(nyFilm);
        System.out.println(minaFilmer);
        //filmerListView.setItems(minaFilmer.getObsFilmLista());
    }
    
    @FXML
    void visaNästaAction(ActionEvent event) {
        System.out.println(minaFilmer.getFilmlista().size());
        if(aktuellFilm<minaFilmer.getFilmlista().size()) {
            titelTextBox.setText(minaFilmer.getFilmlista().
                    get(aktuellFilm).getTitel());
            regissörTextBox.setText(minaFilmer.getFilmlista().
                    get(aktuellFilm).getRegissör());
            längdTextBox.setText(Integer.toString(minaFilmer.getFilmlista().
                    get(aktuellFilm).getLängd()));
            betygTextBox.setText(Float.toString(minaFilmer.getFilmlista().
                    get(aktuellFilm).getImdbBetyg()));
            aktuellFilm++;
        } else {
            aktuellFilm=0;
        }
    }
    
    @FXML
    void updateMovieListAction(ActionEvent event) {
         filmerListView.setItems(minaFilmer.getObsFilmLista());
    }
}

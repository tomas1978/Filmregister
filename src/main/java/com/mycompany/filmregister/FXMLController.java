package com.mycompany.filmregister;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    FilmManager minaFilmer;
    int aktuellFilm = 0;
    
    @FXML
    private TextField idTextBox;
    
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
        System.out.println("Längd: "+minaFilmer.getFilmlista().size());
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
        minaFilmer = new FilmManager();
        filmerListView = new ListView<>();
        minaFilmer.setFilmLista(this.readFromDatabase());
        filmerListView.setItems(minaFilmer.getObsFilmLista());
    }    
    
    @FXML
    void läggTillFilmAction(ActionEvent event) {
        Film nyFilm = new Film( Integer.parseInt(idTextBox.getText()),
                                titelTextBox.getText(), 
                                regissörTextBox.getText(), 
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
            idTextBox.setText(Integer.toString(minaFilmer.getFilmlista().
                    get(aktuellFilm).getFilmID()));
            titelTextBox.setText(minaFilmer.getFilmlista().
                    get(aktuellFilm).getTitel());
            regissörTextBox.setText(minaFilmer.getFilmlista().
                    get(aktuellFilm).getRegissör());
            längdTextBox.setText(Integer.toString(minaFilmer.getFilmlista().
                    get(aktuellFilm).getLängd()));
            betygTextBox.setText(Float.toString(minaFilmer.getFilmlista().
                    get(aktuellFilm).getBetyg()));
            aktuellFilm++;
        } else {
            aktuellFilm=0;
        }
    }
    
    @FXML
    void updateMovieListAction(ActionEvent event) {
         filmerListView.setItems(minaFilmer.getObsFilmLista());
    }
    
    @FXML
    void skapaNyFilmAction(ActionEvent event) {
        idTextBox.setText(Integer.toString(minaFilmer.getStörstaID()+1));
        titelTextBox.setText("");
        regissörTextBox.setText("");
        längdTextBox.setText("");
        betygTextBox.setText("");
    }
    
    List<Film> readFromDatabase() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM filmer";
            ResultSet data = stmt.executeQuery(sql);
            List<Film> filmer=new ArrayList<>();
            
            while(data.next()) {
                int id = Integer.parseInt(data.getString("filmID"));
                System.out.println(id);
                String titel = data.getString("titel");
                System.out.println(titel);
                String regissör = data.getString("regissör");
                System.out.println(regissör);
                int längd = Integer.parseInt(data.getString("längd"));
                System.out.println(längd);
                float betyg = Float.parseFloat(data.getString("längd"));
                System.out.println(betyg);
                filmer.add(new Film(id,titel,regissör,längd,betyg));
            }
            
            return filmer;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}

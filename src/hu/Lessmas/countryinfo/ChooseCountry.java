package hu.Lessmas.countryinfo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChooseCountry extends Application {
    private static ComboBox countryselect;
    private BorderPane bp;
    private static Label lbCapital;
    private static Label lbPopulation;
    private static ImageView selectedImage;
    private static Image kep;
    private static Country egyOrszag;
    private static List<String> orszagnev = new ArrayList<>();
    private static List<Country> orszagok;
    private FileReader beolvas = new FileReader();

    public static void main(String[] args) throws Exception {
        launch(args);

    }

    @Override
    public void start(Stage stage) {



        HBox topPanel = new HBox(countryselect);
        topPanel.setAlignment(Pos.CENTER);
        topPanel.setPadding(new Insets(10));
        HBox centerPanel = new HBox(selectedImage);
        centerPanel.setAlignment(Pos.CENTER);
        //centerPanel.setPadding(new Insets(10));
        HBox bottomPanel = new HBox(40, lbCapital, lbPopulation);
        bottomPanel.setAlignment(Pos.CENTER);
        bottomPanel.setPadding(new Insets(40));

        BorderPane bp = new BorderPane();
        bp.setTop(topPanel);
        bp.setBottom(bottomPanel);
        bp.setCenter(centerPanel);

        Scene scene = new Scene(bp, 800, 600);
        stage.setTitle("Country Info");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        orszagok = beolvas.ReadFile();
        int i = 0;
        Iterator<Country> it = orszagok.iterator();
        while (it.hasNext()) {
            egyOrszag = it.next();
            orszagnev.add(egyOrszag.getCountry());
        }
        countryselect = new ComboBox();
        countryselect.getItems().addAll(orszagnev);
        countryselect.getSelectionModel().select(0);
        selectedImage = new ImageView();
        //selectedImage.setFitHeight(455);
        selectedImage.setFitWidth(500);
        selectedImage.setPreserveRatio(true);
        lbCapital = new Label(orszagok.get(0).getCapital());
        lbPopulation = new Label(String.valueOf(orszagok.get(0).getPopulation()));
        kep = new Image(new FileInputStream("src/usa.jpg"));
        selectedImage.setImage(kep);

        countryselect.setOnAction((e) -> {
            String s = (String) countryselect.getSelectionModel().getSelectedItem();
            Iterator<Country> it2 = orszagok.iterator();
            while (it2.hasNext()) {
                egyOrszag = it2.next();
                if (s==egyOrszag.getCountry()) {
                    lbCapital = new Label(egyOrszag.getCapital());
                    lbPopulation = new Label(String.valueOf(egyOrszag.getPopulation()));
                    String f = "src/" + egyOrszag.getPictue();
                    try {
                        kep = new Image(new FileInputStream(f));
                    } catch (FileNotFoundException ex) {}
                }
                selectedImage.setImage(kep);

            }
        });

    }
}
class Country{
    private String country,capital,pictue;
    private int population;
    public Country(String country,String capital,int population,String picture){
        this.country=country;
        this.capital=capital;
        this.population=population;
        this.pictue=picture;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public String getPictue() {
        return pictue;
    }

    public int getPopulation() {
        return population;
    }
}
class FileReader {
    private String country,capital,pictue;
    private int population;
    public List<Country> ReadFile() throws Exception {
        List<Country> adatok = new ArrayList<>();
        String[] oneCountry;
        BufferedReader br = null;
        br = new BufferedReader(new java.io.FileReader(new File("src/countries.csv")));
        String oneLine;
        oneLine = br.readLine();
        while ((oneLine = br.readLine()) != null) {
            oneCountry = oneLine.split(",");
            country=oneCountry[0];
            capital=oneCountry[1];
            population=Integer.parseInt(oneCountry[2]);
            pictue=oneCountry[3];
            adatok.add(new Country(country,capital,population,pictue));
        }
        br.close();
        return adatok;
    }
}


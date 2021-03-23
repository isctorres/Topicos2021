package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.views.Calculadora;
import sample.views.Encriptador;
import sample.views.Rompecabezas;

public class Main extends Application {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu,mitRompeCabezas,mitEncriptar,mitSalir;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        
        CrearMenu();

        primaryStage.setTitle("Proyecto de Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void CrearMenu() {
        vBox = new VBox();

        mnbPrincipal    = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Compentencia 2");
        menCerrar       = new Menu("Cerrar");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2,menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitRompeCabezas = new MenuItem("Rompecabezas");
        mitRompeCabezas.setOnAction(event -> opcionesMenu(2));
        mitEncriptar = new MenuItem("Encriptador");
        mitEncriptar.setOnAction(event -> opcionesMenu(3));
        menCompetencia1.getItems().addAll(mitCalcu,mitRompeCabezas,mitEncriptar);

        mitSalir  = new MenuItem("Salir");
        mitSalir.setOnAction(event -> { System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox, 300, 70);
    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas(); break;
            case 3: new Encriptador();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.models.Conexion;
import sample.views.Calculadora;
import sample.views.Encriptador;
import sample.views.FrmCanciones;
import sample.views.Rompecabezas;

public class Main extends Application implements EventHandler<WindowEvent> {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu,mitRompeCabezas,mitEncriptar,mitBDCanciones,mitSalir;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        
        CrearMenu();

        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,this);
        primaryStage.setTitle("Proyecto de Clase TAP 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();

        // Abrimos la conexion de manera GLOBAL
        Conexion.getConexion();
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
        mitBDCanciones = new MenuItem("BD Canciones");
        mitBDCanciones.setOnAction(event -> opcionesMenu(4));
        menCompetencia1.getItems().addAll(mitCalcu,mitRompeCabezas,mitEncriptar, mitBDCanciones);

        mitSalir  = new MenuItem("Salir");
        mitSalir.setOnAction(event -> { System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);

        escena = new Scene(vBox, 300, 70);
        escena.getStylesheets().add(getClass().getResource("css/estilos.css").toExternalForm());
    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas(); break;
            case 3: new Encriptador(); break;
            case 4: new FrmCanciones();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(WindowEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensaje del sistema");
        alerta.setHeaderText("Gracias por usar la aplicación :)");
        alerta.setContentText("Vuelva pronto!!!");
        alerta.showAndWait();
    }
}

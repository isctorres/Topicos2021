package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Encriptador extends Stage {

    private Scene escena;
    private HBox hBox;
    private VBox vBox;
    private ToolBar tolMenu;
    private TextArea txtEntrada;
    private TextArea txtSalida;
    private Button btnEncriptar;

    public Encriptador(){

        CrearUI();

        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        hBox = new HBox();
        txtEntrada = new TextArea();
        txtSalida = new TextArea();
        hBox.getChildren().addAll(txtEntrada,txtSalida);
        btnEncriptar = new Button("Encriptar Entrada");
        vBox.getChildren().addAll(tolMenu,hBox,btnEncriptar);

        escena = new Scene(vBox,300,450);
    }
}

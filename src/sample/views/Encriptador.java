package sample.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Encriptador extends Stage implements EventHandler<KeyEvent> {

    private Scene escena;
    private HBox hBox;
    private VBox vBox;
    private ToolBar tolMenu;
    private TextArea txtEntrada;
    private TextArea txtSalida;
    private Button btnEncriptar;
    private Button btnTolAbrir;
    private FileChooser fileChooser;

    public Encriptador(){

        CrearUI();

        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        btnTolAbrir = new Button();
        ImageView imv = new ImageView("sample/assets/icon_open.png");
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);
        btnTolAbrir.setGraphic(imv);
        btnTolAbrir.setOnAction(event -> abrirArchivo());
        tolMenu.getItems().add(btnTolAbrir);

        hBox = new HBox();
        txtEntrada = new TextArea();
        txtEntrada.setOnKeyPressed(this);

        txtSalida = new TextArea();
        txtSalida.setEditable(false);

        hBox.getChildren().addAll(txtEntrada,txtSalida);
        btnEncriptar = new Button("Encriptar Entrada");
        btnEncriptar.setOnAction(event -> encriptarEntrada());
        vBox.getChildren().addAll(tolMenu,hBox,btnEncriptar);

        escena = new Scene(vBox,600,300);
    }

    private void encriptarEntrada() {
    }

    private void abrirArchivo() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo a encriptar :)");
        fileChooser.showOpenDialog(this);
    }

    @Override
    public void handle(KeyEvent event) {

        //txtSalida.appendText(event.getCode().ordinal()+"");

        switch(event.getCode().toString()){
            case "A":
                txtSalida.appendText("b"); break;
            case "B":
                txtSalida.appendText("c");
                break;

        }
    }
}

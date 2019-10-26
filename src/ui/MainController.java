package ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML
    private ImageView foundCompImg;

    @FXML
    private TextField idOrder;

    @FXML
    private TextField CIFOrder;

    @FXML
    private TextField MODOrder;

    @FXML
    private TextField MDOrder;

    @FXML
    private TextField CIFAplicadoOrder;

    @FXML
    private ComboBox<String> isBilled;

    @FXML
    private ComboBox<String> periodoOrder;

    @FXML
    private Button createOrder;

    @FXML
    private TextField nameCompany;

    @FXML
    private TextField cifPresupuestado;

    @FXML
    private TextArea descripcion;

    @FXML
    private ComboBox<String> typeBase;

    @FXML
    private TextField valueBase;

    @FXML
    private HBox tableBilled;

    @FXML
    private HBox tableNOBilled;

    @FXML
    private TextField idBilled;

    @FXML
    void createCompany(ActionEvent event) {

    }

    @FXML
    void searchOrder(ActionEvent event) {

    }
    public void initialize() {
    	isBilled.getItems().addAll("SI","NO");
    	typeBase.getItems().addAll("MONEY","HOURS");
    	periodoOrder.getItems().addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
	}
}

package ui;


import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Company;
import model.Order;

public class MainController {


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
    private DatePicker fechainicio;
    @FXML
    private DatePicker fechaFin;
    
    private TableView<Order> listIsBilled;
    private TableView<Order> listNOBilled;
    
    private ObservableList<Order> data;
    private Company program;

    @FXML
    void createCompany(ActionEvent event) {
    	try {
    	program = new Company(nameCompany.getText(), descripcion.getText(), typeBase.getValue(),Double.parseDouble(valueBase.getText()),Double.parseDouble(cifPresupuestado.getText()));
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("La compañia"+nameCompany.getText()+", ha sido creada correctamente");
		a.show();
		nameCompany.setEditable(false);
		descripcion.setEditable(false);
		valueBase.setEditable(false);
		cifPresupuestado.setEditable(false);
    	}catch(Exception e) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		a.setContentText("Digite los valores validos");
    		a.show();
    	}
    }
    @FXML
    void clean(ActionEvent event) {
    	nameCompany.setEditable(true); nameCompany.setText("");
		descripcion.setEditable(true); descripcion.setText("");
		valueBase.setEditable(true); valueBase.setText("");
		cifPresupuestado.setEditable(true); cifPresupuestado.setText("");
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Cree la nueva compañia");
		a.show();
    }
    @FXML
    void searchOrder(ActionEvent event) {

    }
    private TableView<Order> createTableBilled(){
    	listIsBilled = new TableView<Order>();
    	data = createDataBilled();
    	listIsBilled.setEditable(true);
    	
    	TableColumn<Order, String> id= new TableColumn<Order, String>("ID");
    	id.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
    	
    	TableColumn<Order, Date> start = new TableColumn<Order, Date>("FECHA INICIO");
    	start.setCellValueFactory(new PropertyValueFactory<Order, Date>("start"));
    	
    	TableColumn<Order, Date> finish = new TableColumn<Order, Date>("FECHA FIN");
    	finish.setCellValueFactory(new PropertyValueFactory<Order, Date>("finish"));
    	
    	TableColumn<Order, String> MD= new TableColumn<Order, String>("MD");
    	MD.setCellValueFactory(new PropertyValueFactory<Order, String>("MD"));
    	
    	TableColumn<Order, String> MOD= new TableColumn<Order, String>("MOD");
    	MOD.setCellValueFactory(new PropertyValueFactory<Order, String>("MOD"));
    	
    	TableColumn<Order, String> CIF= new TableColumn<Order, String>("CIF");
    	CIF.setCellValueFactory(new PropertyValueFactory<Order, String>("CIF"));
    	
    	TableColumn<Order, String> CIFApplied= new TableColumn<Order, String>("CIF Aplicados");
    	CIFApplied.setCellValueFactory(new PropertyValueFactory<Order, String>("CIFApplied"));
    	
    	listIsBilled.setItems(data);
    	listIsBilled.getColumns().addAll(id, start,finish,MD,MOD,CIF,CIFApplied);
    	listIsBilled.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	return listIsBilled;
    }
    private TableView<Order> createTableNOBilled(){
    	listNOBilled = new TableView<Order>();
    	data = createDataNOBilled();
    	listNOBilled.setEditable(true);
    	
    	TableColumn<Order, String> id= new TableColumn<Order, String>("ID");
    	id.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
    	
    	TableColumn<Order, Date> start = new TableColumn<Order, Date>("FECHA INICIO");
    	start.setCellValueFactory(new PropertyValueFactory<Order, Date>("start"));
    	
    	TableColumn<Order, Date> finish = new TableColumn<Order, Date>("FECHA FIN");
    	finish.setCellValueFactory(new PropertyValueFactory<Order, Date>("finish"));
    	
    	TableColumn<Order, String> MD= new TableColumn<Order, String>("MD");
    	MD.setCellValueFactory(new PropertyValueFactory<Order, String>("MD"));
    	
    	TableColumn<Order, String> MOD= new TableColumn<Order, String>("MOD");
    	MOD.setCellValueFactory(new PropertyValueFactory<Order, String>("MOD"));
    	
    	TableColumn<Order, String> CIF= new TableColumn<Order, String>("CIF");
    	CIF.setCellValueFactory(new PropertyValueFactory<Order, String>("CIF"));
    	
    	TableColumn<Order, String> CIFApplied= new TableColumn<Order, String>("CIF Aplicados");
    	CIFApplied.setCellValueFactory(new PropertyValueFactory<Order, String>("CIFApplied"));
    	
    	listNOBilled.setItems(data);
    	listNOBilled.getColumns().addAll(id, start,finish,MD,MOD,CIF,CIFApplied);
    	listNOBilled.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	return listNOBilled;
    }
    
    private ObservableList<Order> createDataBilled(){
    	data = FXCollections.observableArrayList();
    	
    	for (int i = 0; i < program.getRegistry().getPeriods().size(); i++) {
			//data.add(program.getRegistry().getPeriods())[i]);
		}
		
    	return data;
    }
    private ObservableList<Order> createDataNOBilled(){
    	data = FXCollections.observableArrayList();
    	/*
    	for (int i = 0; i < s.getFlights().length; i++) {
			data.add(s.getFlights()[i]);
		}
		*/
    	return data;
    }
   
    public void initialize() {
    	isBilled.getItems().addAll("SI","NO");
    	typeBase.getItems().addAll("MONEY","HOURS");
    }
}

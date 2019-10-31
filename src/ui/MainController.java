package ui;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Company;
import model.Order;

public class MainController {
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
	    private DatePicker fechainicio;

	    @FXML
	    private ComboBox<String> isFinished;

	    @FXML
	    private DatePicker fechaFin;

	    @FXML
	    private ScrollPane tableFinished;

	    @FXML
	    private TextField idFinished;

	    @FXML
	    private ScrollPane tableNOFinished;

	    @FXML
	    private TextField idNOFinished;

	    @FXML
	    private ScrollPane tableBilled;
	    
	    private FinishedController finishedController;

	    @FXML
	    void aboutProgram(ActionEvent event) {

	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
	    }

	    @FXML
	    void save(ActionEvent event) {
	    	/*
	    	try {
				program.save(getPath());
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("The game was saved successfully");
				alert.show();
			} catch (FileNotFoundException e) {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("File not found");
				alert.show();
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}*/
	    }

	    @FXML
	    void searchOrderFinished(ActionEvent event) {

	    }
	    
	    @FXML
	    void searchOrder(ActionEvent event) {
	    	try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("invoiceOrdersGUI.fxml"));
	    		Parent root = loader.load();
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(root));
	    		stage.show();
	    		finishedController = loader.getController();
	    		finishedController.setMainController(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    public void finishOrder() {
	    	System.out.println(finishedController.getCIFAPBill());
	    	
	    }
	    
/////////////////////////////////////////////
	private TableView<Order> listNOFinished;
    private TableView<Order> listIsFinished;
    private TableView<Order> listBilled;
    
    private ObservableList<Order> data;
    private Company program;

    @FXML
    void createCompany(ActionEvent event) {
    	try {
    	program = new Company(nameCompany.getText(), descripcion.getText(), typeBase.getValue(),Double.parseDouble(valueBase.getText()),Double.parseDouble(cifPresupuestado.getText()));
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("La compañia: "+nameCompany.getText()+", ha sido creada correctamente");
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
    void createOrder(ActionEvent event) {
    	
    	LocalDate periodInit= fechainicio.getValue();
    	Month pS = periodInit.getMonth();
    	int monthS= pS.getValue();
    	int dayS= periodInit.getDayOfMonth();
    	int yearS = periodInit.getYear();
    	
    	boolean finished= isFinished.getValue().equals("SI")?true: false;
    	
    	LocalDate periodFinal= fechaFin.getValue();
    	Month pF = periodFinal.getMonth();
    	int monthF= pF.getValue();
    	int dayF= periodFinal.getDayOfMonth();
    	int yearF = periodFinal.getYear();
    	System.out.println(idOrder.getText()+" a "+ Double.parseDouble(MDOrder.getText())+" b: "+ Double.parseDouble(MODOrder.getText())+" c: "+ Double.parseDouble(CIFOrder.getText())+" d: "+ dayS+" e: "+ monthS+" f: "+ yearS);
    	program.getRegistry().addOrderNB(idOrder.getText(), Double.parseDouble(MDOrder.getText()), Double.parseDouble(MODOrder.getText()),Double.parseDouble(CIFOrder.getText()),dayS, monthS,yearS);
    	//program.getRegistry().addNewOrder(idOrder.getText(), Double.parseDouble(MDOrder.getText()), Double.parseDouble(MODOrder.getText()),Double.parseDouble(CIFOrder.getText()),dayS, monthS,yearS,finished, dayF, monthF,yearF);
    	listNOFinished = createTableNOFinished();
    	listIsFinished = createTableFinished();
    	listBilled = createTableBilled();
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("La orden"+idOrder.getText()+", ha sido añadida correctamente");
		a.show();
    	
    }

    private TableView<Order> createTableFinished(){
    	listIsFinished = new TableView<Order>();
    	data = createDataFinished();
    	listIsFinished.setEditable(true);
    	
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
    	
    	listIsFinished.setItems(data);
    	listIsFinished.getColumns().addAll(id, start,finish,MD,MOD,CIF,CIFApplied);
    	listIsFinished.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	return listIsFinished;
    }
    private TableView<Order> createTableNOFinished(){
    	listNOFinished = new TableView<Order>();
    	data = createDataNOFinished();
    	listNOFinished.setEditable(true);
    	
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
    	
    	listNOFinished.setItems(data);
    	listNOFinished.getColumns().addAll(id, start,finish,MD,MOD,CIF,CIFApplied);
    	listNOFinished.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	return listNOFinished;
    }
    private TableView<Order> createTableBilled(){
    	listBilled = new TableView<Order>();
    	data = createDataBilled();
    	listBilled.setEditable(true);
    	
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
    	
    	listBilled.setItems(data);
    	listBilled.getColumns().addAll(id, start,finish,MD,MOD,CIF,CIFApplied);
    	listBilled.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	return listIsFinished;
    }
    private ObservableList<Order> createDataFinished(){
    	data = FXCollections.observableArrayList();
    	
    	for (int i = 0; i < program.getRegistry().getPeriods().size(); i++) {
			data.addAll(program.getRegistry().getPeriods().get(i).getOrders());
		}
		
    	return data;
    }
    private ObservableList<Order> createDataNOFinished(){
    	data = FXCollections.observableArrayList();
    	data.addAll(program.getRegistry().getOrdersNotBilled());
    	
    	return data;
    }
    private ObservableList<Order> createDataBilled(){
    	data = FXCollections.observableArrayList();
    	
    	for (int i = 0; i < program.getRegistry().getPeriods().size(); i++) {
    		for (int j = 0; j < program.getRegistry().getPeriods().get(i).getOrders().size(); j++) {
    			if(program.getRegistry().getPeriods().get(i).getOrders().get(i).isBilled()) {
        			data.addAll(program.getRegistry().getPeriods().get(i).getOrders().get(i));
        		}
			}
		}
    	
    	return data;
    }
    public void initialize() {
    	isFinished.getItems().addAll("SI","NO");
    	typeBase.getItems().addAll("MONEY","HOURS");
    }
}

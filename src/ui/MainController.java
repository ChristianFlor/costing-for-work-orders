package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
import javafx.scene.control.Label;
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

	private String idSearch;
	private ObservableList<Order> data;
	private Company program;
	@FXML
	private Label tasaCIF;

	@FXML
	void aboutProgram(ActionEvent event) {

	}

	@FXML
	void exit(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	private void save() throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream(Company.DATA_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(program);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void save(ActionEvent event) {

		try {
			save();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("La compañia se ha guardado correctamente");
			alert.show();
		} catch (FileNotFoundException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("File not found");
			alert.show();
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@FXML
	void searchOrderFinished(ActionEvent event) {
		idSearch = idFinished.getText();

		program.getRegistry().billedOrder(idSearch);

		listNOFinished = createTableNOFinished();
		listIsFinished = createTableFinished();
		listBilled = createTableBilled();

		tableNOFinished.setContent(listNOFinished);
		tableFinished.setContent(listIsFinished);
		tableBilled.setContent(listBilled);

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
		idSearch = idNOFinished.getText();
	}

	public void finishOrder() {
		LocalDate periodFinal = finishedController.getFechaFinBill().getValue();
		Month pF = periodFinal.getMonth();

		int monthF = pF.getValue();
		int dayF = periodFinal.getDayOfMonth();
		int yearF = periodFinal.getYear();
		program.getRegistry().finishedOrder(idSearch, finishedController.getMDBill(), finishedController.getMODBill(),
				finishedController.getCIFBill(), dayF, monthF, yearF);
		listNOFinished = createTableNOFinished();
		listIsFinished = createTableFinished();
		listBilled = createTableBilled();

		tableNOFinished.setContent(listNOFinished);
		tableFinished.setContent(listIsFinished);
		tableBilled.setContent(listBilled);
	}

/////////////////////////////////////////////
	private TableView<Order> listNOFinished;
	private TableView<Order> listIsFinished;
	private TableView<Order> listBilled;

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
		if(typeBase.getValue().equals("MONEY")) {
			tasaCIF.setText(program.getCIF()+"$");
		}else {
			tasaCIF.setText(program.getCIF()+"");
		}
		
    	}catch(Exception e) {
    		Alert a = new Alert(AlertType.ERROR);
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
		a.setContentText("Cree la nueva compaï¿½ia");
		a.show();
	}

	@FXML
	void createOrder(ActionEvent event) {
		try {
			LocalDate periodInit = fechainicio.getValue();
			Month pS = periodInit.getMonth();
			int monthS = pS.getValue();
			int dayS = periodInit.getDayOfMonth();
			int yearS = periodInit.getYear();

			boolean finished = isFinished.getValue().equals("SI") ? true : false;

			LocalDate periodFinal = fechaFin.getValue();
			Month pF = periodFinal.getMonth();
			String period = pF.name();
			int monthF = pF.getValue();
			int dayF = periodFinal.getDayOfMonth();
			int yearF = periodFinal.getYear();

			Order orderF = new Order(idOrder.getText(), Double.parseDouble(MDOrder.getText()),
					Double.parseDouble(MODOrder.getText()), Double.parseDouble(CIFOrder.getText()), dayS, monthS, yearS,
					dayF, monthF, yearF);
			Order orderNF = new Order(idOrder.getText(), Double.parseDouble(MDOrder.getText()),
					Double.parseDouble(MODOrder.getText()), Double.parseDouble(CIFOrder.getText()), dayS, monthS,
					yearS);
			if (finished) {
				program.getRegistry().addOrderF(orderF);
			} else {
				program.getRegistry().addOrderNF(orderNF);
			}

			listNOFinished = createTableNOFinished();
			listIsFinished = createTableFinished();
			listBilled = createTableBilled();

			tableNOFinished.setContent(listNOFinished);
			tableFinished.setContent(listIsFinished);
			tableBilled.setContent(listBilled);

			Alert a = new Alert(AlertType.INFORMATION);
			a.setContentText("La orden: " + idOrder.getText() + ", ha sido aï¿½adida correctamente");
			a.show();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("Cree la compaï¿½ia");
			a.show();
		}

	}

	private TableView<Order> createTableNOFinished() {
		listNOFinished = new TableView<Order>();
		data = createDataNOFinished();
		listNOFinished.setEditable(true);

		double tasa = program.getBudgtedCif() / program.getBase();

		program.getRegistry().calculateCIFAplicatedOrdersNotFinished(tasa);

		TableColumn<Order, String> id = new TableColumn<Order, String>("ID");
		id.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));

		TableColumn<Order, Date> start = new TableColumn<Order, Date>("INICIO");
		start.setCellValueFactory(new PropertyValueFactory<Order, Date>("start"));

		TableColumn<Order, Date> finish = new TableColumn<Order, Date>("FIN");
		finish.setCellValueFactory(new PropertyValueFactory<Order, Date>("finish"));

		TableColumn<Order, String> MD = new TableColumn<Order, String>("MD");
		MD.setCellValueFactory(new PropertyValueFactory<Order, String>("MD"));

		TableColumn<Order, String> MOD = new TableColumn<Order, String>("MOD");
		MOD.setCellValueFactory(new PropertyValueFactory<Order, String>("MOD"));

		TableColumn<Order, String> CIF = new TableColumn<Order, String>("CIF");
		CIF.setCellValueFactory(new PropertyValueFactory<Order, String>("CIF"));

		TableColumn<Order, String> CIFApplied = new TableColumn<Order, String>("CIF Apli");
		CIFApplied.setCellValueFactory(new PropertyValueFactory<Order, String>("CIFApplied"));

		listNOFinished.setItems(data);
		listNOFinished.getColumns().addAll(id, start, finish, MD, MOD, CIF, CIFApplied);
		
		listNOFinished.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		return listNOFinished;
	}

	private TableView<Order> createTableFinished() {
		listIsFinished = new TableView<Order>();
		data = createDataFinished();
		listIsFinished.setEditable(true);

		double tasa = program.getBudgtedCif() / program.getBase();

		program.getRegistry().calculateCIFAplicatedOrdersFinished(tasa);

		TableColumn<Order, String> id = new TableColumn<Order, String>("ID");
		id.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));

		TableColumn<Order, Date> start = new TableColumn<Order, Date>("INICIO");
		start.setCellValueFactory(new PropertyValueFactory<Order, Date>("start"));

		TableColumn<Order, Date> finish = new TableColumn<Order, Date>("FIN");
		finish.setCellValueFactory(new PropertyValueFactory<Order, Date>("finish"));

		TableColumn<Order, String> MD = new TableColumn<Order, String>("MD");
		MD.setCellValueFactory(new PropertyValueFactory<Order, String>("MD"));

		TableColumn<Order, String> MOD = new TableColumn<Order, String>("MOD");
		MOD.setCellValueFactory(new PropertyValueFactory<Order, String>("MOD"));

		TableColumn<Order, String> CIF = new TableColumn<Order, String>("CIF");
		CIF.setCellValueFactory(new PropertyValueFactory<Order, String>("CIF"));

		TableColumn<Order, String> CIFApplied = new TableColumn<Order, String>("CIF Apli");
		CIFApplied.setCellValueFactory(new PropertyValueFactory<Order, String>("CIFApplied"));

		listIsFinished.setItems(data);
		listIsFinished.getColumns().addAll(id, start, finish, MD, MOD, CIF, CIFApplied);
		
		listIsFinished.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		return listIsFinished;
	}

	private TableView<Order> createTableBilled() {
		listBilled = new TableView<Order>();
		data = createDataBilled();
		listBilled.setEditable(true);

		double tasa = program.getBudgtedCif() / program.getBase();

		program.getRegistry().calculateCIFAplicatedOrdersBiled(tasa);

		TableColumn<Order, String> id = new TableColumn<Order, String>("ID");
		id.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));

		TableColumn<Order, Date> start = new TableColumn<Order, Date>("INICIO");
		start.setCellValueFactory(new PropertyValueFactory<Order, Date>("start"));

		TableColumn<Order, Date> finish = new TableColumn<Order, Date>("FIN");
		finish.setCellValueFactory(new PropertyValueFactory<Order, Date>("finish"));

		TableColumn<Order, String> MD = new TableColumn<Order, String>("MD");
		MD.setCellValueFactory(new PropertyValueFactory<Order, String>("MD"));

		TableColumn<Order, String> MOD = new TableColumn<Order, String>("MOD");
		MOD.setCellValueFactory(new PropertyValueFactory<Order, String>("MOD"));

		TableColumn<Order, String> CIF = new TableColumn<Order, String>("CIF");
		CIF.setCellValueFactory(new PropertyValueFactory<Order, String>("CIF"));

		TableColumn<Order, String> CIFApplied = new TableColumn<Order, String>("CIF Apli");
		CIFApplied.setCellValueFactory(new PropertyValueFactory<Order, String>("CIFApplied"));

		listBilled.setItems(data);
		listBilled.getColumns().addAll(id, start, finish, MD, MOD, CIF, CIFApplied);
		listBilled.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		return listBilled;
	}

	private ObservableList<Order> createDataFinished() {
		data = FXCollections.observableArrayList();
		data.addAll(program.getRegistry().getOrdersFinished());

		return data;
	}

	private ObservableList<Order> createDataNOFinished() {
		data = FXCollections.observableArrayList();
		data.addAll(program.getRegistry().getOrdersNotFinished());

		return data;
	}

	private ObservableList<Order> createDataBilled() {
		data = FXCollections.observableArrayList();

		for (int i = 0; i < program.getRegistry().getPeriods().size(); i++) {

			data.addAll(program.getRegistry().getPeriods().get(i).getOrders());

		}

		return data;
	}

	public void initialize() throws FileNotFoundException, IOException {
		isFinished.getItems().addAll("SI", "NO");
		typeBase.getItems().addAll("MONEY", "HOURS");
		fechaFin.setStyle("-fx-text-fill: black");

		File file = new File(Company.DATA_PATH);

		if (file.exists()) {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file));
			try {
				
				program = (Company) entrada.readObject();
				//System.out.println("sii");
				entrada.close();
				createDataFinished();
				createDataNOFinished();
				createDataBilled();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * @author Natalia Isabel Gonzalez Murillo <natalia.gonzalez3@correo.icesi.edu.co>
 * @author Christian David Flor Astudillo <christian.flor1@correo.icesi.edu.co>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class represents
 */
public class FinishedController {
	
	 
	/**
	 * It the relation whit the MainController
	 */
	private MainController mainController;
	
	/**
	 * 
	 */
    @FXML
    private ImageView foundCompImg;
    
    /**
	 * 
	 */
    @FXML
    private TextField MDBill;
    
    /**
	 * 
	 */
    @FXML
    private TextField CIFBill;

    /**
	 * 
	 */
    @FXML
    private TextField MODBill;
    
    /**
	 * 
	 */
    @FXML
    private DatePicker fechaFinBill;
    
    /**
	 * 
	 */
    @FXML
    void bill(ActionEvent event) {
    	mainController.finishOrder();
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("La orden ha sido terminada correctamente");
		a.show();
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
    	
    }
    
    /**
	 * 
	 */
    public void setMainController(MainController main) {
    	mainController = main;
    }
    /**
	 * 
	 */
    public double getMDBill() {
    	return Double.parseDouble(MDBill.getText());
    }
    /**
	 * 
	 */
    public double getCIFBill() {
    	return Double.parseDouble(CIFBill.getText());
    }

    /**
	 * 
	 */
    public double getMODBill() {
    	return Double.parseDouble(MODBill.getText());
    }
    /**
	 * 
	 */
    public DatePicker getFechaFinBill() {
    	return fechaFinBill;
    }
}


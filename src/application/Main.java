package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();
			SampleController controller = loader.getController();
			Scene scene = new Scene(root,550,650);
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (event.getCode().getName() == "Q") {
						Button buttonQ = controller.buttonQ;
						if (!buttonQ.isDisabled()) {
							controller.QButton(null);
						}
					}
					if (event.getCode().getName() == "W") {
						Button buttonW = controller.buttonW;
						if (!buttonW.isDisabled()) {
							controller.WButton(null);
						}
					}
					if (event.getCode().getName() == "E") {
						Button buttonE = controller.buttonE;
						if (!buttonE.isDisabled()) {
							controller.EButton(null);
						}
					}
					if (event.getCode().getName() == "R") {
						Button buttonR = controller.buttonR;
						if (!buttonR.isDisabled()) {
							controller.RButton(null);
						}
					}
					if (event.getCode().getName() == "T") {
						Button buttonT = controller.buttonT;
						if (!buttonT.isDisabled()) {
							controller.TButton(null);
						}
					}
					if (event.getCode().getName() == "Y") {
						Button buttonY = controller.buttonY;
						if (!buttonY.isDisabled()) {
							controller.YButton(null);
						}
					}
					if (event.getCode().getName() == "U") {
						Button buttonU = controller.buttonU;
						if (!buttonU.isDisabled()) {
							controller.UButton(null);
						}
					}
					if (event.getCode().getName() == "I") {
						Button buttonI = controller.buttonI;
						if (!buttonI.isDisabled()) {
							controller.IButton(null);
						}
					}
					if (event.getCode().getName() == "O") {
						Button buttonO = controller.buttonO;
						if (!buttonO.isDisabled()) {
							controller.OButton(null);
						}
					}
					if (event.getCode().getName() == "P") {
						Button buttonP = controller.buttonP;
						if (!buttonP.isDisabled()) {
							controller.PButton(null);
						}
					}
					if (event.getCode().getName() == "A") {
						Button buttonA = controller.buttonA;
						if (!buttonA.isDisabled()) {
							controller.AButton(null);
						}
					}
					if (event.getCode().getName() == "S") {
						Button buttonS = controller.buttonS;
						if (!buttonS.isDisabled()) {
							controller.SButton(null);
						}
					}
					if (event.getCode().getName() == "D") {
						Button buttonD = controller.buttonD;
						if (!buttonD.isDisabled()) {
							controller.DButton(null);
						}
					}
					if (event.getCode().getName() == "F") {
						Button buttonF = controller.buttonF;
						if (!buttonF.isDisabled()) {
							controller.FButton(null);
						}
					}
					if (event.getCode().getName() == "G") {
						Button buttonG = controller.buttonG;
						if (!buttonG.isDisabled()) {
							controller.GButton(null);
						}
					}
					if (event.getCode().getName() == "H") {
						Button buttonH = controller.buttonH;
						if (!buttonH.isDisabled()) {
							controller.HButton(null);
						}
					}
					if (event.getCode().getName() == "J") {
						Button buttonJ = controller.buttonJ;
						if (!buttonJ.isDisabled()) {
							controller.JButton(null);
						}
					}
					if (event.getCode().getName() == "K") {
						Button buttonK = controller.buttonK;
						if (!buttonK.isDisabled()) {
							controller.KButton(null);
						}
					}
					if (event.getCode().getName() == "L") {
						Button buttonL = controller.buttonL;
						if (!buttonL.isDisabled()) {
							controller.LButton(null);
						}
					}
					if (event.getCode().getName() == "Z") {
						Button buttonZ = controller.buttonZ;
						if (!buttonZ.isDisabled()) {
							controller.ZButton(null);
						}
					}
					if (event.getCode().getName() == "X") {
						Button buttonX = controller.buttonX;
						if (!buttonX.isDisabled()) {
							controller.XButton(null);
						}
					}
					if (event.getCode().getName() == "C") {
						Button buttonC = controller.buttonC;
						if (!buttonC.isDisabled()) {
							controller.CButton(null);
						}
					}
					if (event.getCode().getName() == "V") {
						Button buttonV = controller.buttonV;
						if (!buttonV.isDisabled()) {
							controller.VButton(null);
						}
					}
					if (event.getCode().getName() == "B") {
						Button buttonB = controller.buttonB;
						if (!buttonB.isDisabled()) {
							controller.BButton(null);
						}
					}
					if (event.getCode().getName() == "N") {
						Button buttonN = controller.buttonN;
						if (!buttonN.isDisabled()) {
							controller.NButton(null);
						}
					}
					if (event.getCode().getName() == "M") {
						Button buttonM = controller.buttonM;
						if (!buttonM.isDisabled()) {
							controller.MButton(null);
						}
					}
					if (event.getCode() == KeyCode.BACK_SPACE) {
						controller.DeleteButton(null);
					}
				}
			});		
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

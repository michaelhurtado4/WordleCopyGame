package application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.io.*;
import java.util.Enumeration;
import javafx.fxml.FXML;
import java.util.Scanner;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class SampleController extends Sample2Controller {
	public TextField loadField;
	public Integer played = 0;
	public double percent = 0;
	public Integer currStreak = 0;
	public Integer maxStreak = 0;
	public Integer firstGuess = 0;
	public Integer secondGuess = 0;
	public Integer thirdGuess = 0;
	public Integer fourthGuess = 0;
	public Integer fifthGuess = 0;
	public Integer sixthGuess = 0;
	Hashtable<Integer, Label> wordleGrid = new Hashtable<>();
	Hashtable<String, Button> letterGrid = new Hashtable<>();
	Vector<String> words = new Vector<>();
	public Integer numSelected = 0;
	public Integer rowChecker = 0;
	public Scanner infile = null;
	public Scanner loadfile = null;
	public String actualFirst;
	public String actualSecond;
	public String actualThird;
	public String actualFourth;
	public String actualFifth;
	public boolean firstFinal = false;
	public boolean secondFinal = false;
	public boolean thirdFinal = false;
	public boolean fourthFinal = false;
	public boolean fifthFinal = false;
	public Integer score = 0;
	public Random rand = new Random();
	Vector<String> letters = new Vector<>();
	public String word = "";
	@FXML public Button startButton; @FXML public Button saveButton; @FXML  public Label loadLabel;
	@FXML public Label Box0; @FXML public Label Box1; @FXML public Label Box2;
	@FXML public Label Box3; @FXML public Label Box4; @FXML public Label Box5;
	@FXML public Label Box6; @FXML public Label Box7; @FXML public Label Box8;
	@FXML public Label Box9; @FXML public Label Box10; @FXML public Label Box11;
	@FXML public Label Box12; @FXML public Label Box13; @FXML public Label Box14;
	@FXML public Label Box15; @FXML public Label Box16; @FXML public Label Box17;
	@FXML public Label Box18; @FXML public Label Box19; @FXML public Label Box20;
	@FXML public Label Box21; @FXML public Label Box22; @FXML public Label Box23;
	@FXML public Label Box24; @FXML public Label Box25; @FXML public Label Box26;
	@FXML public Label Box27; @FXML public Label Box28; @FXML public Label Box29;
	@FXML public Button buttonQ; @FXML public Button buttonW; @FXML public Button buttonE; 
	@FXML public Button buttonR; @FXML public Button buttonT; @FXML public Button buttonY;
	@FXML public Button buttonU; @FXML public Button buttonI; @FXML public Button buttonO;
	@FXML public Button buttonP; @FXML public Button buttonA; @FXML public Button buttonS;
	@FXML public Button buttonD; @FXML public Button buttonF; @FXML public Button buttonG;
	@FXML public Button buttonH; @FXML public Button buttonJ; @FXML public Button buttonK;
	@FXML public Button buttonL; @FXML public Button buttonZ; @FXML public Button buttonX;
	@FXML public Button buttonC; @FXML public Button buttonV; @FXML public Button buttonB;
	@FXML public Button buttonN; @FXML public Button buttonM; @FXML public Button ButtonEnter;
	@FXML public Integer itNum = 0; @FXML public Button buttonDelete; @FXML public Label warningText;
	@FXML public void initalize() {
		ButtonEnter.requestFocus();
		wordleGrid.put(0, Box0); wordleGrid.put(1, Box1); wordleGrid.put(2, Box2);
		wordleGrid.put(3, Box3); wordleGrid.put(4, Box4); wordleGrid.put(5, Box5);
		wordleGrid.put(6, Box6); wordleGrid.put(7, Box7); wordleGrid.put(8, Box8);
		wordleGrid.put(9, Box9); wordleGrid.put(10, Box10); wordleGrid.put(11, Box11);
		wordleGrid.put(12, Box12); wordleGrid.put(13, Box13); wordleGrid.put(14, Box14);
		wordleGrid.put(15, Box15); wordleGrid.put(16, Box16); wordleGrid.put(17, Box17);
		wordleGrid.put(18, Box18); wordleGrid.put(19, Box19); wordleGrid.put(20, Box20);
		wordleGrid.put(21, Box21); wordleGrid.put(22, Box22); wordleGrid.put(23, Box23);
		wordleGrid.put(24, Box24); wordleGrid.put(25, Box25); wordleGrid.put(26, Box26);
		wordleGrid.put(27, Box27); wordleGrid.put(28, Box28); wordleGrid.put(29, Box29);
		letterGrid.put("Q", buttonQ); letterGrid.put("W", buttonW); letterGrid.put("E", buttonE);
		letterGrid.put("R", buttonR); letterGrid.put("T", buttonT); letterGrid.put("Y", buttonY);
		letterGrid.put("U", buttonU); letterGrid.put("I", buttonI); letterGrid.put("O", buttonO);
		letterGrid.put("P", buttonP); letterGrid.put("A", buttonA); letterGrid.put("S", buttonS);
		letterGrid.put("D", buttonD); letterGrid.put("F", buttonF); letterGrid.put("G", buttonG);
		letterGrid.put("H", buttonH); letterGrid.put("J", buttonJ); letterGrid.put("K", buttonK);
		letterGrid.put("L", buttonL); letterGrid.put("Z", buttonZ); letterGrid.put("X", buttonX);
		letterGrid.put("C", buttonC); letterGrid.put("V", buttonV); letterGrid.put("B", buttonB);
		letterGrid.put("N", buttonN); letterGrid.put("M", buttonM);
		try
		{
			infile = new Scanner(new FileReader("words.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			warningText.setText("File not found");
			e.printStackTrace();
			System.exit(0); 
		}
		int randomNumber = rand.nextInt(2310);
		for (int i = 0; i < 2310; i++) {
			String inputWord = infile.next();
			inputWord = inputWord.toUpperCase();
			words.add(inputWord);
		}
		word = words.elementAt(randomNumber);
		actualFirst = Character.toString(word.charAt(0));
		actualSecond = Character.toString(word.charAt(1));
		actualThird = Character.toString(word.charAt(2));
		actualFourth = Character.toString(word.charAt(3));
		actualFifth = Character.toString(word.charAt(4));
		letters.add(actualFirst);
		letters.add(actualSecond);
		letters.add(actualThird);
		letters.add(actualFourth);
		letters.add(actualFifth);
		System.out.println(word);
	}
	public void onLose() {
		ButtonEnter.requestFocus();
		Enumeration<String> enu = letterGrid.keys();
		while(enu.hasMoreElements()) {
			String key = enu.nextElement();
			Button currButton = letterGrid.get(key);
			currButton.setDisable(true);
		}	
		buttonDelete.setDisable(true);
		ButtonEnter.setDisable(true);
		warningText.setText("You Lose. Press reset to try again.");
    	played++;
    	currStreak = 0;
		percent = ((double)(firstGuess + secondGuess + thirdGuess + fourthGuess + fifthGuess + sixthGuess) / played) * 100;
		Integer realPercent = (int) percent;
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
		Parent root2 = loader.load();
		Sample2Controller controller = loader.getController();
		controller.setStatsLose(played, realPercent, currStreak, maxStreak, firstGuess, secondGuess, thirdGuess, fourthGuess, fifthGuess, sixthGuess);
		Stage newStage = new Stage();
		newStage.setScene(new Scene(root2));	
		newStage.show();
		}
		catch(Exception e2) {
			
		}
	}
	@FXML
	public void onWin() {
		ButtonEnter.requestFocus();
		Enumeration<String> enu = letterGrid.keys();
		while(enu.hasMoreElements()) {
			String key = enu.nextElement();
			Button currButton = letterGrid.get(key);
			currButton.setDisable(true);
		}	
		buttonDelete.setDisable(true);
		ButtonEnter.setDisable(true);
		warningText.setText("You Win! Press reset to play again.");
    	played++;
		if (rowChecker == 5) {
			firstGuess++;
		}
		else if (rowChecker == 10) {
			secondGuess++;
		}
		else if (rowChecker == 15) {
			thirdGuess++;
		}
		else if (rowChecker == 20) {
			fourthGuess++;
		}
		else if (rowChecker == 25) {
			fifthGuess++;
		}
		else if (rowChecker == 30) {
			sixthGuess++;
		}
		percent = ((double)(firstGuess + secondGuess + thirdGuess + fourthGuess + fifthGuess + sixthGuess) / played) * 100;
		currStreak++;
		if(currStreak > maxStreak) {
			maxStreak++;
		}
		Integer realPercent = (int) percent;
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
		Parent root2 = loader.load();
		Sample2Controller controller = loader.getController();
		controller.setStatsWin(played, realPercent, currStreak, maxStreak, firstGuess, secondGuess, thirdGuess, fourthGuess, fifthGuess, sixthGuess);
		Stage newStage = new Stage();
		newStage.setScene(new Scene(root2));	
		newStage.show();

		}
		catch(Exception e2) {
			
		}
		
	}
	@FXML public void reset(ActionEvent e) {
		ButtonEnter.requestFocus();
		for (int i = 0; i < 30; i++) {
			Label currLabel = wordleGrid.get(i);
			currLabel.setText(" ");
			currLabel.setStyle("-fx-background-color: F4F4F4; -fx-border-color: black");
		}
		itNum = 0;
		numSelected = 0;
		rowChecker = 0;
		int randomNumber = rand.nextInt(2310);
		word = words.elementAt(randomNumber);
		actualFirst = Character.toString(word.charAt(0));
		actualSecond = Character.toString(word.charAt(1));
		actualThird = Character.toString(word.charAt(2));
		actualFourth = Character.toString(word.charAt(3));
		actualFifth = Character.toString(word.charAt(4));
		letters.removeAllElements();
		letters.add(actualFirst);
		letters.add(actualSecond);
		letters.add(actualThird);
		letters.add(actualFourth);
		letters.add(actualFifth);
		System.out.println(word);
		Enumeration<String> enu = letterGrid.keys();
		while(enu.hasMoreElements()) {
			String key = enu.nextElement();
			Button currButton = letterGrid.get(key);
			currButton.setDisable(false);
			currButton.setStyle("");
		}	
		buttonDelete.setDisable(false);
		ButtonEnter.setDisable(false);
		firstFinal = false;
		secondFinal = false;
		thirdFinal = false;
		fourthFinal = false;
		fifthFinal = false;
		warningText.setText("");
	}
	@FXML public void startButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		initalize();
		startButton.setDisable(true);
		warningText.setText("");
	}
	@FXML public void QButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("Q");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void WButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("W");
		itNum++;
		numSelected++;
		warningText.setText("");
	}	
	@FXML public void EButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("E");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void RButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("R");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void TButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("T");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void YButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("Y");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void UButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("U");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void IButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("I");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void OButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("O");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void PButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("P");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void AButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("A");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void SButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("S");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void DButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("D");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void FButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("F");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void GButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("G");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void HButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("H");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void JButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("J");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void KButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("K");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void LButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("L");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void ZButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("Z");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void XButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("X");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void CButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("C");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void VButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("V");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void BButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("B");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void NButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("N");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void MButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected == 5) {
			warningText.setText("Too many letters!");
			return;
		}
		Label currLabel = wordleGrid.get(itNum);
		currLabel.setText("M");
		itNum++;
		numSelected++;
		warningText.setText("");
	}
	@FXML public void EnterButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if (numSelected != 5) {
			warningText.setText("Must be a five letter word.");
			return;
		}
		String first = wordleGrid.get(itNum - 5).getText();
		String second = wordleGrid.get(itNum - 4).getText();
		String third = wordleGrid.get(itNum - 3).getText();
		String fourth = wordleGrid.get(itNum - 2).getText();
		String fifth = wordleGrid.get(itNum - 1).getText();
		String guessWord = first + second + third + fourth + fifth;
		if (words.contains(guessWord) == false) {
			warningText.setText("Not a valid word.");
			return;
		}
		rowChecker = rowChecker + 5;
		numSelected = 0;
		boolean firstCheck = false;
		boolean secondCheck = false;
		boolean thirdCheck = false;
		boolean fourthCheck = false;
		boolean fifthCheck = false;
		Button firstButton = letterGrid.get(first);
		Button secondButton = letterGrid.get(second);
		Button thirdButton = letterGrid.get(third);
		Button fourthButton = letterGrid.get(fourth);
		Button fifthButton = letterGrid.get(fifth);
		if (first.equals(actualFirst)) {
			Label currLabel = wordleGrid.get((itNum-5));
			currLabel.setStyle("-fx-background-color: green; -fx-border-color: black");
			firstCheck = true;
			firstFinal = true;
			firstButton.setStyle("-fx-background-color: green");
		}
		else {
			if (letters.contains(first)) {
				Label currLabel = wordleGrid.get((itNum-5));
				currLabel.setStyle("-fx-background-color: yellow; -fx-border-color: black");
				if (!firstFinal) {
					firstButton.setStyle("-fx-background-color: yellow");
				}
			}
			else {
				Label currLabel = wordleGrid.get((itNum-5));
				currLabel.setStyle("-fx-background-color: gray; -fx-border-color: black");
				firstButton.setStyle("-fx-background-color: gray");
				firstButton.setDisable(true);
			}
		}
		if (second.equals(actualSecond)) {
			Label currLabel = wordleGrid.get((itNum-4));
			currLabel.setStyle("-fx-background-color: green; -fx-border-color: black");
			secondCheck = true;
			secondFinal = true;
			secondButton.setStyle("-fx-background-color: green");
		}
		else {
			if (letters.contains(second)) {
				Label currLabel = wordleGrid.get((itNum-4));
				currLabel.setStyle("-fx-background-color: yellow; -fx-border-color: black");
				if (!secondFinal) {
					secondButton.setStyle("-fx-background-color: yellow");
				}
			}
			else {
				Label currLabel = wordleGrid.get((itNum-4));
				currLabel.setStyle("-fx-background-color: gray; -fx-border-color: black");
				secondButton.setStyle("-fx-background-color: gray");
				secondButton.setDisable(true);
			}
		}	
		if (third.equals(actualThird)) {
			Label currLabel = wordleGrid.get((itNum-3));
			currLabel.setStyle("-fx-background-color: green; -fx-border-color: black");
			thirdCheck = true;
			thirdFinal = true;
			thirdButton.setStyle("-fx-background-color: green");
		}
		else {
			if (letters.contains(third)) {
				Label currLabel = wordleGrid.get((itNum-3));
				currLabel.setStyle("-fx-background-color: yellow; -fx-border-color: black");
				if (!thirdFinal) {
					thirdButton.setStyle("-fx-background-color: yellow");
				}
			}
			else {
				Label currLabel = wordleGrid.get((itNum-3));
				currLabel.setStyle("-fx-background-color: gray; -fx-border-color: black");
				thirdButton.setStyle("-fx-background-color: gray");
				thirdButton.setDisable(true);
			}
		}	
		if (fourth.equals(actualFourth)) {
			Label currLabel = wordleGrid.get((itNum-2));
			currLabel.setStyle("-fx-background-color: green; -fx-border-color: black");
			fourthCheck = true;
			fourthFinal = true;
			fourthButton.setStyle("-fx-background-color: green");
		}
		else {
			if (letters.contains(fourth)) {
				Label currLabel = wordleGrid.get((itNum-2));
				currLabel.setStyle("-fx-background-color: yellow; -fx-border-color: black");
				if (!fourthFinal) {
					fourthButton.setStyle("-fx-background-color: yellow");
				}
			}
			else {
				Label currLabel = wordleGrid.get((itNum-2));
				currLabel.setStyle("-fx-background-color: gray; -fx-border-color: black");
				fourthButton.setStyle("-fx-background-color: gray");
				fourthButton.setDisable(true);
			}
		}	
		if (fifth.equals(actualFifth)) {
			Label currLabel = wordleGrid.get((itNum-1));
			currLabel.setStyle("-fx-background-color: green; -fx-border-color: black");
			fifthCheck = true;
			fifthFinal = true;
			fifthButton.setStyle("-fx-background-color: green");
		}
		else {
			if (letters.contains(fifth)) {
				Label currLabel = wordleGrid.get((itNum-1));
				currLabel.setStyle("-fx-background-color: yellow; -fx-border-color: black");
				if (!fifthFinal) {
					fifthButton.setStyle("-fx-background-color: yellow");
				}
			}
			else {
				Label currLabel = wordleGrid.get((itNum-1));
				currLabel.setStyle("-fx-background-color: gray; -fx-border-color: black");
				fifthButton.setStyle("-fx-background-color: gray");
				fifthButton.setDisable(true);
			}
		}			
		warningText.setText("");
		if (firstCheck && secondCheck && thirdCheck && fourthCheck && fifthCheck) {
			onWin();
		}
		if (rowChecker > 25) {
			onLose();
		}
	}
	@FXML public void DeleteButton(ActionEvent e) {
		ButtonEnter.requestFocus();
		if ((itNum - 1) < rowChecker) {
			warningText.setText("Nothing to delete.");
			return;
		}
		Label currLabel = wordleGrid.get((itNum - 1));
		currLabel.setText(" ");
		itNum--;
		numSelected--;
		warningText.setText("");
	}
	
	@FXML public void LoadField(ActionEvent e) {
		String filename = loadField.getText();
		try
		{
			loadfile = new Scanner(new FileReader(filename));
		} 
		catch (FileNotFoundException e2) 
		{
			System.out.println("File not found");
			warningText.setText("File not found");
			e2.printStackTrace();
			System.exit(0); 
		}
		played = loadfile.nextInt();
		percent = loadfile.nextDouble();
		currStreak = loadfile.nextInt();
		maxStreak = loadfile.nextInt();
		firstGuess = loadfile.nextInt();
		secondGuess = loadfile.nextInt();
		thirdGuess = loadfile.nextInt();
		fourthGuess = loadfile.nextInt();
		fifthGuess = loadfile.nextInt();
		sixthGuess = loadfile.nextInt();
		loadLabel.setText("File loaded: " + filename);
		warningText.setText("");
	}
	@FXML public void buttonSave(ActionEvent e) {
		ButtonEnter.requestFocus();
		String filePath = "save.txt";
		File file = new File(filePath);
		try {
	        if (file.createNewFile()) {
	            warningText.setText("File created: " + file.getName());
	        } else {
	            warningText.setText("File already exists.");
	            
	        }
			FileWriter writer = new FileWriter(file);
			writer.write(played + " " + percent + " " + currStreak + " " + maxStreak
			+ " " + firstGuess + " " + secondGuess + " " + thirdGuess + " " + fourthGuess
			+ " " + fifthGuess + " " + sixthGuess); 
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
}

package application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Sample2Controller {

    @FXML
    private Label currNum;
    @FXML
    private Label fiveGuess;
    @FXML
    private Label fourGuess;
    @FXML
    private Label maxNum;
    @FXML
    private Label oneGuess;
    @FXML
    private Label percentNum;
    @FXML
    private Label playedNum;
    @FXML
    private Label sixGuess;
    @FXML
    private Label threeGuess;
    @FXML
    private Label twoGuess;
    public void setStatsWin(Integer played, Integer realPercent, Integer currStreak, Integer maxStreak, Integer firstGuess, Integer secondGuess, Integer thirdGuess, Integer fourthGuess, Integer fifthGuess, Integer sixthGuess) {
		playedNum.setText(String.valueOf(played));
		percentNum.setText(String.valueOf(realPercent));
		currNum.setText(String.valueOf(currStreak));
		maxNum.setText(String.valueOf(maxStreak));
		oneGuess.setText(Integer.toString(firstGuess));
		twoGuess.setText(String.valueOf(secondGuess));
		threeGuess.setText(String.valueOf(thirdGuess));
		fourGuess.setText(String.valueOf(fourthGuess));
		fiveGuess.setText(String.valueOf(fifthGuess));
		sixGuess.setText(String.valueOf(sixthGuess));
    }
    public void setStatsLose(Integer played, Integer realPercent, Integer currStreak, Integer maxStreak, Integer firstGuess, Integer secondGuess, Integer thirdGuess, Integer fourthGuess, Integer fifthGuess, Integer sixthGuess) {
		playedNum.setText(String.valueOf(played));
		percentNum.setText(String.valueOf(realPercent));
		currNum.setText(String.valueOf(currStreak));
		maxNum.setText(String.valueOf(maxStreak));
		oneGuess.setText(Integer.toString(firstGuess));
		twoGuess.setText(String.valueOf(secondGuess));
		threeGuess.setText(String.valueOf(thirdGuess));
		fourGuess.setText(String.valueOf(fourthGuess));
		fiveGuess.setText(String.valueOf(fifthGuess));
		sixGuess.setText(String.valueOf(sixthGuess));
    }

}


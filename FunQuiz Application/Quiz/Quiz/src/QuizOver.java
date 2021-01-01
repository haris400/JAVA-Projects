import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuizOver extends Home {
	Stage stage =new Stage();
	QuizOver(){
		ScoreFile data=new ScoreFile();
		String record = name+"|"+score+"|"+Lives+"\n";
		
		data.addScore(record);
		stage.setTitle("QUIZ OVER");
		stage.setWidth(600);
		stage.setHeight(400);
		stage.setResizable(false);
		Group  root =new Group();
		addComponents(root);
		Scene scene =new Scene(root);
		Image img = new Image("file:images/dddd.jpg");
		ImagePattern pattern = new ImagePattern(img);
		scene.setFill(pattern);
		stage.setScene(scene);
		stage.show();
	}
	void addComponents(Group root) {
		// TODO Auto-generated method stub
		final Label lbl =new Label("Your Score:" +score);
		lbl.setTranslateX(180);
		lbl.setTranslateY(160);
		lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
		
		final Text text1 = new Text(); 
		text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
		text1.setText("Player:" +name); 
		//text1.setFill(Color.WHITE);
		text1.setX(180); 
	    text1.setY(150);
	    
	    
		final Text text = new Text(); 
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 40));
		text.setText("Quiz Over You Lose All Lives"); 
		//text.setFill(Color.WHITE);
		text.setX(40); 
	    text.setY(70);
	    
		 DropShadow shadow = new DropShadow();
		    Button btn1 = new Button("Restart");
			btn1.setFont(new Font("Book Antiqua", 20));
			btn1.setTranslateX(150);
			btn1.setTranslateY(240);
			btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btn1.setEffect(shadow);
				});
			btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btn1.setEffect(null);
				});
		

			
			Button btn2 = new Button("Scores");
			btn2.setFont(new Font("Book Antiqua", 20));
			btn2.setTranslateX(340);
			btn2.setTranslateY(240);
			btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
				btn2.setEffect(shadow);
				});
			btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
				btn2.setEffect(null);
				});
			
			
			btn1.setOnAction((ActionEvent e) -> {
				  
				 Lives = 3;
				 score = 0;
				  ((Stage)lbl.getScene().getWindow()).close();
				  Q1 win1=new Q1();
				
			});
			
			btn2.setOnAction((ActionEvent e) -> {
				 
				  ((Stage)lbl.getScene().getWindow()).close();
				  @SuppressWarnings("unused")
				  AllScores win1=new AllScores();
				
			});
		
			ObservableList child= root.getChildren();
			child.add(lbl);
			child.add(text);
			child.add(text1);
			child.add(btn1);
			child.add(btn2);
		
	}
}

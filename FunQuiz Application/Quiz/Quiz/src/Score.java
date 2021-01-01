import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Score extends Home{
static String record;
	
	
	Stage stage =new Stage();
	Score(){
		ScoreFile data=new ScoreFile();
		record=name+"|"+score+"|"+Lives+"\n";
		
		data.addScore(record);
		
		
		stage.setTitle("Your Score");
		stage.setWidth(450);
		stage.setHeight(300);
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
		final Label lbl =new Label("Your Score:");
		lbl.setTranslateX(90);
		lbl.setTranslateY(100);
		lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
		//lbl.setTextFill(Color.web("#FFFFFF"));
		final Text text = new Text(); 
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
		text.setText(""+score); 
		//text.setFill(Color.WHITE);
		text.setX(348); 
	    text.setY(149);
	    
	    DropShadow shadow = new DropShadow();
	    Button btn1 = new Button("Restart");
		btn1.setFont(new Font("Book Antiqua", 15));
		btn1.setTranslateX(130);
		btn1.setTranslateY(180);
		btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn1.setEffect(shadow);
			});
		btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn1.setEffect(null);
			});
	

		
		Button btn2 = new Button("Scores");
		btn2.setFont(new Font("Book Antiqua", 15));
		btn2.setTranslateX(240);
		btn2.setTranslateY(180);
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
			  AllScores win1=new AllScores();
			
		});
		
		

		
		
		ObservableList child= root.getChildren();
		child.add(lbl);
		child.add(text);
		child.add(btn1);
		child.add(btn2);
	}

}

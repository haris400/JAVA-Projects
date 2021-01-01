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

public class Q6 extends Home{
	Stage stage =new Stage();
	Q6(){
		stage.setTitle("Question No : 6");
		stage.setWidth(1100);
		stage.setHeight(700);
		stage.setResizable(false);
		Group  root =new Group();
		addComponents(root);
		Scene scene =new Scene(root);
		Image img = new Image("file:images/Alien.jpg");
		ImagePattern pattern = new ImagePattern(img);
		scene.setFill(pattern);
		stage.setScene(scene);
		stage.show();
	}
	void addComponents(Group root) {
	
		final Label lbl = new Label("QUESTION NO: 6");
	lbl.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 50));
	lbl.setUnderline(true);
	lbl.setTranslateX(330);
	lbl.setTranslateY(60);
	
	final Text text = new Text(); 
	text.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
	text.setText("What does come down but never goes up?"); 
	text.setX(300); 
    text.setY(200);   
   
    final Label lbl1 = new Label("Score  : "+ score);
	lbl1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
	lbl1.setTranslateX(900);
	lbl1.setTranslateY(60);

	final Label lbl2 = new Label("Player : "+ name);
	lbl2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
	lbl2.setTranslateX(900);
	lbl2.setTranslateY(80);
	
	final Label lbl3 = new Label("Lives   : "+ Lives);
	lbl3.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
	lbl3.setTranslateX(900);
	lbl3.setTranslateY(100);
	
	DropShadow shadow = new DropShadow();
	Button btn1 = new Button("Your Future");
	btn1.setFont(new Font("Book Antiqua", 25));
	btn1.setTranslateX(220);
	btn1.setTranslateY(280);
	btn1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		btn1.setEffect(shadow);
		});
	btn1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		btn1.setEffect(null);
		});
	
	Button btn2 = new Button("Rain");
	btn2.setFont(new Font("Book Antiqua", 25));
	btn2.setTranslateX(220);
	btn2.setTranslateY(380);
	btn2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		btn2.setEffect(shadow);
		});
	btn2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		btn2.setEffect(null);
		});
	
	Button btn3 = new Button("Age");
	btn3.setFont(new Font("Book Antiqua", 25));
	btn3.setTranslateX(700);
	btn3.setTranslateY(280);
	btn3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		btn3.setEffect(shadow);
		});
	btn3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		btn3.setEffect(null);
		});
	
	Button btn4 = new Button("Your GPA");
	btn4.setFont(new Font("Book Antiqua", 25));
	btn4.setTranslateX(700);
	btn4.setTranslateY(380);
	btn4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		btn4.setEffect(shadow);
		});
	btn4.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		btn4.setEffect(null);
		});

	btn1.setOnAction((ActionEvent e) -> {
		  
		 
		  ((Stage)lbl.getScene().getWindow()).close();
		  
		  
		  
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Your Answer is Wrong,\n Click Ok for next Question.Correct Answer Was: Rain");
		  alert.showAndWait();
		  if(Lives == 1)
		  {
			  QuizOver win2 =new QuizOver();
		  }
		  else
		  { 
			  Lives--;
			  Q7 win1=new Q7();
			  } 
		
	});
	
	btn2.setOnAction((ActionEvent e) -> {
		  
		 
		  ((Stage)lbl.getScene().getWindow()).close();
			
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Your Answer is Correct,\n Click Ok for next Question.");
		  score = score +1;
		  alert.showAndWait();
		  Q7 win1=new Q7();
		
	});

	
	btn3.setOnAction((ActionEvent e) -> {
		  
		 
		  ((Stage)lbl.getScene().getWindow()).close();
			
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Your Answer is Wrong,\n Click Ok for next Question.Correct Answer Was: Rain");

		  alert.showAndWait();
		  if(Lives == 1)
		  {
			  QuizOver win2 =new QuizOver();
		  }
		  else
		  { 
			  Lives--;
			  Q7 win1=new Q7();
			  } 
		
	});
	
	btn4.setOnAction((ActionEvent e) -> {
		  
		 
		  ((Stage)lbl.getScene().getWindow()).close();
			
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Information Dialog");
		  alert.setHeaderText(null);
		  alert.setContentText("Your Answer is Wrong,\n Click Ok for next Question.Correct Answer Was: Rain");

		  alert.showAndWait();
		  if(Lives == 1)
		  {
			  QuizOver win2 =new QuizOver();
		  }
		  else
		  { 
			  Lives--;
			  Q7 win1=new Q7();
			  } 
	});
	
	ObservableList child= root.getChildren();
	child.add(text);
	child.add(lbl);
	child.add(lbl1);			
	child.add(lbl2);
	child.add(btn1);
	child.add(btn2);
	child.add(btn3);
	child.add(btn4);
	child.add(lbl3);
}}

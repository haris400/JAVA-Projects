import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
	private String username="admin";
	 private String password="admin";
	
	Stage stage =new Stage();
	Login(){
		
		
		stage.setTitle("Login");
		stage.setWidth(380);
		stage.setHeight(600);
		stage.setResizable(false);
		Group  root =new Group();
		addComponents(root);
		Scene scene =new Scene(root);
		Image img = new Image("file:images/login-background.jpg");
		ImagePattern pattern = new ImagePattern(img);
		scene.setFill(pattern);
		stage.setScene(scene);
		stage.show();
}
	private void addComponents(Group root) {
		// TODO Auto-generated method stub
		
		Image quiz=new Image("file:images/user-512.png");
		ImageView quz=new ImageView(quiz);
				quz.setX(113);
				quz.setY(100);
				
				quz.setFitHeight(140);
				quz.setFitWidth(160);
		
		final TextField  textField = new TextField();	
		textField.getText();
		textField.setPromptText("Enter ID");
		textField.setTranslateX(115);
		textField.setTranslateY(360);

		PasswordField pas = new PasswordField();
		pas.getText();
		pas.setPromptText("Password");
		pas.setTranslateX(115);
		pas.setTranslateY(400);
		 
		Button btn = new Button("Login");
		  btn.setFont(new Font("Arial", 15));
		  btn.setTranslateX(162);
		  btn.setTranslateY(440);
		  DropShadow shadow = new DropShadow();
		  btn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			  btn.setEffect(shadow);
			});
		  btn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			  btn.setEffect(null);
			});
		  
 btn.setOnAction((ActionEvent e) -> {
			  
	 if(textField.getText().equals(username) && pas.getText().equals(password))	
		{

			  
			        
			       
			        ((Stage)textField.getScene().getWindow()).close();
			        AdminAr win1=new AdminAr();
			        
		}
		 
	  else
    {
		  ((Stage)textField.getScene().getWindow()).close();
		  Login home =new Login();
		}
			  
			}); 
		 
			
		
		
		
		
		ObservableList child= root.getChildren();
		child.add(textField);
		child.add(pas);
		child.add(btn);
		child.add(quz);
	}
}
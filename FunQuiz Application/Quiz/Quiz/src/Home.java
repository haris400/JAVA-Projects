import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Home extends Application {
	
	static String name;
	static int score = 0;
	static int Lives = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}

	@Override
	public void start(Stage PrimaryStage) {
		// TODO Auto-generated method stub
		
		PrimaryStage.setTitle("Quiz");
		PrimaryStage.setWidth(750);
		PrimaryStage.setHeight(500);
		PrimaryStage.setResizable(false);
		
		Group root= new Group();
		
		addComponents(root);
		Image quiz=new Image("file:images/ncbddd-topic-socialmedia-resources-quiz.jpg");
		ImagePattern pattern = new ImagePattern(quiz);
		Scene sce= new Scene(root);
		sce.setFill(pattern);
		PrimaryStage.setScene(sce);
		PrimaryStage.show();
	}
	
	  
	void addComponents(Group root) {
		// TODO Auto-generated method stub
		
		
		//ImageView quiz=new ImageView(quiz);
		//quz.setX(220);
		//quz.setY(60);
		
		//quz.setFitHeight(230);
		//quz.setFitWidth(350);
		
		final TextField  textField = new TextField();	
		textField.getText();
		textField.setTranslateX(300);
		textField.setTranslateY(410);
		
		
		 Button btn = new Button("Start");
		  btn.setFont(new Font("Arial", 15));
		  btn.setTranslateX(464);
		  btn.setTranslateY(412);
		  DropShadow shadow = new DropShadow();
		  btn.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			  btn.setEffect(shadow);
			});
		  btn.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			  btn.setEffect(null);
			});
		
		  
		  Label lbl = new Label("ENTER YOUR NAME");
		  lbl.setTranslateX(330);
		  lbl.setTranslateY(435);
		  
		  BooleanBinding booleanBind = textField.textProperty().isEmpty();
		  btn.disableProperty().bind(booleanBind);
		 
		  MenuBar menuBar = new MenuBar();
		  menuBar.setMinSize(800,10);
		  Menu menuHelp = new Menu("Help");
		  Menu menulogin = new Menu("Admin");
	      MenuItem add = new MenuItem("About");
	      MenuItem add2 = new MenuItem("Login");
	      menuHelp.getItems().addAll(add);
	      menulogin.getItems().addAll(add2);
	      menuBar.getMenus().addAll(menulogin,menuHelp);
	      add2.setOnAction((ActionEvent t) -> {
	    	  ((Stage)textField.getScene().getWindow()).close();  
	    	  Login log =new Login();
	        });
	     
	      add.setOnAction((ActionEvent t) -> {
	    	  
	            About about=new About();
	        });
	      
		  
		  btn.setOnAction((ActionEvent e) -> {
			  
			  name =textField.getText(); 
			  ((Stage)textField.getScene().getWindow()).close();
			  //  Score win1=new Score();
			     Q1 win1 =new Q1();
			  // QuizOver win1 =new QuizOver();
			  // AllScores win1=new AllScores();
			});
		 /* btn.setOnAction(new EventHandl
		  * er<ActionEvent>(){
			
				public void handle(ActionEvent arg0){
					
					name =textField.getText(); 
					((Stage)textField.getScene().getWindow()).close();
					Q1 win1 =new Q1();
					}
				}
				});
		  */
  
		ObservableList child= root.getChildren();
		//child.add(quz);
		child.add(textField);
		child.add(btn);
		child.add(lbl);
		child.add(menuBar);
	}
	
	
}

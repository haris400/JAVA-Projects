import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class About {
	Stage stage =new Stage();
	About(){
		stage.setTitle("About");
		stage.setWidth(820);
		stage.setHeight(200);
		stage.setResizable(false);
		Group  root =new Group();
		addComponents(root);
		Scene scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	void addComponents(Group root){
		final Text text = new Text(); 
		text.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		text.setText("Think you are a true General Knowledge expert?\n You Will have 3 Lives to complete the quiz \nTake these addictive General Knowledge quizzes and prove it."); 
		text.setX(25); 
	    text.setY(60);   
	    
	      
		
		ObservableList child= root.getChildren();
		child.add(text);
		}

}

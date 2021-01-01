import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdminAr {
Stage stage =new Stage();
	
AdminAr(){
		

		stage.setTitle("AdminAr");
		
		stage.setWidth(480);
		
		stage.setHeight(500);
		stage.setResizable(false);
		Group  root =new Group();
	    addComponents(root);
		Scene scene =new Scene(root);
		
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		
		stage.show();
	}
	
	void addComponents(Group root){
	
		 
		Button btn = new Button("Delete");
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
			
			  
			}); 
		TableView<scoreObject> tv =new TableView();
		tv.setPrefWidth(750);
	    tv.setTranslateY(0);
	    TableColumn name=new TableColumn("Name");
	    name.setMinWidth(160);
		TableColumn score=new TableColumn("Score");
		score.setMinWidth(160);
		TableColumn lives=new TableColumn("Lives");
		lives.setMinWidth(160);
		
		
		tv.getColumns().addAll(name,score,lives);
		
		
		name.setCellValueFactory(new PropertyValueFactory("Name"));
	
		
		score.setCellValueFactory(new PropertyValueFactory("Score"));
		
		lives.setCellValueFactory(new PropertyValueFactory("Lives"));
	
		
		
		ObservableList<scoreObject> data =FXCollections.observableArrayList();
		
		String [][]fileRecords=getScoreFromfile();
	
		

		for(int row=0;row<fileRecords.length;row++)
		{
		
			data.add(new scoreObject (fileRecords[row][0],fileRecords[row][1],fileRecords[row][2]));
			System.out.println(fileRecords[row][0]+fileRecords[row][1]+fileRecords[row][2] );
		}
		
		
		tv.setItems(data);
		root.getChildren().add(tv);
	}


public String [][] getScoreFromfile(){
	
	try{
		String file ="file://../data/scores.txt";
		FileReader Accountfile =new FileReader(file);
		BufferedReader br =new BufferedReader(Accountfile);
		
		String data[][];
		data=new String [10][];//records
		
		String []row =new String [3];//cols
		String record="";
		int rowNum=0;
		
		while((record=br.readLine())!=null){
			
			System.out.println(record);
			row=record.split("\\|");
			data[rowNum]=row;
			rowNum++;
	 
		}
	br.close();
	return data;
	}catch(IOException e){
		System.out.println(e);
		return null;
	}
}
}

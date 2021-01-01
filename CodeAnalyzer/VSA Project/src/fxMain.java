import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class fxMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception { 
		stage.setTitle("JAVA SourceCode Analyzer");
		Group group=new Group();
		AddComponent(group,stage);
		Scene scene=new Scene(group);
		Image img=new Image("Asset 8.png");
		ImagePattern i=new ImagePattern(img);
		scene.setFill(i);
		stage.setScene(scene);
		stage.setHeight(650);
		stage.getHeight();
		stage.setWidth(970);
		stage.setResizable(false);;
		stage.show();
		
	}
	ObservableList<String> files = FXCollections.observableArrayList();
	private void AddComponent(Group group,Stage stage) {
		CategoryAxis xAxis = new CategoryAxis();
 	    NumberAxis yAxis = new NumberAxis();
 	    BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
 	    bc.setTitle("Metrics Plot");
 	        xAxis.setLabel("");       
 	        yAxis.setLabel("Value");
 	    bc.setLayoutX(470);
 	    bc.setLayoutY(20);

		DirectoryChooser dc = new DirectoryChooser();
		dc.setInitialDirectory(new File(System.getProperty("user.home")));
	    Label s1=new Label("Files :");
        s1.setLayoutX(2);
		s1.setLayoutY(120);
		s1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        ListView<String> list = new ListView<String>();
        list.setPrefWidth(430);
        list.setPrefHeight(130);
        list.setLayoutX(10);
        list.setLayoutY(150);
        list.setDisable(true);
        CheckBox select =new CheckBox("Select");
        select.setLayoutX(350);
        select.setLayoutY(120);
        
        select.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		if(select.isSelected()){
			list.setDisable(false);}
		else {
			list.setDisable(true);
		}
		    } 	
		});
		
    	
		 Label s2=new Label("Source Code Directory");
	        s2.setLayoutX(2);
			s2.setLayoutY(10);
			s2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		TextField tl=new TextField();
		tl.setLayoutX(10);
		tl.setLayoutY(40);
		tl.setPrefWidth(330);
		tl.setPrefHeight(40);
		Button btn2=new Button("Browes ..");
		btn2.setLayoutX(350);
		btn2.setLayoutY(45);
		btn2.setPrefWidth(90);
		btn2.setPrefHeight(30);
		btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		btn2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	list.getItems().clear();
		        XYChart.Series series1 = new XYChart.Series();
 
		        series1.getData().add(new XYChart.Data( "LOC",0));
		        series1.getData().add(new XYChart.Data( "CLOC",0));
		        series1.getData().add(new XYChart.Data( "SLOC",0));
		        series1.getData().add(new XYChart.Data( "BLOC",0));
		        series1.getData().add(new XYChart.Data( "NCLOC",0));      
		        series1.getData().add(new XYChart.Data( "McCabeComplex",0));   

		    	bc.getData().addAll(series1);
		    	File	selectedDirectory = dc.showDialog(stage);	  
		    	tl.setText(selectedDirectory.getAbsolutePath()); 
		    	listFilesAndFilesSubDirectories(selectedDirectory.getAbsoluteFile().toString()); 
		    	list.setItems(files);
		    } 	
		});

 		Label nf=new Label("Source Files :");
 		nf.setLayoutX(70);
 		nf.setLayoutY(400);
 		nf.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label nfV=new Label("0");
 		nfV.setLayoutX(350);
 		nfV.setLayoutY(400);
 		nfV.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label l1=new Label("LOC, Line of Code :");
 		l1.setLayoutX(70);
 		l1.setLayoutY(430);
 		l1.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label l1V=new Label("0");
 		l1V.setLayoutX(350);
 		l1V.setLayoutY(430);
 		l1V.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label l2=new Label("BLOC, Blank Lines :");
 		l2.setLayoutX(70);
 		l2.setLayoutY(460);
 		l2.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label l2V=new Label("0");
 		l2V.setLayoutX(350);
 		l2V.setLayoutY(460);
 		l2V.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label tl1=new Label("CLOC, Comment Lines :");
 		tl1.setLayoutX(70);
 		tl1.setLayoutY(490);
 		tl1.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label tl1V=new Label("0");
 		tl1V.setLayoutX(350);
 		tl1V.setLayoutY(490);
 		tl1V.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label tl2=new Label("NCLOC :");
 		tl2.setLayoutX(70);
 		tl2.setLayoutY(520);
 		tl2.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label tl2V=new Label("0");
 		tl2V.setLayoutX(350);
 		tl2V.setLayoutY(520);
 		tl2V.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label ls=new Label("SLOC :");
 		ls.setLayoutX(70);
 		ls.setLayoutY(550);
 		ls.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label lsV=new Label("0");
 		lsV.setLayoutX(350);
 		lsV.setLayoutY(550);
 		lsV.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		
 		Label l3=new Label("McCabe Complexity :");
 		l3.setLayoutX(70);
 		l3.setLayoutY(580);
 		l3.setFont(Font.font("Verdana", FontWeight.BLACK, 15));
 		Label l3V=new Label("0");
 		l3V.setLayoutX(350);
 		l3V.setLayoutY(580);
 		l3V.setFont(Font.font("Verdana", FontWeight.BLACK, 15));

		Button btn1=new Button("Calculate LOC");
		btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		btn1.setLayoutX(640);
		btn1.setLayoutY(470);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	nfV.setText(files.size()+"");
		    	if(select.isSelected()) {
		    	
		    	String source = null;
				try {
					source = source = new String(Files.readAllBytes(Paths.get(list.getSelectionModel().getSelectedItem())));
				} catch (IOException e1) {
					
					e1.printStackTrace();
				};
		    	   McCabe mc=new McCabe(source);
		    	   ArrayList result = null;
		    	   try {
		    		   result =  CalculateLOC.CalculateLOC(Paths.get(list.getSelectionModel().getSelectedItem()).toString());
		    		   System.out.print(list.getSelectionModel().getSelectedItem());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    	  
		    	l3V.setText(mc.CalculateCyclomaticComplexity()+"");
				l1V.setText((String) result.get(0));
				tl1V.setText((String) result.get(1));
				lsV.setText((String) result.get(2));
				l2V.setText((String) result.get(3));
				tl2V.setText((String) result.get(4));
				bc.getData().clear();
			    XYChart.Series series1 = new XYChart.Series();
		             
		        series1.getData().add(new XYChart.Data( "LOC",Integer.parseInt((String) result.get(0))));
		        series1.getData().add(new XYChart.Data( "CLOC",Integer.parseInt((String) result.get(1))));
		        series1.getData().add(new XYChart.Data( "SLOC",Integer.parseInt((String) result.get(2))));
		        series1.getData().add(new XYChart.Data( "BLOC",Integer.parseInt((String) result.get(3))));
		        series1.getData().add(new XYChart.Data( "NCLOC",Integer.parseInt((String) result.get(4))));      
		        series1.getData().add(new XYChart.Data( "McCabeComplex",mc.CalculateCyclomaticComplexity()));   
		        
		    	
		    	bc.getData().addAll(series1);
		    	}
		    	else {	
		    		int loc = 0,bloc = 0,cloc = 0,ncloc = 0,mc = 0,sloc = 0;
		    		for(String f: files) {
			    	String source = null;
					try {
						source = source = new String(Files.readAllBytes(Paths.get(f)));
					} catch (IOException e1) {
						
						e1.printStackTrace();
					};
			    	   McCabe mc1=new McCabe(source);
			    	   ArrayList result = null;
			    	   try {
			    		   result=  CalculateLOC.CalculateLOC(f);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			    	System.out.println(result.get(0));
			    	mc+=mc1.CalculateCyclomaticComplexity();
					loc+=Integer.parseInt((String) result.get(0));
					cloc+=Integer.parseInt((String) result.get(1));
					sloc+=Integer.parseInt((String) result.get(2));
					bloc+=Integer.parseInt((String) result.get(3));
					ncloc+=Integer.parseInt((String) result.get(4));
					
		    		}

		    		l3V.setText(mc+"");
					l1V.setText(loc+"");
					lsV.setText(sloc+"");
					tl1V.setText(cloc+"");
					l2V.setText(bloc+"");
					tl2V.setText(ncloc+"");
					bc.getData().clear();
				    XYChart.Series series1 = new XYChart.Series();
			             
			        series1.getData().add(new XYChart.Data( "LOC",loc));
			        series1.getData().add(new XYChart.Data( "CLOC",cloc));
			        series1.getData().add(new XYChart.Data( "SLOC",sloc));
			        series1.getData().add(new XYChart.Data( "BLOC",bloc));
			        series1.getData().add(new XYChart.Data( "NCLOC",ncloc));      
			        series1.getData().add(new XYChart.Data( "McCabeComplex",mc));   

			    	bc.getData().addAll(series1);
		    	}
		    } 	
		});
	group.getChildren().addAll(btn1);
    	group.getChildren().addAll(nf,l1,l2,l3,tl1,tl2,bc,nfV,l1V,l2V,l3V,tl2V,list,s1,tl,btn2,s2,tl1V,select,ls,lsV);
	}

	public void listFilesAndFilesSubDirectories(String directoryName){
		File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
            	if(file.getAbsolutePath().endsWith(".java")) {
            	files.add(file.getAbsolutePath());
            	System.out.println(file.getAbsolutePath());
            	}
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
 
       }

	}


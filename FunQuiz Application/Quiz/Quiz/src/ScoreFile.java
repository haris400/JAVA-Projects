import java.io.*;
import java.lang.*;
import java.util.*;

import javafx.scene.control.Alert;

public class ScoreFile extends Home {

public boolean addScore(String record){
	
	String csvFile="file://../data/scores.txt";
	try{
		
		FileWriter fw=new FileWriter (csvFile,true);
		fw.write(record);
		fw.close();
		
	}catch(IOException e){
		e.printStackTrace();
		return false;
		
	}
	return true;}
	
}

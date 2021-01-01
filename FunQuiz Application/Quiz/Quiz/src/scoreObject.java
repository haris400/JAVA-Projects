
public class scoreObject {
	private String Name;
	private String Score;
	private String Lives;
	
	
	scoreObject(String name,String Score,String Lives){
		
		this.Name=name;
		this.Score=Score;
		this.Lives=Lives;
	}
	
	public String getName(){
		
		return Name;
	}
	
public String getScore(){
		
		return Score;
	}
	

public String getLives(){
	
	return Lives;
}


public void setName(String name){
	
	this.Name=name;
}

public void setScore(String Score){
	
	this.Score=Score;
}

public void setAccountNo(String Lives){
	
	this.Lives=Lives;
}



}

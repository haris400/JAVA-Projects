
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  CalculateLOC
	{
	 
		public static ArrayList CalculateLOC(String Path) throws IOException
		{
			ArrayList<String> result=new ArrayList<String>();
			int LOC = 0, CLOC = 0, SLOC = 0, BLOC = 0,NCLOC=0,temp=0;

		File f=new File(Path);
		BufferedReader reader = new BufferedReader(new FileReader(f));
		 String line;
		while ((line = reader.readLine()) != null) {
	
		if (line.equals(""))
            BLOC++;

		if(line.contains("import")||line.contains("{")||line.contains("}")) {
			temp++;
		}
		
        if (line.contains("/*") && !line.contains("*/"))
        {
            String x = "";
            CLOC++;
            while (!x.contains("*/"))
            {
                x = reader.readLine();
                CLOC++;
                LOC++;
            }
        }
        else if (line.contains("/*") && line.contains("*/"))
        {
            CLOC++;
        }
        else if (line.contains("//"))
        {
            CLOC++;
        }
        LOC++;
     
        SLOC=LOC-CLOC-BLOC;
    

    }

		result.add(LOC+"");
		//System.out.println(result.get(0));
		result.add(CLOC+"");
		//System.out.println(result.get(1));
		result.add(SLOC+"");
		//System.out.println(result.get(2));
		result.add(BLOC+"");
		//System.out.println(result.get(3));
		result.add((SLOC -temp)+"");
		//System.out.println(result.get(4));
		return result;
		
		
		}

}

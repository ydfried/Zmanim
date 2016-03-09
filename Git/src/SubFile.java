

import java.io.*;

public class SubFile {
	
	
	public StringBuilder match(){

		StringBuilder sub = new StringBuilder();

		// The name of the file to open.
        InputStream filePath = this.getClass().getResourceAsStream("subscriber.txt");
        
        // This will reference one line at a time
        String line = null;

        try {
            
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(filePath, "UTF-8"));

            while((line = bufferedReader.readLine()) != null) {
                sub.append("," + line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                filePath + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + filePath + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		return sub;
    }
}	

import java.util.TimerTask;


public class MyTimeTask extends TimerTask {

	
	public String message; 
	
	MyTimeTask(String message){
		this.message = message;
	}
	
	
	@Override
	public void run() {
		
		 System.out.println(this.message);
		

	}

}

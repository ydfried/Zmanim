import java.util.TimerTask;


public class MyTimeTask extends TimerTask {

	
	private String message; 
	private String phoneNumber;
	
	MyTimeTask(String message, String phoneNumber){
		this.message = message;
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public void run() {
		
		 //System.out.println(this.message);
		 
		 try {
				SMS.text(this.phoneNumber, this.message);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}

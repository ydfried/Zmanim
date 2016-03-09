import java.util.TimerTask;


public class DailyRun extends TimerTask {

	@Override
	public void run() {
		
		DB myDb = null;
		try {
			myDb = new DB();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		GetReminders.getReminders(myDb);

	}

}

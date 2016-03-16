import java.util.TimerTask;


public class DailyRun extends TimerTask {

	@Override
	public void run() {
		System.out.println("1");
		DB myDb = null;
		try {
			myDb = new DB();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		GetReminders.getReminders(myDb);

	}

}

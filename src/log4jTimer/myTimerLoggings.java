package log4jTimer;
import org.apache.logging.log4j.*;
import java.time.format.DateTimeFormatter;

public class myTimerLoggings {

	private static Logger timeLogger = LogManager.getLogger(myTimerLoggings.class.getName());
	public static void main(String[] args) {
		System.out.println("Logger demo");	
		System.out.println(timeLogger.getLevel());
		while(true) { 
			if(timeLogger.getLevel()== Level.DEBUG) {
				waitFor(3600000);
				timeLogger.debug(getTime());
			}
			if(timeLogger.getLevel()== Level.ERROR) {
				waitFor(60000);
				timeLogger.error(getTime());
			}
			if(timeLogger.getLevel()== Level.FATAL) {
				waitFor(1000);
				timeLogger.fatal(getTime());
			}
		}
	}
	public static String getTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String now = (java.time.LocalTime.now()).format(formatter);
		return now;
	}
	
	public static void waitFor(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

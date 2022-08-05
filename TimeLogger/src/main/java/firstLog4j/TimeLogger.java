package firstLog4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.Thread.sleep;

public class TimeLogger {
	static Logger log = LogManager.getLogger(TimeLogger.class.getName());
	public static void main(String[] args) throws InterruptedException { //throws IOException {

		System.out.println("Level is: " + log.getLevel().toString());
		switch(log.getLevel().toString()){
			case "TRACE":
				//Date date = new Date();
				while (log.getLevel().toString().equals("TRACE")) {
					LocalDateTime dateTime = LocalDateTime.now();
					DateTimeFormatter form_dateTime = DateTimeFormatter.ofPattern("HH:mm:ss");
					String str_DateTime = dateTime.format(form_dateTime);
					log.trace(str_DateTime);
					sleep(1000);
				}
				break;
			case "DEBUG":
				while(log.getLevel().toString().equals("DEBUG")) {
					LocalDateTime dateTime = LocalDateTime.now();
					DateTimeFormatter form_dateTime = DateTimeFormatter.ofPattern("HH:mm:ss");
					String str_DateTime = dateTime.format(form_dateTime);
					if (str_DateTime.substring(6).equals("00")){
						log.debug(str_DateTime);
					}
					sleep(1000);
				}
				break;
			case "INFO":
				while(log.getLevel().toString().equals("INFO")) {
					LocalDateTime dateTime = LocalDateTime.now();
					DateTimeFormatter form_dateTime = DateTimeFormatter.ofPattern("HH:mm:ss");
					String str_DateTime = dateTime.format(form_dateTime);
					if (str_DateTime.substring(3).equals("00:00")){
						log.info(str_DateTime);
					}
					sleep(1000);
				}
				break;
			default:
				log.fatal("FATAL: Wrong level selected!");
		}
	}
}
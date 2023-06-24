package Controller;

import java.io.IOException;

import java.util.logging.*;


public class Logging {
    

    public static Logger log = Logger.getLogger(Logging.class.getName());
    

    public static void someMethod() {

        FileHandler fh;
        try {
            fh = new FileHandler("history.log",true);
            log.addHandler(fh); 
            SimpleFormatter sFormat = new SimpleFormatter ();
            fh.setFormatter(sFormat);
        } catch (SecurityException | IOException e) {
            
        }
        
    }
  
}

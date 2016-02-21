package epam.com.tsm.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Irina_Kartun on 2/20/2016.
 */
public class Logging {

    public static Logger logger;

    public static Logger getLogger() {
        logger = LogManager.getRootLogger();
        return logger;
    }

}

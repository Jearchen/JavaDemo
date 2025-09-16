import java.util.logging.Level;

public class LogUtil {
    private Logger logger;
    private String nameOfClass;
    private String jointStr = "****";

    public LogUtil(String className){
        nameOfClass = className;
        logger = Logger.getLogger(className);
    }
    public void info(String message){
        logger.log(SelfLevel.INFO,"[source class]:"+nameOfClass+jointStr+"[Date]:"+new Date()+jointStr+"[Content]:"+message);
    }
    public void warn(String message){
        logger.log(SelfLevel.WARN,"[source class]:"+nameOfClass+jointStr+"[Date]:"+new Date()+jointStr+"[Content]:"+message);
    }
    public void error(String message){
        logger.log(SelfLevel.ERROR,"[source class]:"+nameOfClass+jointStr+"[Date]:"+new Date()+jointStr+"[Content]:"+message);
    }

    public static class SelfLevel extends Level{
        public static final SelfLevel INFO = new SelfLevel("INFO",1000);
        public static final SelfLevel WARN = new SelfLevel("WARN",2000);
        public static final SelfLevel ERROR = new SelfLevel("ERROR",3000);

        public SelfLevel(String name,int value){
            super(name,value,null);
        }
    }
}

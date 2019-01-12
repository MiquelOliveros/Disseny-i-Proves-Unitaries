package Exception;

public class NullParameterException extends RuntimeException{
    public NullParameterException(String msg){
        super(msg);
    }

    public NullParameterException() {
        super();
    }
}

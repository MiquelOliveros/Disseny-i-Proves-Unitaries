package services;

public class NoMailerServiceException extends RuntimeException {

    public NoMailerServiceException(String msg){
        super(msg);
    }

    public NoMailerServiceException(){
        super();
    }

}

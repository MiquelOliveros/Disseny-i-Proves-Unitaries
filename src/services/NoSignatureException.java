package services;

public class NoSignatureException extends RuntimeException {

    public NoSignatureException(String msg){
        super(msg);
    }

    public NoSignatureException(){
        super();
    }
}

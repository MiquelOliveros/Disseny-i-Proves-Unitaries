package services;

public class NoElectoralOrganismException extends RuntimeException {

    public NoElectoralOrganismException(String msg){
        super(msg);
    }

    public NoElectoralOrganismException(){
        super();
    }
}

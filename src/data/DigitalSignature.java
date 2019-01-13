package data;

public class DigitalSignature {

    private final byte[] signature;

    public DigitalSignature(byte[] signature) {
        if (signature == null){
            throw new NullParameterException();
        }else{
            this.signature = signature;
        }
    }

    public byte[] getSignature(){
        return signature;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature signature1 = (DigitalSignature) o;
        return signature.equals(signature1.signature);
    }

    @Override public int hashCode(){
        return signature.hashCode();
    }

    @Override
    public String toString(){
        return "DigitalSignature{" + "signature='" + signature + '\'' + '}';
    }
}

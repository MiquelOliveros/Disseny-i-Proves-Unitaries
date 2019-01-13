package data;

public class Nif {

    private final String nif;

    public Nif(String nif) {
        if (!validNif(nif)) {
            throw new NullParameterException();
        }else{
            this.nif = nif;
        }
    }

    private boolean validNif(String nif) {
        if(nif == null || nif.length() > 9){
            return false;
        }
        for (int i = 0; i< nif.length(); i++){
            if (Character.isDigit(nif.charAt(i)) && i == nif.length() - 1) {
                return false;
            }
        }
        return true;
    }

    public String getNif(){
        return nif;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif nif1 = (Nif) o;
        return nif.equals(nif1.nif);
    }

    @Override public int hashCode(){
        return nif.hashCode();
    }

    @Override
    public String toString(){
        return "Nif{" + "nif='" + nif + '\'' + '}';
    }
}

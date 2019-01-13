package data;

public class MailAdress {

    private final String adress;

    public MailAdress(String adress) {
        if(adress == null){
            throw new NullParameterException();
        }else{
            this.adress = adress;
        }
    }

    public String getAdress(){
        return adress;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAdress adress1 = (MailAdress) o;
        return adress.equals(adress1.adress);
    }

    @Override public int hashCode(){
        return adress.hashCode();
    }

    @Override
    public String toString(){
        return "MailAdress{" + "adress='" + adress + '\'' + '}';
    }
}

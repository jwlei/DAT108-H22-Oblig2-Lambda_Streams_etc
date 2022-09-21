package ex2.task2;

public class Ansatt {

    private String fornavn;
    private String etternavn;
    private Kjonn kjonn;
    private String stilling;
    private int aarslonn;
   
    public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int lonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = lonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public boolean erMann() {
        return kjonn == Kjonn.MANN;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getAarslonn() {
        return aarslonn;
    }
     	
    public void setAarslonn(int aarslonn) {
        this.aarslonn = aarslonn;
    }

    @Override
    public String toString() {
    	
    	return "\nAnsatt [Navn = " + fornavn
                + ", Etternavn = " + etternavn
                + ", Kjønn = " + kjonn
                + ", Stilling = " + stilling
                + ", Lønn = "+ aarslonn + "]";
     
    }
}
    
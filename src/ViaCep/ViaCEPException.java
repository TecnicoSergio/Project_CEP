package ViaCep;

public class ViaCEPException extends Exception {
    private String CEP;
    private String Classe;

    public ViaCEPException(String message, String classe) {
        super(message);
        this.CEP = "";
        this.Classe = classe;
    }

    public ViaCEPException(String message, String cep, String name) {
    }


    public void setCEP(String cep) {
        this.CEP = cep;
    }


    public String getCEP() {
        return this.CEP;
    }


    public boolean hasCEP() {
        return !this.CEP.isEmpty();
    }


    public String getClasse() {
        return Classe;
    }


}

package ViaCep;

public class ViaCEPException extends Exception {
    private String CEP;
    private String Classe;

    public ViaCEPException(String message, String classe) {
        super(message);
        this.CEP = "";
        this.Classe = classe;
    }



}

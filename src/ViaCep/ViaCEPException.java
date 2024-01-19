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

    /**
     * Define o CEP da exceção
     *
     * @param cep
     */
    public void setCEP(String cep) {
        this.CEP = cep;
    }

    /**
     * Retorna o CEP da exceção
     *
     * @return String CEP
     */
    public String getCEP() {
        return this.CEP;
    }

    /**
     * Retorna se tem algum CEP
     *
     * @return boolean
     */
    public boolean hasCEP() {
        return !this.CEP.isEmpty();
    }

    /**
     * Retorna a classe da excessão original
     *
     * @return
     */
    public String getClasse() {
        return Classe;
    }


}

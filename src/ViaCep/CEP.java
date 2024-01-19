package ViaCep;

public class CEP {

    public String cep;
    public String logradouro;
    public String complemento;
    public String bairro;
    public String localidade;
    public String uf;
    public String ibje;
    public String gia;


    /**
     * Cria um novo cep vazio
     */
    public CEP() {
        this.logradouro = null;
        this.complemento = null;
        this.bairro = null;
        this.localidade = null;
        this.uf = null;
        this.ibje = null;
        this.gia = null;
    }

    /**
     * @param cep
     * @param logradouro
     * @param complemento
     * @param bairro
     * @param localidade
     * @param uf
     * @param ibje
     * @param gia
     */

    public CEP(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibje, String gia) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibje = ibje;
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "CEP{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibje='" + ibje + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }

    /**
     * @param logradouro
     * @param localidade
     * @param uf
     */

    public CEP(String logradouro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbje() {
        return ibje;
    }

    public void setIbje(String ibje) {
        this.ibje = ibje;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}

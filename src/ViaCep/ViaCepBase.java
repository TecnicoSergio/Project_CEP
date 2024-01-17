package ViaCep;

import java.util.ArrayList;
import java.util.List;

public abstract class ViaCepBase {

    protected List<Cep> CEPs;
    protected int index;
    protected String currentCep;

    protected ViaCepEvents Events;

    public ViaCepBase (){
        CEPs = new ArrayList<>();
        index = -1;
        currentCep = "00000-000";
        this.Events = null;
    }

    public abstract void buscar(String cep) throws ViaCEPException;
    public abstract void buscarCEP(CEP cep) throws ViaCEPException;

    /**
     *
     * @param Uf
     * @param Localidade
     * @param Logradouro
     * @throws ViaCEPException
     */
    public void buscarCEP(String Uf, String Localidade, String Logradouro) throws ViaCEPException {
        buscarCEP(new CEP(Logradouro, Localidade, Uf));

        public int getIndex(){
            return index;
        }

        public int getSize(){
            return CEPs.size();
        }

        public String getCep(){
            return CEPs.get(index).CEP;
        }


    }
}

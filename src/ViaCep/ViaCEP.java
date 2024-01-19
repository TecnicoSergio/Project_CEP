package ViaCep;


import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.io.Serializable;

import static sun.security.util.ResourcesMgr.getString;

public class ViaCEP extends ViaCepBase {

    public static final double VIACEP_VERSAO = 0.33;

    public ViaCEP() {
        super();
    }

    /**
     * @param events
     */
    public ViaCEP(ViaCepEvents events) {
        super();
        this.Events = events;
    }
    
    public String complemento;

    public ViaCEP(String cep, ViaCepEvents events) throws ViaCEPException {
        super();
        this.Events = events;
        this.buscar(cep);
    }

    //public final void Events(String events) throws ViaCepEvents {
    //currentEvents = events;
    //}

    public final void buscar(String cep) throws ViaCEPException {
        currentCep = cep;

        String url = "http://viacep.com.br/ws" + cep + "/json/";
        JSObject obj = new JSObject() {
            @Override
            public Object call(String methodName, Object... args) throws JSException {
                return null;
            }

            @Override
            public Object eval(String s) throws JSException {
                return null;
            }

            @Override
            public Object getMember(String name) throws JSException {
                return null;
            }

            @Override
            public void setMember(String name, Object value) throws JSException {

            }

            @Override
            public void removeMember(String name) throws JSException {

            }

            @Override
            public Object getSlot(int index) throws JSException {
                return null;
            }

            @Override
            public void setSlot(int index, Object value) throws JSException {

            }
        };
        if (!has("erro")) {
            CEP novoCEP = new CEP(getCep(),
                    getLogradouro(),
                    getComplemento(),
                    getBairro(),
                    getLocalidade(),
                    getUf(),
                    getIbge(),
                    getGia());

            CEPs.add(novoCEP);
            index = CEPs.size() - 1;

            if (Events instanceof ViaCepEvents) {
                Events.onCEPSuccess(this);
            }

        } else {
            if (Events instanceof ViaCepEvents) {
                Events.onCEPError(currentCep);
            }
            throw new ViaCEPException("Não foi possivel encontrar o CEP", cep, ViaCEPException.class.getName());
        }

    }

    private boolean has(String erro){
        return true;
    }

    private Object getHttpGET(String url) {
        return true;
    }

    public void buscarCEP(CEP cep) throws ViaCEPException {
        buscarCEP(cep.uf, cep.localidade, cep.logradouro);
    }

    public Serializable buscarCEP(String Uf, String localidade, String logradouro) throws ViaCEPException {
        currentCep = "?????-???";

        String url = "http://viacep.com.br/ws/" + Uf.toUpperCase() + "/" + localidade + "/" + logradouro + "/json";

        JSOArray ceps = new JSOArray(getHttpGET(url));
        if (ceps.length() > 0) {
            for (int i = 0; i < ceps.length(); i++) {
                JSObject obj = ceps.getJSONObject(i);
                if (!has("erro")) {
                    CEP novoCEP = new CEP(getCep(),
                            getLogradouro(),
                            getComplemento(),
                            getBairro(),
                            getLocalidade(),
                            getUf(),
                            getIbge(),
                            getGia());

                    CEPs.add(novoCEP);
                    index = CEPs.size() - 1;
                    if (Events instanceof ViaCepEvents) {
                        Events.onCEPSuccess(this);
                    }
                } else {
                    if (Events instanceof ViaCepEvents) {
                        Events.onCEPError(currentCep);
                    }
                    throw new ViaCEPException("Não foi possível validar o cep", currentCep, ViaCEPException.class.getName());
                }
            }
        } else {
            throw new ViaCEPException("Nenhum CEP encontrado", currentCep, getClass().getName());
        }


        return null;
    }


    public java.lang.String getCep() {
    }

    public java.lang.String getComplemento(){

    }

    public java.lang.String getLogradouro() {
    }

    public java.lang.String getBairro() {
    }

    public java.lang.String getLocalidade() {
    }

    public java.lang.String getUf() {
    }

    public java.lang.String getGia() {
    }

    public java.lang.String getIbge() {
    }
}

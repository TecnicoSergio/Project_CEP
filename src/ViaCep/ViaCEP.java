package ViaCep;


import netscape.javascript.JSObject;

public class ViaCEP extends ViaCepBase {

    public static  final double VIACEP_VERSAO = 0.33;

    public ViaCEP(){
        super();
    }

    /**
     *
     * @param events
     */
    public ViaCEP(ViaCepEvents events){
        super();
        this.Events = events;
    }

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
        JSObject obj = new JSObject(getHttpGET(url));
                if (!obj.has("erro")) {
                    CEP novoCEP = new CEP(obj.getString("cep"),
                            obj.getString("logradouro"),
                            obj.getString("complemento"),
                            obj.getString("bairro"),
                            obj.getString("localidade"),
                            obj.getString("uf"),
                            obj.getString("ibge"),
                            obj.getString("gia"));

                    CEPs.add(novoCEP);
                    index = CEPs.size() - 1;

                    if (Events instanceof ViaCepEvents) {
                        Events.onCEPSuccess(this);
                    }

                }else {
                    if (Events instanceof ViaCepEvents) {
                        Events.onCEPError(currentCep);
                    }
                    throw new ViaCEPException("Não foi possivel encontrar o CEP", cep, ViaCEPException.class.getName());
                }

    }

    public void buscarCEP(CEP cep) throws ViaCEPException {
        buscarCEP(cep.Uf, cep.Localidade, cep.Logradouro);
    }

    public void buscarCEP(String Uf, String localidade, String logradouro) throws ViaCEPException {
        currentCEP = "?????-???";

        String url = "http://viacep.com.br/ws/" + Uf.toUpperCase() + "/" + localidade + "/" + logradouro + "/json";

        JSOArray ceps = new JSOArray(getHttpGET(url));
        if (ceps.length() > 0) {
            for (int i = 0; i < ceps.length(); i++) {
                JSObject obj = ceps.getJSONObject(i);
                if (!obj.has("erro")){
                    CEP novoCEP = new CEP(obj.getString("cep"),
                            obj.getString("logradouro"),
                            obj.getString("complemento"),
                            obj.getString("bairro"),
                            obj.getString("localidade"),
                            obj.getString("uf"),
                            obj.getString("ibge"),
                            obj.getString("gia"));

                    CEPs.add(novoCEP);
                    index = CEPs.size() - 1;
                    if (Events instanceof ViaCepEvents) {
                        Events.onCEPSuccess(this);
                    }
                }else {
                    if (Events instanceof ViaCepEvents){
                        Events.onCEPError(currentCep);
                    }
                    throw new ViaCEPException("Não foi possível validar o cep", currentCep, ViaCEPException.class.getName());
                }
            }
        }else {
            throw new ViaCEPException("Nenhum CEP encontrado", currentCep, getClass().getName());
        }
    }


    public String getCep() {
    }
}

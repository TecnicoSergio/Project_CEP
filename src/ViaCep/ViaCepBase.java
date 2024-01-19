package ViaCep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.ProtocolException;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;


public abstract class ViaCepBase {

    protected List<CEP> CEPs;
    protected int index;
    protected String currentCep;

    protected ViaCepEvents Events;
    private String urlToRead;

    public ViaCepBase() {
        CEPs = new ArrayList<>();
        index = -1;
        currentCep = "00000-000";
        this.Events = null;
    }

    public abstract void buscar(String cep) throws ViaCEPException;

    public abstract void buscarCEP(CEP cep) throws ViaCEPException;

    /**
     * @param Uf
     * @param Localidade
     * @param Logradouro
     * @throws ViaCEPException
     */
    public Serializable buscarCEP(String Uf, String Localidade, String Logradouro) throws ViaCEPException {
        buscarCEP(new CEP(Logradouro, Localidade, Uf));

        public int getIndex () {
            return index;
        }

        public int getSize () {
            return CEPs.size();
        }

        public String getCep () {
            return CEPs.get(index).cep;
        }

        public String getLogradouro () {
            return CEPs.get(index).logradouro;
        }

        public String getComplemento() {
            return CEPs.get(index).complemento;
        }
        public String getBairro () {
            return CEPs.get(index).bairro;
        }
        public String getLocalidade () {
            return CEPs.get(index).localidade;
        }
        public String getUf () {
            return CEPs.get(index).uf;
        }
        public String getIbge () {
            return CEPs.get(index).ibje;
        }
        public String getGia () {
            return CEPs.get(index).gia;
        }
        public final String getHttpGET (String urlToRead) throws ViaCEPException {
            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL(urlToRead);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            } catch (MalformedURLException | ProtocolException ex) {
                // verifica os Eventos
                if (Events instanceof ViaCepEvents) {
                    Events.onCEPError(currentCep);
                }

                throw new ViaCEPException(ex.getMessage(), ex.getClass().getName());
            } catch (IOException ex) {

                if (Events instanceof ViaCepEvents) {
                    Events.onCEPError(currentCep);
                }

                throw new ViaCEPException(ex.getMessage(), ex.getClass().getName());
            }

            return result.toString();
        }


        public boolean move ( int index){
            if (CEPs.size() > 0 && index >= 0 && index < CEPs.size()) {
                this.index = index;
                return true;
            }

            this.index = -1;
            return false;
        }


        public boolean moveFirst () {
            if (CEPs.size() > 0) {
                index = 0;
                return true;
            }

            index = -1;
            return false;
        }


        public boolean moveNext () {
            if (CEPs.size() > 0 && (index + 1) < CEPs.size()) {
                index += 1;
                return true;
            }

            index = -1;
            return false;
        }


        public boolean movePrevious () {
            if (CEPs.size() > 0 && (index - 1) >= 0) {
                index -= 1;
                return true;
            }

            index = -1;
            return false;
        }


        public boolean moveLast () {
            if (CEPs.size() > 0) {
                index = CEPs.size() - 1;
                return true;
            }

            index = -1;
            return false;
        }


        public List<CEP> getList () {
            return CEPs;
        }


        protected String formatStringToUrl(String String string;
        string) throws ViaCEPException {
            String out = null;

            // verifica está válido
            if (string != null && !string.isEmpty()) {
                try {
                    out = URLEncoder.encode(string, "utf-8");
                    out = out.replace("+", "%20"); // força espaço como %20
                } catch (UnsupportedEncodingException e) {
                    throw new ViaCEPException("Não foi possível codificar o valor solicitado!", UnsupportedEncodingException.class.getName());
                }
            } else {
                throw new ViaCEPException("Valor nulo ou vazio informado!", String.class.getName());
            }

            return out;
        }


    }
}







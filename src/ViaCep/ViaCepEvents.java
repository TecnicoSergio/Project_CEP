package ViaCep;

public interface ViaCepEvents {

    public void onCEPSuccess(ViaCEP cep);

    public void onCEPError(String cep);

    public default void ViaCepEvents(ViaCEP cep) {

    }
}

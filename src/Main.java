
import java.util.Scanner;

import ViaCep.ViaCEP;
import ViaCep.ViaCepEvents;
import ViaCep.ViaCEPException;


public class ViaCEPTest implements ViaCepEvents {

    @Override
    public void onCEPSuccess(ViaCEP cep) {

    }

    @Override
    public void onCEPError(String cep) {

    }

    public class Main {
        public static void main(String[] args) {
            new ViaCEPTest().run();

        }

        public void run() {
            ViaCEP viaCEP = new ViaCEP(this);
            String cep;
            Scanner scan = new Scanner(System.in);
            System.out.println(ViaCEPTest.class.getName() + "- digite sair para fechar o teste!! ");

            do {
                System.out.println("Digite um cep: ");
                cep = scan.next();
                if (!cep.equals("sair")) {
                    try {
                        viaCEP.buscar(cep);
                    } catch (ViaCEPException ex) {
                        System.out.println("Ocorreu um erro na classe " + ex.getClasse() + ": " + ex.getMessage());

                    }
                }
            } while (!cep.equals("sair"));
        }

        @Override
        public void onCEPSuccess(ViaCEP cep) {
            System.out.println();
            System.out.println("CEP " + cep.getCep() + "encontrado ");
            System.out.println("Logradouro " + cep.getLogradouro());
            System.out.println("Complemento " + cep.getComplemento());
            System.out.println("Bairro " + cep.getBairro());
            System.out.println("Localidade " + cep.getLocalidade());
            System.out.println("Uf " + cep.getUf());
            System.out.println("Gia " + cep.getGia());
            System.out.println("Ibge " + cep.getIbge());
            System.out.println();

        }

        @Override
        public void onCEPError(String cep) {
            System.out.println();
            System.out.println("Não foi possivel encontrar o CEP " + cep + "!");
            System.out.println();

        }
    }

    private void run() {
    }

}


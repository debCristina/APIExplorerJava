import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaApi {

    public CepInfo requisicao (String cep) throws InterruptedException, IOException, ErroCepInvalido {

        if (cep.length() < 8) {
            throw new ErroCepInvalido ("Erro: O CEP não é válido");
        }
        String endereco = "https://viacep.com.br/ws/"+ cep +"/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CepInfo.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter informações do CEP");
        }

    }

}

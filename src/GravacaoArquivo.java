import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GravacaoArquivo {

    public void gerarArquivo (CepInfo cepInfo) throws IOException {
        FileWriter escrita = new FileWriter(cepInfo.cep() +".json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escrita.write(gson.toJson(cepInfo));
        escrita.close();
    }
}

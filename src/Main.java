import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ErroCepInvalido {
        ConsultaApi consulta = new ConsultaApi();
        Scanner scanner = new Scanner(System.in);
        List<CepInfo> consultas= new ArrayList<>();

        int opcaoUsuario =0;
        while (opcaoUsuario != 1){
            System.out.println("");
            System.out.println("Deseja realizar uma busca?");
            System.out.println("[0] Sim");
            System.out.println("[1] Não");
            opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            if (opcaoUsuario == 1) {
                break;
            }

            System.out.println("Digite um CEP para consulta: ");
            var cep = scanner.nextLine();

            try {
                CepInfo novoCepinfo = consulta.requisicao(cep);
                System.out.println(novoCepinfo);
                GravacaoArquivo gravacao = new GravacaoArquivo();
                gravacao.gerarArquivo(novoCepinfo);
            }catch (ErroCepInvalido e) {
                System.out.println(e.getMessage());
            }catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação");
            }
        }
    }
}
public class ErroCepInvalido extends Throwable {
    private String mensagem;
    public ErroCepInvalido(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}

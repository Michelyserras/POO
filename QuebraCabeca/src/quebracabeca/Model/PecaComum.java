package quebracabeca.Model;

public class PecaComum extends Peca{

    public PecaComum(String descricao, Borda[] bordas) {
        super(descricao, bordas);
    }

    @Override
    public boolean encaixaCom(Peca outra, int minhaBorda, int bordaOutra) {
        return this.getBorda(minhaBorda).encaixaCom(outra.getBorda(bordaOutra));
    }

}

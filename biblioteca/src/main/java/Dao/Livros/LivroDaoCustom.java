package Dao.Livros;

import Model.Usuario;
import Model.Livro;

public interface LivroDaoCustom {

    public boolean devolver(Usuario user);
    public boolean isAtrasado(Livro livro);
    public boolean empresta(Usuario user, int prazoMax);
    public boolean isDisponivel(Livro livro);
    public boolean isBloqueado(Livro livro);
    public boolean bloqueia(Usuario user, int prazo);
    public boolean desbloqueia(Usuario user);
}

package Dao.Usuarios;

import Model.Livro;

public interface UsuarioDaoCustom {
    public boolean prazoVencido();
    public boolean emprestarLivro(Livro livro);
    public boolean devolverLivro(Livro livro);
    
}

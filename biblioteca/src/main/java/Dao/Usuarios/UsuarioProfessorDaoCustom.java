package Dao.Usuarios;

import Model.Livro;

public interface UsuarioProfessorDaoCustom {
    public boolean bloqueiaLivro(Livro it, int prazo);
    public boolean desbloqueiaLivro(Livro it);
   
}

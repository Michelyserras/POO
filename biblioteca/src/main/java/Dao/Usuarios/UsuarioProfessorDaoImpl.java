package Dao.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;

import Dao.Livros.LivroDaoImpl;
import Model.Livro;
import Model.UsuarioProfessor;

public class UsuarioProfessorDaoImpl implements UsuarioProfessorDaoCustom {

    @Autowired
    private LivroDaoImpl livroRepo;
    private UsuarioProfessor user;

    @Override
    public boolean bloqueiaLivro(Livro it, int prazo){
        return(livroRepo.bloqueia(user, prazo));
    }
    
    @Override
    public boolean desbloqueiaLivro(Livro it){
        return (livroRepo.desbloqueia(user));
    }
   
    
}

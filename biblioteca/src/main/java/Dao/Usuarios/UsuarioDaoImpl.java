package Dao.Usuarios;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Model.Livro;
import Model.Usuario;
import Dao.Livros.LivroDaoImpl;

public class UsuarioDaoImpl implements UsuarioDaoCustom{

    @Autowired
    private Usuario user;

    @Autowired
    private LivroDaoImpl livroRepo;

    public UsuarioDaoImpl(LivroDaoImpl livroRepo){
        this.livroRepo = livroRepo;
    }


    @Override
    public boolean prazoVencido() {
        Livro livro;
        Enumeration lista = Collections.enumeration(user.getLivros());
        
        while(lista.hasMoreElements()){
            livro = (Livro)lista.nextElement();
            if(livroRepo.isAtrasado(livro)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean emprestarLivro(Livro livro) {
        if(podeRetirar()){
            if(livroRepo.empresta(user, user.getPrazoMaximo())){
                user.addLivro(livro.getId(), livro);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean devolverLivro(Livro livro) {
        if(livroRepo.devolver(user)){
            user.removeLivro(livro.getId());
            return true;
        }else{
            return false;
        }

    }

    private boolean precisaDevolver(){
        return((user.getLivros().size() >= user.getPrazoMaximo()|| prazoVencido()) ?  true : false);
    }
    
    public boolean podeRetirar(){
        return (!precisaDevolver());
    }
    

    
}

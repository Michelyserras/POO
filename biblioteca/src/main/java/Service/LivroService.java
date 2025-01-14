package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.Livros.LivroDao;
import Dao.Livros.LivroDaoImpl;
import Model.Livro;
import jakarta.validation.Valid;

@Service
public class LivroService {

    @Autowired
    private LivroDao livroRepo;

    public Livro cadastrarLivro(String nome, String tipo) {
        Livro livro;
        if (nome.isEmpty() || tipo.isEmpty()) {
            throw new IllegalArgumentException("Tipo inválido. Use 1 para Livro e 2 para Periódico.");
        } else{
            livro = new Livro(nome, tipo);
        }

        return livroRepo.save(livro);
    }

    public List<Livro> listarLivros() {
        return (List<Livro>) livroRepo.findAll();
    }

    public Livro updateLivro(Livro livro){
        livro = livroRepo.findById(livro.getId()).get();
        if(livro !=  null){
           return livroRepo.save(livro);
        }else{
            throw new Error("Livro não encontrado");
        }

    }
    
    public void excluirLivro(Integer id) {
       Livro livro = livroRepo.findById(id).get();
        if (livro != null) {
            livroRepo.delete(livro);
        } else {
            throw new IllegalArgumentException("Não foi possível excluir o livro!");
        }
    }
}

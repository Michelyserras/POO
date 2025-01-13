package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.Livros.LivroDao;
import Dao.Livros.LivroDaoImpl;
import Model.Livro;
import Model.Periodico;
import jakarta.validation.Valid;

@Service
public class LivroService {

    @Autowired
    private LivroDao livroRepo;

    public Livro cadastrarLivro(String nome, int tipo) {
        Livro livro;
        if (tipo == 1) {
            livro = new Livro(nome);
        } else if (tipo == 2) {
            livro = new Periodico(nome);
        } else {
            throw new IllegalArgumentException("Tipo inválido. Use 1 para Livro e 2 para Periódico.");
        }
        return livroRepo.save(livro);
    }

    public List<Livro> listarLivros() {
        return (List<Livro>) livroRepo.findAll();
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

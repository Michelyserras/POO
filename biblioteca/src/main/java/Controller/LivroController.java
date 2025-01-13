package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Model.Livro;
import Model.Usuario;
import Service.LivroService;
import jakarta.validation.Valid;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }
    
    @GetMapping("/index")
    public String showBookList(Model model) {
        model.addAttribute("livros", livroService.listarLivros()); 
        return "index";
    }

    @PostMapping("/adicionarBook")
    public String cadastrarLivro(@Valid String nome, @Valid int tipo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book"; // Retorna à página de adição em caso de erro
        } else {
            livroService.cadastrarLivro(nome, tipo); // Salva o livro no banco de dados
            return "redirect:/index"; // Redireciona para a página de listagem
        }
    }

    @GetMapping("/addBook")
    public String mostrarFormularioAdicaoLivro(Model model) {
        model.addAttribute("livro", new Livro("Titulo inicial")); // Adiciona um novo objeto Livro ao modelo
        return "add-book";
    }

}

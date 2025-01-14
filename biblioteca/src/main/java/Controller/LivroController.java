package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.Livro;
import Service.LivroService;

@Controller
@RequestMapping("/livros") // Prefixo comum para todas as rotas deste controlador
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Rota para exibir a página inicial com a lista de livros
    @GetMapping
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarLivros());
        return "index"; // Nome do arquivo HTML (src/main/resources/templates/index.html)
    }

    // Rota para exibir o formulário de adição de um novo livro
    @GetMapping("/novo")
    public String mostrarFormularioAdicaoLivro(Model model) {
        model.addAttribute("livro", new Livro()); // Cria um objeto Livro vazio para o formulário
        return "add-book"; // Nome do arquivo HTML (src/main/resources/templates/add-book.html)
    }

    // Rota para processar o formulário de adição de livro
    @PostMapping
    public String cadastrarLivro(Livro livro) {
        livroService.cadastrarLivro(livro.getTitulo(), livro.getTipo());
        return "redirect:/livros"; // Redireciona para a listagem de livros
    }
}

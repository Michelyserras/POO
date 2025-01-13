package Dao.Livros;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Model.Livro;

@Repository
public interface LivroDao extends CrudRepository<Livro, Integer>, LivroDaoCustom{
    
}

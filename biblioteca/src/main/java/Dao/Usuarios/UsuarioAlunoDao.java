package Dao.Usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Model.UsuarioAluno;

@Repository
public interface UsuarioAlunoDao extends CrudRepository<UsuarioAluno, Integer>{
    
}

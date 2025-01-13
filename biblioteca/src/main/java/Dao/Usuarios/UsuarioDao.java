package Dao.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Model.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer>, UsuarioDaoCustom {
    
}

package Dao.Usuarios;

import org.springframework.data.repository.CrudRepository;

import Model.UsuarioProfessor;

public interface UsuarioProfessorDao extends CrudRepository<UsuarioProfessor, Integer>, UsuarioProfessorDaoCustom{
    
}

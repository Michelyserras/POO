package Dao.Livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Model.Livro;
import Model.Usuario;
import Model.UsuarioProfessor;

@Repository
public class LivroDaoImpl implements LivroDaoCustom{

    @Autowired
    private Livro livro;

    @Override
    public boolean devolver(Usuario user) {
        if(user == livro.getRetiradoPor()){
            livro.setRetiradoPor(null);
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean isAtrasado(Livro livro) {
        Date hoje = new Date();
        return (isEmprestado(livro) && livro.getDtDevolucao().before(hoje));
    }

    private boolean isEmprestado(Livro livro){
        return(!(livro.getRetiradoPor() == null));
    }

    @Override
    public boolean empresta(Usuario user, int prazoMax) {
        GregorianCalendar cal = new GregorianCalendar();

        if(isDisponivel(livro)){
            livro.setRetiradoPor(user); 
            livro.setDtEmprestimo(cal.getTime());
            cal.add(Calendar.DATE, user.getPrazoMaximo());
            return true;
        }else{
            return false;
        }
    }   

    @Override
    public boolean isDisponivel(Livro livro){
        Date hoje = new Date();
        return (livro.getRetiradoPor() == null && livro.getBloqueadoPor() == null
            || livro.getDtDesbloqueio().before(hoje));
    }

    @Override
    public boolean isBloqueado(Livro livro) {
        Date hoje =  new Date();
        return(livro.getRetiradoPor() == null &&
                !(livro.getBloqueadoPor() == null) &&
                !(livro.getDtDesbloqueio().before(hoje)));
    }

    @Override
    public boolean bloqueia(Usuario user, int prazo) {
        GregorianCalendar cal = new GregorianCalendar();

        if(isDisponivel(livro) && user.isProfessor()){
            livro.setBloqueadoPor(user);
            livro.setDtBloqueio(cal.getTime());
            cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));
            livro.setDtDesbloqueio(cal.getTime());
            return (true);
        } else{
            return false;
        }
    }

    @Override
    public boolean desbloqueia(Usuario user) {
        if(livro.getBloqueadoPor() == user){
            livro.setBloqueadoPor(null);
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean emprestaPeriodico(UsuarioProfessor u, int prazo){
        if(u.isProfessor()){
            return (empresta(u, 7));
        }
        return (false);
    }
}

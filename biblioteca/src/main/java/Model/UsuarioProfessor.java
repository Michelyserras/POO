package Model;

public class UsuarioProfessor extends Usuario {
    public UsuarioProfessor(String nome) {
        super(nome);
    }
    
    
    @Override
    public int getQtdMaxima(){
        return 5;
    }
    
    @Override
    public int getPrazoMaximo(){
        return 14;
    }
    
    @Override
    public boolean isProfessor(){
        return (true);
    }
    
}

package quebracabeca.Model;


public class Borda {
    private boolean[] espacos; 

    public Borda(boolean[] espacos) {
        if (espacos.length != 2) {
            System.out.println("Uma borda deve ter exatamente dois espaços.");
        }
        this.espacos = espacos;
    }

    public boolean[] getEspacos() {
        return espacos;
    }

    public boolean encaixaCom(Borda outra) {
        return (this.espacos[0] != outra.getEspacos()[0]) && 
               (this.espacos[1] != outra.getEspacos()[1]);
    }

    public void exibir(){
        System.out.println("[" + (espacos[0] ? "Preenchido" : "Vazio") + ", " + (espacos[1] ? "Preenchido" : "Vazio") + "]"); 
    }
}

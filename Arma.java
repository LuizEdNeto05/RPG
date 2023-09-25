import java.util.Random;

public class Arma {
    String categoria;
    int danoConstante;

    public Arma()
    {
        this.categoria = " ";
        this.danoConstante = 0;
    }

    public Arma(String categoria, int danoConstante)
    {
        this.categoria = categoria;
        this.danoConstante = danoConstante;
    }

    public void setCategoria(String categoria)
    {
        if(categoria.length()>0) {
            this.categoria = categoria;
        } 
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setdanoConstante(int danoConstante)
    {
        if(danoConstante>0)
        {
            this.danoConstante=danoConstante;
        }
    }

    public int getdanoConstante(){
        return danoConstante;
    }

    // Função para sortear um número entre 1 e 4
    public static int dado4() {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

    // Função para sortear um número entre 1 e 6
    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Função para sortear um número entre 1 e 12
    public static int dado12() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }

    public static double ArmaLeve(int destreza, int danoConstante){
        double danoArmaLeve = danoConstante + dado4() + dado4() + dado4() + destreza;
        return danoArmaLeve;
    }

    public static double ArmaPesada(int forca, int danoConstante){
        double danoArmaPesada = danoConstante + dado12() + (1.5*forca);
        return danoArmaPesada;
    }
}

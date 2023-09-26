import java.util.Random;
import java.util.Scanner;

public class Jogador {
   private String nome;
   public int pv;
   public int forca;
   public int constituicao;
   public int constituicao2;
   public int agilidade;
   public int destreza;
   private Arma arma;
   private Armadura armadura;
   int dado;

    public Jogador(){
    
    this.nome=" ";
    this.pv=0;
    this.forca=0;
    this.constituicao=0;
    this.constituicao2=0;
    this.agilidade=0;
    this.destreza=0;

    }

    // Função para sortear um número entre 1 e 6
    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public Jogador(String nome, int pv, int constituicao, int forca,int agilidade, int destreza, Arma arma, Armadura armadura)
    {
        setNome(nome);
        setPv(pv);
        setForca(forca);
        setConstituicao(constituicao);
        setAgilidade(agilidade);
        setDestreza(destreza);
        

    }


    public void setNome(String nome)
    {
        if(nome.length()>0) {
            this.nome = nome;
        } 

    }

    public String getNome() 
    {
        return nome;
    }

    public void setPv(int pv)
    {
        if(pv>0){
            this.pv=pv;
        }

    }

    public int getPv()
    {
        int pv = dado6() + dado6() + dado6() + constituicao;
        return pv;
    }

    public void setForca(int forca)
    {
        if(forca > 0)
        {
            this.forca=forca;
        }
    }

    public int getForca()
    {
        return forca;
    }

    public void setConstituicao(int constituicao)
    {
        if(constituicao > 0)
        {
            this.constituicao=constituicao;
        }
    }

    public int getConstituicao()
    {
        return constituicao;
    }

    public void setAgilidade(int agilidade)
    {
        if(agilidade > 0)
        {
            this.agilidade=agilidade;
        }
    }

    public int getAgilidade()
    {
        return agilidade;
    }

    public void setDestreza(int destreza)
    {
        if(destreza > 0)
        {
            this.destreza=destreza;
        }
    }

    public int getDestreza()
    {
        return destreza;
    }
    

    public void DistribuirPontos(int i) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Você possui 15 pontos para distribuir.");
        System.out.println("1. Força: " + forca);
        System.out.println("2. Constituição: " + constituicao);
        System.out.println("3. Agilidade: " + agilidade);
        System.out.println("4. Destreza: " + destreza);

        int loop=1;
        while(loop==1){
        
        forca= getForca();
        constituicao = getConstituicao();
        agilidade = getAgilidade();
        destreza = getDestreza();
        
        int pontos = 0;
        if (i==1) {
            pontos = 15;
        } else if (i==2) {
            pontos = 5;
        }
        

        System.out.println("Insira a quantidade para Força:");
        int escolhaForca = scanner.nextInt();
        pontos -= escolhaForca;
        forca  = escolhaForca + getForca();
            
        System.out.println("Restam "+ pontos +" pontos");

        System.out.println("Insira a quantidade para Constituição:");
        int escolhaConstituicao = scanner.nextInt();
        pontos -= escolhaConstituicao;
        constituicao = escolhaConstituicao + getConstituicao();

        System.out.println("Restam "+ pontos +" pontos");

        System.out.println("Insira a quantidade para Agilidade:");
        int escolhaAgilidade = scanner.nextInt();
        pontos -= escolhaAgilidade;
        agilidade = escolhaAgilidade + getAgilidade();

        System.out.println("Restam "+ pontos +" pontos");

        System.out.println("Insira a quantidade para Destreza:");
        int escolhaDestreza = scanner.nextInt();
        pontos -= escolhaDestreza;
        destreza = escolhaDestreza + getDestreza();
            
            if(pontos>0)
            {
                System.out.println("Ainda restaram pontos, utilize todos!");
                continue;
            }

        System.out.println("1. Força: " + forca);
        System.out.println("2. Constituição: " + constituicao);
        System.out.println("3. Agilidade: " + agilidade);
        System.out.println("4. Destreza: " + destreza);
        
        System.out.println("Deseja alterar ou manter?");
        System.out.println("1) Alterar 2) Manter");

        int escolha = scanner.nextInt();

        if(escolha == 1){

        }else if(escolha == 2){
            break;
        }else{
            System.out.println("Escolha inválida");
        }

        }
                    
    //scanner.close();
    }
}

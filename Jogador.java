import java.util.Scanner;

public class Jogador {
   private String nome;
   private int pv;
    int forca;
    int constituicao;
    int agilidade;
    int destreza;
    Arma arma;
    Armadura armadura;


    public Jogador(){
    
    this.nome=" ";
    this.pv=0;
    this.forca=0;
    this.constituicao=0;
    this.agilidade=0;
    this.destreza=0;

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



    public void distribuirPontos() {
        Scanner scanner = new Scanner(System.in);

        

        int pontos = 15;

        System.out.println("Distribuição de Pontos:");
        System.out.println("Você possui " + pontos + " pontos para distribuir.");
            System.out.println("Pontos restantes: \n" + pontos);
            System.out.println("1. Força: " + forca);
            System.out.println("2. Constituição: " + constituicao);
            System.out.println("3. Agilidade: " + agilidade);
            System.out.println("4. Destreza: " + destreza);

        while (true) {

            forca= 0;
            constituicao = 0;
            agilidade = 0;
            destreza =0;

            pontos =15;

            System.out.println("Insira a quantidade para Força");
            int escolhaForca = scanner.nextInt();
            pontos -= escolhaForca;
            forca  += escolhaForca;

            int escolha;

            System.out.println("Você possui " + pontos + " pontos para distribuir.");
                 
            System.out.println("Insira a quantidade para Constituição");
            int escolhaConstituicao = scanner.nextInt();
            pontos -= escolhaConstituicao;
            constituicao += escolhaConstituicao;

            System.out.println("Você possui " + pontos + " pontos para distribuir.");

            System.out.println("Insira a quantidade para Agilidade");
            int escolhaAgilidade = scanner.nextInt();
            pontos -= escolhaAgilidade;
            agilidade += escolhaAgilidade;

            System.out.println("Você possui " + pontos + " pontos para distribuir.");

            System.out.println("Insira a quantidade para Destreza");
            int escolhaDestreza = scanner.nextInt();
            pontos -= escolhaDestreza;
            destreza += escolhaDestreza;

            System.out.println("Distribuição de Pontos:");
            System.out.println("Você possui " + pontos + " pontos para distribuir.");
            System.out.println("Pontos restantes: \n" + pontos);
            System.out.println("1. Força: " + forca);
            System.out.println("2. Constituição: " + constituicao);
            System.out.println("3. Agilidade: " + agilidade);
            System.out.println("4. Destreza: " + destreza);

            System.out.println("Deseja alterar ou manter?");
            System.out.println("1) Alterar 2) Manter");

            escolha = scanner.nextInt();

            if(escolha == 1)
            {

            }else if(escolha == 2)
            {
                break;
            }else{
                System.out.println("Escolha inválida");

            }
            




            }

            

            

            
            scanner.close();
         
         
        }

        
    }





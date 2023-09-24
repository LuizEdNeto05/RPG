import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RPG {

    public static void limparTela() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
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

    public static void main (String args[])
    {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner nome = new Scanner(System.in);
        String player;
        
        //List<Inimigo> inimigos1 = new ArrayList<>(); 
         
        //Menu
        System.out.println("                                                            ");
        System.out.println("                                                            ");
        System.out.println("                  Menu principal                            "); //DESIGN A SER DEFINIDO
        System.out.println("                                                            ");
        System.out.println("                                                            ");
        System.out.println("\n\n\n");
        System.out.println("1) Novo Jogo");
        System.out.println("2) Lore");
        System.out.println("3) Sair");
        int escolhaMenu = scanner1.nextInt();
        
        if(escolhaMenu==1){
        limparTela();
        
        //Input nome
        System.out.println("Olá herói! Me diga, qual é o seu nome?");
        player = nome.nextLine();
        Jogador jogador = new Jogador(player,100, 0,0,0,0,new Arma(),new Armadura());

        //Atribuir pontos
        System.out.println("Olá "+jogador.getNome()+"! Quais são as suas halibidades?");       
        jogador.distribuirPontos();
        
        //Escolher arma
        Arma rapieira = new Arma("Arma Leve", 15); //rever o dano constante
        Arma machado = new Arma("Arma pesada", 30); //rever o dano constante
        System.out.println("Agora escolha sua arma:");
        System.out.println("1) Rapieira "+rapieira.getCategoria()+" 2) Machado "+machado.getCategoria());
        int escolhaArma = scanner2.nextInt();

        //->Definição do dano da arma
        double danoJogador=0;
        if (escolhaArma==1) {
            danoJogador = Arma.ArmaLeve(jogador.destreza);
            System.out.println("Sua arma causa "+danoJogador+" de dano");
            
        }else if (escolhaArma==2) {
            danoJogador = Arma.ArmaPesada(jogador.forca);
            System.out.println("Sua arma causa "+danoJogador+" de dano");
            
        }

        //Definição da defesa da Armadura
        double defesaJogador= Armadura.ArmaduraSimples(jogador.constituicao);

        //Exibição dos status do Jogador
        System.out.println("Status de "+jogador.getNome());
        System.out.println("Vida: "+jogador.pv);
        System.out.println("Defesa: "+defesaJogador);
        System.out.println("Dano: " +danoJogador);
        System.out.println("Agilidade: " +jogador.agilidade);
        

        //Combate 1



        /*}else if(x == 2){      
            System.out.println("Lore"); //LORE A SER DEFINIDA
        }else if(x==3){

        }
        */ 
        scanner1.close();
        scanner2.close();
        nome.close();

    }
}
}
    
     /*public static Inimigo sortearInimigoAleatorio(List<Inimigo> inimigos) {
        Random random = new Random();
        int indice = random.nextInt(inimigos.size());
        return inimigos.get(indice);
    }*/

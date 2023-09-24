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
        int cura = 3, curainimigo =3;
        Random rand = new Random();
        
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
        Jogador jogador = new Jogador(player,0, 0,0,0,0,new Arma(),new Armadura());

        limparTela();

        //Atribuir pontos
        System.out.println("Olá "+jogador.getNome()+"! Quais são as suas halibidades?");       
        jogador.distribuirPontos();
        
        limparTela();
        
        //Escolher arma
        Arma rapieira = new Arma("Arma Leve", 15); //rever o dano constante
        Arma machado = new Arma("Arma pesada", 30); //rever o dano constante
        System.out.println("Agora escolha sua arma:");
        System.out.println("1) Rapieira "+rapieira.getCategoria()+" 2) Machado "+machado.getCategoria());
        int escolhaArma = scanner2.nextInt();

        limparTela();
        
        //->Definição do dano da arma
        double danoJogadorLeve=0, danoJogadorPesado =0;
        if (escolhaArma==1) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.destreza);
            System.out.println("Sua arma causa "+danoJogadorLeve+" de dano");
            
        }else if (escolhaArma==2) {
            danoJogadorPesado = Arma.ArmaPesada(jogador.forca);
            System.out.println("Sua arma causa "+danoJogadorPesado+" de dano");
            
        }

        //Definição da defesa da Armadura
        double defesaJogador = Armadura.ArmaduraSimples(jogador.constituicao);

        //Exibição dos status do Jogador
        System.out.println("Status de "+jogador.getNome());
        
        System.out.println("Defesa: "+defesaJogador);
        System.out.println("Dano: " +danoJogadorLeve);
        System.out.println("Agilidade: " +jogador.agilidade);
        limparTela();

        jogador.pv = jogador.getPv();
        

        //Combate 1
        Inimigo Goblin = new Inimigo("Goblin",100, 30, 5, 5);

        Scanner acao = new Scanner(System.in);
        int agir;
        while (true){
            if(jogador.agilidade>Goblin.inimigoAgilidade){
                System.out.println("Goblin: "+ Goblin.inimigoVida);
                System.out.println(""+jogador.getNome() +jogador.pv);
                agir = acao.nextInt();

                if(agir == 1)
                {
                    double danototal = danoJogadorLeve - Goblin.inimigoDefesa;
                    Goblin.inimigoVida -= danototal;

                }else if(agir == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou");
                }else if(agir == 3)
                {
                    
                    if(cura>0)
                    {
                        
                    int curaTotal = dado6() + dado6() + dado6();
                    jogador.pv += curaTotal;
                    cura --;
                    }else if(cura <= 0){
                        System.out.println("voce n tem mais cura");

                    }
                    

                }
                int escolhaInimigo = rand.nextInt(3) + 1;

                if(escolhaInimigo == 1)
                {
                    int danoNpc = dado6() + dado6() + dado6() + 5;
                    double danoNPC = danoNpc - defesaJogador;
                    jogador.pv -= danoNPC;
                }else if(escolhaInimigo == 2)
                {
                    int def = Goblin.inimigoDefesa * 2;
                    System.out.println("Defesa aumentada para: "+def);
                }else if(escolhaInimigo == 3)
                {
                    if(curainimigo>0)
                    {
                        
                    int curaEnemy = dado6() + dado6() + dado6();
                    jogador.pv += curaEnemy;
                    curainimigo --;
                    }else if(cura <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");

                    }
                }


                if(Goblin.inimigoVida <= 0 || jogador.pv<=0)
                {
                    break;
                }

            }
        }

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

/*public void acoesPersonagem()
    {
        int acao;
        Scanner agir = new Scanner(System.in);
        int cura = 3;


        System.out.println("É a sua vez, o que deseja fazer?\n");
        System.out.println("1) Atacar\n 2) Defender\n 3) Curar\n");

        acao = agir.nextInt();

        if(acao == 1)
        {
            Goblin.inimigoVida -= ArmaLeve(); ;
        }
    } */
}
    
     /*public static Inimigo sortearInimigoAleatorio(List<Inimigo> inimigos) {
        Random random = new Random();
        int indice = random.nextInt(inimigos.size());
        return inimigos.get(indice);
    }*/

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
         Scanner scanner1;
         Scanner scanner2;
         Scanner scanner3;
         Scanner scanner4;
         Scanner nome;
         int escolhaMenu;
        
        while(true){
        scanner1 = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        scanner3 = new Scanner(System.in);
        scanner4 = new Scanner(System.in);
        nome = new Scanner(System.in);
        String player;
        Random rand = new Random();

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
        escolhaMenu = scanner1.nextInt();
        
        if(escolhaMenu==1){
        limparTela();
        
        //Input nome
        System.out.println("Olá herói! Me diga, qual é o seu nome?");
        player = nome.nextLine();
        Jogador jogador = new Jogador(player,0, 0,0,0,0,new Arma(),new Armadura());

        limparTela();
    
        //Atribuir pontos
        System.out.println("Olá "+jogador.getNome()+"! Quais são as suas halibidades?");       
        jogador.DistribuirPontos(1);
        
        limparTela();
        
        /*Escolher arma
        Arma porrete = new Arma("(Arma Leve)\n", 10); 
        Arma faca = new Arma("(Arma Leve)\n", 10);
        Arma machado = new Arma("(Arma pesada)", 20); 
        System.out.println("Agora escolha sua arma:");
        System.out.println("1) Porrete "+porrete.getCategoria()+" 2) Faca "+faca.getCategoria()+" 3) Machado "+machado.getCategoria());
        int escolhaArma = scanner2.nextInt();
        */
        limparTela();
        
        //->Definição do dano da arma
        double danoJogador =0, danoJogadorLeve=0, danoJogadorPesado =0;
        /*
        if (escolhaArma==1) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.destreza, porrete.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;          
        }else if (escolhaArma==2) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.destreza, faca.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;
        }else if (escolhaArma==3) {
            danoJogadorPesado = Arma.ArmaPesada(jogador.forca, machado.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorPesado+" de dano");
            danoJogador += danoJogadorPesado;
        }*/

        //Escolher armadura
        Armadura ladrão = new Armadura(jogador.constituicao);
        Armadura couro = new Armadura(jogador.constituicao);
        Armadura malha = new Armadura(jogador.constituicao);
        System.out.println("Agora escolha sua armadura:");
        System.out.println("1) Armadura de ladrão   2) Armadura de Couro   3) Armadura de malha");
        int escolhaArmadura = scanner3.nextInt();

        //Definição armadura
        double defesaJogador =0;
        if (escolhaArmadura==1) {
            defesaJogador = Armadura.Armadura(jogador.constituicao);
            System.out.println("Sua defesa é: "+defesaJogador);
        }else if (escolhaArmadura==2) {
            defesaJogador = Armadura.Armadura(jogador.constituicao);
            System.out.println("Sua defesa é: "+defesaJogador);
        }else if (escolhaArmadura==3) {
            defesaJogador = Armadura.Armadura(jogador.constituicao);
            System.out.println("Sua defesa é: "+defesaJogador);
        }      

        limparTela();

        jogador.pv = jogador.getPv();
        int vida = jogador.pv;

        //Exibição dos status do Jogador
        System.out.println("Status de "+jogador.getNome());
        System.out.println("Vida: "+jogador.pv);
        System.out.println("Defesa: "+defesaJogador);
        System.out.println("Dano: " +danoJogador);
        System.out.println("Agilidade: " +jogador.agilidade);

        int cura = 3, curainimigo =3, cura2 = 3, curainimigo2 =3;

        //Lista de Inimigos combate 1
        List<Inimigo> inimigos1 = new ArrayList<>(); 
        inimigos1.add(new Inimigo("Goblin Verde", 20, 30, 5,5));
        inimigos1.add(new Inimigo("Grande ogro", 40, 50, 5, 3));
        inimigos1.add(new Inimigo("Esqueleto alto", 30, 5, 4, 6));
        Inimigo inimigo = inimigos1.get(rand.nextInt(inimigos1.size()));

        //Combate 1 
        System.out.println("Os 3 inimigos tiram zerinho ou um para decidir quem vai te enfrentar");
        System.out.println("e foi definido que o seu adversário será o " +inimigo.getinimigoNome()); 
        while (true){
            Scanner acao = new Scanner(System.in);
            int agir;       

            //Combate para agilidade do jogador maior
            if(jogador.agilidade>inimigo.inimigoAgilidade){
                System.out.println(inimigo.getinimigoNome()+ inimigo.inimigoVida);
                System.out.println(""+jogador.getNome() +jogador.pv);
                agir = acao.nextInt();

                if(agir == 1)
                {
                    double danototal = danoJogador - inimigo.inimigoDefesa;
                    
                    inimigo.inimigoVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                }else if(agir == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
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
                    double danoInimigo2 = dado6() + dado6() + dado6() + 5;
                    danoInimigo2 = danoInimigo2 - defesaJogador;
                    jogador.pv -= danoInimigo2;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo2);
                }else if(escolhaInimigo == 2)
                {
                    int def = inimigo.inimigoDefesa * 2;
                    System.out.println("Defesa aumentada para: "+def);
                }else if(escolhaInimigo == 3)
                {
                    if(curainimigo>0)
                    {
                        
                    int curaEnemy = dado6() + dado6() + dado6();
                    inimigo.inimigoVida += curaEnemy;
                    curainimigo --;
                    System.out.println("Seu inimigo recuperou de em: " +curaEnemy);
                    }else if(cura <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");

                    }
                }


                if(inimigo.inimigoVida <= 0 || jogador.pv<=0)
                {
                    break;
                }

            }
            //combate para agilidade do inimigo maior
            else if(jogador.agilidade<inimigo.inimigoAgilidade){
                System.out.println(inimigo.getinimigoNome()+ inimigo.inimigoVida);
                System.out.println(""+jogador.getNome() +jogador.pv);

               int escolhaInimigo = rand.nextInt(3) + 1;             

                if(escolhaInimigo == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + 5;
                    danoInimigo = danoInimigo - defesaJogador;
                    jogador.pv -= danoInimigo;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo == 2){
                    int def = inimigo.inimigoDefesa * 2;
                    System.out.println("Defesa aumentada para: "+def);
                }else if(escolhaInimigo == 3){
                    if(curainimigo>0){                      
                    int curaEnemy = dado6() + dado6() + dado6();
                    inimigo.inimigoVida += curaEnemy;
                    curainimigo --;
                    System.out.println("Seu inimigo recuperou de em: " +curaEnemy);
                    }else if(cura <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");
                    }
                }
                System.out.println(inimigo.getinimigoNome()+ inimigo.inimigoVida);
                System.out.println(""+jogador.getNome() +jogador.pv);

                agir = acao.nextInt();

                if(agir == 1){
                    double danototal = danoJogador - inimigo.inimigoDefesa;
                    
                    inimigo.inimigoVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                }else if(agir == 2){
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                }else if(agir == 3){                   
                    if(cura>0){                      
                    int curaTotal = dado6() + dado6() + dado6();
                    jogador.pv += curaTotal;
                    cura --;
                    }else if(cura <= 0){
                        System.out.println("voce n tem mais cura");
                    }         
                }

                if(inimigo.inimigoVida <= 0 || jogador.pv<=0){
                    break;
                }
            }
        }

        limparTela();
        inimigo.inimigoVida=0;

        //Pós-combate 1
        if (inimigo.inimigoVida<=0) 
        {
            System.out.println("Parabéns! Você concluiu o primeiro combate");
            System.out.println("Subiu para o nível 2!");
            System.out.println("Mais 5 pontos para atributos!");

            jogador.DistribuirPontos(2);

            //Nova vida Jogador
            System.out.println("Sua vida aumentou!");
            jogador.pv = vida + jogador.getConstituicao();
            System.out.println("Sua nova vida é: "+jogador.pv);

            //Escolha da nova arma
            System.out.println("Novas Armas podem ser escolhidas!");
            Arma rapieira = new Arma("(Arma Leve)\n", 20); 
            Arma claymore = new Arma("(Arma pesada)\n", 30);
            Arma berdiche = new Arma("(Arma pesada)", 30); 
            System.out.println("Agora escolha sua arma:");
            System.out.println("1) Rapieira "+rapieira.getCategoria()+" 2) Claymore "+claymore.getCategoria()+" 3) Berdiche "+berdiche.getCategoria());
            int escolhaArma2 = scanner4.nextInt();         

            //->Definição do dano da nova arma
            double danoJogadorLeve2=0, danoJogadorPesado2=0;
            if (escolhaArma2==1) {
                danoJogadorLeve2 = Arma.ArmaLeve(jogador.destreza, rapieira.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorLeve2+" de dano");
                danoJogador = danoJogadorLeve2;          
            }else if (escolhaArma2==2) {
                danoJogadorPesado2 = Arma.ArmaPesada(jogador.destreza, claymore.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorPesado2+" de dano");
                danoJogador = danoJogadorPesado2;
            }else if (escolhaArma2==3) {
                danoJogadorPesado2 = Arma.ArmaPesada(jogador.forca, berdiche.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorPesado2+" de dano");
                danoJogador = danoJogadorPesado2;
            }

        }

        //Lista de Inimigos combate 2
        List<Inimigo> inimigos2 = new ArrayList<>();
        inimigos2.add(new Inimigo("Golem de Pedra", 70, 60, 15,1));
        inimigos2.add(new Inimigo("Soldado Amaldiçoado", 60, 40, 10, 1));
        Inimigo inimigo2 = inimigos2.get(rand.nextInt(inimigos2.size()));

        //Combate 2
        System.out.println("Os 2 inimigos tiram zerinho ou um para decidir quem vai te enfrentar");
        System.out.println("e foi definido que o seu adversário será o " +inimigo2.getinimigoNome());
        while (true) {
            Scanner acao2 = new Scanner(System.in);
            int agir2;   
            
            //Combate para agilidade do jogador maior
            if(jogador.agilidade>inimigo2.inimigoAgilidade){
                System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigo2.inimigoVida);
                System.out.println(""+jogador.getNome()+" Vida: " +jogador.pv);
                System.out.println("1) Atacar   2) Defender   3)Curar");
                agir2 = acao2.nextInt();

                if(agir2 == 1)
                {
                    double danototal = danoJogador - inimigo2.inimigoDefesa;
                    
                    inimigo2.inimigoVida -= danototal;
                    System.out.println("-Voce causou :"+danototal);

                }else if(agir2 == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("-A defesa aumentou para:" +defesatotal);
                }else if(agir2 == 3){
                    
                    if(cura>0){
   
                    int curaTotal = dado6() + dado6() + dado6();
                    jogador.pv += curaTotal;
                    cura --;
                    System.out.println("-Curou: "+curaTotal);
                    }else if(cura <= 0){
                        System.out.println("-Voce não tem mais cura");
                    }
                    

                }
            
                int escolhaInimigo2 = rand.nextInt(3) + 1;

                if(escolhaInimigo2 == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + 5;
                    danoInimigo = danoInimigo - defesaJogador;
                    jogador.pv -= danoInimigo;
                    System.out.println("-Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.inimigoDefesa * 2;
                    System.out.println("-Inimigo aumentou defesa para: "+def2);
                }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                      
                        int curaEnemy2 = dado6() + dado6() + dado6();
                        inimigo2.inimigoVida += curaEnemy2;
                        curainimigo2 --;
                        System.out.println("-Seu inimigo recuperou se em: " +curaEnemy2);
                    }else if(cura <= 0){
                        System.out.println("-Inimigo tenta curar mas ele n tem mais cura");
                    }
                }
                if(inimigo2.inimigoVida <= 0 || jogador.pv<=0){
                    break;
                }
            }
                //Combate para agilidade do Inimigo maior
                else if(jogador.agilidade<inimigo2.inimigoAgilidade){
                    System.out.println(inimigo2.getinimigoNome()+ inimigo2.inimigoVida);
                    System.out.println(""+jogador.getNome() +jogador.pv);
                    
                    int escolhaInimigo2 = rand.nextInt(3) + 1;             

                    if(escolhaInimigo2 == 1){
                    double danoInimigo2 = dado6() + dado6() + dado6() + 5;
                    danoInimigo2 = danoInimigo2 - defesaJogador;
                    jogador.pv -= danoInimigo2;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo2);
                    }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.inimigoDefesa * 2;
                    System.out.println("Defesa aumentada para: "+def2);
                    }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                  
                        int curaEnemy2 = dado6() + dado6() + dado6();
                        inimigo2.inimigoVida += curaEnemy2;
                        curainimigo2 --;
                        System.out.println("Seu inimigo recuperou de em: " +curaEnemy2);
                    }else if(cura2 <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");
                    }
                    }

                    System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigo2.inimigoVida);
                    System.out.println(""+jogador.getNome()+" Vida: " +jogador.pv);

                    agir2 = acao2.nextInt();

                    if(agir2 == 1)
                    {
                    double danototal = danoJogador - inimigo2.inimigoDefesa;
                    
                    inimigo2.inimigoVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                    }else if(agir2 == 2)
                    {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                    }else if(agir2 == 3)
                    {
                    
                    if(cura>0)
                    {
                        
                    int curaTotal = dado6() + dado6() + dado6();
                    jogador.pv += curaTotal;
                    cura --;
                    System.out.println("-Curou: "+curaTotal);
                    }else if(cura <= 0){
                        System.out.println("Voce não tem mais cura");
                    }
                    

                    }

                    if(inimigo.inimigoVida <= 0 || jogador.pv<=0)
                    {
                    break;
                    }

            }
        }

        }else if(escolhaMenu == 2){      
            System.out.println("Lore"); //LORE A SER DEFINIDA
        }else if(escolhaMenu==3){

            break;
              

        }
        
        
       
    }
             scanner1.close();
              scanner2.close();
              nome.close();
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

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
         Scanner nome;
         int escolhaMenu;
        
        while(true){
        scanner1 = new Scanner(System.in);
        nome = new Scanner(System.in);
        Pocao pocaoCura = new Pocao(0);

        
        
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
        
        int jogadorVida;                   
        jogadorVida = jogador.getPv();
        jogador.setPv(jogadorVida);
        System.out.println(jogadorVida);

        limparTela();
    
        //Atribuir pontos
        System.out.println("Olá "+jogador.getNome()+"! Quais são as suas halibidades?");       
        jogador.DistribuirPontos(1);
        
        limparTela();
        
        
        Arma porrete = new Arma("(Arma Leve)\n", 10); 
        Arma faca = new Arma("(Arma Leve)\n", 10);
        Arma machado = new Arma("(Arma pesada)", 20); 
        System.out.println("Agora escolha sua arma:");
        System.out.println("1) Porrete "+porrete.getCategoria()+" 2) Faca "+faca.getCategoria()+" 3) Machado "+machado.getCategoria());
        int escolhaArma = scanner1.nextInt();
        
        limparTela();
        
        //->Definição do dano da arma
        double danoJogador =0, danoJogadorLeve=0, danoJogadorPesado =0;
        
        if (escolhaArma==1) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.getDestreza(), porrete.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;          
        }else if (escolhaArma==2) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.getDestreza(), faca.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;
        }else if (escolhaArma==3) {
            danoJogadorPesado = Arma.ArmaPesada(jogador.getForca(), machado.danoConstante);
            System.out.println("Sua arma causa "+danoJogadorPesado+" de dano");
            danoJogador += danoJogadorPesado;
        }

        //Escolher armadura
        Armadura ladrão = new Armadura(5);
        Armadura couro = new Armadura(10);
        Armadura malha = new Armadura(15);
        System.out.println("Agora escolha sua armadura:");
        System.out.println("1) Armadura de ladrão   2) Armadura de Couro   3) Armadura de malha");
        int escolhaArmadura = scanner1.nextInt();

        //Definição armadura
        double defesaJogador =0;
        if (escolhaArmadura==1) {
            defesaJogador = Armadura.ArmaduraSimples(jogador.getConstituicao(),ladrão.getdefesaConstante());
            System.out.println("Sua defesa é: "+defesaJogador);
        }else if (escolhaArmadura==2) {
            defesaJogador = Armadura.ArmaduraMedia(jogador.getConstituicao(), couro.getdefesaConstante());
            System.out.println("Sua defesa é: "+defesaJogador);
        }else if (escolhaArmadura==3) {
            defesaJogador = Armadura.ArmaduraPesada(jogador.getConstituicao(), malha.getdefesaConstante());
            System.out.println("Sua defesa é: "+defesaJogador);
        }      

        limparTela();

        
        int vida = jogadorVida;

        

        //Exibição dos status do Jogador
        System.out.println("Status de "+jogador.getNome());
        System.out.println("Vida: "+jogadorVida);
        System.out.println("Defesa: "+defesaJogador);
        System.out.println("Dano: " +danoJogador);
        System.out.println("Agilidade: " +jogador.getAgilidade());

        int cura = 3, curainimigo =3, curaboss = 3, curainimigo2 =3;

        //Lista de Inimigos combate 1
        List<Inimigo> inimigos1 = new ArrayList<>(); 
        inimigos1.add(new Inimigo("Goblin Verde", 20, 30, 5,1));
        inimigos1.add(new Inimigo("Grande ogro", 40, 50, 5, 1));
        inimigos1.add(new Inimigo("Esqueleto alto", 30, 5, 4, 1));
        Inimigo inimigo = inimigos1.get(rand.nextInt(inimigos1.size()));

        double inimigoVida;                   
        inimigoVida = inimigo.getinimigoVida();
        inimigo.setinimigoVida(inimigoVida);
        System.out.println(inimigoVida);  

        //Combate 1 
        System.out.println("Os 3 inimigos tiram zerinho ou um para decidir quem vai te enfrentar");
        System.out.println("e foi definido que o seu adversário será o " +inimigo.getinimigoNome()); 
        while (true){
            
            int agir;       

            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>inimigo.getinimigoAgilidade()){
                System.out.println(inimigo.getinimigoNome()+ inimigoVida);
                System.out.println(""+jogador.getNome() +jogadorVida);
                agir = scanner1.nextInt();

                if(agir == 1)
                {
                    double danototal = danoJogador - inimigo.getinimigoDefesa();
                    
                    inimigoVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                }else if(agir == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                }else if(agir == 3)
                {
                    
                    if(cura>0)
                    {
                        //comando que ativa a função de cura no personagem
                       int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;


                    }else if(cura <= 0){
                        System.out.println("voce n tem mais cura");

                    }
                    

                }
                int escolhaInimigo = rand.nextInt(3) + 1;

                if(escolhaInimigo == 1)
                {
                    double danoInimigo2 = dado6() + dado6() + dado6() + 5;
                    danoInimigo2 = danoInimigo2 - defesaJogador;
                    jogadorVida -= danoInimigo2;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo2);
                }else if(escolhaInimigo == 2)
                {
                    int def = inimigo.getinimigoDefesa() * 2;
                    System.out.println("Defesa aumentada para: "+def);
                }else if(escolhaInimigo == 3)
                {
                    if(curainimigo>0)
                    {
                        
                     int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao( pocaoCura.getPontos());

                     inimigoVida += curaTotal;
                     
                    curainimigo --;
                    
                    }else if(cura <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");

                    }
                }

                


                if(inimigoVida <= 0 || jogadorVida<=0)
                {
                    break;
                }

            }
            //combate para agilidade do inimigo maior
            else if(jogador.getAgilidade()<inimigo.getinimigoAgilidade()){
                System.out.println(inimigo.getinimigoNome()+ inimigoVida);
                System.out.println(""+jogador.getNome() +jogadorVida);

               int escolhaInimigo = rand.nextInt(3) + 1;             

                if(escolhaInimigo == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + 5;
                    danoInimigo = danoInimigo - defesaJogador;
                    jogadorVida -= danoInimigo;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo == 2){
                    int def = inimigo.getinimigoDefesa() * 2;
                    System.out.println("Defesa aumentada para: "+def);
                }else if(escolhaInimigo == 3){
                    if(curainimigo>0){    
                        
                        //comando que ativa a função de cura pro inimigo
                     int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao( pocaoCura.getPontos());

                     inimigoVida += curaTotal;
                     curainimigo--;
                    }else if(cura <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");
                    }
                }
                

                agir = scanner1.nextInt();

                if(agir == 1){
                    double danototal = danoJogador - inimigo.getinimigoDefesa();
                    
                    inimigoVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                }else if(agir == 2){
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                }else if(agir == 3){                   
                    if(cura>0){                      
                    int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                    }else if(cura <= 0){
                        System.out.println("voce n tem mais cura");
                    }         
                }

                if(inimigoVida <= 0 || jogadorVida<=0){
                    break;
                }
            }
            if(inimigoVida <= 0 || jogadorVida<=0){
                    break;
                }
        }

        if(jogadorVida<=0)
        {
           break; 
        }

        limparTela();
        inimigoVida=0;

        //Pós-combate 1
        if (inimigoVida<=0) 
        {
            System.out.println("Parabéns! Você concluiu o primeiro combate");
            System.out.println("Subiu para o nível 2!");
            System.out.println("Mais 5 pontos para atributos!");

            jogador.DistribuirPontos(2);

            //Nova vida Jogador
            System.out.println("Sua vida aumentou!");
            jogadorVida = vida + jogador.getConstituicao();
            System.out.println("Sua nova vida é: "+jogadorVida);

            //Escolha da nova arma
            System.out.println("Novas Armas podem ser escolhidas!");
            Arma rapieira = new Arma("(Arma Leve)\n", 20); 
            Arma claymore = new Arma("(Arma pesada)\n", 30);
            Arma berdiche = new Arma("(Arma pesada)", 30); 
            System.out.println("Agora escolha sua arma:");
            System.out.println("1) Rapieira "+rapieira.getCategoria()+" 2) Claymore "+claymore.getCategoria()+" 3) Berdiche "+berdiche.getCategoria());
            int escolhaArma2 = scanner1.nextInt();         

            //->Definição do dano da nova arma
            double danoJogadorLeve2=0, danoJogadorPesado2=0;
            if (escolhaArma2==1) {
                danoJogadorLeve2 = Arma.ArmaLeve(jogador.getDestreza(), rapieira.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorLeve2+" de dano");
                danoJogador = danoJogadorLeve2;          
            }else if (escolhaArma2==2) {
                danoJogadorPesado2 = Arma.ArmaPesada(jogador.getDestreza(), claymore.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorPesado2+" de dano");
                danoJogador = danoJogadorPesado2;
            }else if (escolhaArma2==3) {
                danoJogadorPesado2 = Arma.ArmaPesada(jogador.getForca(), berdiche.danoConstante);
                System.out.println("Sua arma causa "+danoJogadorPesado2+" de dano");
                danoJogador = danoJogadorPesado2;
            }

        }

        

        //Lista de Inimigos combate 2
        List<Inimigo> inimigos2 = new ArrayList<>();
        inimigos2.add(new Inimigo("Golem de Pedra", 70, 60, 15,1));
        inimigos2.add(new Inimigo("Soldado Amaldiçoado", 60, 40, 10, 1));
        Inimigo inimigo2 = inimigos2.get(rand.nextInt(inimigos2.size()));

        double inimigoVida2;                   
        inimigoVida2 = inimigo2.getinimigoVida();
        inimigo2.setinimigoVida(inimigoVida2);
        System.out.println(inimigoVida2); 

        cura = 3;

        //Combate 2
        System.out.println("Os 2 inimigos tiram pedra, papel e tesoura para decidir quem vai te enfrentar");
        System.out.println("e foi definido que o seu adversário será o " +inimigo2.getinimigoNome());
        while (true) {
            
            int agir2;   

            
            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>inimigo2.getinimigoAgilidade()){
                System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigoVida2);
                System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);
                System.out.println("1) Atacar   2) Defender   3)Curar");
                agir2 = scanner1.nextInt();

                if(agir2 == 1)
                {
                    double danototal = danoJogador - inimigo2.getinimigoDefesa();
                    
                    inimigoVida2 -= danototal;
                    System.out.println("-Voce causou :"+danototal);

                }else if(agir2 == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("-A defesa aumentou para:" +defesatotal);
                }else if(agir2 == 3){
                    
                    if(cura>0){
                        
   
                    int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao( pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                    }else if(cura <= 0){
                        System.out.println("-Voce não tem mais cura");
                    }
                    

                }
            
                int escolhaInimigo2 = rand.nextInt(3) + 1;

                if(escolhaInimigo2 == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + 5;
                    danoInimigo = danoInimigo - defesaJogador;
                    jogadorVida -= danoInimigo;
                    System.out.println("-Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.getinimigoDefesa() * 2;
                    System.out.println("-Inimigo aumentou defesa para: "+def2);
                }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                      
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                        curainimigo2 --;
                        
                    }else if(cura <= 0){
                        System.out.println("-Inimigo tenta curar mas ele n tem mais cura");
                    }
                }
                if(inimigoVida2 <= 0 || jogadorVida<=0){
                    break;
                }
            }
                //Combate para agilidade do Inimigo maior
                else if(jogador.getAgilidade()<inimigo2.getinimigoAgilidade()){
                    System.out.println(inimigo2.getinimigoNome()+ inimigo2.getinimigoVida());
                    System.out.println(""+jogador.getNome() +jogador.getPv());
                    
                    int escolhaInimigo2 = rand.nextInt(3) + 1;             

                    if(escolhaInimigo2 == 1){
                    double danoInimigo2 = dado6() + dado6() + dado6() + 5;
                   double danoInimigo2t = danoInimigo2 - defesaJogador;
                    jogadorVida -= danoInimigo2t;

                    System.out.println("Seu inimigo causou dano de: "+danoInimigo2t);
                    }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.getinimigoDefesa() * 2;
                    System.out.println("Defesa aumentada para: "+def2);
                    }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                  
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     curainimigo2 --;                        
                    }else if(curainimigo <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");
                    }
                    }

                    System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigoVida2);
                    System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);

                    agir2 = scanner1.nextInt();

                    if(agir2 == 1)
                    {
                    double danototal = danoJogador - inimigo2.getinimigoDefesa();
                    
                    inimigoVida2 -= danototal;
                    System.out.println("Voce causou :"+danototal);

                    }else if(agir2 == 2)
                    {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                    }else if(agir2 == 3)
                    {
                    
                    if(cura>0)
                    {
                        
                    int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                    }else if(cura <= 0){
                        System.out.println("Voce não tem mais cura");
                    }
                    

                    }

                    if(inimigoVida2 <= 0 || jogadorVida <= 0)
                    {
                    break;
                    }

            }
        }

        cura = 0;


        if (inimigoVida2<=0) 
        {
            System.out.println("Parabéns! Você concluiu o primeiro combate");
            System.out.println("Subiu para o nível 4!");
            System.out.println("Mais 10 pontos para atributos!");

            jogador.DistribuirPontos(3);

            //Nova vida Jogador
            System.out.println("Sua vida aumentou!");
            jogadorVida = vida + jogador.getConstituicao();
            System.out.println("Sua nova vida é: "+jogadorVida);

            //Escolha da nova arma
            System.out.println("Novas Armas podem ser escolhidas!");
            Armadura viking = new Armadura( 25); 
            Armadura templário = new Armadura( 35);
            Armadura Samurai = new Armadura( 40); 
            System.out.println("Agora escolha sua nova armadura:");
            System.out.println("1) Armadura de Viking 2) Armadura de Cavaleiro Templário 3) Armadura de Samurai");
            int escolhaArmadura2 = scanner1.nextInt();         

            //->Definição do dano da nova arma
             defesaJogador=0;
            if (escolhaArmadura2==1) {
                defesaJogador = Armadura.ArmaduraSimples(jogador.getConstituicao(), viking.getdefesaConstante());
                System.out.println("Sua armadura aumenta para "+defesaJogador+" de defesa");
                         
            }else if (escolhaArmadura2==2) {
                defesaJogador = Armadura.ArmaduraMedia(jogador.getConstituicao(), templário.getdefesaConstante());
                System.out.println("Sua armadura aumenta para "+defesaJogador+" de defesa");
                
            }else if (escolhaArmadura2==3) {
                defesaJogador = Armadura.ArmaduraPesada(jogador.getConstituicao(), Samurai.getdefesaConstante());
                System.out.println("Sua armadura aumenta para "+defesaJogador+" de defesa");
                
            }

        }

        cura = 3;

        Inimigo boss = new Inimigo("Lorde das Sombras", 150, 25, 20, 15 );

        double bossVida;                   
        bossVida = boss.getinimigoVida();
        boss.setinimigoVida(bossVida);
        System.out.println(bossVida); 

        System.out.println("Sua jornada está quase no fim, "+jogador.getNome()+". Mas para isso, voce deve enfrentar seu desafio final");
        System.out.println("Ele se aproxima, o "+ boss.getinimigoNome()+"será seu desafio final!");

        while (true) {
            
            int agir3;   
            
            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>boss.getinimigoAgilidade()){
                System.out.println(boss.getinimigoNome()+" Vida: "+bossVida);
                System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);
                System.out.println("1) Atacar   2) Defender   3)Curar");
                agir3 = scanner1.nextInt();

                if(agir3 == 1)
                {
                    double danototal = danoJogador - boss.getinimigoDefesa();
                    
                    bossVida -= danototal;
                    System.out.println("-Voce causou :"+danototal);

                }else if(agir3 == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("-A defesa aumentou para:" +defesatotal);
                }else if(agir3 == 3){
                    
                    if(cura>0){
   
                     int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                    }else if(cura <= 0){
                        System.out.println("-Voce não tem mais cura");
                    }
                    

                }
            
                int escolhaInimigo3 = rand.nextInt(3) + 1;

                if(escolhaInimigo3 == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + boss.getinimigoForca();
                    danoInimigo = danoInimigo - defesaJogador;
                    jogadorVida -= danoInimigo;
                    System.out.println("-Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo3 == 2){
                    int def3 = boss.getinimigoDefesa() * 2;
                    System.out.println("-Inimigo aumentou defesa para: "+def3);
                }else if(escolhaInimigo3 == 3){
                    if(curaboss>0){                      
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                        curaboss --;
                        
                    }else if(cura <= 0){
                        System.out.println("-Inimigo tenta curar mas ele n tem mais cura");
                    }
                }
                if(bossVida <= 0 || jogadorVida<=0){
                    break;
                }
            }
                //Combate para agilidade do Inimigo maior
                else if(jogador.getAgilidade()<boss.getinimigoAgilidade()){
                    System.out.println(boss.getinimigoNome()+ bossVida);
                    System.out.println(""+jogador.getNome() +jogadorVida);
                    
                    int escolhaInimigo3 = rand.nextInt(3) + 1;             

                    if(escolhaInimigo3 == 1){
                    double danoBoss = dado6() + dado6() + dado6() + boss.getinimigoForca();
                    double danoBosstotal= danoBoss - defesaJogador;
                    jogadorVida -= danoBosstotal;
                    System.out.println("Seu inimigo causou dano de: "+danoBosstotal);
                    }else if(escolhaInimigo3 == 2){
                    int def2 = inimigo2.getinimigoAgilidade() * 2;
                    System.out.println("Defesa aumentada para: "+def2);
                    }else if(escolhaInimigo3 == 3){
                    if(curaboss>0){                  
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                        curaboss --;
                        
                    }else if(curainimigo <= 0){
                        System.out.println("adversario tenta curar mas ele n tem mais cura");
                    }
                    }

                    System.out.println(boss.getinimigoNome()+" Vida: "+bossVida);
                    System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);

                    agir3 = scanner1.nextInt();

                    if(agir3 == 1)
                    {
                    double danototal = danoJogador - boss.getinimigoAgilidade();
                    
                    bossVida -= danototal;
                    System.out.println("Voce causou :"+danototal);

                    }else if(agir3 == 2)
                    {
                    double defesatotal = defesaJogador*2;
                    System.out.println("A defesa aumentou para:" +defesatotal);
                    }else if(agir3 == 3)
                    {
                    
                    if(cura>0)
                    {
                        
                     int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao( pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                    }else if(cura <= 0){
                        System.out.println("Voce não tem mais cura");
                    }
                    

                    }

                    if(bossVida <= 0 || jogadorVida <= 0)
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
    

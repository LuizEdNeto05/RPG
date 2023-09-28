import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RPG {

    // Função para "limpar a tela"
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
        int prossiga;
        
        while(true){
        scanner1 = new Scanner(System.in);
        nome = new Scanner(System.in);
        Pocao pocaoCura = new Pocao(0);      
        
        String player;
        Random rand = new Random();      

        //Menu
        System.out.println("\n\n\n");
        System.out.println(".........................................................................................................................................................................");
        System.out.println("...SSSSSS....HHH.....HHH.....AAAAA.....DDDDDDDD.........OOOO......WW....WWW....WWW........HHH.....HHH..UUU.....UUU..NNN.....NNN.NTTTTTTTTTT.EEEEEEEEEE..RRRRRRRRR........");
        System.out.println("..SSSSSSSS...HHH.....HHH.....AAAAA.....DDDDDDDDDD.....OOOOOOOO....WW....WWW....WWW........HHH.....HHH..UUU.....UUU..NNNN....NNN.NTTTTTTTTTT.EEEEEEEEEE..RRRRRRRRRR.......");
        System.out.println(".SSSSSSSSSS..HHH.....HHH.....AAAAA.....DDDDDDDDDD....OOOOOOOOOO...WW...WWWWW...WWW........HHH.....HHH..UUU.....UUU..NNNNN...NNN.NTTTTTTTTTT.EEEEEEEEEE..RRRRRRRRRRR......");
        System.out.println(".SSS....SSS..HHH.....HHH....AAA.AAA....DDD....DDDD...OOO....OOO...WWW..WW.WW..WWW.........HHH.....HHH..UUU.....UUU..NNNNN...NNN.....TTT.....EEE.........RRR.....RRR......");
        System.out.println(".SSS.........HHH.....HHH....AAA.AAA....DDD.....DDD..OOO......OOO..WWW..WW.WW..WWW.........HHH.....HHH..UUU.....UUU..NNNNNN..NNN.....TTT.....EEE.........RRR.....RRR......");
        System.out.println(".SSSSSSS.....HHHHHHHHHHH....AAA.AAA....DDD.....DDD..OOO......OOO..WWW.WWW.WWW.WWW.........HHHHHHHHHHH..UUU.....UUU..NNN.NN..NNN.....TTT.....EEEEEEEEEE..RRRRRRRRRRR......");
        System.out.println("..SSSSSSSS...HHHHHHHHHHH...AAA...AAA...DDD.....DDD..OOO......OOO..WWW.WWW.WWW.WWW.........HHHHHHHHHHH..UUU.....UUU..NNN.NNN.NNN.....TTT.....EEEEEEEEEE..RRRRRRRRRR.......");
        System.out.println("....SSSSSSS..HHHHHHHHHHH...AAAAAAAAA...DDD.....DDD..OOO......OOO..WWW.WW...WW.WWW.........HHHHHHHHHHH..UUU.....UUU..NNN..NN.NNN.....TTT.....EEEEEEEEEE..RRRRRRRR.........");
        System.out.println("........SSS..HHH.....HHH...AAAAAAAAA...DDD.....DDD..OOO......OOO..WWW.WW...WW.WWW.........HHH.....HHH..UUU.....UUU..NNN..NNNNNN.....TTT.....EEE.........RRR..RRRR........");
        System.out.println(".SSS....SSS..HHH.....HHH..AAAAAAAAAAA..DDD....DDDD...OOO....OOO....WWWWW...WWWWW..........HHH.....HHH..UUUU...UUUU..NNN...NNNNN.....TTT.....EEE.........RRR...RRRR.......");
        System.out.println(".SSSSSSSSSS..HHH.....HHH..AAA.....AAA..DDDDDDDDDD....OOOOOOOOOO....WWWWW...WWWWW..........HHH.....HHH...UUUUUUUUU...NNN...NNNNN.....TTT.....EEEEEEEEEE..RRR....RRR.......");
        System.out.println("..SSSSSSSS...HHH.....HHH..AAA.....AAA..DDDDDDDDDD.....OOOOOOOO.....WWWW.....WWWW..........HHH.....HHH...UUUUUUUUU...NNN....NNNN.....TTT.....EEEEEEEEEE..RRR....RRRR......");
        System.out.println("...SSSSSS....HHH.....HHH.HAA.......AAA.DDDDDDDD.........OOOO.......WWWW.....WWWW..........HHH.....HHH.....UUUUU.....NNN.....NNN.....TTT.....EEEEEEEEEE..RRR.....RRRR.....");
        System.out.println(".........................................................................................................................................................................");
        System.out.println("\n\n");
        System.out.println("\t\t\t\t\t\t1) Jogar\t2) História\t3) Sair");
        System.out.println("\n\n");
        escolhaMenu = scanner1.nextInt();
        
        if(escolhaMenu==1){
        limparTela();
        while(true){

        
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
               
        Arma porrete = new Arma("(Arma Leve)\n", 5); 
        Arma faca = new Arma("(Arma Leve)\n", 7);
        Arma machado = new Arma("(Arma pesada)", 10); 
        System.out.println("Para enfrentar as sombras é preciso não só ter coragem e bravura, mas também algumas ferramentas. Escolha sua arma:");
        System.out.println("1) Porrete "+porrete.getCategoria()+" 2) Faca "+faca.getCategoria()+" 3) Machado "+machado.getCategoria());
        int escolhaArma = scanner1.nextInt();
        
        limparTela();
        
        //->Definição do dano da arma
        double danoJogador =0, danoJogadorLeve=0, danoJogadorPesado =0;
        
        if (escolhaArma==1) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.getDestreza(), porrete.getdanoConstante());
            System.out.println("As suas habilidades combinadas à sua arma e a causalidade da realidade, determinaram que causas:");
            System.out.println(+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;          
        }else if (escolhaArma==2) {
            danoJogadorLeve = Arma.ArmaLeve(jogador.getDestreza(), faca.getdanoConstante());
            System.out.println("As suas habilidades combinadas à sua arma e a causalidade da realidade, determinaram que causas:");
            System.out.println(+danoJogadorLeve+" de dano");
            danoJogador += danoJogadorLeve;
        }else if (escolhaArma==3) {
            danoJogadorPesado = Arma.ArmaPesada(jogador.getForca(), machado.getdanoConstante());
            System.out.println("As suas habilidades combinadas à sua arma e a causalidade da realidade, determinaram que causas:");
            System.out.println(+danoJogadorPesado+" de dano");
            danoJogador += danoJogadorPesado;
        }
    
        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();

        //Escolher armadura
        Armadura ladrão = new Armadura(7);
        Armadura couro = new Armadura(8);
        Armadura malha = new Armadura(10);
        System.out.println("Agora escolha sua armadura:");
        System.out.println("1) Armadura de ladrão   2) Armadura de Couro   3) Armadura de malha");
        int escolhaArmadura = scanner1.nextInt();

        limparTela();

        //Definição armadura
        double defesaJogador =0;
        if (escolhaArmadura==1) {
            defesaJogador = Armadura.ArmaduraSimples(jogador.getConstituicao(),ladrão.getdefesaConstante());
            System.out.println("As suas habilidades, sua armadura e a causalidade da realidade, determinaram que:");
            System.out.println(+defesaJogador+" é a sua defesa");
        }else if (escolhaArmadura==2) {
            defesaJogador = Armadura.ArmaduraMedia(jogador.getConstituicao(), couro.getdefesaConstante());
            System.out.println("As suas habilidades, sua armadura e a causalidade da realidade, determinaram que:");
            System.out.println(+defesaJogador+" é a sua defesa");
        }else if (escolhaArmadura==3) {
            defesaJogador = Armadura.ArmaduraPesada(jogador.getConstituicao(), malha.getdefesaConstante());
            System.out.println("As suas habilidades, sua armadura e a causalidade da realidade, determinaram que:");
            System.out.println(+defesaJogador+" é a sua defesa");
        }      

        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();
        
        int vida = jogadorVida;
        //Exibição dos status do Jogador
        System.out.println("Status de "+jogador.getNome());
        System.out.println("Vida: "+jogadorVida);
        System.out.println("Defesa: "+defesaJogador);
        System.out.println("Dano: " +danoJogador);
        System.out.println("Agilidade: " +jogador.getAgilidade());

        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();

        int cura = 3, curainimigo =3, curaboss = 3, curainimigo2 =3;
        //Lista de Inimigos combate 1
        List<Inimigo> inimigos1 = new ArrayList<>(); 
        inimigos1.add(new Inimigo("Goblin Verde", 20, 14, 5,1));
        inimigos1.add(new Inimigo("Grande ogro", 40, 16, 5, 1));
        inimigos1.add(new Inimigo("Esqueleto", 30, 11, 4, 1));
        Inimigo inimigo = inimigos1.get(rand.nextInt(inimigos1.size()));

        double inimigoVida;                   
        inimigoVida = inimigo.getinimigoVida();
        inimigo.setinimigoVida(inimigoVida);  

        //Combate 1
        System.out.println("Depois de muito caminhar, "+jogador.getNome()+" finalmente chega à entrada da caverna. Está escuro, a tocha não é suficiente para iluminar o local.");
        System.out.println("Lá existem o que parecem ser 3 vultos, você ateia fogo em um amontoado de algumas folhas secas para iluminar o local");
        System.out.println("O fogo ilumina! Os vultos se revelam ser 3 inimigos, um Goblin verde, um Grande ogro e um Esqueleto");
        System.out.println("Os 3 inimigos um pouco assustados, resolvem tirar zerinho ou um para decidir quem vai te enfrentar");
        System.out.println("O destino decidiu: seu adversário será o " +inimigo.getinimigoNome());
        
        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();

        while (true){
            
            int agir;       
            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>inimigo.getinimigoAgilidade()){
                System.out.println(jogador.getNome()+" é mais rápido e inicia atacando!");
                System.out.println(inimigo.getinimigoNome()+" Vida: "+inimigoVida);
                System.out.println(jogador.getNome()+" Vida: "+jogadorVida);
                System.out.println("1) Atacar     2)defender     3)Curar");
                agir = scanner1.nextInt();

                if(agir == 1)
                {
                    double danototal = danoJogador - inimigo.getinimigoDefesa();
                    
                    inimigoVida -= danototal;
                    System.out.println("Você causou :"+danototal+" de dano");

                }else if(agir == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("Sua defesa aumentou para:" +defesatotal);
                }else if(agir == 3)
                {
                    
                    if(cura>0)
                    {
                        //comando que ativa a função de cura no personagem
                        int curaTotal = 0;
                        curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        jogadorVida += curaTotal;
                        cura--;
                        System.out.println("Você curou: " +curaTotal+" de vida");

                    }else if(cura <= 0){
                        System.out.println("Você não possui mais cura");

                    }
                    
                }
                System.out.println(" ");
                System.out.println("Turno do "+inimigo.getinimigoNome());
                System.out.println(" ");
                int escolhaInimigo = rand.nextInt(3) + 1;

                if(escolhaInimigo == 1)
                {
                    double danoInimigo2 = dado6() + dado6() + dado6() + inimigo.getinimigoForca();
                    danoInimigo2 = danoInimigo2 - defesaJogador;
                    jogadorVida -= danoInimigo2;
                    System.out.println("Seu inimigo causou: "+danoInimigo2+" de dano");
                }else if(escolhaInimigo == 2)
                {
                    int def = inimigo.getinimigoDefesa() * 2;
                    System.out.println("Defesa inimiga aumentada para: "+def);
                }else if(escolhaInimigo == 3)
                {
                    if(curainimigo>0)
                    {                       
                        int curaTotal = 0;                      
                        curaTotal = Pocao.usarPocao( pocaoCura.getPontos());
                        inimigoVida += curaTotal;                   
                        curainimigo --;
                        System.out.println("O inimigo curou "+curaTotal+" de vida");

                    }else if(cura <= 0){
                        System.out.println("O inimigo tenta se curar mas ele não tem mais cura");

                    }
                }             

                if(inimigoVida <= 0 || jogadorVida<=0)
                {
                    break;
                }

            }
        
            //combate para agilidade do inimigo maior
            else if(jogador.getAgilidade()<inimigo.getinimigoAgilidade()){
                System.out.println(inimigo.getinimigoNome()+" é mais rápido e inicia atacando!");
                System.out.println(inimigo.getinimigoNome()+" Vida: "+inimigoVida);
                System.out.println(jogador.getNome()+" Vida: "+jogadorVida);

               int escolhaInimigo = rand.nextInt(3) + 1;             

                if(escolhaInimigo == 1){

                    double danoInimigo = dado6() + dado6() + dado6() + inimigo.getinimigoForca();
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
                     System.out.println("O inimigo curou "+curaTotal+" de vida");

                    }else if(cura <= 0){
                        System.out.println("O inimigo tenta se curar mas ele não tem mais cura");
                    }
                }
                
                System.out.println(" ");
                System.out.println("Turno do "+jogador.getNome());
                System.out.println(" ");
                System.out.println("1) Atacar     2)defender     3)Curar");
                agir = scanner1.nextInt();

                if(agir == 1){
                    double danototal = danoJogador - inimigo.getinimigoDefesa();
                    
                    inimigoVida -= danototal;
                    System.out.println("Você causou :"+danototal+" de dano");

                }else if(agir == 2){
                    double defesatotal = defesaJogador*2;
                    System.out.println("Sua defesa aumentou para:" +defesatotal);
                }else if(agir == 3){                   
                    if(cura>0){                      
                    int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                     System.out.println("Você curou: " +curaTotal+" de vida");
                    }else if(cura <= 0){
                        System.out.println("Você não tem mais cura");
                    }         
                }

                if(inimigoVida <= 0 || jogadorVida<=0){
                    break;
                }
            }
            



               
        }

         if(jogadorVida<=0)
        {

            System.out.println("GAME OVER");
            System.out.println("Aperte qualquer tecla para continuar");

           break; 
        }

        limparTela();
        inimigoVida=0;

        //Pós-combate 1
        if (inimigoVida<=0) 
        {
            System.out.println("Parabéns! Você derrotou o primeiro inimigo! Os demais ficam assustados com a sua batalha e decidem fugir!");
            System.out.println(jogador.getNome()+" subiu para o nível 2!");
            System.out.println(jogador.getNome()+" recebeu mais 5 pontos para atributos!");

            jogador.DistribuirPontos(2);

            //Nova vida Jogador
            System.out.println("Vida de"+jogador.getNome()+"aumentou!");
            jogadorVida = vida + jogador.getConstituicao();
            System.out.println("Sua nova vida é: "+jogadorVida);

            //Escolha da nova arma
            System.out.println("Novas Armas podem ser escolhidas!");
            Arma rapieira = new Arma("(Arma Leve)\n", 16); 
            Arma claymore = new Arma("(Arma pesada)\n", 18);
            Arma berdiche = new Arma("(Arma pesada)", 26); 
            System.out.println("Escolha sua  nova arma:");
            System.out.println("1) Rapieira "+rapieira.getCategoria()+" 2) Claymore "+claymore.getCategoria()+" 3) Berdiche "+berdiche.getCategoria());
            int escolhaArma2 = scanner1.nextInt();         

            //->Definição do dano da nova arma
            double danoJogadorLeve2=0, danoJogadorPesado2=0;
            if (escolhaArma2==1) {
                danoJogadorLeve2 = Arma.ArmaLeve(jogador.getDestreza(), rapieira.getdanoConstante());
                System.out.println("As suas habilidades combinadas à sua nova arma e a causalidade da realidade, determinaram que causas:");
                System.out.println(+danoJogadorLeve+" de dano");
                danoJogador = danoJogadorLeve2;          
            }else if (escolhaArma2==2) {
                System.out.println("As suas habilidades combinadas à sua nova arma e a causalidade da realidade, determinaram que causas:");
                System.out.println(+danoJogadorLeve+" de dano");
                danoJogador = danoJogadorPesado2;
            }else if (escolhaArma2==3) {
                danoJogadorPesado2 = Arma.ArmaPesada(jogador.getForca(), berdiche.getdanoConstante());
                System.out.println("As suas habilidades combinadas à sua nova arma e a causalidade da realidade, determinaram que causas:");
                System.out.println(+danoJogadorLeve+" de dano");
                danoJogador = danoJogadorPesado2;
            }

        }    

        //Lista de Inimigos combate 2
        List<Inimigo> inimigos2 = new ArrayList<>();
        inimigos2.add(new Inimigo("Lobisomem ", 70, 60, 15,1));
        inimigos2.add(new Inimigo("Soldado Amaldiçoado", 60, 40, 10, 1));
        Inimigo inimigo2 = inimigos2.get(rand.nextInt(inimigos2.size()));

        double inimigoVida2;                   
        inimigoVida2 = inimigo2.getinimigoVida();
        inimigo2.setinimigoVida(inimigoVida2);
        System.out.println(inimigoVida2); 

        cura = 3;

        //Combate 2
        System.out.println("Após seu primeiro combate, "+jogador.getNome()+" acende uma nova tocha e continua à avançar afundo na caverna.");
        System.out.println("Até que "+jogador.getNome()+" chega a uma parte da caverna que possui um enorme buraco no topo. A luz da lua cheia ilumina parte do local.");
        System.out.println("É então que se revelam duas figuras sob a luz, um Lobisoem e um cavaleiro amaldiçoado");
        System.out.println("Os 2 inimigos discutem pois ambos querem te enfrentar");
        System.out.println("É então que uma voz surge e diz para o " +inimigo2.getinimigoNome()+" enfrentá-lo. Ambos ouvem e sem hesitar, obedecem o comando da voz.");
        
        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();

        while (true) {

            
            
            int agir2;   
            
            
            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>inimigo2.getinimigoAgilidade()){
                System.out.println(jogador.getNome()+" é mais rápido e inicia atacando!");
                System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigoVida2);
                System.out.println(jogador.getNome()+" Vida: "+jogadorVida);
                System.out.println("1) Atacar   2) Defender   3)Curar");
                agir2 = scanner1.nextInt();

                if(agir2 == 1)
                {
                    double danototal = danoJogador - inimigo2.getinimigoDefesa();
                    
                    inimigoVida2 -= danototal;
                    System.out.println("Você causou :"+danototal+" de dano");

                }else if(agir2 == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("Sua defesa aumentou para:" +defesatotal);
                }else if(agir2 == 3){
                    
                    if(cura>0){
                          
                    int curaTotal = 0;                     
                     curaTotal = Pocao.usarPocao( pocaoCura.getPontos());
                     jogadorVida += curaTotal;
                     cura--;
                     System.out.println("Você curou: " +curaTotal+" de vida");
                    }else if(cura <= 0){
                        System.out.println("Você não possui mais cura");
                    }
                    

                }

                System.out.println(" ");
                System.out.println("Turno do Inimigo");
                System.out.println(" ");
                int escolhaInimigo2 = rand.nextInt(3) + 1;

                if(escolhaInimigo2 == 1){
                    double danoInimigo = dado6() + dado6() + dado6() + inimigo.getinimigoForca();
                    danoInimigo = danoInimigo - defesaJogador;
                    jogadorVida -= danoInimigo;
                    System.out.println("Seu inimigo causou dano de: "+danoInimigo);
                }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.getinimigoDefesa() * 2;
                    System.out.println("Defesa inimiga aumentada para: "+def2);
                }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                      
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     inimigoVida2 += curaTotal;
                        curainimigo2 --;
                        System.out.println("O inimigo curou "+curaTotal+" de vida");
                    }else if(cura <= 0){
                        System.out.println("O inimigo tenta se curar mas ele não tem mais cura");
                    }
                }
                if(inimigoVida2 <= 0 || jogadorVida<=0){
                    break;
                }
            }
                //Combate para agilidade do Inimigo maior
                else if(jogador.getAgilidade()<inimigo2.getinimigoAgilidade()){
                    System.out.println(inimigo2.getinimigoNome()+" é mais rápido e inicia atacando!");
                    System.out.println(inimigo.getinimigoNome()+" Vida: "+inimigoVida2);
                    System.out.println(jogador.getNome()+" Vida: "+jogadorVida);
                    
                    int escolhaInimigo2 = rand.nextInt(3) + 1;             

                    if(escolhaInimigo2 == 1){
                    double danoInimigo2 = dado6() + dado6() + dado6() + inimigo2.getinimigoForca();
                    double danoInimigo2t = danoInimigo2 - defesaJogador;
                    jogadorVida -= danoInimigo2t;

                    System.out.println("Seu inimigo causou dano de: "+danoInimigo2t);
                    }else if(escolhaInimigo2 == 2){
                    int def2 = inimigo2.getinimigoDefesa() * 2;
                    System.out.println("Defesa inimiga aumentada para: "+def2);
                    }else if(escolhaInimigo2 == 3){
                    if(curainimigo2>0){                  
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     inimigoVida2 += curaTotal;
                     curainimigo2 --;                        
                    }else if(curainimigo <= 0){
                        System.out.println("O inimigo tenta se curar mas ele não tem mais cura");
                    }
                    }
                    System.out.println("Seu turno: ");
                    System.out.println(inimigo2.getinimigoNome()+" Vida: "+inimigoVida2);
                    System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);
                    System.out.println("1) Atacar   2) Defender   3)Curar");
                    agir2 = scanner1.nextInt();

                    if(agir2 == 1)
                    {
                    double danototal = danoJogador - inimigo2.getinimigoDefesa();
                    
                    inimigoVida2 -= danototal;
                    System.out.println("Você causou :"+danototal+" de dano");

                    }else if(agir2 == 2)
                    {
                    double defesatotal = defesaJogador*2;
                    System.out.println("Sua defesa aumentou para:" +defesatotal);
                    }else if(agir2 == 3)
                    {
                    
                    if(cura>0)
                    {
                        
                    int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                     System.out.println("Voce curpu: "+curaTotal+" de vida");
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

        if(jogadorVida<=0)
        {

            System.out.println("GAME OVER");
            System.out.println("Aperte qualquer tecla para continuar");

           break; 
        }

        cura = 0;

        //Pós combate 2
        if (inimigoVida2<=0) 
        {
            System.out.println("Parabéns! Você concluiu o segundo combate");
            System.out.println("Subiu para o nível 4!");
            System.out.println("Mais 10 pontos para atributos!");

            jogador.DistribuirPontos(3);

            //Nova vida Jogador
            System.out.println("Sua vida aumentou!");
            jogadorVida = vida + jogador.getConstituicao();
            System.out.println("Sua nova vida é: "+jogadorVida);

            //Escolha da nova arma
            System.out.println("Novas Armas podem ser escolhidas!");
            Armadura viking = new Armadura( 14); 
            Armadura templário = new Armadura( 16);
            Armadura Samurai = new Armadura( 24); 
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
        //Combate Boss
        Inimigo boss = new Inimigo("Lorde das Sombras", 150, 40, 20, 15 );

        double bossVida;                   
        bossVida = boss.getinimigoVida();
        boss.setinimigoVida(bossVida);
        System.out.println(bossVida); 

        System.out.println("Após "+jogador.getNome()+" derrotar seu inimigo, o outro com quem ele estava discutindo se preparava para lutar, mas aquela voz novamente apareceu.");
        System.out.println("Uma escuridão, mais escura que as próprias sombras daquela caverna se revelava. Lá estava ele, o Lorde das sombras se revelava e dispensa seu subordinado.");
        System.out.println("Ele se aproxima, o "+ boss.getinimigoNome()+" será seu desafio final!");

        System.out.println("1) Continue");
        prossiga = scanner1.nextInt();
        limparTela();

        while (true) {
            
            int agir3;   
            
            //Combate para agilidade do jogador maior
            if(jogador.getAgilidade()>boss.getinimigoAgilidade()){

                System.out.println(jogador.getNome()+" é mais rápido e inicia atacando!");
                System.out.println(inimigo2.getinimigoNome()+" Vida: "+bossVida);
                System.out.println(jogador.getNome()+" Vida: "+jogadorVida);
                System.out.println("1) Atacar   2) Defender   3)Curar");
                agir3 = scanner1.nextInt();

                if(agir3 == 1)
                {
                    double danototal = danoJogador - boss.getinimigoDefesa();
                    
                    bossVida -= danototal;
                    System.out.println("Voce causou: "+danototal);

                }else if(agir3 == 2)
                {
                    double defesatotal = defesaJogador*2;
                    System.out.println("Sua defesa aumentou para: " +defesatotal);
                }else if(agir3 == 3){
                    
                    if(cura>0){
   
                     int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     jogadorVida += curaTotal;
                     cura--;
                        System.out.println("Voce curou "+curaTotal+" de vida");
                    }else if(cura <= 0){
                        System.out.println("Voce não possui mais cura");
                    }
                    

                }
                System.out.println("Turno Inimigo: ");
                int escolhaInimigo3 = rand.nextInt(3) + 1;

                if(escolhaInimigo3 == 1){
                    double danoBoss = dado6() + dado6() + dado6() + boss.getinimigoForca();
                   double  danoBosstotal = danoBoss - defesaJogador;
                    jogadorVida -= danoBosstotal;
                    System.out.println("Seu inimigo causou dano de: "+danoBosstotal);
                }else if(escolhaInimigo3 == 2){
                    int def3 = boss.getinimigoDefesa() * 2;
                    System.out.println("Inimigo aumentou defesa para: "+def3);
                }else if(escolhaInimigo3 == 3){
                    if(curaboss>0){                      
                        int curaTotal = 0;
                        
                     curaTotal = Pocao.usarPocao(pocaoCura.getPontos());

                     bossVida += curaTotal;
                        curaboss --;
                        System.out.println("Inimigo curou "+curaTotal+" de vida");
                    }else if(cura <= 0){
                        System.out.println("Inimigo tenta se curar mas ele não tem mais cura");
                    }
                }
                if(bossVida <= 0 || jogadorVida<=0){
                    break;
                }
            }
                //Combate para agilidade do Inimigo maior
                else if(jogador.getAgilidade()<boss.getinimigoAgilidade()){
                    System.out.println("Lorde das Sombras é mais rápido e inicia atacando!");
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

                     bossVida += curaTotal;
                        curaboss --;
                        System.out.println("Inimigo curou "+curaTotal+" de vida");
                    }else if(curainimigo <= 0){
                        System.out.println("Inimigo tenta curar mas ele não possui mais cura");
                    }
                    }

                    System.out.println(boss.getinimigoNome()+" Vida: "+bossVida);
                    System.out.println(""+jogador.getNome()+" Vida: " +jogadorVida);
                    
                    
                    
                    System.out.println("Seu turno: ");
                    System.out.println("1) Atacar     2)defender     3)Curar");
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
                     System.out.println("Voce curou"+curaTotal+" de vida");
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

        if(jogadorVida<=0)
        {

            System.out.println("GAME OVER");
            System.out.println("Aperte qualquer tecla para continuar");

           break; 
        }

    }
        
        }else if(escolhaMenu == 2){      
            System.out.println("Em um reino onde magia e tecnologia se entrelaçam, um herói desconhecido é convocado por seu mestre Ottogir, cujo nome"); 
            System.out.println(" esconde o segredo de sua verdadeira identidade. A missão épica do herói o levará em busca do lendário conhecimento total de Vaaj, aprisionado");
            System.out.println(" pelo temível Lorde das Sombras. Sua missão é faze-lo embarcar em uma busca pelo conhecimento total de Vaaj, onde segredos mágicos");
            System.out.println("e códigos misteriosos se unem");

            System.out.println("Digite 1 para continuar");

            prossiga = scanner1.nextInt();

            if(prossiga == 1)
            {
                
            }

            
        }else if(escolhaMenu==3){

            break;
              
        }      
       
    }
    scanner1.close();
    nome.close();           
}
}


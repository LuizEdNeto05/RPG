import java.util.Scanner;

public class RPG {
    
    public static void main (String args[])
    {
        Scanner scanner1 = new Scanner(System.in);
        Scanner nome = new Scanner(System.in);
        String player;
        double x;

        while(true){

            

        System.out.println("                                                            ");
        System.out.println("                                                            ");
        System.out.println("                  Menu principal                            "); //DESIGN A SER DEFINIDO
        System.out.println("                                                            ");
        System.out.println("                                                            ");


        System.out.println("\n\n\n");
        System.out.println("1) Novo Jogo");
        System.out.println("2) Lore");
        System.out.println("3) Sair");


        x = scanner1.nextDouble();



        if(x==1){

        limparTela();

        System.out.println("Escreva");

        player = nome.nextLine();

        Jogador jogador = new Jogador(player,100, 0,0,0,0,new Arma(),new Armadura());




       

        System.out.println("Nome: " +jogador.getNome());

        

        jogador.distribuirPontos();

        }else if(x == 2){


        

        System.out.println("Lore");

        //LORE A SER DEFINIDA
        }else if(x==3){



        

        break;
        }



       

      }
          
        scanner1.close();
        nome.close();

    }

    

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println(); // Imprime uma linha em branco
        }
    }

        
        
    }

    


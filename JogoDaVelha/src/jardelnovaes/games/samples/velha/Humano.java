package jardelnovaes.games.samples.velha;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[LINHA] = entrada.nextInt();
                
                if( tentativa[LINHA] > 3 ||tentativa[LINHA] < 1)
                    System.out.println("Linha inv\u00e1lida. É 1, 2 ou 3");
                
            }while( tentativa[LINHA] > 3 ||tentativa[LINHA] < 1);
            
            do{
                System.out.print("Coluna: ");
                tentativa[COLUNA] = entrada.nextInt();
                
                if(tentativa[COLUNA] > 3 ||tentativa[COLUNA] < 1)
                    System.out.println("Coluna inv\u00e1lida. É 1, 2 ou 3");
                
            }while(tentativa[COLUNA] > 3 ||tentativa[COLUNA] < 1);
            
            tentativa[LINHA]--; 
            tentativa[COLUNA]--;
            
            if(!checaTentativa(tentativa, tabuleiro))
                System.out.println("Esse local j\u00e1 foi marcado. Tente outro.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}

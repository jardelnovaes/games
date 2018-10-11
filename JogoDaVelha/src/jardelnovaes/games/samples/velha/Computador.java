package jardelnovaes.games.samples.velha;

public class Computador extends Jogador{
    //TODO Implementar v�rios n�veis de dificuldade.
	
	private Jogador adversario;
	
    public Computador(int jogador){
        super(jogador);
        if(jogador==1)
        	adversario = new Humano(2);        
        else
        	adversario = new Humano(1);
        	
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){
    	Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);    
    }
    
    @Override
    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
    	Boolean ret = super.checaTentativa(tentativa, tabuleiro);
    	
    	//TODO testar as op��es do advers�rio.
    	//adversario.checaTentativa(tentativa, tabuleiro);
    	
    	if(ret){
    		//tabuleiro.setPosicao(tentativa, jogador)
    	}
    	return ret;
    	
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        //Nivel f�cil
    	
    	//Vai tentar o centro.
    	tentativa[LINHA] = 1;
    	tentativa[COLUNA] = 1;
    	//Se n�o der vai tentar os cantos
    	if(!checaTentativa(tentativa, tabuleiro)){    		
		
			tentativa[LINHA] = 0;
			tentativa[COLUNA] = 0;
			if(!checaTentativa(tentativa, tabuleiro)){				
				tentativa[COLUNA] = 2;
				if(!checaTentativa(tentativa, tabuleiro)){
					tentativa[LINHA] = 2;
					if(!checaTentativa(tentativa, tabuleiro)){
						tentativa[COLUNA] = 0;
						if(!checaTentativa(tentativa, tabuleiro)){
							TentarPrimeiroLivre(tabuleiro);
						}
		    		}	
	    		}
				
    		}
    	}
    }
    
    public void TentarPrimeiroLivre(Tabuleiro tabuleiro){
    	//Vai tentar o primeiro livre.
    	
    	tentativa[LINHA] = 1;
    	tentativa[COLUNA] = 1;
    	
    	for(int linha=0 ; linha<3 ; linha++){
            for(int coluna=0 ; coluna<3 ; coluna++){
            	tentativa[LINHA] = linha;
            	tentativa[COLUNA] = coluna;
            	if( checaTentativa(tentativa, tabuleiro) ){
                    break;
                }
            }
        }
    }
    
}
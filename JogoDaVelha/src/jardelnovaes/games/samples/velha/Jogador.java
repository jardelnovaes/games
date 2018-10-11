package jardelnovaes.games.samples.velha;

public abstract class Jogador {
    
	protected static final int LINHA = 0;
	protected static final int COLUNA = 1;
	
    protected int[] tentativa = new int[2];
    protected int jogador;

    
    public Jogador(int jogador){
        this.jogador = jogador;
    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    
    public abstract void Tentativa(Tabuleiro tabuleiro);

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }
    
}

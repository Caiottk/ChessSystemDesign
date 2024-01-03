package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece( Board board) {
		this.board = board;
		position = null ;
	}

	protected Board getBoard() { //somente classes dentro do mesmo pacote e subclasses
								 //v�o acessar o tabuleiro de uma pe�a
		return board;
	}
	
	
	

}

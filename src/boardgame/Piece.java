package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece( Board board) {
		this.board = board;
		position = null ;
	}

	protected Board getBoard() { //somente classes dentro do mesmo pacote e subclasses
								 //vão acessar o tabuleiro de uma peça
		return board;
	}
	
	
	

}

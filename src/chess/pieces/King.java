package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;
    public King(Board board, Color color, ChessMatch chessMatch) {

        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position); // pega a peça na posição
        return p == null || p.getColor() != getColor(); // se a peça for nula ou a cor for diferente
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position); // pega a peça na posição
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0; // se a peça for nula ou a cor for diferente
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true; // pode mover
        }

        // #specialmove castling
        if( getMoveCount() == 0 && !chessMatch.getCheck() ) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3); // posição da torre
            if( testRookCastling(posT1) ) { // se a torre pode fazer o roque
                Position p1 = new Position(position.getRow(), position.getColumn() + 1); // posição entre o rei e a torre
                Position p2 = new Position(position.getRow(), position.getColumn() + 2); // posição entre o rei e a torre
                if( getBoard().piece(p1) == null && getBoard().piece(p2) == null ) { // se as posições entre o rei e a torre estiverem vazias
                    mat[position.getRow()][position.getColumn() + 2] = true; // pode mover
                }
            }
            // #specialmove castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4); // posição da torre
            if( testRookCastling(posT2) ) { // se a torre pode fazer o roque
                Position p1 = new Position(position.getRow(), position.getColumn() - 1); // posição entre o rei e a torre
                Position p2 = new Position(position.getRow(), position.getColumn() - 2); // posição entre o rei e a torre
                Position p3 = new Position(position.getRow(), position.getColumn() - 3); // posição entre o rei e a torre
                if( getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null ) { // se as posições entre o rei e a torre estiverem vazias
                    mat[position.getRow()][position.getColumn() - 2] = true; // pode mover
                }
            }
        }

        return mat;
    }
}
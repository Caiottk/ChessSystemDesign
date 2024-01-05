package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position); // pega a peça na posição
        return p == null || p.getColor() != getColor(); // se a peça for nula ou a cor for diferente
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

        return mat;
    }
}
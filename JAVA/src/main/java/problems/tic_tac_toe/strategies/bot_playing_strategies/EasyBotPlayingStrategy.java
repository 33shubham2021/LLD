package problems.tic_tac_toe.strategies.bot_playing_strategies;

import problems.tic_tac_toe.models.Board;
import problems.tic_tac_toe.models.Cell;
import problems.tic_tac_toe.models.CellState;
import problems.tic_tac_toe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(
                            cell,
                            null
                    );
                }
            }
        }
        return null;
    }
}

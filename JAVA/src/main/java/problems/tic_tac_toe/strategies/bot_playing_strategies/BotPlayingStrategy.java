package problems.tic_tac_toe.strategies.bot_playing_strategies;

import problems.tic_tac_toe.models.Board;
import problems.tic_tac_toe.models.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}

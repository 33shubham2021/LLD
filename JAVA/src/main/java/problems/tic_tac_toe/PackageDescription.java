package problems.tic_tac_toe;

public class PackageDescription {
    /**
     *
     * Similar requirements are for other games like, chess, ludo, etc
     *
     *
     * Requirements
     *
     * Size of board can be n*n, any size not restricted to 3*3
     * number of players = n-1
     * Will there be bots -> YES, at max 1 bot per game
     * Bots can be of different difficulty levels
     * Every player has a different symbol/character, this must be validated
     * When will the game start and when will it end
     * Tournaments supported ? NO
     * Supporting leaderboard/score of players - NO
     * Will teams be there - > NO
     * Undo
     *      Global undo (anyone can call) - undo the previous move of the game
     *
     * Is there any time limit - NO
     * When / how will a game start ?
     *      Who will make the first move? -> Randomly choose the order, and then fix it
     *
     *
     * When / how will the game end ?
     *      When someone has won
     *      Draw
     *      When all but one have won..like Ludo, it continues till last couple player
     *      What decides the victory ..Can there be multiple logics in future ?
     *      Allow to add new ways in someone can win
     * What to do when someone exists - NOT Supported for now
     *      End the game
     *      Remove there symbol
     * Show replay of the game -> Ignore undo moves
     **/

}

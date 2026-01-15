package com.chess.chessbackend;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ChessController {

    @PostMapping("/moves")
    public String[][] getMoves(@RequestBody MoveRequest req) {
        int row = req.fromRow;
        int col = req.fromCol;
        return C_B.calculateMoves(row, col);
    }

    @GetMapping("/board")
    public String[][] getBoard() {
        return Chess_board.chessBoard;
    }

    @PostMapping("/move")
    public String[][] makeMove(@RequestBody MoveRequest req) {
        C_B.makeMove(req.fromRow, req.fromCol, req.toRow, req.toCol);
        return Chess_board.chessBoard;
    }

    @PostMapping("/reset")
public String[][] resetGame() {
    C_B.resetGame();      // ✅ CORRECT
    return Chess_board.chessBoard;
}


    @PostMapping("/undo")
public String[][] undoMove() {
    C_B.undoMove();
    return Chess_board.chessBoard;
}


    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("gameOver", C_B.gameOver);
        status.put("winner", C_B.winner);
        return status;
    }
}

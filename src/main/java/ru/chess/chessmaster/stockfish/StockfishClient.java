package ru.chess.chessmaster.stockfish;


import ru.chess.chessmaster.stockfish.stockfish.Stockfish;
import ru.chess.chessmaster.stockfish.stockfish.engine.StockfishException;
import ru.chess.chessmaster.stockfish.stockfish.engine.StockfishInitException;
import ru.chess.chessmaster.stockfish.stockfish.utils.Option;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StockfishClient {
    private final Stockfish stockfish;

    public StockfishClient(String variant, Option... options) {
        try {
            stockfish = new Stockfish(variant, options);
        } catch (StockfishInitException e) {
            throw new StockfishException(e);
        }
    }

    public String getFen() {
        return stockfish.getFen();
    }

    public String getBestMove(String fen, int difficulty) {
        return stockfish.getBestMove(fen, difficulty);
    }

    public List<String> getCheckers(String fen) {
        return stockfish.getCheckers(fen);
    }

    public String makeMove(String fen, String move) {
        return stockfish.makeMove(fen, move);
    }


    public static class Builder {
        private Set<Option> options = new HashSet<>();
        private String variant;

        public final Builder setVariant(String variant) {
            this.variant = variant;
            return this;
        }

        public final Builder setOption(String name, int value) {
            options.add(new Option(name, value));
            return this;
        }

        public final StockfishClient build() {
            return new StockfishClient(variant, options.toArray(new Option[0]));
        }
    }
}

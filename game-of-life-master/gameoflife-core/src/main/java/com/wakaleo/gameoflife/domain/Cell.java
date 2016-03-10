package com.wakaleo.gameoflife.domain;

public enum Cell {
    LIVE_CELL("*"), DEAD_CELL(".");

    private String symbol;

    private Cell(final String initialSymbol) {
        this.symbol = initialSymbol;
    }
    //DEV1 + MASTER. Nu voor de echt!
    @Override
    public String toString() {
        return symbol;
    }

    static Cell fromSymbol(final String symbol) {
        Cell cellRepresentedBySymbol = null;
        for (Cell cell : Cell.values()) {
            if (cell.symbol.equals(symbol)) {
                cellRepresentedBySymbol = cell;
                break;
            }
        }
        return cellRepresentedBySymbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

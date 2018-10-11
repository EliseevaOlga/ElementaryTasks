/*
 * 2018/10/04
 *
 * Copyright (c) Olga Eliseeva
 *
 * */

package ElementaryTasks.Task01;

import ElementaryTasks.InputErrorsControl;

import java.util.concurrent.BlockingDeque;

/**
 * Class Chessboard prints a chessboard with given height and width
 *
 * @author Olga Eliseeva
 */

public class Chessboard{
    private int width;
    private int height;
    private String content;
    private final String WHITECELL = "*";
    private final String BLACKCELL = " ";

    public Chessboard(int height, int width){
        this.height = height;
        this.width = width;
    }

    public void fillChessboard(){
        String evenLine = makeAlternation(WHITECELL, BLACKCELL, width);
        String oddLine = makeAlternation(BLACKCELL, WHITECELL, width);
        content = makeAlternation(evenLine,oddLine, height);

    }

    private String makeAlternation(String odd, String even, int stepsCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stepsCount; i++) {
            sb.append((i % 2)==0 ? even : odd);
        }
        sb.append('\n');
        return sb.toString();
    }

    @Override
    public String toString(){
        return content;
    }

}


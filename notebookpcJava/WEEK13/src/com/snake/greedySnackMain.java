package com.snake;

import javax.swing.JFrame;


public class greedySnackMain extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	snackWin snackwin;
    static final int Width = 800 , Height = 600 , LocX = 200 , LocY = 80;
    public greedySnackMain() {
        super(" Ã∞≥‘…ﬂ");
        snackwin = new snackWin();
        add(snackwin);
        this.setSize(Width, Height);
        this.setVisible(true);
        this.setLocation(LocX, LocY);
        //snackwin.requestFocus();
    }
    public static void main(String[] args) {
        new greedySnackMain();
    }
}
package Main;

import Main.Game;

import javax.swing.*;
import java.awt.*;
/**
 * Created by mak on 04.03.2017.
 */
@SuppressWarnings("serial")
public class Renderer extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
// TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 807, 700);
        Game game = Game.game;
        for(Point point : game.snake.getSnakePieces()){
            g.setColor(Color.YELLOW);
            g.fillRect(point.x * 10, point.y * 10,10,10);
        }
        g.fillRect(game.snake.getHead().x * 10, game.snake.getHead().y * 10,10,10);
        g.setColor(Color.RED);
        g.fillRect(game.cherry.x * 10, game.cherry.y*10,10,10);
        g.setColor(Color.GREEN);
        if(game.score > game.highscore) game.highscore = game.score;
        g.drawString("YOUR SCORE : " + String.valueOf(game.score),76*5 , 20);
        g.drawString("LENGTH : " + String.valueOf(game.snake.getLength()),76*5 , 50);
        g.drawString("HIGHSCORE : " + String.valueOf(game.highscore),76*5 , 35);
        if(game.gameOver && game.score <500){
            g.setColor(Color.GREEN);
            g.drawString("YOU LOSE!",62*5,64*5);
        }else if(game.score == 500){
            game.gameOver = true;
            g.drawString("НУ ТЫ КРАСАВА!", 76*5, 64*5);
        }

    }}

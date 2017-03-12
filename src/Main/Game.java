package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mak on 04.03.2017.
 */
public class Game implements ActionListener, KeyListener {
    public static Scanner in = new Scanner(System.in);
    public static Game game;
    public Snake snake;
    public Timer timer = new Timer(20, this);
    public Renderer renderer;
    public Point cherry;
    public int cnt;
    public Random rand = new Random();
    boolean gameOver = false, pause = false;
    public JFrame frame = new JFrame("Main.Snake");
    public int score = 0, time = 0,highscore = 0;
    int type = 5,cherryCnt = 0;

    public Game() {
        Toolkit tool = Toolkit.getDefaultToolkit();
// d = new Dimension(tool.getScreenSize());
        frame.setSize(807, 700);
        frame.setLocation((tool.getScreenSize().width / 2 - frame.getWidth() / 2),
                (tool.getScreenSize().height / 2 - frame.getHeight() / 2));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.add(renderer = new Renderer());
        frame.setVisible(true);
        snake = new Snake();
        snake.setHead(new Point(0, -1));
        timer.start();
        cherry = new Point(random(79), random(66));
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        game = new Game();
    }

    int random(int x){
        return rand.nextInt(x - 2) + 1;
    }

    public void start() {
        time = 0;
        gameOver = false;
        score = 0;
        cnt = 0;
        score = 0;
        snake = new Snake();
        snake.setHead(new Point(0,-1));
        rand = new Random();
        cherry = new Point(random(79), random(66));
        pause = !pause;
        type = 5;
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
// 0 for Up,1 for Down,2 for Left,3 for Right
        renderer.repaint();
        cnt++;
        if (cnt % type == 0 && gameOver == false && pause == false) {
            snake.addPiece(new Point(snake.getHead().x, snake.getHead().y));
            if (snake.getDirection() == 0) {
                if (snake.getHead().y - 1 >= 0 && snake.tailCheck(snake.getHead().x, snake.getHead().y - 1)) {
                    snake.setHead(new Point(snake.getHead().x, snake.getHead().y - 1));
                } else {
                    gameOver = true;

                }
            }

            if (snake.getDirection() == 1) {
                if (snake.getHead().y + 1 < 66 && snake.tailCheck(snake.getHead().x, snake.getHead().y + 1)) {
                    snake.setHead(new Point(snake.getHead().x, snake.getHead().y + 1));
                } else {
                    gameOver = true;
                }
            }

            if (snake.getDirection() == 2) {
                if (snake.getHead().x - 1 >= 0 && snake.tailCheck(snake.getHead().x - 1, snake.getHead().y)) {
                    snake.setHead(new Point(snake.getHead().x-1, snake.getHead().y));
                } else {
                    gameOver = true;
                }
            }

            if (snake.getDirection() == 3) {
                if (snake.getHead().x + 1 < 79 && snake.tailCheck(snake.getHead().x + 1, snake.getHead().y)) {
                    snake.setHead(new Point(snake.getHead().x+1, snake.getHead().y));
                } else {
                    gameOver = true;
                }
            }
            if (cherry != null) {
                if (cherry.equals(snake.getHead())) {
                    snake.incLength();
                    score += 10;
                    cherryCnt ++;
                    if(type > 2) type--;
                    if(cherryCnt == 10) type = 1;
                    cherry = new Point(rand.nextInt(79), rand.nextInt(66));
                }
            }
            if (snake.getSnakePieces().size() > snake.getLength())
                snake.remove(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
// TODO Auto-generated method stub
        if ((arg0.getKeyCode() == KeyEvent.VK_W || arg0.getKeyCode() == KeyEvent.VK_UP) && snake.getDirection() != 1) {
            snake.setDirection(0);
        }
        if
                ((arg0.getKeyCode() == KeyEvent.VK_A || arg0.getKeyCode() == KeyEvent.VK_LEFT) && snake.getDirection() != 3) {
            snake.setDirection(2);
        }
        if ((arg0.getKeyCode() == KeyEvent.VK_S || arg0.getKeyCode() == KeyEvent.VK_DOWN) && snake.getDirection() != 0) {
            snake.setDirection(1);
        }
        if ((arg0.getKeyCode() == KeyEvent.VK_D || arg0.getKeyCode() == KeyEvent.VK_RIGHT) && snake.getDirection() != 2) {
            snake.setDirection(3);
        }
        if (arg0.getKeyCode() == KeyEvent.VK_SPACE && gameOver == true) {
            start();
        }
        if (arg0.getKeyCode() == KeyEvent.VK_SPACE && gameOver != true) {
            pause = !pause;
        }

    }
    @Override
    public void keyReleased(KeyEvent arg0) {
// TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
// TODO Auto-generated method stub

    }}

package Main;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by mak on 04.03.2017.
 */
public class Snake {
    private ArrayList<Point> snakePieces ;
    private Point head;
    private int tailLength;
    private int direction;

    public Snake(){
        snakePieces = new ArrayList<Point>();
        tailLength = 5;
        direction = 1;
    }

    public void setHead(Point p){
        this.head = p;
    }

    public ArrayList<Point> getSnakePieces(){
        return this.snakePieces;
    }

    public void addPiece(Point p){
        snakePieces.add(p);
    }

    public Point getHead(){
        return this.head;
    }

    public int getDirection(){
        return this.direction;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void incLength(){
        tailLength++;
    }

    public int getLength(){
        return this.tailLength;
    }

    public void remove(int i){
        snakePieces.remove(i);
    }

    public boolean tailCheck(int x, int y) {
        for (Point point : this.getSnakePieces()) {
            if (point.x == x && point.y == y) {
                return false;
            }
        }
        return true;
    }

}

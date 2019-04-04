public class Node {
    int x;
    int y;
    String typ;
    int distance=0;

    public String getTyp() {
        return typ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, String typ) {
        this.x = x;
        this.y = y;
        this.typ=typ;
    }

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        return  x*37+y*37;
    }

    @Override
    public String toString() {
        return "Node [" + this.x + "," + this.y + "]";
    }
}

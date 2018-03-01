package mind.hash.model;

public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceTo( Position another )
    {
        return Math.abs( this.x - another.x ) + Math.abs( this.y - another.y );
    }
}

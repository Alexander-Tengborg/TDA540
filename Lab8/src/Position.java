// A class representing a position in the game
public class Position {
    private final int col;
    private final int row;

    Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return String.format("Col: %d, Row: %d", col, row);
    }

    /*
     * The equals function uses this "underneath", and wont work with this. It creates a unique hashcode for every
     * position by using the position's column and row.
     */
    @Override
    public int hashCode() //TODO check if needed & fix
    {
        final int temp = 14;
        int ans = temp * getCol() + getRow();
        return ans;
    }

    /*
     * Overrides the position object's equal class, so you more easily can compare two position objects.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Position pos = (Position) o;
        return (this.getCol() == pos.getCol() && this.getRow() == pos.getRow());
    }
}

// A class representing a position in the game
//TODO everything should be col->row instead of row->col (xy, not yx) ---- fixed
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

    @Override
    public int hashCode() //TODO check if needed & fix
    {
        final int temp = 14;
        int ans = 1;
        ans = temp * getCol() + getRow();
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Position pos = (Position) o;
        return (this.getCol() == pos.getCol() && this.getRow() == pos.getRow());
    }
}

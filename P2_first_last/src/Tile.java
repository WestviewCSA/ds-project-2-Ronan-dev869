
public class Tile {
	private int row;
	private int col;
	private char location;
	
	public Tile() {
		row = 0;
		col = 0;
		location = 'x';
	}
	public Tile (int row, int col, char location) {
		this.row = row;
		this.col = col;
		this.location = location;
	}
	public boolean equals(Tile e) {
		return  col == e.getCol() && row == e.getRow();
	}
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getLocation() {
		return location;
	}

	public void setLocation(char location) {
		this.location = location;
	}
}

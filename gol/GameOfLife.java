

package gol;

public class GameOfLife implements Board {

private int[][] board;

public GameOfLife(int x, int y) {
board = new int[x][y];
}

public void set(int x, int y, int[][] data) {
for (int i = 0; i < data.length; i++) {
for (int j = 0; j < data[0].length; j++) {
board[(i + x) % board.length][(j + y) % board[0].length] = data[i][j];
}
}
}

public void run(int turns) {
for (int i = 0; i < turns; i++) {
step();
}
}

public void step() {
print();

int rows = board.length;
int cols = board[0].length;
int[][] next = new int[rows][cols];

for (int x = 0; x < rows; x++) {
for (int y = 0; y < cols; y++) {
int neighbors = countNeighbors(x, y);
int current = board[x][y];

if (current == 1) {
next[x][y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
} else {
next[x][y] = (neighbors == 3) ? 1 : 0;
}
}
}

board = next;
}


public int countNeighbors(int x, int y) {
return
get(x - 1, y - 1) + get(x, y - 1) + get(x + 1, y - 1) +
get(x - 1, y) + get(x + 1, y) +
get(x - 1, y + 1) + get(x, y + 1) + get(x + 1, y + 1);
}

public int get(int x, int y) {
int xLimit = board.length;
int yLimit = board[0].length;
return board[(x + xLimit) % xLimit][(y + yLimit) % yLimit];
}

public int[][] get() {
return board;
}

public void print() {
System.out.print("\n ");
for (int y = 0; y < board[0].length; y++) {
System.out.print(y % 10 + " ");
}

for (int x = 0; x < board.length; x++) {
System.out.print("\n" + x % 10);
for (int y = 0; y < board[x].length; y++) {
System.out.print(board[x][y] == 1 ? "⬛" : "⬜");
}
}
System.out.println();
}
}


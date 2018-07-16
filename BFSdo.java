package misc;

import java.util.LinkedList;
import java.util.Queue;


class Cell {
	int x;
	int y;
	Cell(int m, int n){
		this.x = m;
		this.y = n;
	}		
}


public class BFSdo {

	public static void main(String[] args) {

		int[][] rooms = {
				
				{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
				{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
				{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
	
		};
		
		int rows = rooms.length;
		int cols = rooms[0].length;
		
		int[][] move = {
				{1,0},
				{-1,0},
				{0,1},
				{0,-1}
		};
		
		
		Queue<Cell> q = new LinkedList<Cell>();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++ ) {
				if (rooms[i][j] == 0)
					q.add(new Cell(j, i));
			}
		}
		
		while (q.size() != 0) {
			Cell temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < 4; i++) {
				add(x + move[i][0], y + move[i][1], rooms, q, rooms[y][x] + 1);
			}
			printArr(rooms);
			for(Cell c : q) { 
				  System.out.println(c.x + " " + c.y); 
			}
			System.out.println(); 
		}
		
		printArr(rooms);
	}
	
	public static void add(int x, int y, int[][] rooms, Queue<Cell> q, int steps) {
		
		if ((y < 0 || y >= rooms.length) ||
		   (x < 0 || x >= rooms[0].length) || 
		   (rooms[y][x] == -1) ||
		   (rooms[y][x] != Integer.MAX_VALUE)) {
			return;
		}
		
		rooms[y][x] = steps;
		q.add(new Cell(x, y));
		
	}
	
	public static void printArr(int[][] rooms) {
		
		for (int[] y : rooms) {
			for (int x : y) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
	}
	
}

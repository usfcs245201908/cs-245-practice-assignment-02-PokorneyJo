public class NQueens{
	int x;
	public NQueens(int n){
		x = n;
	}
	public boolean canPlaceQueen(int chessBoard[][], int row, int col){
		int i, j;
		for(i = 0; i < col; i++){
			if(chessBoard[row][i] == 1){
				return false;
			}
		}
		i = row;
		j = col;
		while(i >= 0 && j >= 0){
			if(chessBoard[i][j] == 1){
				return false;
			}
			i--;
			j--;
		}
		i = row;
		j = col;
		while( j >= 0 && i < x){
			if(chessBoard[i][j] == 1){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public boolean placeQueens(int chessBoard[][], int col){
		if(col >= x){
			return true;
		}
		for(int i = 0; i < x; i++){
			if(canPlaceQueen(chessBoard, i, col)){
				chessBoard[i][col] = 1;

				if(placeQueens(chessBoard, col+1) == true){
					return true;
				}
				chessBoard[i][col] = 0;
			}
		}
		return false;
	}
	public void printToConsole(int chessBoard[][]){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < x; j++){
				System.out.print(" " + chessBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
	public boolean placeNQueens(){
		if(x < 1){
			throw new IllegalArgumentException("Board size cannot be less than one.");
		}
		int[][] chessBoard = new int[x][x];
		for(int i = 0; i < x; i++){
			for(int j = 0; j < x; j++){
				chessBoard[i][j] = 0;
			}
		}
		if(placeQueens(chessBoard, 0) == false){
			System.out.println("There is no solution for the value you input.");
			return false;
		}
		printToConsole(chessBoard);
		return true;

	}
}
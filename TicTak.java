import java.util.*;
public class TicTak{
    
    char[][] board= new char[3][3];
    char playerValue;
    char computerValue;
    int boardPosition;
    String winner = null;
    ArrayList<Integer> playerPosition;
    ArrayList<Integer> computerPosition;
    Scanner sc = new Scanner(System.in);
    
    //Function play to start game
    public void play() {
        int tossValue = toss();
		this.display();
        
        if (tossValue==1) {

            playerChoice();
        } else {
            computerChoice();
            
        }
        gamePlay(tossValue);
    }
    


    //function to display
	public void display() {

        System.out.println("+--------+-------+-------+");

		for(int i = 0; i < 3; i++) {

            System.out.print("|");

			for(int j = 0; j < 3; j++) {
   
                System.out.print(this.board[i][j]+" ");
                				             
                System.out.print("\t |");
			}
			System.out.println();
			System.out.println("+--------+-------+-------+");
        }
        
    }
    
    //function to check if player or computer chance
    public int toss(){
        Random rand = new Random();
		// Generating a random number b/w 0 and 1
		int checkOption = rand.nextInt(2);
		//option 1 = PLAYER <> option 2 = COMPUTER 
		if(checkOption == 1) {
            System.out.println("Player Chance to Play");
        }
		else {
            System.out.println("Computer Chance to Play");
        }
        return checkOption;
    }
    
    //function to consider player choice
    public void playerChoice(){
        System.out.println("Enter your Choice either 'X' or 'O'");
        playerValue=sc.next().charAt(0);
        if (playerValue == 'x'||playerValue == 'X') {
            System.out.println("Your Choice:"+playerValue);
            this.computerValue='O';
            
        } 
        else if(playerValue == 'o'||playerValue =='O') {
            System.out.println("Your Choice:"+playerValue);
            this.computerValue='X';

        }
        else{
            System.out.println("Wrong Input");

        }
    }
    
    //function for computer choice
    public void computerChoice(){
        Random rand = new Random();
        int computerChoice = rand.nextInt(2);
		//option 1 = PLAYER </> option 2 = COMPUTER 
		if(computerChoice == 1) {
            this.computerValue='X';
            System.out.println("Computer choice:"+this.computerValue);
            this.playerValue='O';
		}
		else {
            this.computerValue='O';
            System.out.println("Computer Choice:"+this.computerValue);
            this.playerValue='X';
		}

    }
    
    //function to start game after intial toss and play
    public void gamePlay(int tossResult) {
		Scanner sc = new Scanner(System.in);
		int move;
		while(true) {
			if(tossResult == 1) {
				System.out.println("Enter the move in range[1-9]");
				move = sc.nextInt();
				move -= 1;
				boolean moveValid = moveValid(move);
				
				if(!moveValid ) {
					System.out.println("Invalid Move Try Once More");
					continue;			
				}
				this.playerPosition.add(move);
				this.board[(int)(move / 3)][move % 3] = this.playerValue;
			}
			else {
				System.out.println("Computer Turn");
				computerMove();
			}
			
			this.display();
			
			String resultWinner=this.checkWinner();
			boolean dre = this.draw();
			if(resultWinner != null ) {
				System.out.println(resultWinner);
				if(resultWinner.charAt(0) == this.computerValue) {
					System.out.println("The winner is Computer");
					
				}
				else if(resultWinner.charAt(0) == this.playerValue) {
					System.out.println("The winner is Player");
					
				}
				else {
					System.out.println("The Game is Draw");
				}
				
				this.display();
				return;
			}
		
			if(tossResult == 0) {
				tossResult = 1;
			}
			else {
				tossResult = 0;
			}	
	    }
    }
    
    //function to check valid or invalid move
    public boolean moveValid(int move) {
		if(this.board[(int)(move / 3)][move % 3] == ' ') {
			return true;
		}
		return false;	
    }

    //function to play computer move
    public void computerMove() {	
        //Winning Position
		int move = this.checkAnyWinning(this.computerPosition);
		if( move != -1 && this.moveValid(move)) {
			this.board[(int)(move / 3)][move % 3] = this.computerValue;
			this.computerPosition.add(move);
			return;
        }
        //check winning position of player and choose that position
        move = this.checkAnyWinning(this.playerPosition);
        if( move != -1 && this.moveValid(move)) {
            this.board[(int)(move / 3)][move % 3] = this.computerValue;
            this.computerPosition.add(move);
            return;
        }
        //check corner positions
        int[] cornerPositions = { 0,2,4,8};
        for (int i = 0; i < cornerPositions.length; i++) {
            move=cornerPositions[i];
            if(this.moveValid(move)) {
				this.board[(int)(move / 3)][(int)(move % 3)] = this.computerValue;
				this.computerPosition.add(move);
                return;
            }
        }
        //check Centre Position
        if(this.moveValid(4)) {
            this.board[(int)(move / 3)][(int)(move % 3)] = this.computerValue;
            this.computerPosition.add(move);
            return;
        }
		//Random Sides
		int[] sidePositions = { 1,3,5,7};
        for (int i = 0; i < sidePositions.length; i++) {
            move=sidePositions[i];
            if(this.moveValid(move)) {
				this.board[(int)(move / 3)][(int)(move % 3)] = this.computerValue;
				this.computerPosition.add(move);
                return;
            }
        }
		
	}
    
    
    //function to check if equal values on board 
    boolean equals3(char a, char b, char c) {
        return (a == b && b == c && a != ' ');
    }

    //check winner function
    public String checkWinner() {
        isHorizontal();
        isVertical();
        isDiagonal();
        if (this.draw() == true && winner == null  ) {
            return "tie";
        } else {
            return winner;
        }
    }
    // horizontal
    public void isHorizontal(){
        for (int i = 0; i < 3; i++) {
            if (this.equals3(board[i][0], board[i][1], board[i][2])) {
            winner = Character.toString(board[i][0]);
            }
        }
    }
    // Vertical
    public void isVertical(){
        for (int i = 0; i < 3; i++) {
            if (equals3(board[0][i], board[1][i], board[2][i])) {
            winner = Character.toString(board[0][i]);
            }
        }
    }
    // Diagonal
    public void isDiagonal(){
        if (equals3(board[0][0], board[1][1], board[2][2])) {
            winner = Character.toString(board[0][0]);
        }
        if (equals3(board[2][0], board[1][1], board[0][2])) {
            winner = Character.toString(board[2][0]);
        }
    }

    //Checking for draw
	public boolean draw() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (this.board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
    }
    
    public int checkAnyWinning(ArrayList<Integer> position) {
		//Storing all the wining Positions
		int[][] winningPosition = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
                { 2, 4, 6 } };
		int count = 0;
		ArrayList<Integer> emptyPosition = new ArrayList<Integer>();
		while ( count < 8) {
			int countMatch=0;
			emptyPosition.clear();
			
			for(int i = 0; i < winningPosition[count].length; i++) {
				
				// if position array list contains winning positing incrementing by 1
				if (position.contains(winningPosition[count][i])) {
					countMatch++;
				}
				else {
					emptyPosition.add(winningPosition[count][i]);
				}
			}
			if( countMatch == 2 && emptyPosition.size() == 1) {
				return emptyPosition.get(0);
			}
			count++;
		}
		return -1;
	}
    
    TicTak() {
        board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				this.board[i][j] = ' ';
			}
		}
        playerPosition = new ArrayList<Integer>();
        computerPosition = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        System.out.println(" %%%%%%% TicTakToe %%%%%%% ");
        //OBJ created
        TicTak objTicTak = new TicTak();
        objTicTak.play();
        
    }
}
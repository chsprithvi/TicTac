import java.util.*;
public class TicTak{
    
    char[][] board= new char[3][3];
    char playerValue;
    char computerValue;
    int boardPosition;
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
        Scanner sc = new Scanner(System.in);
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
		//Random Sides
		while(true) {
            Random rand = new Random();
       
			int move = rand.nextInt(9);
			if(this.moveValid(move)) {
				this.board[(int)(move / 3)][(int)(move % 3)] = this.computerValue;
				this.computerPosition.add(move);
				return;
			}	
		}
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
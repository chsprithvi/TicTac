import java.util.*;
class TicTak{
    
    char[][] board= new char[3][3];
    Random rand = new Random();
    char playerValue;
    int boardPosition;
    int rowValue;
    int colValue;

    
    //Function play to start game
    public void play() {
        display();
        toss();
        
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
    public void toss(){

		// Generating a random number b/w 0 and 1
		int checkOption = rand.nextInt(2);
		//option 1 = PLAYER <> option 2 = COMPUTER 
		if(checkOption == 1) {
            System.out.println("Player Chance to Play");
            playerChoice();
        }
		else {
            System.out.println("Computer Chance to Play");
            computerChoice();
		}
    }
    
    //function to consider player choice
    public void playerChoice(){
        System.out.println("Enter your Choice either 'X' or 'O' ");
        Scanner sc = new Scanner(System.in);
        playerValue=sc.next().charAt(0);
        System.out.println("Enter your desired position b/w [1-9]");
        boardPosition=sc.nextInt();
        
        if (playerValue == 'x'||playerValue == 'X') {
            System.out.println("Your Choice:"+playerValue);
            setPosition(boardPosition,playerValue);
            
        } 
        else if(playerValue == 'o'||playerValue =='O') {
            System.out.println("Your Choice:"+playerValue);
            setPosition(boardPosition,playerValue);

        }
        else{
            System.out.println("Wrong Input");

        }
    }
    
    //function for computer choice
    public void computerChoice(){

        int computerValue = rand.nextInt(2);
		//option 1 = PLAYER <> option 2 = COMPUTER 
		if(computerValue == 1) {
			System.out.println("Computer choice: X");
		}
		else {
			System.out.println("Computer Choice: O");
		}

    }
    
    //function to set positions on board
    public void setPosition(int setPosition, char setValue){
        rowValue=(setPosition-1)/3;
        colValue=(setPosition-1)%3;
        this.board[rowValue][colValue]=setValue;
        display();                
    } 
    
  

    public static void main(String[] args) {
        System.out.println(" %%%%%%% TicTakToe %%%%%%% ");
        //OBJ created
        TicTak objTicTak = new TicTak();
        objTicTak.play();
        
    }
}
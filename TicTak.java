import java.util.*;
class TicTak{
    
    String[][] board= new String[3][3];

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
                if(board[i][j]==null){
                    System.out.print(" ");    
                }
				else{
                    System.out.print(this.board[i][j]+" ");
                }
				             
                System.out.print("\t |");
			}
			System.out.println();
			System.out.println("+--------+-------+-------+");
        }
        
    }
    
    //function to check if player or computer chance
    public void toss(){
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
	}
    
    
    public static void main(String[] args) {
        System.out.println(" %%%%%%% TicTakToe %%%%%%% ");
        //OBJ created
        TicTak objTicTak = new TicTak();
        objTicTak.play();
        
    }
}
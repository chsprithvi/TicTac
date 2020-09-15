class TicTak{
    
    String[][] board= new String[3][3];
    
    
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
                    System.out.print(board[i][j]+" ");
                }
				             
                System.out.print("\t |");
			}
			System.out.println();
			System.out.println("+--------+-------+-------+");
        }
        
	}
    
    public static void main(String[] args) {
        System.out.println(" %%%%%%% TicTakToe %%%%%%% ");
        //OBJ created
        TicTak objTicTak=new TicTak();
        objTicTak.display();
        
    }
}
    package MainApp;
    import java.util.Scanner;
    import java.util.Set;

    import CustomExceptions.*;
    import TicTacToe.DetermineWinner;
    import TicTacToe.TicTacToe;

    import java.util.HashSet;
    class Main extends TicTacToe
    {
        public static void main(String[] args) 
        {
            TicTacToe ttt=new TicTacToe();
            CustomExceptionsHandler ceh=new CustomExceptionsHandler();
            Scanner sc=new Scanner(System.in);
            System.out.println();
            boolean continueTheGame=false;
            do{
                continueTheGame=false;
                System.out.println("\t\t\t\t>>>-------------------------------------------<<<");
                System.out.println("\t\t\t\t{\tWELCOME TO THE TIC TAC TOE GAME\t\t}");
                System.out.println("\t\t\t\t<<<------------------------------------------->>>");
                System.out.println();

                //storing players names in an array
                String[] playerNames=new String[2];
                
                for(int i=0;i<2;i++)
                {
                    System.out.print("Enter Player "+(i+1)+" name : ");
                    playerNames[i]=sc.next();
                }
                System.out.println();

                //assigning symbols to the players
                char[] symbols={'X','O'};
                System.out.println(playerNames[0]+" for : "+'X');
                System.out.println(playerNames[1]+" for : "+'O');

                // Tic Tac Toe borad
                char[][] arr=new char[3][3];
                int k=0;
                System.out.println();
                
                for(int i=0;i<arr.length;i++)
                {
                    System.out.println("-------------");
                    System.out.print("| ");
                    for(int j=0;j<arr[i].length;j++)
                    {
                        System.out.print((++k)+" | ");
                        arr[i][j]=' ';    
                    }
                    System.out.println();
                    System.out.println("-------------");
                }

                //read the instructions before playing the game
                System.out.println("\nInstructions :- ");  
                System.out.println();
                System.out.println("1. Choose the spot between (1-9) and based on the availability.\n2. You must fill all 9 spots to get result.\n3."+playerNames[0]+" will go first.");
                ttt.printBoard(arr);

                int playerChoice=0;  // players choices of slots will be checked that it is available or not 
                boolean slotsAvailable=false;
                Set<Integer> bookedSlots=new HashSet<Integer>();
                bookedSlots.add(0);

                int count=0; // checking if all slots are filled or not if filled then game tie 
                do
                {
                    slotsAvailable=true;
                    if(bookedSlots.size()<10)
                    {
                        for(int i=0;i<2;i++)
                        {   
                            boolean playerGame=false;
                            do                              
                            {           
                                playerGame=false;
                                    System.out.print(playerNames[i]+" choice : ");
                                    if(sc.hasNextInt())
                                    {       
                                        playerChoice=sc.nextInt();            
                                        try{
                                            ceh.validate(playerChoice);  // if >9 or 1<
                                            ceh.checkSpotOccupied(bookedSlots,playerChoice);
                                        }
                                        catch(InvalidOptionEnteredException e)
                                        {
                                            System.out.println("Exception occurred : "+e.getMessage());
                                            System.out.println();
                                            playerGame=true;
                                        }
                                        catch(SpotOccupiedException e)
                                        {
                                            System.out.println("Exception occurred : "+e.getMessage());
                                            System.out.println();
                                            playerGame=true;              
                                        } 
                                    }
                                bookedSlots.add(playerChoice);
                            }while(playerGame);

                            count++;
                            System.out.println("count "+count);
                            ttt.fillBoard(arr,playerChoice,bookedSlots,symbols[i],playerNames[i]);
                            ttt.printBoard(arr);

                            if(DetermineWinner.determineWinner(arr,playerNames[i],count))
                            {
                                slotsAvailable=false;
                                break;
                            }   
                        }                
                    }
                    else slotsAvailable=false;

                }while(slotsAvailable);

                System.out.print("Do you want to play again ? Enter 1 for yes, 0 for No : "); // want to play another match
                int t=sc.nextInt();
                System.out.println();

                continueTheGame=(t==1);
                if(!continueTheGame){                         //don't want to play the match again....
                    System.out.println();
                    System.out.print("\t\t\tTHANK YOU FOR PLAYING THIS GAME");
                }
            }while(continueTheGame);
            sc.close();
    }
}


import java.util.Scanner;
import java.util.HashSet;
class InvalidOptionEntered extends Exception  // if user enter grater than 9 then this exception will be raised
{
    public InvalidOptionEntered(String s)
    { 
        super(s);
    }
}
class SpotOccupiedException extends Exception  // if user enters the booked slot again then this exception will be raised
{
    public SpotOccupiedException(String s)
    {
        super(s);
    }
}
class TTT
{
    static void validate(int playerChoice) throws InvalidOptionEntered     
    {
        if(9<playerChoice) 
        {
            throw new InvalidOptionEntered("The option is invalid...please enter between 1 and 9");
        }
    } 
    static void SpotOccupiedException(HashSet<Integer> containsEles,int playerChoice) throws SpotOccupiedException
    {
        if(containsEles.contains(playerChoice) || playerChoice>9)
        {
            throw new SpotOccupiedException("Sorry, this spot is occupied by someone..SpotEOcuupiedxception");
        }
    }
    public static void printBoard(char[][] arr)   // printing the board
    { 
        System.out.println("\t\t-------------");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print("\t\t| ");
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j]+" | ");
            }
            System.out.println();
            System.out.println("\t\t-------------");
        }
        System.out.println();
    }
    public static boolean checkWhoAreWin(char[][] arr,String player,int count)  // cheching who are win 
    {
        if((arr[0][0]=='X' && arr[0][1]=='X' && arr[0][2]=='X') || 
            (arr[1][0]=='X' && arr[1][1]=='X' && arr[1][2]=='X') || 
            (arr[2][0]=='X' && arr[2][1]=='X' && arr[2][2]=='X') || 
            (arr[0][0]=='X' && arr[1][0]=='X' && arr[2][0]=='X') || 
            (arr[0][1]=='X' && arr[1][1]=='X' && arr[2][1]=='X') || 
            (arr[0][2]=='X' && arr[1][2]=='X' && arr[2][2]=='X') || 
            (arr[0][0]=='X' && arr[1][1]=='X' && arr[2][2]=='X') || 
            (arr[0][2]=='X' && arr[1][1]=='X' && arr[2][0]=='X'))
            {
                System.out.println(player+" is won....congratulations "+player);
                System.out.println();
                return true;
            }
        else if((arr[0][0]=='O' && arr[0][1]=='O' && arr[0][2]=='O') || 
                (arr[1][0]=='O' && arr[1][1]=='O' && arr[1][2]=='O') || 
                (arr[2][0]=='O' && arr[2][1]=='O' && arr[2][2]=='O') || 
                (arr[0][0]=='O' && arr[1][0]=='O' && arr[2][0]=='O') || 
                (arr[0][1]=='O' && arr[1][1]=='O' && arr[2][1]=='O') || 
                (arr[0][2]=='O' && arr[1][2]=='O' && arr[2][2]=='O') || 
                (arr[0][0]=='O' && arr[1][1]=='O' && arr[2][2]=='O') || 
                (arr[0][2]=='O' && arr[1][1]=='O' && arr[2][0]=='O'))
                {
                    System.out.println(player+" is won....congratulations "+player);
                    System.out.println();
                    return true;
                }
        else if(count==9 || count==8)
        {
            System.out.println("Game over...Nobody has win");
            System.out.println();
            return true;
        }
        return false;
    }
    public static void fillBoard(char[][] arr,int playerChoice,HashSet<Integer> containsEles,char key,String player)  // filling the slots by user entered value
    {
            switch(playerChoice)
            {
                case 1: if(key=='X')  arr[0][0]=key;
                        else          arr[0][0]=key;
                        break;
                case 2: if(key=='X')  arr[0][1]=key;
                        else          arr[0][1]=key;
                        break;
                case 3: if(key=='X')  arr[0][2]=key;
                        else          arr[0][2]=key;
                        break;
                case 4: if(key=='X')  arr[1][0]=key;
                        else          arr[1][0]=key;
                        break;
                case 5: if(key=='X')  arr[1][1]=key;
                        else          arr[1][1]=key;
                        break;
                case 6: if(key=='X')  arr[1][2]=key;
                        else          arr[1][2]=key;
                        break;
                case 7: if(key=='X')  arr[2][0]=key;
                        else          arr[2][0]=key;
                        break;
                case 8: if(key=='X')  arr[2][1]=key;
                        else          arr[2][1]=key;
                        break;
                case 9: if(key=='X')  arr[2][2]=key;
                        else          arr[2][2]=key;
                        break;
            }
    }
}

class TicTacToe extends TTT
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String player1,player2;
        System.out.println();
        boolean continueTheGame=false;
        do{
            continueTheGame=false;
            System.out.println("\t\t\tWELCOME TO THE TIC TAC TOE GAME");
            System.out.println();
            System.out.print("Enter Player 1 name : ");
            player1=sc.next();
            System.out.print("Enter Player 2 name : ");
            player2=sc.next();
            System.out.println();
            System.out.println(player1+" for : "+'X');
            System.out.println(player2+" for : "+'O');
            char[][] arr=new char[3][3];
            int k=0;
            System.out.println();
            for(int i=0;i<arr.length;i++)
            {
                System.out.println("-----------");
                for(int j=0;j<arr[i].length;j++)
                {
                    System.out.print((++k)+" | ");
                    arr[i][j]=' ';    
                }
                System.out.println();
                System.out.println("-----------");
            }
            System.out.println("\nInstructions :- ");  //read the instructions before playing the game
            System.out.println();
            System.out.println("1. Insert the spot number (1-9) to put your sign.\n2. You must fill all 9 spots to get result.\n3. Player 1 will go first.\n4. Fill the slots\n");
            printBoard(arr);
            int player1Choice=0,player2Choice=0;  // players choices of slots will be checked....is it available or not 
            boolean allSpots=false;
            HashSet<Integer> containsEles=new HashSet<Integer>();
            containsEles.add(0);
            int count=0; // this is useful to check when the all 9 slots are filled and nobody has win 
            do
            {
                allSpots=true;
                if(containsEles.size()<10)
                {
                    boolean player1Ele=false;     
                    do                                 // for player 1 game 
                    {
                        
                        player1Ele=false;
                        System.out.print(player1+" choice : ");  
                        player1Choice=sc.nextInt();
                        try{
                            validate(player1Choice);  // if out off 9 slots
                        }
                        catch(InvalidOptionEntered e)
                        {
                            System.out.println("Exception occurred : "+e.getMessage());
                            System.out.println();
                            player1Ele=true;
                        }
                        player1Ele=false;
                        try{
                            SpotOccupiedException(containsEles,player1Choice);  // same slot entered again
                        }
                        catch(SpotOccupiedException e)
                        {
                            System.out.println("Exception occurred : "+e.getMessage());
                            System.out.println();
                            player1Ele=true;
                        }               
                        containsEles.add(player1Choice);
                    }while(player1Ele);
                    count++;
                    fillBoard(arr,player1Choice,containsEles,'X',player1);
                    printBoard(arr);
                    if(checkWhoAreWin(arr,player1,count))
                    {
                        break;
                    }   
                    boolean player2Ele=false;      
                    do                                         // for player 2 game
                    {
                        player2Ele=false;
                        System.out.print(player2+" choice : ");   
                        player2Choice=sc.nextInt();
                        try{
                            validate(player2Choice);  // if out off three options of rock paper sessor
                        }
                        catch(InvalidOptionEntered e)
                        {
                            System.out.println("Exception occurred : "+e.getMessage());
                            System.out.println();
                            player2Ele=true;
                        }
                        player2Ele=false;
                        try{
                            SpotOccupiedException(containsEles,player2Choice);  // if out off three options of rock paper sessor
                        }
                        catch(SpotOccupiedException e)
                        {
                            System.out.println("Exception occurred : "+e.getMessage());
                            System.out.println();
                            player2Ele=true;
                        }
                        containsEles.add(player2Choice);
                    }while(player2Ele);
                    count++;
                    fillBoard(arr,player2Choice,containsEles,'O',player2);   // filling the slots 
                    printBoard(arr); 
                    if(checkWhoAreWin(arr,player2,count))
                    
                    {
                        break;
                    }
                }
                else allSpots=false;

            }while(allSpots);

            System.out.print("Do you want to play agian then enter 1...otherwise enter 0  : "); // want to play another match
            int t=sc.nextInt();
            System.out.println();
            if(t==1) 
                continueTheGame=true;
            else                          //don't want to play the match again....
            {
                continueTheGame=false;
                System.out.println();
                System.out.print("\t\t\tTHANK YOU FOR PLAYING THIS GAME");
            }
        }while(continueTheGame);
    }
}
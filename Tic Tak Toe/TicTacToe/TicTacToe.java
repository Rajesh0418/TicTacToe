package TicTacToe;
import java.util.Set;

public class TicTacToe
{
    public void printBoard(char[][] arr)   // printing the board
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

    public void fillBoard(char[][] arr,int playerChoice,Set<Integer> containsEles,char key,String player)  // filling the slots by user entered value
    {
            switch(playerChoice)
            {
                case 1: arr[0][0]=key;      
                        break;
                case 2: arr[0][1]=key;
                        break;
                case 3: arr[0][2]=key;
                        break;
                case 4: arr[1][0]=key;
                        break;
                case 5: arr[1][1]=key;
                        break;
                case 6: arr[1][2]=key;
                        break;
                case 7: arr[2][0]=key;
                        break;
                case 8: arr[2][1]=key;
                        break;
                case 9: arr[2][2]=key;
                        break;
            }
    }
}

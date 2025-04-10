package TicTacToe;

public class DetermineWinner 
{
    public static boolean determineWinner(char[][] arr,String player,int count)  // cheching who are win 
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
        else if(count==9)
        {
            System.out.println("Game over...Nobody has win");
            System.out.println();
            return true;
        }
      return false;
    }
}

import java.util.Scanner;
public class Player extends Client{

    private int PLAYER1 = 1;
    private int PLAYER2 = 2;
    Player(String name,int number){
        super(name,number);
    }

    @Override
    public int whichHole(Board board) {
            Scanner number = new Scanner(System.in);
            int hole = number.nextInt();
            int index = 0;
            if(super.getNumberOfPlayer() == PLAYER1) index = hole-1;
            else index =hole + 6;
            while ((hole < 1 || hole > 6) || board.emptyHole(index)) {
                System.out.println("Wybrano niepoprawny numer : Taki dołek nie istnieje lub jest pusty");
                System.out.println("Podaj numer jeszcze raz: ");
                hole = number.nextInt();
                index = (super.getNumberOfPlayer() == PLAYER1) ? hole--: hole + 6;
            }
        return hole;
        }
}

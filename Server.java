import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Server {
    private Board board;
    private Client player1;
    private Client player2;
    private int PLAYER1 = 1;
    private int PLAYER2 = 2;
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);


    public int chooseGame() {
        System.out.println("Wybierz grę:");
        System.out.println("1.Gracz vs gracz");
        System.out.println("2.Gracz vs komputer");
        System.out.println("3.Komputer vs komputer");
        return input.nextInt();
    }

    public void initializeGame() {
        int choose = chooseGame();
        board = new Board();
        switch (choose) {
            case 1:
                System.out.println("Gracz1 -> Podaj nick: ");
                player1 = new Player(input2.nextLine(), PLAYER1);
                System.out.println("Gracz2 -> Podaj nick: ");
                player2 = new Player(input3.nextLine(), PLAYER2);
                break;
            case 2:
                System.out.println("Gracz1 -> Podaj nick: ");
                player1 = new Player(input2.nextLine(), PLAYER1);
                player2 = new Computer("Computer", PLAYER2);
                break;
            case 3:
                player1 = new Computer("Computer1", PLAYER1);
                player2 = new Computer("Computer2", PLAYER2);
                break;
            default:
                System.out.println("Nieprawidłowy numer");
                choice();
        }
    }

    public void choice() {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1.Zakończ grę");
        System.out.println("2.Zagraj jeszcze raz");
        switch (input.nextInt()) {
            case 1:
                System.out.println("Dziekuję za grę");
            case 2:
                startGame();
        }
    }

    public void startGame() {
        initializeGame();
        int player = PLAYER1;
        boolean cont = true;
        while (!board.isGameFinished() && cont) {
            if (player == PLAYER1) System.out.println(board.showBoard1());
            else System.out.println(board.showBoard2());
            System.out.println("Gracz nr: " + player);
            System.out.println("Podaj numer dołka: ");
            if (player == PLAYER1) player = board.movePebbles(player1.whichHole(board), PLAYER1);
            else player =  board.movePebbles(player2.whichHole(board), PLAYER2);
        }
            if (player == PLAYER1) System.out.println(board.showBoard2());
            else System.out.println(board.showBoard1());
            int result = board.results();
            String name;
            if (result == 1) name = player1.getName();
            else if (result == 2) name = player2.getName();
            else name = "remis";
            System.out.println("Wygrał gracz : " + name);
            System.out.println("Dziękuję za grę");

    }

}

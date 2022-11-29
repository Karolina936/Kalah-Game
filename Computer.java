class Computer extends Client {

    private int PLAYER1 = 1;
    private int PLAYER2 = 2;
    private int BASE1 = 6;
    private int BASE2 = 13;
    private int INDEX1 = 0;
    private int INDEX2 = 7;
    private int base;
    private int player = 0;
    private int move = -1;
    private int max = -1;
    private int hole = -1;
    private int index;
    private Board copyBoard;

    Computer(String name, int number)
        {
            super(name,number);
            if (super.numberOfPlayer == PLAYER1) base = BASE1;
            else  base = BASE2;
            if (super.numberOfPlayer == PLAYER1) index =  INDEX1;
            else index = INDEX2;
        }

        @Override
        public int whichHole(Board board) {
        int startBase;
        if(super.getNumberOfPlayer() == PLAYER1) startBase=board.getBoard()[BASE1].getPebbles();
        else startBase=board.getBoard()[BASE2].getPebbles();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Błąd z czasem");
        }
        chooseBestMove(board.copy(), super.getNumberOfPlayer(), startBase, -1);
        int choice = hole;
        hole = -1;
        max = -1;
        return choice;
    }

    public void chooseBestMove(Board board,int numberOfPlayer, int startBase, int holeNumber){
        for(int i=0; i<=5; i++) {
        if (!board.emptyHole(i + index)) {
        copyBoard = board.copy();
        player = copyBoard.movePebbles(i + 1, super.getNumberOfPlayer());
        move = copyBoard.getBoard()[base].getPebbles() - startBase;
        if (move > max) {
           max = move;
           if (holeNumber == -1) hole = i+1;
           else hole = holeNumber;
        }
        if (player == super.getNumberOfPlayer()) chooseBestMove(copyBoard, super.getNumberOfPlayer(), startBase,(holeNumber == -1)? i+1:holeNumber);
        }
        }
        }
}
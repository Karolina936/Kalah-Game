public class Board {
        private Hole [] board = new Hole[14];
        private int PLAYER1 = 1;
        private int PLAYER2 = 2;
        private int BASE1 = 6;
        private int BASE2 = 13;

         Board() {
             board[BASE1] = new Hole(0, true, PLAYER1);
             board[BASE2] = new Hole(0, true, PLAYER2);

             for (int i=0; i<=5; i++)
             {
                 board[i] = new Hole(6, false, PLAYER1);
                 board[i].setOpposite(12 - i);
             }

             for (int i=7; i<=12; i++)
             {
                 board[i] = new Hole(6, false, PLAYER2);
                 board[i].setOpposite(12 - i);
             }
         }
        public int movePebbles(int number, int whichPlayer) {
            int secondPlayer=0;
            if (whichPlayer == PLAYER1) secondPlayer=PLAYER2;
            else secondPlayer=PLAYER1;
            int numberHole=0;
            if (whichPlayer == PLAYER1) numberHole =  number-1;
            else numberHole = number + 6;
            int pebbles  = board[numberHole].getPebbles();
            int i = 1;
            if (pebbles == 0)  return -1;
                else
            {
                board[numberHole].setPebbles(0);
                while (pebbles > 0) {
                    if (board[(numberHole + i) % board.length].getBase() == true && board[(numberHole + i) % board.length].getPlayer() != whichPlayer)
                    {
                        i++;
                    }
                    else{
                        board[(numberHole + i) % board.length].incrementPebbles();
                        pebbles--;
                        i++;
                    }
                }
            }

            int lastIndex = (numberHole + i - 1) % board.length;
            int base = 0;

            if (lastIndex != BASE1 && lastIndex != BASE2 && board[lastIndex].getPebbles() == 1 && board[lastIndex].getPlayer() == whichPlayer && board[board[lastIndex].getOpposite()].getPebbles() != 0)
            {
                if (whichPlayer == PLAYER1) base = BASE1;
                else base = BASE2;
                board[base].setPebbles(board[base].getPebbles() + board[lastIndex].getPebbles() + board[board[lastIndex].getOpposite()].getPebbles());
                board[lastIndex].setPebbles(0);
                board[board[lastIndex].getOpposite()].setPebbles(0);
                return secondPlayer;
            }
           else if (board[lastIndex].getBase() == true && board[lastIndex].getPlayer() == whichPlayer) return whichPlayer;
           else return secondPlayer;
        }

         public boolean isGameFinished() {
             int emptyHole = 0;
             for(int i=0 ;i<=5; i++)
             {
                 if (board[i].getPebbles() == 0) emptyHole++;
             }
             if (emptyHole == BASE1) return true;

             emptyHole = 0;
             for(int i=7; i<=12;i++)
             {
                 if (board[i].getPebbles() == 0) emptyHole++;
             }
             if (emptyHole == 6) return true;

             return false;
         }


        public int results() {
            for(int i=0; i<=5; i++)
            {
                board[BASE1].setPebbles(board[BASE1].getPebbles() + board[i].getPebbles());
                board[i].setPebbles(0);
            }

            for(int i=7; i<=12; i++)
            {
                board[BASE2].setPebbles(board[BASE2].getPebbles() + board[i].getPebbles());
                board[i].setPebbles(0);
            }
            int player1 = board[BASE1].getPebbles();
            int player2 = board[BASE2].getPebbles();
            System.out.println("Wyniki: ");
            System.out.println(player1+" : "+player2);
            if (player1 > player2) return 1;
                else if (player1 < player2) return 2;
                return 0;
        }

        public String showBoard1() {

            String board1="\n    "+board[12].getPebbles()+" | "+board[11].getPebbles()+" | "+board[10].getPebbles()+" | "+board[9].getPebbles()+" | "+board[8].getPebbles()+" | "+board[7].getPebbles()+"\n" +
                     board[13].getPebbles()+"                           "+board[6].getPebbles()+"\n" +

            "    "+board[0].getPebbles()+" | "+board[1].getPebbles()+" | "+board[2].getPebbles()+" | "+board[3].getPebbles()+" | "+board[4].getPebbles()+" | "+board[5].getPebbles()+"\n";
            return board1;
        }
        public String showBoard2() {

            String board2 ="\n    "+board[5].getPebbles()+" | "+board[4].getPebbles()+" | "+board[3].getPebbles()+" | "+board[2].getPebbles()+" | "+board[1].getPebbles()+" | "+board[0].getPebbles()+"\n" +
                    " "+board[6].getPebbles()+"                         "+board[13].getPebbles()+"\n" +

            "    "+board[7].getPebbles()+" | "+board[8].getPebbles()+" | "+board[9].getPebbles()+" | "+board[10].getPebbles()+" | "+board[11].getPebbles()+" | "+board[12].getPebbles()+"\n";
            return board2;
        }

        public boolean emptyHole(int index ) {
            if (board[index].isEmpty()) return true;
            else  return false;
        }
        public Hole[] getBoard() {
            return board;
        }

        public void setBoard(Hole[] board) {
            this.board = board;
        }

        public Board copy() {
            Board copyBoard= new Board();
            for (int i=0; i<=board.length-1; i++)
            {
                copyBoard.getBoard()[i] = new Hole(board[i].getPebbles(), board[i].getBase(), board[i].getPlayer(), board[i].getOpposite());
            }
            return copyBoard;
        }

}

public class Hole {

    private int pebbles;
    private boolean base;
    private int player;
    private int opposite=-1;
    Hole(int pebbles,boolean base,int  player , int opposite)
    {
        this.pebbles = pebbles;
        this.base = base;
        this.player = player;
        this.opposite = opposite;
    }
    Hole(int pebbles, boolean base, int player)
    {
        this.pebbles = pebbles;
        this.base = base;
        this.player = player;
        this.opposite = -1;
    }
     public int getPebbles()
     {
         return pebbles;
     }
     public void setPebbles(int peb)
     {
         pebbles = peb;
     }
     public void incrementPebbles()
     {
         pebbles++;
     }

     public  boolean getBase()
     {
         return base;
     }
     public void setBase(boolean newBase)
     {
         base = newBase;
     }

    public int getPlayer()
    {
        return player;
    }

    public void setPlayer(int newPlayer)
    {
        player = newPlayer;
    }

    public boolean isEmpty()
    {
        if(pebbles==0) return true;
        else return false;
    }

    public int getOpposite()
    {
        return opposite;
    }

    public void setOpposite(int newOpp)
    {
        opposite = newOpp;
    }

}


public abstract class Client {

    String name = "";
    int numberOfPlayer = -1;

    Client(String name, int numberOfPlayer)
    {
        this.name = name;
        this.numberOfPlayer= numberOfPlayer;
    }
    public String getName()
    {
        return name;
    }

    public int getNumberOfPlayer()
    {
        return numberOfPlayer;
    }

    public abstract int whichHole(Board board);

}


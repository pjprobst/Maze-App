class square
{
    private int row;
    private int col;
    private int type;

    private boolean explored;
    private Square previous;

    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;
    

    public square(int ro, int co, int typ)
    {
        this.row = ro;
        this.col = co;
        this.type = typ;
        this.explored = false;
        this.previous = null;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getType()
    {
        return type;
    }

    public void setPrevious(Sqaure prev)
    {
        previous = prev;
    }

    public Square getPrevious()
    {
        return previous;
    }

    public boolean wasExplored()
    {
        return explored;
    }

    public boolean setExplored()
    {
        explored = true;
    }

    public void reset()
    {
        previous = null;
    }

    public String toString()
    {
        switch(type)
        {
            case SPACE:
            {
                if(explored)
                    return ".";
                //if is on solver work list
                //if is on the final path to exit
                return ("_");
            }
            case WALL:
            {
                return ("#");
            }
            case START:
            {
                return ("S");
            }
            case EXIT:
            {
                return ("E");
            }
        }
    }
}
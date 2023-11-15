class square{
    private int row;
    private int col;
    private int type;
    private char ctype;
    private boolean explored;
    private square previous;

    public square(int ro, int co, int typ) {
    this.row = ro;
    this.col = co;
    this.type = typ;
    explored = false;
    if (type == 0)
        ctype = '_';
    else if (type == 1)
        ctype = '#';
    else if (type == 2)
        ctype = 'S';
    else
        ctype = 'E';
    }

    public int getRow(){

        return row;
    }

    public int getCol(){

        return col;
    }

    public int getType(){

        return type;
    }
    
    public boolean isExplored()
    {
        return explored;
    }

    public void setExplored()
    {
        explored = true;
    }

    public void setCharType(char c)
    {
        ctype = c;
    }

    public void setPrevious(square sq) 
    {
        previous = sq;
    }

    public square getPrevious() 
    {
        return previous;
    }

    public void reset()
    {
        if (type == 0)
            ctype = '_';
        else if (type == 1)
            ctype = '#';
        else if (type == 2)
            ctype = 'S';
        else
            ctype = 'E';
        explored = false;
        previous = null;
    }

    public String toString()
    {
        String strtype = "" + ctype;
        return strtype;
    }
}
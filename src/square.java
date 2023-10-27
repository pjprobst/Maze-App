class square{
    private int row;
    private int col;
    private int type;
    public square(int ro, int co, int typ) {
    this.row = ro;
    this.col = co;
    this.type = typ;
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

    public String toString() {
        if (type == 0){
            return ("_ - empty space");
        }
        else if (type == 1){
            return ("# - wall");
        }
        else if (type == 2){
            return ("S - start");
        }
        else if (type == 3){
            return ("E - exit");
        }
        else {
            return "";
        }
    }
}
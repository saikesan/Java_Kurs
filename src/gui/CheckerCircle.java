package gui;

public class CheckerCircle
        extends Circle
{
    int row;
    int col;

    public Checker getChecker()
    {
        return checker;
    }
    Checker checker;

    public CheckerCircle(int row, int col, Rectangle rectangle, Checker checker)
    {
        super(rectangle);
        this.row = row;
        this.col = col;
        this.checker = checker;
    }
}

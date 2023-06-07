package gui;

public class Rectangle
        extends java.awt.Rectangle
{
    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    boolean isActive;

    public Rectangle(int x, int y)
    {
        super(x, y);
    }
}

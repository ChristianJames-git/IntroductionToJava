/**
 *  Program 8
 *  This program creates a display that allows the user to choose tools using buttons and place metal, water, sand, oil,
 *  cloud, and fire. Each has a behavior that dictates where it moves and what it does when in contact with other elements.
 *  CS108-3
 *  8 December 2019
 *  @author  Christian James
 */
import java.awt.*;
import java.util.*;

public class SandLab
{
  public static void main(String[] args)
  {
    SandLab lab = new SandLab(120, 80);
    lab.run();
  }
  
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int OIL = 4;
  public static final int CLOUD = 5;
  public static final int FIRE = 6;
  
  //do not add any more fields
  public int[][] grid;
  private SandDisplay display;

  /**
   * The constructor creates the display and grid and named elements
   * @param numRows
   * @param numCols
   */
  public SandLab(int numRows, int numCols)
  {
    String[] names;
    names = new String[7];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[OIL] = "Oil";
    names[CLOUD] = "Cloud";
    names[FIRE] = "Fire";
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    grid = new int[numRows][numCols];
  }

  /**
   * Upon click on the grid, set the location to the selected element if empty (or set to empty if empty is selected)
   * @param row
   * @param col
   * @param tool
   */
  private void locationClicked(int row, int col, int tool)
  {
    if (grid[row][col] == EMPTY)
      grid[row][col] = tool;
    else if (tool == EMPTY) {
      grid[row][col] = tool;
    }
  }

  /**
   * Copies each element of grid into the display with appropriate colors
   */
  public void updateDisplay()
  {
    int r,b,g;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == EMPTY) {
          r = 0; b = 0; g = 0;
        }
        else if (grid[i][j] == METAL) {
          r = 128; b = 128; g = 128;
        }
        else if (grid[i][j] == SAND) {
          r = 255; b = 250; g = 205;
        }
        else if (grid[i][j] == WATER) {
          r = 0; b = 0; g = 255;
        }
        else if (grid[i][j] == OIL) {
          r = 139; b = 69; g = 19;
        }
        else if (grid[i][j] == CLOUD) {
          r = 255; b = 255; g = 255;
        }
        else if (grid[i][j] == FIRE) {
          r = 255; b = 0; g = 0;
        }
        else {
          r = 0; b = 0; g = 0;
        }
        Color color = new Color(r,b,g);
        display.setColor(i, j, color);
      }
    }
  }

  /**
   * Called repeatedly. Causes a random pixel to maybe do something based on behavioral restrictions.
   * Metal doesn't move ever unless replaced with Empty. Sand falls through everythings except Metal.
   * Water falls through everything besides Sand and Metal. Oil only falls through Empty and Cloud.
   * Cloud rises until it hits the top or Metal and then turns into Water.
   * Water and Oil randomly shift left or right when not falling. This can't move Metal and only sometimes moves Sand (erosion).
   * Fire turns any adjacent oil into more fire, spreading, and turns adjacent water in steam (cloud). Otherwise it disappears.
   */
  public void step()
  {
    Random rand = new Random();
    int a = rand.nextInt(120);
    int b = rand.nextInt(80);
    if (a < 119) {
      switch (grid[a][b]) {
        case SAND:
          Sand.step(grid, a, b);
          break;
        case WATER:
          Water.step(grid, a, b);
          break;
        case OIL:
          Oil.step(grid, a, b);
          break;
        case CLOUD:
          Cloud.step(grid, a, b);
          break;
        case FIRE:
          Fire.step(grid, a, b);
          break;
        default:
      }
    }
  }

  /**
   * Infite loop that calls step() and updates display and tests for mouse clicks
   */
  public void run()
  {
    while (true)
    {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}

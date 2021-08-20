/**  Blob class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Blob extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Blob( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Blob( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }

    /** move:  calculates the new x position for the racer
     *   Blob move characteristics: "slow & steady wins the race"
     *      increment x by 1 most of the time
     */
    public void move( )
    {
        int move =  rand.nextInt( 100 )  + 1;
        if ( move < speed )
            setX( getX( ) + 2 );
    }

    /** draw: draws the Blob at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );

        g.setColor( new Color( 34, 0, 34 ) );

        //body
        g.fillOval( startX - 30, startY, 25, 15 );

        //flatten bottom
        g.clearRect( startX - 30, startY + 11, 35, 4 );

        //feet
        g.setColor( new Color( 80, 40, 100 ) );  // brown
        g.fillOval( startX - 27, startY + 10,  5, 5 );
        g.fillOval( startX - 13, startY + 10, 5, 5 );
    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this blob moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 50;
    }
    /**
     * Causes the blob to move up and down randomly
     * @param a
     */
    public void morph (boolean a) {
        if (a)
            setY(getY() + 5);
        else
            setY(getY() - 5);
    }
}
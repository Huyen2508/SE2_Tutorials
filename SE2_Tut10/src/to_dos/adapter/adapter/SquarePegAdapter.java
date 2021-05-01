package to_dos.adapter.adapter;

import to_dos.adapter.round.RoundPeg;
import to_dos.adapter.square.SquarePeg;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {
    //TO-DO: Declare an attribute: name = peg, type = SquarePeg
    private SquarePeg peg;
    //TO-DO: Declare the constructor with a parameter
    public SquarePegAdapter(SquarePeg squarePeg){
        this.peg = squarePeg;
    }
    //TO-DO: Implement getRadius() method
    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        //TO-DO: result = Square Root [(getRadius() of SquarePeg/2)^2) * 2)]
        result = Math.sqrt(Math.pow(peg.getWidth() /2, 2) * 2);
        return result;
    }
}

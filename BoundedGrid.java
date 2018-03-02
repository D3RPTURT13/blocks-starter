/**
 * BoundedGrid.java  04/30/14
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 */

import java.util.List;
import java.util.ArrayList;

// A BoundedGrid is a rectangular grid with a finite number of rows and columns.
public class BoundedGrid<E>
{
	private Object[][] occupantArray;  // the array storing the grid elements

	// Constructs an empty BoundedGrid with the given dimensions.
	// Precondition:  0 < rows and 0 < cols.
	public BoundedGrid(int rows, int cols)
	{
		occupantArray = new Object[rows][cols];
	}

	// Returns the number of rows.
	public int getNumRows()
	{
		return occupantArray.length;
	}

	// Returns the number of columns.
	public int getNumCols()
	{
		return occupantArray[0].length;
	}

	// Returns the object at location loc
	// (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	@SuppressWarnings("unchecked")
	public E get(Location loc)
	{
		return (E)occupantArray[loc.getRow()][loc.getCol()];
	}

	// Puts obj at location loc in this grid and returns the object previously
	// at that location (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	public E put(Location loc, E obj)
	{
		E oldOccupant = get(loc);
		occupantArray[loc.getRow()][loc.getCol()] = obj;
		return oldOccupant;
	}

	// Returns true if loc is valid in this grid, false otherwise.
	// Precondition:  loc is not null.
	public boolean isValid(Location loc)
	{
		int r = loc.getRow();
		int c = loc.getCol();

		return 0 <= r && r < getNumRows() &&
			    0 <= c && c < getNumCols();
	}

	// Removes the object at location loc from this grid and returns
	// the object that was removed (or null if the location is unoccupied).
	// Precondition:  loc is valid in this grid.
	public E remove(Location loc)
	{
		E result = get(loc);
		put(loc, null);
		return result;
	}

	// Returns a list of all occupied locations in this grid.
	public List<Location> getOccupiedLocations()
	{
		List<Location> occupiedLocs = new ArrayList<Location>();

		for (int r = 0; r < getNumRows(); r++)
			for (int c = 0; c < getNumCols(); c++)
			{
				Location loc = new Location(r, c);
				if (get(loc) != null)
					occupiedLocs.add(loc);
			}

		return occupiedLocs;
	}
}
package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (sdb) 
 * @version (Oct 2017)
 */
public class Doc implements Comparable<Doc>
{
    private int size;      // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size)
    {
        this.size = size;
    }
    
    public int size()
    {   return size;  }
    
    public String toString()
    {
    		return size + "";
    }

	public int compareTo(Doc o) {
		if(((Doc) o).size() > size)
			return 1;
		if(((Doc) o).size() < size)
			return -1;
		return 0;	
	}
}
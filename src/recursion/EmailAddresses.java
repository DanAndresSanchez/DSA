package recursion;
import java.util.*;

/** Maintain email addresses, with aliases.
 * @author (sdb)
 * @author (Dan Sanchez)
 */
public class EmailAddresses
{
  private Map <String, Set <String>>  book;

  public EmailAddresses ()
  {  book = new HashMap <String, Set <String>> ();  }

  /** Associate the given alias with the given people */
  public void add (String alias, Set <String> people)
  // Add this entry to the map
  {	
      book.put(alias , people);
  }

  
  /** @return All the email addresses corresponding to
   * the given alias, in a Set.
   */
  public Set <String> expandAlias (String alias)
  {	
	  Set<String> emails = new HashSet<String>();
	 
		
	  if(!book.containsKey(alias)) {
		  emails.add(alias);
		  return emails;
	  }
	  
	  Set<String> allValues = book.get(alias);
	  Iterator<String> itty = allValues.iterator();
	  while(itty.hasNext()) {
		  Set<String> expandedValues = expandAlias(itty.next());
		  emails.addAll(expandedValues);
	  }
		    
	  return emails;	  
  }	
}

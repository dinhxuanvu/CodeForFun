/**
 * File:
 *   $Id: Dealer.java,v 1.1 2013/04/16 20:31:31 vxd9797 Exp $
 *   
 * Revisions:
 *   $Log: Dealer.java,v $
 *   Revision 1.1  2013/04/16 20:31:31  vxd9797
 *   Initial Version
 *
 */

import java.util.*;

/**
 * Dealer implements the Dealer class
 * @author Aaron T Deever
 * @author Vu Dinh
 *
 */
public class Dealer {

	public static final int CARDS_PER_PACK = 5;
	public static final int COST_PER_CARD = 3;
	public static final int COST_PER_PACK = 10;
	
	/**
	 * Method to create and return a new BaseballCard object corresponding to a specific player.
	 * @param player - Name of player to create and return new BaseballCard.
	 * Return a new BaseballCard object.
	 */
	public BaseballCard buyCard(String player) {
		
		if (playerData.containsKey(player)) {
			return new BaseballCard(player, playerData.get(player));
		}
		else
			return null;
		
	}
	
	/**
	 * Method to create a Collection of BaseballCard objects representing a pack.
	 * Return a Collection of size CARDS_PER_PACK containing new BaseballCard objects.
	 * 
	 */
	public Collection<BaseballCard> buyPack() {
		
		Collection<BaseballCard> result = new HashSet<BaseballCard>();
		
		Iterator<String> it = playerData.keySet().iterator();
		String next;
		int cards = 0;
		
		while (cards++ < 5) {
			next = it.next();
			result.add(new BaseballCard(next, playerData.get(next)));
		}
		
		return result;
	}
	
	/**
	 * Method to create a collection of the entire special edition of cards that can be compared.
	 * Return a Collection containing a BaseballCard object for each player in the pack.
	 * 
	 */
	public Collection<BaseballCard> getCompleteSet() {
		
		Iterator<String> it = playerData.keySet().iterator();
		String next;
		Collection<BaseballCard> result = new HashSet<BaseballCard>();
		
		while (it.hasNext()) {
			next = it.next();
			result.add(new BaseballCard(next, playerData.get(next)));
		}
		
		return result;
	}
	
	/**
	 * Method to "trade" one BaseballCard for another.
	 * @param fanPlayer - Name of player BaseballCard that Fan wants to trade to Dealer.
	 * @param dealerPlayer - name of player BaseballCard that Fan wants to acquire from Dealer.
	 * Return a new BaseballCard object.
	 */
	public BaseballCard trade(String fanPlayer, String dealerPlayer) {
		
		if (playerData.containsKey(fanPlayer) && playerData.containsKey(dealerPlayer)) {
			BaseballCard fan = new BaseballCard(fanPlayer, playerData.get(fanPlayer));
			BaseballCard dealer = new BaseballCard(dealerPlayer, playerData.get(dealerPlayer));
			
			if (fan.compareTo(dealer) > 0) {
				return dealer;
			}
		}

		return null;
	}
	
	/* Dealer stores information about the baseball cards contained in this
	 * special edition.
	 */
	private HashMap<String, Integer> playerData = 
			new HashMap<String, Integer>();
	
	/**
	 * Constructor
	 */
	public Dealer() { 
		playerData.put("Bonds", 762);
		playerData.put("Aaron",  755);
		playerData.put("Ruth", 714);
		playerData.put("Mays",  660);
		playerData.put("Rodriguez",  647);
		playerData.put("Griffey", 630);
		playerData.put("Thome",  612);
		playerData.put("Sosa", 609);
		playerData.put("Robinson", 586);
		playerData.put("McGwire", 583);
	}

}
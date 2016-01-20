/**
 * File:
 *   $Id: Fan.java,v 1.1 2013/04/16 20:31:30 vxd9797 Exp $
 *   
 * Revisions:
 *   $Log: Fan.java,v $
 *   Revision 1.1  2013/04/16 20:31:30  vxd9797
 *   Initial Version
 *
 */

import java.util.*;

/**
 * Fan implements the Fan class.
 * @author Aaron T Deever
 * @author Vu Dinh
 *
 */
public class Fan {

	public static final int FAN_MONEY = 50;
	private List<BaseballCard> cards;
	private Dealer dealer;
	private int money;
	
	private Scanner in = new Scanner(System.in);
	
	/**
	 * Constructor
	 */
	public Fan() {
		cards = new ArrayList<BaseballCard>();
		dealer = new Dealer();
		this.money = FAN_MONEY;
	}
	
	/**
	 * Method to simulate a trade between Fan and Dealer.
	 */
	public void makeTrade() {
		System.out.println("What is the name of fan's card?");
		String fancard = in.next();
		System.out.println("What is the name of dealer's card?");
		String dealercard = in.next();
		
		boolean have = false;
		BaseballCard card = cards.get(0);
		
		for (int i = 0; i < cards.size() && !have; i++) {
			card = cards.get(i);
			if (card.getPlayerName().equals(fancard)) {
				have = true;
			}
		}
		if (have) {
			BaseballCard baseball = dealer.trade(fancard, dealercard);
			
			if (baseball != null) {
				cards.remove(card);
				cards.add(new BaseballCard(dealercard, baseball.getHomeRuns()));
				System.out.println("Trade is successful.");
			}
			else
				System.out.println("Trade is unsuccessful.");
		}
		else
		System.out.println("You don't have that card.");
	}
	
	/**
	 * Method to simulate a purchase of a card from the Dealer.
	 */
	public void purchaseCard() {
		
		System.out.println("What is the name of new card?");
		String fancard = in.next();
		
		if (money >= Dealer.COST_PER_CARD) {
			BaseballCard bc = dealer.buyCard(fancard);
			if (bc != null) {
				cards.add(new BaseballCard(fancard, bc.getHomeRuns()));
				money -= Dealer.COST_PER_CARD;
				System.out.println("Purchase is successful.");
			}
			else 
				System.out.println("Purchase is unsuccessful.");
		}
		else
		System.out.println("You don't have enough money.");
	}
	
	/**
	 * Method to simulate a purchase of a pack of cards from the Dealer. 
	 */
	public void purchasePack() {
		
		if (money >= Dealer.COST_PER_PACK) {
			
			money -= Dealer.COST_PER_PACK;
			
			BaseballCard next;
			
			Iterator<BaseballCard> it = dealer.buyPack().iterator();
			while (it.hasNext()) {
				next = it.next();
				cards.add(new BaseballCard(next.getPlayerName(), next.getHomeRuns()));
			}
			
				System.out.println("Purchase is successful.");
	
		}
		else
		System.out.println("You don't have enough money.");
		
	}
	
	/**
	 * Method to print the current status of the simulation. 
	 */
	public void status() {
		
		System.out.println("Fan has $" + money + " remaining.");
		System.out.println("Fan has: " + cards.toString());
		
		Collection<BaseballCard> needs = dealer.getCompleteSet();
		
		for (int i = 0; i < cards.size(); i++) {
			needs.remove(cards.get(i));	
		}
		
		System.out.println("Fan needs: " + needs);
		
		List<BaseballCard> extra = new ArrayList<BaseballCard>();
		
		for (int i = 0; i < cards.size(); i++) {
			if (cards.lastIndexOf(cards.get(i)) != i){
				extra.add(cards.get(i));
			}
		}
		
		System.out.println("Fan has extra: " + extra);
		
	}
	
	/**
	 * Main method for Baseball card simulation
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		if(args.length != 0) { 
			System.out.println("Usage: java Fan");
			return;
		}
		
		Fan fan = new Fan();
		fan.simulate();
	}
	
	/**
	 * Method to simulate the interaction of a Fan and Dealer to buy/trade cards
	 */
	public void simulate() { 
		
		boolean quit = false;
		
		do { 
			System.out.println();
			System.out.print("Options: buy (P)ack / buy (C)ard / (T)rade");
			System.out.println(" / (S)tatus / (Q)uit");
			System.out.print("Command: ");
			
			if(in.hasNext()) { 
				String cmd = in.next();
				switch(cmd.charAt(0)) { 
				case 'P':
				case 'p':
					purchasePack();
					break;
				case 'C':
				case 'c':
					purchaseCard();
					break;
				case 'T':
				case 't':
					makeTrade();
					break;
				case 'S':
				case 's':
					status();
					break;
				case 'Q':
				case 'q':
					quit = true;
					break;
				default:
					break;
				}
			}
			else { 
				return;
			}
			
		} while (!quit);
	}
	
	
}
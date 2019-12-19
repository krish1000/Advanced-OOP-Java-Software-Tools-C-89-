package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. A piggy bank owns a
 * collection (or possibly collections) of coins, but does not own the coins
 * themselves.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins from the piggy bank.
 */
public class OwnedPiggyBank {
	// YOU NEED TO ADD A FIELD OR FIELDS TO STORE THE COINS

	// created:
	private ArrayList<Coin> coinList;
	// given:
	private Owner owner;

	/**
	 * Initializes this piggy bank so that it has the specified owner and no coins.
	 * 
	 * @param owner the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		this.coinList = new ArrayList<Coin>();
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy bank
	 * will have the same owner and the same number and type of coins as the other
	 * piggy bank.
	 * 
	 * @param other the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
		this.owner = other.owner;
		this.coinList = new ArrayList<Coin>(other.coinList);
	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {

		return this.owner;
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		this.coinList.addAll(coins);
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		if (this.coinList.contains(coin)) {
			return true;
		}

		return false;
	}

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value of
	 * the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank, then the
	 * coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user the person trying to remove the coin
	 * @param coin a coin
	 * @return a coin equal to the value of the specified coin from this piggy bank,
	 *         or null if user is not the owner of this piggy bank @pre. the piggy
	 *         bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		if (user != this.owner) {
			return null;
		}
		this.coinList.remove(coin);

		return coin;
	}

	/**
	 * Allows the owner of this piggy bank to remove the smallest number of coins
	 * whose total value in cents is equal to the specified value in cents from this
	 * piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to the owner of
	 * this piggy bank.
	 * 
	 * @param user  the person trying to remove coins from this piggy bank
	 * @param value a value in cents
	 * @return the smallest number of coins whose total value in cents is equal to
	 *         the specified value in cents from this piggy bank @pre. the piggy
	 *         bank contains a group of coins whose total value is equal to
	 *         specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		if (user != this.owner) {
			return new ArrayList<Coin>();
		}
		int total = 0;
		ArrayList<Coin> yeeETlist = new ArrayList<Coin>(this.deepCopy());
		// Cant use Arrays.asList feelsbaaaaaad not imported
//		yeeETlist.add(Coin.PENNY);
//		yeeETlist.add(Coin.NICKEL);
//		yeeETlist.add(Coin.DIME);
//		yeeETlist.add(Coin.QUARTER);
//		yeeETlist.add(Coin.LOONIE);
//		yeeETlist.add(Coin.TOONIE);
		ArrayList<Coin> demcointho_equaltovalue = new ArrayList<Coin>();

		for (int i = yeeETlist.size() - 1; i > -1; i--) {
			if (total == value) {
				break;
			} else {
				int currcoin = yeeETlist.get(i).getValue();
				if (currcoin <= value && (total + currcoin) <= value) {
					total += currcoin;
					demcointho_equaltovalue.add(yeeETlist.get(i));
				}
			}

		}

		return demcointho_equaltovalue;
	}

	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list has
	 * its coins in sorted order (from smallest value to largest value; i.e.,
	 * pennies first, followed by nickels, dimes, quarters, loonies, and toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		ArrayList<Coin> temp = new ArrayList<Coin>();

		for (int i = 0; i < this.coinList.size(); i++) {
			temp.add(new Coin(this.coinList.get(i)));
		}

		Collections.sort(temp);
		return temp;
	}

	/**
	 * Counts the number of coins equal to the specified coin in this piggy bank.
	 * 
	 * <p>
	 * NOTE TO STUDENTS: You should create a private static helper method that
	 * recursively counts the number of coins in a specified list, array, or map
	 * depending on how you chose to implement the piggy bank. This method should
	 * then call the recursive method to get the required count.
	 * 
	 * @param coin a coin
	 * @return the number of coins equal to the specified coin in this piggy bank
	 */
	public int numberOf(Coin coin) {
		// YOU SHOULD MAKE A PRIVATE RECURSIVE HELPER METHOD AND CALL
		// THE HELPER METHOD

		int numof_coins = yeeter(coin, 0, this.coinList);

		return numof_coins;
	}

	// ADD A PRIVATE STATIC HELPER METHOD HERE
	private static int yeeter(Coin coin, int numof_coins, ArrayList<Coin> yeetCoinlist) {
		// trying out remove first yolo
		if (yeetCoinlist.size() == 0) {
			return numof_coins;
		} else if (yeetCoinlist.size() == 1) {
			if (yeetCoinlist.get(0).getValue() == coin.getValue()) {
				numof_coins++;
			}
			return numof_coins;
		} else if (yeetCoinlist.size() > 1) {
			if (yeetCoinlist.get(0).getValue() == coin.getValue()) {
				yeetCoinlist.remove(0);
				return yeeter(coin, numof_coins + 1, yeetCoinlist);
			} else {
				yeetCoinlist.remove(0);
				return yeeter(coin, numof_coins, yeetCoinlist);
			}
		} else {
			return numof_coins;
		}
	}

}

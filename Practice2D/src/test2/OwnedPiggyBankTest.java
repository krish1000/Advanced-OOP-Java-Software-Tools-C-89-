package test2;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OwnedPiggyBankTest {

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test
	public void test01_staticFields() {
		try {
			List<Field> fields = Arrays.asList(OwnedPiggyBank.class.getDeclaredFields());

			int nStatic = 0;
			for (Field f : fields) {
				int mod = f.getModifiers();
				if (Modifier.isStatic(mod)) {
					nStatic++;
				}
			}
			assertTrue("there should be no static fields", nStatic == 0);
		} catch (Exception x) {
			fail("exception occurred trying to get the fields of this class");
		}
	}
	
	
	@Test
	public void test02a_ctor() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		assertEquals("ctor set the wrong owner",
				w, b.getOwner());
	}
	
	@Test
	public void test02b_ctor() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		assertEquals("ctor did not make an empty list of coins",
				new ArrayList<Coin>(), b.deepCopy());
	}
	
	@Test
	public void test03a_copyCtor() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		OwnedPiggyBank c = new OwnedPiggyBank(b);
		assertEquals("copy ctor set the wrong owner",
				w, c.getOwner());
	}
	
	@Test
	public void test03b_copyCtor() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		List<Coin> coins = new ArrayList<Coin>(
				Arrays.asList(Coin.PENNY, Coin.LOONIE, Coin.TOONIE));
		b.add(coins);
		OwnedPiggyBank c = new OwnedPiggyBank(b);
		
		assertEquals("copy ctor did not copy the other list of coins",
				coins, c.deepCopy());
	}
	
	@Test
	public void test04a_getOwner() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		assertEquals("getOwner returned the wrong owner",
				w, b.getOwner());
	}
//	
	@Test
	public void test05a_addCoins() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		List<Coin> coins = new ArrayList<Coin>();
		b.add(coins);
		
		assertEquals("addCoins did not correctly add the coins",
				coins, b.deepCopy());
	}
	
	@Test
	public void test05b_addCoins() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		List<Coin> coins = new ArrayList<Coin>(
				Arrays.asList(Coin.PENNY));
		b.add(coins);
		
		assertEquals("addCoins did not correctly add the coins",
				coins, b.deepCopy());
	}
	
	
	@Test
	public void test05c_addCoins() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		List<Coin> coins = new ArrayList<Coin>(
				Arrays.asList(Coin.PENNY, Coin.LOONIE, Coin.TOONIE));
		b.add(coins);
		
		assertEquals("addCoins did not correctly add the coins",
				coins, b.deepCopy());
	}
	
	@Test
	public void test06a_contains() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.PENNY));
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.NICKEL));
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.DIME));
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.QUARTER));
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.LOONIE));
		assertFalse("contains returned true for an empty piggy bank!",
				b.contains(Coin.TOONIE));
	}
	
	@Test
	public void test06b_contains() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.NICKEL, Coin.DIME, 
				Coin.QUARTER, Coin.LOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.PENNY));
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.NICKEL));
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.DIME));
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.QUARTER));
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.LOONIE));
		assertTrue("contains returned false for a piggy bank with every coin",
				b.contains(Coin.TOONIE));
	}
	
	@Test
	public void test06c_contains() {
		List<Coin> coins = Arrays.asList(Coin.NICKEL, Coin.NICKEL, Coin.NICKEL);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		assertFalse("contains returned true for a piggy bank with only nickels",
				b.contains(Coin.PENNY));
		assertTrue("contains returned false for a piggy bank with only nickels",
				b.contains(Coin.NICKEL));
		assertFalse("contains returned false for a piggy bank with only nickels",
				b.contains(Coin.DIME));
		assertFalse("contains returned false for a piggy bank with only nickels",
				b.contains(Coin.QUARTER));
		assertFalse("contains returned false for a piggy bank with only nickels",
				b.contains(Coin.LOONIE));
		assertFalse("contains returned false for a piggy bank with only nickels",
				b.contains(Coin.TOONIE));
	}
	
	@Test
	public void test07a_remove() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.NICKEL, Coin.DIME, 
				Coin.QUARTER, Coin.LOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		Coin got = b.remove(w, Coin.PENNY);
		assertEquals("remove returned the wrong coin", Coin.PENNY, got);
				
		got = b.remove(w, Coin.NICKEL);
		assertEquals("remove returned the wrong coin", Coin.NICKEL, got);
		
		got = b.remove(w, Coin.DIME);
		assertEquals("remove returned the wrong coin", Coin.DIME, got);
		
		got = b.remove(w, Coin.QUARTER);
		assertEquals("remove returned the wrong coin", Coin.QUARTER, got);
		
		got = b.remove(w, Coin.LOONIE);
		assertEquals("remove returned the wrong coin", Coin.LOONIE, got);
		
		got = b.remove(w, Coin.TOONIE);
		assertEquals("remove returned the wrong coin", Coin.TOONIE, got);		
	}
//	
	@Test
	public void test07b_remove() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.NICKEL, Coin.DIME, 
				Coin.QUARTER, Coin.LOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		Coin got = b.remove(new Owner("Selina"), Coin.PENNY);
		assertNull("remove allowed a non-owner to remove a coin", got);
	}
	

	@Test
	public void test08a_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.PENNY);
		List<Coin> got = b.removeCoins(w, 1);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08b_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.PENNY, Coin.PENNY);
		List<Coin> got = b.removeCoins(w, 2);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08c_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.PENNY, Coin.NICKEL);
		List<Coin> got = b.removeCoins(w, 6);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08d_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.DIME);
		List<Coin> got = b.removeCoins(w, 10);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08e_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.PENNY, Coin.NICKEL, Coin.DIME);
		List<Coin> got = b.removeCoins(w, 16);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08f_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.DIME, Coin.DIME);
		List<Coin> got = b.removeCoins(w, 20);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08g_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.QUARTER);
		List<Coin> got = b.removeCoins(w, 25);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08h_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.DIME, Coin.QUARTER);
		List<Coin> got = b.removeCoins(w, 35);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08i_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.LOONIE);
		List<Coin> got = b.removeCoins(w, 100);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08j_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.DIME, Coin.LOONIE);
		List<Coin> got = b.removeCoins(w, 110);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08k_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = Arrays.asList(Coin.TOONIE);
		List<Coin> got = b.removeCoins(w, 200);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08l_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> exp = new ArrayList<Coin>(coins);
		List<Coin> got = b.removeCoins(w, 682);
		Collections.sort(got);
		assertEquals("removeCoins returned the wrong list of coins",
				exp, got);
	}
	
	@Test
	public void test08m_removeCoins() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> got = b.removeCoins(new Owner("Selina"), 1);
		assertEquals("removeCoins allowed a non-owner to remove coins", new ArrayList<Coin>(), got);
	}
	
	@Test
	public void test09a_deepCopy() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		List<Coin> got = b.deepCopy();
		got.add(Coin.LOONIE);

		assertEquals("deepCopy did not return a new list",
				new ArrayList<>(), b.deepCopy());
	}
	
	@Test
	public void test09b_deepCopy() {
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(Arrays.asList(Coin.PENNY));
		List<Coin> got = b.deepCopy();
		assertNotSame("deepCopy did not return new coins",
				Coin.PENNY, got.get(0));
	}
	
	@Test
	public void test09c_deepCopy() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY,  
				Coin.NICKEL, Coin.NICKEL, 
				Coin.DIME, Coin.DIME,
				Coin.QUARTER, Coin.QUARTER,
				Coin.LOONIE, Coin.LOONIE,
				Coin.TOONIE, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		List<Coin> got = b.deepCopy();
		assertEquals("deepCopy returned the wrong list of coins",
				coins, got);
	}
	
	
	@Test
	public void test10a_numberOf() {
		List<Coin> coins = Arrays.asList(Coin.PENNY);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		assertEquals("numberOf failed; " + coins + " has 1 penny",
				1, b.numberOf(Coin.PENNY));
	}
	
	@Test
	public void test10b_numberOf() {
		List<Coin> coins = Arrays.asList(Coin.PENNY);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		assertEquals("numberOf failed; " + coins + " has 0 nickels",
				0, b.numberOf(Coin.NICKEL));
	}
//	
	@Test
	public void test10c_numberOf() {
		List<Coin> coins = Arrays.asList(Coin.PENNY, Coin.PENNY, 
				Coin.DIME, Coin.QUARTER,
				Coin.PENNY, Coin.TOONIE);
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		b.add(coins);
		assertEquals("numberOf failed; " + coins + " has 3 pennies",
				3, b.numberOf(Coin.PENNY));
	}
	
	@Test
	public void test10d_numberOf() {
		List<Coin> coins = new ArrayList<>();
		Owner w = new Owner("Lola");
		OwnedPiggyBank b = new OwnedPiggyBank(w);
		assertEquals("numberOf failed; " + coins + " has 0 loonies",
				0, b.numberOf(Coin.LOONIE));
	}
}

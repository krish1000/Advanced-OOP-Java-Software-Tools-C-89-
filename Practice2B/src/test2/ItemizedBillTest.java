package test2;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemizedBillTest {

	private static Map<String, Boolean> results = new TreeMap<>();
	
	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			String test = description.getMethodName().substring(0, 6);
			results.put(test, false);
		}

		@Override
		protected void succeeded(Description description) {
			String test = description.getMethodName().substring(0, 6);
			if (!results.containsKey(test)) {
				results.put(test, true);
			}
		}
	};

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);

	private void guard(String test, String message) {
		if (results.containsKey(test)) {
			fail(message);
		}
	}
	
	@Test
	public void test01_staticFields() {
		try {
			List<Field> fields = Arrays.asList(ItemizedBill.class.getDeclaredFields());

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
	public void test02a_noArgCtor() {
		Date now = new Date();
		ItemizedBill b = new ItemizedBill();
		assertTrue("bad date", b.getDate().compareTo(now) >= 0);
	}

	@Test
	public void test02b_noArgCtor() {
		ItemizedBill b = new ItemizedBill();
		assertEquals("wrong total", 0, b.getTotal());
	}

	@Test
	public void test02c_noArgCtor() {
		ItemizedBill b = new ItemizedBill();
		assertEquals("wrong number of items", 0, b.getItems().size());
	}
//
	@Test
	public void test03a_ctor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		assertTrue("ctor set the wrong date", b.getDate().equals(now));
	}
//
	@Test
	public void test03b_ctor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		assertEquals("ctor set the wrong total", 50, b.getTotal());
	}

	@Test
	public void test03c_ctor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		assertEquals("ctor set the wrong number of items", 3, b.getItems().size());
	}

	@Test
	public void test03d_ctor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		now.setTime(0);
		assertFalse("ctor is not using composition for the date", b.getDate().equals(now));
	}

	@Test
	public void test03e_ctor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		items.add(new Item("", 50));
		assertEquals("ctor is not using composition for the list of items", 3, b.getItems().size());
	}
	
	@Test
	public void test04a_copyCtor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);

		ItemizedBill copy = new ItemizedBill(b);
		assertTrue("copy ctor set the wrong date", copy.getDate().equals(now));
	}

	@Test
	public void test04b_copyCtor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);

		ItemizedBill copy = new ItemizedBill(b);
		assertEquals("copy ctor set the wrong total", 50, copy.getTotal());
	}
	
	@Test
	public void test04c_copyCtor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);

		ItemizedBill copy = new ItemizedBill(b);
		assertEquals("copy ctor set the wrong number of items", 3, copy.getItems().size());
	}
	
	@Test
	public void test04d_copyCtor() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("", 10), new Item("", 15), new Item("", 25)));
		ItemizedBill b = new ItemizedBill(now, items);

		ItemizedBill copy = new ItemizedBill(b);
		b.addItem(new Item("", 100));
		assertEquals("copy ctor is not using composition for the list of items", 3, copy.getItems().size());
	}
	
	@Test
	public void test05a_getItems() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		
		assertEquals("getItems returned the wrong number of items", 3,
				b.getItems().size());
	}
	
	@Test
	public void test05b_getItems() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		List<Item> itemsCopy = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		
		assertEquals("getItems returned the wrong items", 
				itemsCopy, b.getItems());
	}
	
	@Test
	public void test05c_getItems() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		
		List<Item> got = b.getItems();
		
		assertNotSame("getItems has a privacy leak", 
				got, b.getItems());
	}
	
	@Test
	public void test06a_addItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item orange = new Item("orange", 5);
		b.addItem(orange);
		assertEquals("addItem followed by getTotal got the wrong total", 55, b.getTotal());
	}
	
	@Test
	public void test06b_addItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item orange = new Item("orange", 5);
		b.addItem(orange);
		assertEquals("addItem followed by getItems returned the wrong number of items", 4,
				b.getItems().size());
	}
	
	@Test
	public void test06c_addItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		List<Item> itemsCopy = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item orange = new Item("orange", 5);
		itemsCopy.add(orange);
		b.addItem(orange);
		assertEquals("addItem followed by getItems returned the wrong items",
				itemsCopy, b.getItems());
	}
	
	@Test
	public void test07a_removeItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item orange = new Item("orange", 5);
		try {
			b.removeItem(orange);
			fail("removeItem failed to throw an exception");
		}
		catch (NoSuchElementException x) {
			// ok
		}
		catch (Exception x) {
			fail("removeItem threw the wrong kind of exception");
		}
	}
	
	@Test
	public void test07b_removeItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		b.removeItem(new Item("milk", 15));
		assertEquals("removeItem followed by getTotal got the wrong total", 
				35, b.getTotal());
		b.removeItem(new Item("eggs", 10));
		assertEquals("removeItem followed by getTotal got the wrong total", 
				25, b.getTotal());
		b.removeItem(new Item("steak", 25));
		assertEquals("removeItem followed by getTotal got the wrong total", 
				0, b.getTotal());
	}
	
	@Test
	public void test07c_removeItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		b.removeItem(new Item("milk", 15));
		assertEquals("removeItem followed by getItems returned the wrong number of items", 
				2, b.getItems().size());
		b.removeItem(new Item("eggs", 10));
		assertEquals("removeItem followed by getItems returned the wrong number of items", 
				1, b.getItems().size());
		b.removeItem(new Item("steak", 25));
		assertEquals("removeItem followed by getItems returned the wrong number of items", 
				0, b.getItems().size());
	}
	
	@Test
	public void test07d_removeItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		List<Item> itemsCopy = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		b.removeItem(new Item("milk", 15));
		itemsCopy.remove(new Item("milk", 15));
		assertEquals("removeItem followed by getItems returned the wrong items", 
				itemsCopy, b.getItems());
		
		b.removeItem(new Item("eggs", 10));
		itemsCopy.remove(new Item("eggs", 10));
		assertEquals("removeItem followed by getItems returned the wrong items", 
				itemsCopy, b.getItems());
		
		b.removeItem(new Item("steak", 25));
		itemsCopy.remove(new Item("steak", 25));
		assertEquals("removeItem followed by getItems returned the wrong items", 
				itemsCopy, b.getItems());
	}
	
	@Test
	public void test08a_getDate() {
		Date now = new Date();
		Date exp = new Date(now.getTime());
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		assertEquals("getDate returned the wrong date", 
				exp, b.getDate());
	}
	
	@Test
	public void test08b_getDate() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("milk", 15), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		assertNotSame("getDate has a privacy leak", 
				b.getDate(), b.getDate());
	}
	
	
	@Test
	public void test09a_getMostExpensiveItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item exp = new Item("eggs", 10);
		assertEquals("getMostExpensiveItem returned the wrong item",
				exp, b.getMostExpensiveItem());
		assertNotSame("getMostExpensiveItem should return a copy of the item",
				b.getItems().get(0), b.getMostExpensiveItem());
	}
	
	@Test
	public void test09b_getMostExpensiveItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("eggs", 10), new Item("steak", 25)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item exp = new Item("steak", 25);
		assertEquals("getMostExpensiveItem returned the wrong item",
				exp, b.getMostExpensiveItem());
	}
	
	@Test
	public void test09c_getMostExpensiveItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("steak", 25), new Item("eggs", 10)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item exp = new Item("steak", 25);
		assertEquals("getMostExpensiveItem returned the wrong item",
				exp, b.getMostExpensiveItem());
	}
	
	@Test
	public void test09d_getMostExpensiveItem() {
		Date now = new Date();
		List<Item> items = new ArrayList<>(Arrays.asList(
				new Item("steak", 25), new Item("eggs", 10), 
				new Item("lobster", 30), new Item("carrots", 5)));
		ItemizedBill b = new ItemizedBill(now, items);
		Item exp = new Item("lobster", 30);
		assertEquals("getMostExpensiveItem returned the wrong item",
				exp, b.getMostExpensiveItem());
	}
}


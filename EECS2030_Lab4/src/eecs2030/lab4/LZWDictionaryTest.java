package eecs2030.lab4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class LZWDictionaryTest {

	@Test
	public void test_01_ctor() {

		LZWDictionary act = new LZWDictionary("ababababa");
		List<String> exp = Arrays.asList("a","b");
		Set<String> s = new LinkedHashSet<String>( (Collection<String>) exp);

		Map<String, Integer> cmap = act.getMap();
		List<String> clist = act.getList();


		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), cmap.size());
		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), clist.size());

		assertEquals("Map keys not correct", s, cmap.keySet());
		assertEquals("List entries not correct", s, new LinkedHashSet<String>((Collection<String>) clist));

		// indexes in map and/or list entries incorrect
		for (String key : cmap.keySet()) {
			int expIndex = exp.indexOf(key);
			int actIndexM = cmap.get(key);
			int actIndexL = clist.indexOf(key);
			assertEquals("index value for \"" + key + "\" not correct in map", expIndex, actIndexM);
			assertEquals("index value for \"" + key + "\" not correct in list", expIndex, actIndexL);

		}

	}


	@Test
	public void test_02_ctor() {

		LZWDictionary act = new LZWDictionary("#@$*@#($*@#$@(#*$@(#*$@#$");
		List<String> exp = Arrays.asList("#","@","$","*","(");
		Set<String> s = new LinkedHashSet<String>( (Collection<String>) exp);

		Map<String, Integer> cmap = act.getMap();
		List<String> clist = act.getList();


		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), cmap.size());
		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), clist.size());

		assertEquals("Map keys not correct", s, cmap.keySet());
		assertEquals("List entries not correct", s, new LinkedHashSet<String>((Collection<String>) clist));

		// indexes in map and/or list entries incorrect
		for (String key : cmap.keySet()) {
			int expIndex = exp.indexOf(key);
			int actIndexM = cmap.get(key);
			int actIndexL = clist.indexOf(key);
			assertEquals("index value for \"" + key + "\" not correct in map", expIndex, actIndexM);
			assertEquals("index value for \"" + key + "\" not correct in list", expIndex, actIndexL);

		}

	}


	@Test
	public void test_03_ctor() {

		LZWDictionary act = new LZWDictionary(" ");
		List<String> exp = Arrays.asList(" ");
		Set<String> s = new LinkedHashSet<String>( (Collection<String>) exp);

		Map<String, Integer> cmap = act.getMap();
		List<String> clist = act.getList();


		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), cmap.size());
		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), clist.size());

		assertEquals("Map keys not correct", s, cmap.keySet());
		assertEquals("List entries not correct", s, new LinkedHashSet<String>((Collection<String>) clist));

		// indexes in map and/or list entries incorrect
		for (String key : cmap.keySet()) {
			int expIndex = exp.indexOf(key);
			int actIndexM = cmap.get(key);
			int actIndexL = clist.indexOf(key);
			assertEquals("index value for \"" + key + "\" not correct in map", expIndex, actIndexM);
			assertEquals("index value for \"" + key + "\" not correct in list", expIndex, actIndexL);

		}

	}

	@Test
	public void test_04_ctor() {

		LZWDictionary act = new LZWDictionary("1214311212312312312124312413");
		List<String> exp = Arrays.asList("1","2","4","3");
		Set<String> s = new LinkedHashSet<String>( (Collection<String>) exp);

		Map<String, Integer> cmap = act.getMap();
		List<String> clist = act.getList();


		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), cmap.size());
		assertEquals("Number of entries in map vs list is inconsistent", exp.size(), clist.size());

		assertEquals("Map keys not correct", s, cmap.keySet());
		assertEquals("List entries not correct", s, new LinkedHashSet<String>((Collection<String>) clist));

		// indexes in map and/or list entries incorrect
		for (String key : cmap.keySet()) {
			int expIndex = exp.indexOf(key);
			int actIndexM = cmap.get(key);
			int actIndexL = clist.indexOf(key);
			assertEquals("index value for \"" + key + "\" not correct in map", expIndex, actIndexM);
			assertEquals("index value for \"" + key + "\" not correct in list", expIndex, actIndexL);

		}

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_05_ctor_throws() {

		new LZWDictionary("");

	}

	@Test
	public void test_06_indexOf() {

		LZWDictionary act = new LZWDictionary("ababababa");
		List<String> exp = Arrays.asList("a","b");


		// test indexOf
		for (int i=0; i<exp.size(); i++) {
			int expIndex = i;
			int actIndex = act.indexOf(exp.get(i));
			assertEquals("index value for \"" + exp.get(i) + "\" not correct", expIndex, actIndex);

		}

	}

	@Test
	public void test_07_indexOf() {

		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");


		// test indexOf
		for (int i=0; i<exp.size(); i++) {
			int expIndex = i;
			int actIndex = act.indexOf(exp.get(i));
			assertEquals("index value for \"" + exp.get(i) + "\" not correct", expIndex, actIndex);

		}

	}

	@Test
	public void test_08_indexOf_bad() {

		LZWDictionary act = new LZWDictionary("$%#@%HJC");
		List<String> exp = Arrays.asList("a","b","e","c");


		// test indexOf
		for (int i=0; i<exp.size(); i++) {
			int expIndex = -1;
			int actIndex = act.indexOf(exp.get(i));
			assertEquals("index value for \"" + exp.get(i) + "\" not correct", expIndex, actIndex);

		}

	}

	@Test
	public void test_09_get() {

		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");


		// test get
		for (int i=0; i<exp.size(); i++) {
			String expString = exp.get(i);
			String actString = act.get(i);
			assertEquals("entry for index [" + i + "] not correct", expString, actString);

		}

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_10_get_throws_neg() {

		LZWDictionary act = new LZWDictionary("ababaecbaba");

		act.get(-1);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test_11_get_throws_large() {

		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");

		act.get(exp.size());

	}


	@Test
	public void test_12_hasIndex() {


		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");

		assertEquals(false, act.hasIndex(-1));
		assertEquals(true, act.hasIndex(0));
		assertEquals(true, act.hasIndex(exp.size()/2));
		assertEquals(true, act.hasIndex(exp.size()-1));
		assertEquals(false, act.hasIndex(exp.size()));
		assertEquals(false, act.hasIndex(exp.size()+1));

	}

	@Test
	public void test_13_add() {


		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");
		List<String> change = Arrays.asList("ab","ba","aba","bae");
		int n;

		for (int i=0; i<exp.size(); i++) {

			Map<String, Integer> prevmap = new LinkedHashMap<String,Integer>(act.getMap());
			List<String> prevlist = new ArrayList<String>(act.getList());

			n = act.add(exp.get(i));
			assertEquals("Map should not change when adding existing entry",  prevmap, act.getMap());
			assertEquals("List should not change when adding existing entry",  prevlist, act.getList());
			assertEquals("An incorrect index was returned by add", i , n);

			n = act.add(change.get(i));
			assertEquals("An incorrect index was returned by add", prevlist.size() , n);
			prevmap.put(change.get(i), prevmap.size());
			prevlist.add(change.get(i));
			assertEquals("Map did not add new entry", prevmap , act.getMap());
			assertEquals("List did not add new entry", prevlist , act.getList());
			
		}


	}

	@Test
	public void test_14_contains() {


		LZWDictionary act = new LZWDictionary("ababaecbaba");
		List<String> exp = Arrays.asList("a","b","e","c");
		List<String> change = Arrays.asList("ab","ba","aba","bae");

		for (int i=0; i<exp.size(); i++) {

			assertEquals("dictionary should contain \"" + exp.get(i) + "\" ",  true, act.contains(exp.get(i)) );
			assertEquals("dictionary should NOT contain \"" + change.get(i) + "\" ",  false, act.contains(change.get(i)) );

		}


	}

	@Test
	public void test_15_size() {


		LZWDictionary act;

		act = new LZWDictionary("ababaecbaba");
		assertEquals("incorrect size ",  4, act.size() );

		act = new LZWDictionary(" ");
		assertEquals("incorrect size ",  1, act.size() );

		act = new LZWDictionary("#@$*@#($*@#$@(#*$@(#*$@#$");
		assertEquals("incorrect size ",  5, act.size() );

		act = new LZWDictionary("1234567890");
		assertEquals("incorrect size ",  10, act.size() );

		act.getList().clear();
		act.getMap().clear();
		assertEquals("incorrect size ",  -1, act.size() );


	}

	@Test
	public void test_16_toString() {


		LZWDictionary act;
		String exp;
		
		act = new LZWDictionary("ababababa");
		exp = "{a=0, b=1}";
		assertEquals("incorrect toString ",  exp, act.toString() );

		act = new LZWDictionary(" ");
		exp = "{ =0}";
		assertEquals("incorrect toString ",  exp, act.toString() );

		act = new LZWDictionary("#@$*@#($*@#$@(#*$@(#*$@#$");
		exp = "{#=0, @=1, $=2, *=3, (=4}";
		assertEquals("incorrect toString ",  exp, act.toString() );

		act = new LZWDictionary("1231411212312312312124312413");
		exp = "{1=0, 2=1, 3=2, 4=3}";
		assertEquals("incorrect toString ",  exp, act.toString() );

	


	}




}

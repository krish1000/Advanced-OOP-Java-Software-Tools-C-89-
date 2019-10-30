package eecs2030.lab4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class LZWCompressorTest {

	
	
	@Test
	public void test_01_ctor() {
		
		LZWCompressor act = new LZWCompressor("ababababa");
		
		List<String> cset = Arrays.asList("a","b");
		List<Integer> csetI = Arrays.asList(0,1);
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		
		for (int i=0; i<cset.size(); i++)
			cmap.put(cset.get(i), csetI.get(i));
			
		
		assertEquals("ababababa", act.getInput());
		assertEquals(cmap, act.getDictionary().getMap());
		assertEquals(cset, act.getDictionary().getList());
		
	}
	
	@Test
	public void test_02_ctor() {
		
		LZWCompressor act = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
		
		List<String> cset = Arrays.asList("#","@","$","*","(");
		List<Integer> csetI = Arrays.asList(0,1,2,3,4);
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		
		for (int i=0; i<cset.size(); i++)
			cmap.put(cset.get(i), csetI.get(i));
			
		
		assertEquals("#@$*@#($*@#$@(#*$@(#*$@#$", act.getInput());
		assertEquals(cmap, act.getDictionary().getMap());
		assertEquals(cset, act.getDictionary().getList());
		
	}
	
	@Test
	public void test_03_ctor() {
		
		LZWCompressor act = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$ ");
		
		List<String> cset = Arrays.asList("#","@","$","*","(", " ");
		List<Integer> csetI = Arrays.asList(0,1,2,3,4,5);
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		
		for (int i=0; i<cset.size(); i++)
			cmap.put(cset.get(i), csetI.get(i));
			
		
		assertEquals("#@$*@#($*@#$@(#*$@(#*$@#$ ", act.getInput());
		assertEquals(cmap, act.getDictionary().getMap());
		assertEquals(cset, act.getDictionary().getList());

		
	}
	
	@Test
	public void test_04_ctor(){
		
		LZWCompressor act = new LZWCompressor(" #@$*@#($*@#$@(#*$@(#*$@#$ ");
		
		List<String> cset = Arrays.asList("#","@","$","*","(", " ");
		List<String> cset2 = Arrays.asList(" ", "#","@","$","*","(");
		List<Integer> csetI = Arrays.asList(0,1,2,3,4,5);
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		
		for (int i=0; i<cset.size(); i++)
			cmap.put(cset2.get(i), csetI.get(i));
			
	
		assertEquals(" #@$*@#($*@#$@(#*$@(#*$@#$ ", act.getInput());
		assertEquals(cmap, act.getDictionary().getMap());
		assertEquals(cset2, act.getDictionary().getList());

	}
	
	@Test
	public void test_05_ctor() {
		
		LZWCompressor act = new LZWCompressor("1231411212312312312124312413");
		
		List<String> cset = Arrays.asList("1","2","3","4");
		List<Integer> csetI = Arrays.asList(0,1,2,3);
		Map<String,Integer> cmap = new HashMap<String, Integer>();
		
		for (int i=0; i<cset.size(); i++)
			cmap.put(cset.get(i), csetI.get(i));
			
	
		assertEquals("1231411212312312312124312413", act.getInput());
		assertEquals(cmap, act.getDictionary().getMap());
		assertEquals(cset, act.getDictionary().getList());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_06_ctor_throws() {
		
		new LZWCompressor("");
	
	}



	@Test
	public void test_07_encode() {
		LZWCompressor codec = new LZWCompressor("ababababa");
		List<Integer> exp = Arrays.asList(0,1,2,4,3);
		
		List<Integer> act = codec.encode();
		assertEquals(exp, act);

		
	}
	
	@Test
	public void test_08_encode() {
		LZWCompressor codec = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
		List<Integer> exp = Arrays.asList(0,1,2,3,1,0,4,7,9,2,1,4,0,3,14,16,18,13);
		
		List<Integer> act = codec.encode();
		assertEquals(exp, act);
		

	}
	
	@Test
	public void test_09_encode() {
		LZWCompressor codec = new LZWCompressor("the fat the cat the bat the rat the mat the sat the tat");
		List<Integer> exp = Arrays.asList(0, 1, 2, 3, 4, 5, 0, 3, 11, 13, 6, 16, 18, 12, 3, 7, 22, 19, 3, 8, 27, 24, 9, 31, 13, 10, 34, 18, 16);
		
		List<Integer> act = codec.encode();
		assertEquals(exp, act);
		
		String dec = codec.decode(act);
		assertEquals("the fat the cat the bat the rat the mat the sat the tat", dec);
		
	}	
	
	@Test
	public void test_10_encode() {
		LZWCompressor codec = new LZWCompressor("1231411212312312312124312413");
		List<Integer> exp = Arrays.asList(0, 1, 2, 0, 3, 0, 4, 4, 6, 5, 11, 10, 1, 3, 12, 8, 2);
		
		List<Integer> act = codec.encode();
		assertEquals(exp, act);
		

		
	}
	
	@Test
	public void test_11_encode() {
		LZWCompressor codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");
		List<Integer> exp = Arrays.asList(0, 1, 2, 3, 4, 0, 10, 2, 5, 14, 16, 6, 19, 11, 7, 22, 2, 8, 25, 9, 25, 0, 25, 13, 15, 11, 18, 34, 2, 21, 37, 24, 37, 27, 37, 29, 37);
		
		List<Integer> act = codec.encode();
		assertEquals(exp, act);
		
	}
	
	@Test
	public void test_12_encode_invariant() {
		LZWCompressor codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");
		
		Map<String,Integer> cmap = new HashMap<String, Integer>(codec.getDictionary().getMap());
		List<String> clist = new ArrayList<String>(codec.getDictionary().getList());
		
		codec.encode();
		
		assertEquals("Class invariant not maintained after encode",clist, codec.getDictionary().getList());
		assertEquals("Class invariant not maintained after encode", cmap, codec.getDictionary().getMap());
		
	}
	

	
	
	@Test
	public void test_13_decode() {
		LZWCompressor codec = new LZWCompressor("ababababa");
		List<Integer> enc = Arrays.asList(0,1,2,4,3);
		
				
		String dec = codec.decode(enc);
		assertEquals("ababababa", dec);
		
	}
	

	
	@Test
	public void test_14_decode() {
		LZWCompressor codec = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
		List<Integer> enc = Arrays.asList(0,1,2,3,1,0,4,7,9,2,1,4,0,3,14,16,18,13);
		
		
		String dec = codec.decode(enc);
		assertEquals("#@$*@#($*@#$@(#*$@(#*$@#$", dec);
	}
	

	
	@Test
	public void test_15_decode() {
		LZWCompressor codec = new LZWCompressor("the fat the cat the bat the rat the mat the sat the tat");
		List<Integer> enc = Arrays.asList(0, 1, 2, 3, 4, 5, 0, 3, 11, 13, 6, 16, 18, 12, 3, 7, 22, 19, 3, 8, 27, 24, 9, 31, 13, 10, 34, 18, 16);
		
		
		String dec = codec.decode(enc);
		assertEquals("the fat the cat the bat the rat the mat the sat the tat", dec);
		
	}


	

	@Test
	public void test_16_decode() {
		LZWCompressor codec = new LZWCompressor("1231411212312312312124312413");
		List<Integer> enc = Arrays.asList(0, 1, 2, 0, 3, 0, 4, 4, 6, 5, 11, 10, 1, 3, 12, 8, 2);
		
		String dec = codec.decode(enc);
		assertEquals("1231411212312312312124312413", dec);
		
		
	}

	
	
	@Test
	public void test_17_decode() {
		LZWCompressor codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");
		List<Integer> enc = Arrays.asList(0, 1, 2, 3, 4, 0, 10, 2, 5, 14, 16, 6, 19, 11, 7, 22, 2, 8, 25, 9, 25, 0, 25, 13, 15, 11, 18, 34, 2, 21, 37, 24, 37, 27, 37, 29, 37);
		
		String dec = codec.decode(enc);
		assertEquals("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe", dec);
		
	}
	
	
	
	@Test (expected = IllegalArgumentException.class)
	public void test_17_decode_throws() {
		LZWCompressor codec = new LZWCompressor(" ");
		List<Integer> enc = new ArrayList<Integer>();
		
		codec.decode(enc);

		
	}
	
	@Test
	public void test_18_decode_invariant() {
		LZWCompressor codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");
		List<Integer> enc = Arrays.asList(0, 1, 2, 3, 4, 0, 10, 2, 5, 14, 16, 6, 19, 11, 7, 22, 2, 8, 25, 9, 25, 0, 25, 13, 15, 11, 18, 34, 2, 21, 37, 24, 37, 27, 37, 29, 37);

		Map<String,Integer> cmap = new HashMap<String, Integer>(codec.getDictionary().getMap());
		List<String> clist = new ArrayList<String>(codec.getDictionary().getList());
		
		codec.decode(enc);
		
		assertEquals("Dictionary not reset after decode", clist, codec.getDictionary().getList());
		assertEquals("Dictionary not reset after decode", cmap, codec.getDictionary().getMap());
		
	}
	

	

	@Test
	public void test_19_CompressionRatio() {
		
		double delta = 1e-9;
		
		LZWCompressor codec;
		
		codec = new LZWCompressor("ababababa");
		assertEquals("wrong compression ratio", 1.8, codec.compressionRatio(), delta);
		
		codec = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
		assertEquals("wrong compression ratio", 1.3888888888888888, codec.compressionRatio(), delta);
		
		codec = new LZWCompressor("the fat the cat the bat the rat the mat the sat the tat");
		assertEquals("wrong compression ratio", 1.896551724137931, codec.compressionRatio(), delta);
		
		codec = new LZWCompressor("1231411212312312312124312413");
		assertEquals("wrong compression ratio", 1.6470588235294117, codec.compressionRatio(), delta);
		
		codec = new LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");
		assertEquals("wrong compression ratio", 2.189189189189189, codec.compressionRatio(), delta);
		
		codec = new LZWCompressor(" ");
		assertEquals("wrong compression ratio", 1.0, codec.compressionRatio(), delta);
		
		
	}

}

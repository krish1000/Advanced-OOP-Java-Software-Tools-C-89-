import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	  TestOneArrayDictionary.class ,
	  TestTwoArrayDictionary.class ,
	  TestArrayImplementations.class
	}) 
public class AllTests {
}
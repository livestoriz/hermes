package hk.hku.cecid.edi.as2.admin.listener;

import java.lang.reflect.Method;

import junit.framework.TestCase;
import hk.hku.cecid.edi.as2.admin.listener.MessageHistoryPageletAdaptorTest;

public class MessageHistoryPageletAdaptorTest extends TestCase {

		private MessageHistoryPageletAdaptor adaptor = new MessageHistoryPageletAdaptor();
		
		// Invoked for setup.
		public void setUp() throws Exception {
			System.out.println();
			System.out.println("---------" + this.getName() + " Start -------");
		}
		
		// Invoked for finalized.
		public void tearDown() throws Exception {
			System.out.println("---------" + this.getName() + " End   -------");
		}	
		
		public void testCheckEmptyAndConvertToPercent() throws Exception {
			Method m = Class.forName("hk.hku.cecid.edi.as2.admin.listener.MessageHistoryPageletAdaptor").
				getDeclaredMethod("checkEmptyAndConvertToPercent", new Class[] {String.class});
			m.setAccessible(true);
			TestCase.assertEquals("abcdefg", (String)m.invoke(adaptor, new Object[] {"abcdefg"}));
			TestCase.assertEquals("%", (String)m.invoke(adaptor, new Object[] {null}));
			TestCase.assertEquals("%", (String)m.invoke(adaptor, new Object[] {""}));
		}	
		
		public void testCheckNullAndReturnEmpty() throws Exception {
			Method m = Class.forName("hk.hku.cecid.edi.as2.admin.listener.MessageHistoryPageletAdaptor").
				getDeclaredMethod("checkNullAndReturnEmpty", new Class[] {String.class});
			m.setAccessible(true);
			TestCase.assertEquals("abcdefg", (String)m.invoke(adaptor, new Object[] {"abcdefg"}));
			TestCase.assertEquals("", (String)m.invoke(adaptor, new Object[] {null}));
			
		}
		
		public void testCheckStarAndConvertToPercent() throws Exception {
			Method m = Class.forName("hk.hku.cecid.edi.as2.admin.listener.MessageHistoryPageletAdaptor").
			getDeclaredMethod("checkStarAndConvertToPercent", new Class[] {String.class});
			m.setAccessible(true);
			TestCase.assertEquals("abcdefg", (String)m.invoke(adaptor, new Object[] {"abcdefg"}));
			TestCase.assertEquals("%", (String)m.invoke(adaptor, new Object[] {null}));
			TestCase.assertEquals("%", (String)m.invoke(adaptor, new Object[] {""}));
			TestCase.assertEquals("%", (String)m.invoke(adaptor, new Object[] {"*"}));
			TestCase.assertEquals("abc\\_def", (String)m.invoke(adaptor, new Object[] {"abc_def"}));
			TestCase.assertEquals("abc\\%def", (String)m.invoke(adaptor, new Object[] {"abc%def"}));
			TestCase.assertEquals("abc%def", (String)m.invoke(adaptor, new Object[] {"abc*def"}));
			TestCase.assertEquals("\\%%\\_\\_%\\%", (String)m.invoke(adaptor, new Object[] {"%*__*%"}));
		}
}

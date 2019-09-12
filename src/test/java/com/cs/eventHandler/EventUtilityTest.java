package com.cs.eventHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;
import org.junit.Test;
import com.cs.model.Event;
import com.cs.utils.EventUtility;

/*Added Junit test case of one class.*/

public class EventUtilityTest {
	
	@Test 
	public void testReadJsonToList() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("log.txt").getFile());		
		List<Event> eventlist=EventUtility.readJsonToList(file.getAbsolutePath());
		assertNotNull(eventlist);
		assertEquals(6, eventlist.size());
		System.out.println(eventlist.size());
	}
}

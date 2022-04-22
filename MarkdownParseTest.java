import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List.*;

import static org.junit.Assert.*; // This line imports the JUnit assert class
import org.junit.*; // This line imports all classes from JUnit?

public class MarkdownParseTest { // creates a new class
    @Test // marks as Test and informs JUnit that there is a test
    public void addition() { // creates method
        assertEquals(2, 1 + 1); // assertEquals method that performs the test
    }

    @Test
    public void testfile1() throws IOException { 
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("https://something.com");
        expectedLinks.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(links, expectedLinks);
    }
}


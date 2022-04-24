import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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
	    assertEquals(expectedLinks, links);
    }

    @Test
    public void testfile2() throws IOException { 
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("https://google.com");
        expectedLinks.add("https://www.ucsd.edu");
        expectedLinks.add("http://www.website.com/?utm_source%3Dgoogle%255BB%252B%255D%26utm_medium%3Dcpc%26utm_content%3Dgoogle_ad(B)%26utm_campaign%3Dproduct&sa=D&source=docs&ust=1650050824592873&usg=AOvVaw2rvQJMBSETT1Ewg3l_QrX6");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(expectedLinks, links);
    }

    @Test
    public void testfile3() throws IOException { 
        ArrayList<String> expectedLinks = new ArrayList<String>();
        expectedLinks.add("https://google.com");
        expectedLinks.add("https://www.ucsd.edu");
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(expectedLinks, links);
    }

    @Test
    public void testfile4() throws IOException { 
        ArrayList<String> expectedLinks = new ArrayList<String>();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
	    assertEquals(expectedLinks, links);
    }
}
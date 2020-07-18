package pdfReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfReaderTest {
@Test
public void read() throws IOException {
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
    WebDriver d=new ChromeDriver();
   // d.get("http://www.pdf995.com/samples/pdf.pdf");--->Directly from website
    d.get("file:///C:/Users/Mashuda/Desktop/java_tutorial.pdf");
    String Current_Url=d.getCurrentUrl();
	URL url=new URL(Current_Url);
	InputStream is=url.openStream();
	BufferedInputStream bis=new BufferedInputStream(is);
	PDDocument document =null;
	document=PDDocument.load(bis);
	String PdfContents=new PDFTextStripper().getText(document);
	System.out.println(PdfContents);
	Assert.assertTrue(PdfContents.contains("About the Tutorial"));
	Assert.assertTrue(PdfContents.contains("Audience"));
	Assert.assertTrue(PdfContents.contains("Prerequisites"));
    d.quit();
}
}

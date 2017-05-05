package com.lara.pdf.textstripper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
			String f = "/strikethru.pdf"; //default to the file packaged with the jar
			if (args.length > 0)
				f = args[0]; //use the filename provided
			App a = new App();
			try {
				a.testExtractStyledFromStyleTest(f);
			} catch (COSVisitorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
    }
    
    public void testExtractStyledFromStyleTest(String f) throws COSVisitorException, IOException
    {
				InputStream documentStream = App.class.getResourceAsStream(f);
				PDDocument document = PDDocument.load(documentStream);
				String styled = extractStyled(document);

				System.out.println("\n"+ f + ", extract with style:");
				System.out.println(styled);
				System.out.println("***********************************");
    }
    String extractStyled(PDDocument document) throws IOException
    {
        PDFTextStripper stripper = new PDFStyledTextStripper();
        stripper.setSortByPosition(true);
        return stripper.getText(document);
    }
}

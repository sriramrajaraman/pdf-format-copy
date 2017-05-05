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
        System.out.println( "Hello World!" );
        App a = new App();
        try {
			a.testExtractStyledFromStyleTest();
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testExtractStyledFromStyleTest() throws COSVisitorException, IOException
    {
        		InputStream documentStream = App.class.getResourceAsStream("/strikethru.pdf");
                PDDocument document = PDDocument.load(documentStream);
            String styled = extractStyled(document);

            System.out.println("\n'style-test.pdf', extract with style:");
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

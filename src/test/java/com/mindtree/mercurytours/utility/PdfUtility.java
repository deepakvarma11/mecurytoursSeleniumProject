package com.mindtree.mercurytours.utility;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


public class PdfUtility {
	
	static PDDocument document;
//	static String pdfReportPath = "C:\\Users\\M1049027\\Desktop\\Eclipse\\project\\pdfreports\\TestResult.pdf";
	static String pdfReportPath = "";

	
	public PdfUtility() {
		super();
	}

	public void writeTestResultsToPdfFile(String fileName, List<String> testCase) throws IOException {
		try {
//			System.out.println("PD FILENAME == " + fileName);
			pdfReportPath = fileName;
			document = new PDDocument();
			PDPage page = new PDPage();
			PDFont font = PDType1Font.HELVETICA;
			int fontSize = 12;
			float leading = 1.5f * fontSize;
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			float x = 30;
			float y = 750;
			if (testCase.size() == 0) {
				return;
			}

			final float fontHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
			contentStream.setFont(font, fontSize);
			contentStream.beginText();
			contentStream.moveTextPositionByAmount(x, y);
			contentStream.appendRawCommands(fontHeight + "TL\n");
				for (String line: testCase)
			    {
			        contentStream.drawString(line);
			        contentStream.moveTextPositionByAmount(0, -leading);
			    }

			contentStream.endText();
			contentStream.close();
			document.save(fileName);
		} finally {
			if (document != null) {
				document.close();
			}
		}

	}
	
	public static String sendPdfEmail()
	{
		return pdfReportPath;
	}
}

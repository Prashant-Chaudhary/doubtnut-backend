package com.doubtnut.backend.service.ipml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.doubtnut.backend.model.RelatedQuestion;
import com.doubtnut.backend.service.PDFGenerationService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PDFGenerationServiceImpl implements PDFGenerationService {
	public static void main(String[] args) {
		List<RelatedQuestion> list = new ArrayList<RelatedQuestion>();
		RelatedQuestion q1 = new RelatedQuestion(1, " Question 1");
		RelatedQuestion q2 = new RelatedQuestion(2, " Question 2");
		RelatedQuestion q3 = new RelatedQuestion(3, " Question 3");
		RelatedQuestion q4 = new RelatedQuestion(4, " Question 4");
		RelatedQuestion q5 = new RelatedQuestion(5, " Question 5");
		RelatedQuestion q6 = new RelatedQuestion(6, " Question 6");
		RelatedQuestion q7 = new RelatedQuestion(7, " Question 7");
		list.add(q1);
		list.add(q2);
		list.add(q3);
		list.add(q4);
		list.add(q5);
		list.add(q6);
		list.add(q7);
		new PDFGenerationServiceImpl().generatePDF(list);
	}

	/**
	 * Method to generate PDF from List of Questions
	 */
	@Override
	public long generatePDF(List<RelatedQuestion> list) {
		Document document = new Document();
		long timeStamp = System.currentTimeMillis();
		try {

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfs/" + timeStamp + ".pdf"));
			document.open();

			PdfPTable table = new PdfPTable(2); // 2 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			setColumnStructure(table);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell[] cells = table.getRow(0).getCells();
			for (int j = 0; j < cells.length; j++) {
				cells[j].setBackgroundColor(BaseColor.GRAY);
			}
			for (RelatedQuestion ques : list) {
				table.addCell(ques.getId() + "");
				table.addCell(ques.getQuestion());

			}
			document.add(table);
			document.close();
			writer.close();
			System.out.println("PDF Generated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeStamp;
	}

	/**
	 * @param table
	 * @throws DocumentException
	 */
	private void setColumnStructure(PdfPTable table) throws DocumentException {
		// Set Column widths
		float[] columnWidths = { 1f, 3f };
		table.setWidths(columnWidths);

		PdfPCell cell1 = new PdfPCell(new Paragraph("Ques. No."));
		cell1.setBorderColor(BaseColor.BLUE);
		cell1.setPaddingLeft(10);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

		PdfPCell cell2 = new PdfPCell(new Paragraph("Related Question"));
		cell2.setBorderColor(BaseColor.GREEN);
		cell2.setPaddingLeft(10);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

		table.addCell(cell1);
		table.addCell(cell2);
	}

}

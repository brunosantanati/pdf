package me.brunosantana.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

//Example based on these links:
//https://www.baeldung.com/java-pdf-creation
//https://pdfbox.apache.org/1.8/cookbook/documentcreation.html
//https://stackoverflow.com/questions/14686013/pdfbox-wrap-text

class History{
	private int id;
	private String status;
	private String dateCreation;
	private String feature;
	private String type;
	private String action;
	private String blockType;
	private String channel;
	private String dateUpdate;
	
	public History(int id, String status, String dateCreation, String feature, String type, String action,
			String blockType, String channel, String dateUpdate) {
		super();
		this.id = id;
		this.status = status;
		this.dateCreation = dateCreation;
		this.feature = feature;
		this.type = type;
		this.action = action;
		this.blockType = blockType;
		this.channel = channel;
		this.dateUpdate = dateUpdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getBlockType() {
		return blockType;
	}
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
}

public class PdfCreator {

	public static void main(String[] args) throws IOException {
		createPdf1();
		createPdf2();
		createPdf3();
	}

	private static void createPdf1() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);

		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.setFont(PDType1Font.COURIER, 12);
		contentStream.beginText();
		contentStream.showText("Hello World");
		contentStream.endText();
		contentStream.close();

		document.save("output/pdf1.pdf");
		document.close();
	}
	
	private static void createPdf2() throws IOException {
		// Create a document and add a page to it
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created content
		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		// Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
		contentStream.beginText();
		contentStream.setFont( font, 12 );
		//contentStream.moveTextPositionByAmount( 100, 700 ); //deprecated
		contentStream.newLineAtOffset(100, 700);
		//contentStream.drawString( "Hello World" ); //deprecated
		contentStream.showText( "Hello World" );
		contentStream.endText();

		// Make sure that the content stream is closed:
		contentStream.close();

		// Save the results and ensure that the document is properly closed:
		document.save( "output/pdf2.pdf");
		document.close();
	}
	
	private static void createPdf3() throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage( page );

		PDFont font = PDType1Font.TIMES_ROMAN;

		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		History history = new History(15200, "CREATED", "2021-05-13T12:53:53", "PRINCIPAL", "PLASTIC", 
				"BLOQUEADO_E_BLABLABLA_E_BLABLABLA", "ALGO_AQUI", "HELPDESK", "2021-05-13T12:53:53");

		contentStream.beginText();
		contentStream.setFont( font, 10 );
		contentStream.newLineAtOffset(15, 750);
		contentStream.showText(history.getId() + " " + history.getStatus() + " " + history.getDateCreation() + " " + 
				history.getFeature() + " " + history.getType() + " " + history.getAction() + " " + history.getBlockType());
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.setFont( font, 10 );
		contentStream.newLineAtOffset(15, 740);
		contentStream.showText(history.getChannel() + " " + history.getDateUpdate());
		contentStream.endText();

		contentStream.close();
		
		document.save( "output/pdf3.pdf");
		document.close();
	}

}

package poslovna_banka;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import poslovna_banka.model.AnalyticOfStatement;
import poslovna_banka.model.BankAccount;
import poslovna_banka.model.Currency;

public class GeneratePdfReport {

	
	public static ByteArrayInputStream accountsReport(List<BankAccount> accounts, String title) {
		

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
	
        
        
        try {

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{5, 5, 10, 5, 5, 5});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Lice", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Datum otvaranja", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
          
            hcell = new PdfPCell(new Phrase("Broj racuna", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            
            hcell = new PdfPCell(new Phrase("Validnost", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Banka", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Valuta", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
          
            
            PdfPCell cell;
            
            for (BankAccount account : accounts) {

            	
            	if(account.getIndividual() == null) {
            		
            		cell = new PdfPCell(new Phrase(account.getLegalEntity().getName().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
            		
            	}
            	
            	else{
            		
            		cell = new PdfPCell(new Phrase(account.getIndividual().getName().toString()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
            	}
            	
            	

                cell = new PdfPCell(new Phrase(account.getDateOfOpenning().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(account.getNumber().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                if(account.isValid()){
                	
                	cell = new PdfPCell(new Phrase("VALIDAN"));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                }
                else{
                	cell = new PdfPCell(new Phrase("NEVALIDAN"));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);
                }
                
                cell = new PdfPCell(new Phrase(account.getBank().getName().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(account.getCurrency().getName().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
            
            }
            
        
            PdfWriter.getInstance(document, out);
            document.open();
            
        
            
            document.add(new Paragraph("Racuni banke '" + title + "'"));
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
	
	
	
	
	
	public static ByteArrayInputStream clientReport(BankAccount b, List<AnalyticOfStatement> analytics, Double initial, Double endState) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{3, 3, 3, 3, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Tip", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Receipt date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Debtor", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Creditor", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Sum", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Currency", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            PdfPCell cell;
            
            for (AnalyticOfStatement a : analytics) {

               
            	

                cell = new PdfPCell(new Phrase(a.getType().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(a.getDateOfReceipt()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(a.getDebtorAccount().getNumber()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                if(a.getType().equals("Nalog za naplatu") || a.getType().equals("Nalog za prenos")){
	                cell = new PdfPCell(new Phrase(a.getAccountCreditor().getNumber()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
                } else {
                	cell = new PdfPCell(new Phrase("/"));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
                }
                
                cell = new PdfPCell(new Phrase(a.getSum().toString()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(a.getPaymentCurrency().getName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
              
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.addTitle("Izvod racuna " + b.getNumber());
            document.add(table);
            document.add(new Paragraph("Pocetno stanje: " + initial));
            document.add(new Paragraph("Krajnje stanje: " + endState));
            if(b.getIndividual() != null)
            	document.add(new Paragraph("Klijent: " + b.getIndividual().getName()));
            else
            	document.add(new Paragraph("Klijent: " + b.getLegalEntity().getName()));
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
	
	public static ByteArrayInputStream citiesReport(List<Currency> currencies) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            PdfPCell cell;
            
            for (Currency c : currencies) {

               
            	

                cell = new PdfPCell(new Phrase(c.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(c.getName()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

              
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}

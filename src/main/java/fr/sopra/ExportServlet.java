package fr.sopra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@SuppressWarnings("serial")
@WebServlet("/export.xls")
public class ExportServlet extends HttpServlet {

	@EJB
	private GestionDesProduits gestion;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String FILENAME = "export.xls";

		try {
			resp.setHeader("Content-Disposition", "attachment; filename=" + FILENAME);
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("content-type", "application/xls");

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("magasin");

			List<Fabriquant> listeFabriquants = gestion.findAllFabriquants();
			List<Categorie> listeCategories = gestion.findAllCategories();
			List<Produit> listeProduits = gestion.findAllProduits();

			int rowIterator = 0;
			int columnIterator = 0;

			HSSFRow row = sheet.createRow(rowIterator);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue("Fabriquant_ID");
			cell = row.createCell(1);
			cell.setCellValue("Fabriquant_Name");
			cell = row.createCell(2);
			cell.setCellValue("Fabriquant_Produit_Number");

			for (Fabriquant current : listeFabriquants) {
				rowIterator++;
				row = sheet.createRow(rowIterator);

				for (columnIterator = 0; columnIterator < 3; columnIterator++) {
					cell = row.createCell(columnIterator);
					switch (columnIterator) {

					case 0:
						cell.setCellValue(current.getId());
						break;
					case 1:
						cell.setCellValue(current.getNom());
						break;
					case 2:
						cell.setCellValue(gestion.nbrProduitParFabriquant(current.getId()));
						break;
					}
				}

			}

			
			rowIterator = rowIterator + 5;
			
			
			cell = row.createCell(0);
			cell.setCellValue("Categorie_ID");
			cell = row.createCell(1);
			cell.setCellValue("Categorie_Name");
			cell = row.createCell(2);
			cell.setCellValue("Categorie_Produit_Number");

			for (Categorie current : listeCategories) {
				rowIterator++;
				row = sheet.createRow(rowIterator);

				for (columnIterator = 0; columnIterator < 3; columnIterator++) {
					cell = row.createCell(columnIterator);
					switch (columnIterator) {

					case 0:
						cell.setCellValue(current.getId());
						break;
					case 1:
						cell.setCellValue(current.getNom());
						break;
					case 2:
						cell.setCellValue(gestion.nbrProduitParCategorie(current.getId()));
						break;
						
					}
				}

			}

			rowIterator = rowIterator + 5;

			cell = row.createCell(0);
			cell.setCellValue("Produit_ID");
			cell = row.createCell(1);
			cell.setCellValue("Produit_Name");
			cell = row.createCell(2);
			cell.setCellValue("Produit_Reference");
			cell = row.createCell(3);
			cell.setCellValue("Produit_Categorie");
			cell = row.createCell(4);
			cell.setCellValue("Produit_Fabriquant");

			for (Produit current : listeProduits) {
				rowIterator++;
				row = sheet.createRow(rowIterator);

				for (columnIterator = 0; columnIterator < 5; columnIterator++) {
					cell = row.createCell(columnIterator);
					switch (columnIterator) {

					case 0:
						cell.setCellValue(current.getId());
						break;
					case 1:
						cell.setCellValue(current.getNom());
						break;
					case 2:
						cell.setCellValue(current.getReference());
						break;
					case 3:
						cell.setCellValue(current.getCategorie().getNom());
						break;
					case 4:
						cell.setCellValue(current.getFabriquant().getNom());
						break;
					}
				}

			}

			wb.write(resp.getOutputStream());
			wb.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}

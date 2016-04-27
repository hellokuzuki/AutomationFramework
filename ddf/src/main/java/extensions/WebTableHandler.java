package extensions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebTableHandler {

	private WebElement webTable;

	public WebTableHandler(WebElement webTable) {
		set_Table(webTable);
	}

	public WebElement get_Table() {
		return this.webTable;
	}

	public void set_Table(WebElement webTable) {
		this.webTable = webTable;
	}

	public int getRowCount() {
		List<WebElement> tableRows = this.webTable.findElements(By.tagName("tr"));
		return tableRows.size();
	}

	public int getColCount() {
		List<WebElement> tableRows = this.webTable.findElements(By.tagName("tr"));
		return tableRows.get(0).findElements(By.tagName("td")).size();

	}

	public String getCellValue(int rowId, int colId) {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowId - 1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colId - 1);
		return cell.getText();
	}

	public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) throws NoSuchElementException {
		try {
			List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx - 1);
			WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx);
			return cellEditor;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}

	}

}

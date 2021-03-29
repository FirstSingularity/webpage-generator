package model;

public class TableElement extends TagElement implements Element {

	private Element[][] table;
	private int rows;
	private int cols;

	public TableElement(int rows, int cols, String attributes) {
		super("table", true, null, attributes);
		this.table = new Element[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	public void addItem(int rowIndex, int colIndex, Element item) {
		this.table[rowIndex][colIndex] = item;
	}

	public double getTableUtilization() {
		double total = 0;
		double used = 0;

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				if (this.table[i][j] != null) {
					used++;
					
				}

				total++;
			}
		}

		return (100 * used / total);
	}

	@Override
	public String genHTML(int indentation) {
		String answer = "";

		answer += Utilities.spaces(indentation) + this.getStartTag();

		for (int i = 0; i < this.rows; i++) {
			answer += "\n" + Utilities.spaces(indentation + 3) + "<tr>";

			for (int j = 0; j < this.cols; j++) {
				answer += "<td>";

				if (this.table[i][j] == null) {
					answer += "";

				} else {
					answer += this.table[i][j].genHTML(0);

				}
				answer += "</td>";

			}
			answer += "</tr>";
		}

		answer += "\n" + Utilities.spaces(indentation) + this.getEndTag();

		return answer;
	}
}

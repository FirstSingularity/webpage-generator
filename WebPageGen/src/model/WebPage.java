package model;

import java.util.ArrayList;

public class WebPage implements Comparable<WebPage> {

	private String title;
	private ArrayList<Element> totalElements;

	public WebPage(String title) {
		this.title = title;
		this.totalElements = new ArrayList<Element>();
	}

	public int addElement(Element element) {
		this.totalElements.add(element);

		if (element instanceof TagElement) {
			return ((TagElement) element).getId();

		} else {
			return -1;

		}
	}

	public int compareTo(WebPage webpage) {
		return (this.title.compareTo(webpage.title));
	}

	public static void enableIds(boolean choice) {
		TagElement.idGen = choice;
	}

	public Element findElem(int id) {
		for (Element e : this.totalElements) {
			if (e instanceof TagElement) {
				if (((TagElement) e).getId() == id) {
					return e;

				}
			}
		}

		return null;
	}

	public String stats() {
		String answer = "";
		int paragraphs = 0, lists = 0, tables = 0;
		double totalUtilization = 0;

		for (Element e : this.totalElements) {
			if (e instanceof ListElement) {
				lists++;

			} else if (e instanceof ParagraphElement) {
				paragraphs++;

			} else if (e instanceof TableElement) {
				tables++;
				totalUtilization += ((TableElement) e).getTableUtilization();

			}
		}

		// Separation for clarity
		answer += "List Count: " + lists + "\n";
		answer += "Paragraph Count: " + paragraphs + "\n";
		answer += "Table Count: " + tables + "\n";
		answer += "TableElement Utilization: " + (totalUtilization / tables);

		return answer;
	}

	public String getWebPageHTML(int indentation) {
		String elementHTML = "\n";

		for (Element e : this.totalElements) {
			elementHTML += e.genHTML(indentation * 2);
		}

		// Indentation for clarity
		String answer = "<!doctype html>\n" + 
						"<html>\n" + 
						"   <head>\n" + 
						"      <meta charset=\"utf-8\"/>\n" +
						"      <title>" + this.title + "</title>\n" + 
						"   </head>\n" + 
						"   <body>\n" + 
								elementHTML + "\n" +
						"   </body>\n" +
						"</html>";

		return answer;
	}

	public void writeToFile(String filename, int indentation) {
		Utilities.writeToFile(filename, this.getWebPageHTML(indentation));
	}
}

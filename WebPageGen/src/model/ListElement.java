package model;

import java.util.ArrayList;

public class ListElement extends TagElement implements Element {

	private ArrayList<Element> totalElements;

	public ListElement(boolean ordered, String attributes) {
		super(ordered ? "ol" : "ul", true, null, attributes);
		this.totalElements = new ArrayList<Element>();
	}

	public void addItem(Element item) {
		this.totalElements.add(item);
	}

	@Override
	public String genHTML(int indentation) {
		String answer = "";

		answer += Utilities.spaces(indentation) + this.getStartTag();

		for (Element e : this.totalElements) { // Separation of string add-ons for clarity
			answer += "\n" + Utilities.spaces(indentation + 3) + "<li>\n";
			answer += Utilities.spaces(indentation + 3) + e.genHTML(3) + "\n";
			answer += Utilities.spaces(indentation + 3) + "</li>";
			
		}

		answer += "\n" + Utilities.spaces(indentation) + this.getEndTag();

		return answer;
	}
}

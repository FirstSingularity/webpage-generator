package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement implements Element {

	private ArrayList<Element> totalElements;

	public ParagraphElement(String attributes) {
		super("p", true, null, attributes);
		this.totalElements = new ArrayList<Element>();
	}

	public void addItem(Element item) {
		this.totalElements.add(item);
	}

	@Override
	public String genHTML(int indentation) {
		String answer = "";

		answer += Utilities.spaces(indentation) + this.getStartTag() + "\n";

		for (Element e : this.totalElements) {
			answer += Utilities.spaces(indentation) + e.genHTML(3) + "\n";
			
		}

		answer += Utilities.spaces(indentation) + this.getEndTag();

		return answer;
	}
}

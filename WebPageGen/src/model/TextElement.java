package model;

public class TextElement implements Element {
	
	private String text;
	
	public TextElement(String text) {
		this.text = text;
		
	}
	
	public String genHTML(int indentation) {
		String answer = "";
		
		answer += Utilities.spaces(indentation) + this.text;
		
		return answer;
	}
}

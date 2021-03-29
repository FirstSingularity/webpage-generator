package model;

public class TagElement implements Element {

	private String tagName, attributes;
	private Element content;
	private boolean endTag;
	private int idNum;

	private static int idCount = 1;
	protected static boolean idGen = true;

	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		this.content = content;
		this.tagName = tagName;
		this.attributes = attributes;
		this.endTag = endTag;
		this.idNum = idCount;

		idCount++;
	}

	public static void enableId(boolean choice) {
		idGen = choice;
	}

	public static void resetIds() {
		idCount = 1;
	}

	public int getId() {
		int privacyLeakBlock = this.idNum;
		return privacyLeakBlock;
	}

	public String getStringId() {
		String answer = "";

		answer += "\"" + this.tagName + this.idNum + "\"";

		return answer;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getStartTag() {
		String answer = "";

		answer += "<" + this.tagName;

		if (idGen) {
			answer += " id=" + getStringId();
			
		}

		if (this.attributes != null) {
			answer += " " + this.attributes;
			
		}

		answer += ">";

		return answer;
	}

	public String getEndTag() {
		if (!endTag) {
			return "";
			
		}

		String answer = "";

		answer += "</" + this.tagName + ">";

		return answer;
	}

	public String genHTML(int indentation) {
		String answer = "";

		answer += Utilities.spaces(indentation) + this.getStartTag(); // Separation of add-ons for clarity
		answer += (content == null) ? "" : this.content.genHTML(indentation);
		answer += this.getEndTag();

		return answer;
	}
}

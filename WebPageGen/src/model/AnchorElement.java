package model;

public class AnchorElement extends TagElement implements Element {
	
	private String url;
	private String linkText;
	
	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, null, attributes);
		this.url = url;
		this.linkText = linkText;
	}
	
	public String getLinkText() {
		String privacyLeakBlock = new String(linkText);
		return privacyLeakBlock;
	}
	
	public String getUrlText() {
		String privacyLeakBlock = new String(url);
		return privacyLeakBlock;
	}
	
	@Override
	public String genHTML(int indentation) { // Indentation for clarity
		return(Utilities.spaces(indentation) + "<a " + 
				(TagElement.idGen ? "id=\"a" + this.getId() + "\" " : "" ) +
				"href=\"" + getUrlText() + "\">" + 
				getLinkText() + 
				"</a>");
	}
}

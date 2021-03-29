package model;

public class ImageElement extends TagElement implements Element {
	
	private String imageURL;
	
	public ImageElement(String imageURL, int width, int height, String alt, String attributes) { // Indentation for clarity
		super("img", false, null, 
				"src=\"" + imageURL +
				"\" width=\"" + width +
				"\" height=\"" + height +
				"\" alt=\"" + alt + "\"" + 
				((attributes == null) ? "" : attributes));
		this.imageURL = imageURL;
	}
	
	public String getImageUrl() {
		String privacyLeakBlock = new String(this.imageURL);
		return privacyLeakBlock;
	}
}

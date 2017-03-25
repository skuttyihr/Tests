package testCommons;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

public class TesseractHelper {
	private static final double PASS_PERCENTAGE = 0.7;
	private static final String dataPath = "./src/test-commons";
	private String imagePath;
	private BytePointer outText;
	private TessBaseAPI api;
	
	public TesseractHelper () {
		api = new TessBaseAPI();
		if (api.Init(dataPath, "ENG") != 0) {
			System.err.println("Could not initialize tesseract.");
		}
	}
	
	public TesseractHelper (String imagePath) {
		this();
		this.imagePath = imagePath;
	}
	
	public String getText () {
		// Open input image with leptonica library
		PIX image = pixRead(imagePath);
		api.SetImage(image);
		outText = api.GetUTF8Text();
		String text = outText.getString();
        
		// Destroy used object and release memory
		api.End();
		outText.deallocate();
		pixDestroy(image);
        
		return text;
	}
	
	public void setPath (String imagePath) {
		this.imagePath = imagePath;
	}
	
	public static boolean isMatchingText (String result, String... keywords) {
		int totalMatching = 0;
		String lowercaseResult = result.toLowerCase();
		for (String keyword : keywords) {
			if (lowercaseResult.contains(keyword.toLowerCase())) {
				totalMatching++;
			}
		}
		return (totalMatching/keywords.length) > PASS_PERCENTAGE;
	}
}

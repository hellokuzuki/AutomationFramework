package utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;


public class CompareImageUtil {

	public enum Result {
		Matched, SizeMisMatch, PixelMismatch
	};

	public static Result CompareImage(String baseFile, String actualFile) {
		Result compareResult = Result.PixelMismatch;
		Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
		Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);

		try {
			PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);

			PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);

			int[] baseImageData = null;
			int[] actualImageData = null;

			if (baseImageGrab.grabPixels()) {
				int bwidth = baseImageGrab.getWidth();
				int bheight = baseImageGrab.getHeight();
				System.out.println("base file width = " + bwidth + " height = " + bheight);
				baseImageData = new int[bwidth * bheight];
				baseImageData = (int[]) baseImageGrab.getPixels();
			}

			if (actualImageGrab.grabPixels()) {
				int awidth = actualImageGrab.getWidth();
				int aheight = actualImageGrab.getHeight();
				System.out.println("source file width = " + awidth + " height = " + aheight);
				actualImageData = new int[awidth * aheight];
				actualImageData = (int[]) actualImageGrab.getPixels();
			}

			if ((baseImageGrab.getHeight() != actualImageGrab.getHeight())
					|| (baseImageGrab.getWidth() != actualImageGrab.getWidth()))
				compareResult = Result.SizeMisMatch;
			else if (java.util.Arrays.equals(baseImageData, actualImageData))
				compareResult = Result.Matched;
			
			System.out.println("campare result" + java.util.Arrays.equals(baseImageData, actualImageData));
			
//			System.out.println(baseImageData.toString());
//			System.out.println(Arrays.toString(baseImageData));
//			System.out.println(actualImageData.toString());
//			System.out.println(Arrays.toString(actualImageData));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return compareResult;
	}

}

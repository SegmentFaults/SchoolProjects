
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Michael Gentile CSE 274
 * 
 * 
 *         Problems: Had problems resolving none square images. I believe this
 *         has been resolved. Maybe an error, My run time for aldo is about 5
 *         seconds. This is because I found it not smart to make multiple checks
 *         within the soften section for edge cases. Therefore, I sent all edge
 *         and corner cases to a four nested loop.
 * 
 *         Things that work correctly: All filters are applied and print out an
 *         image that I believe meets the requirements. The driver can read in
 *         files with or without comments. Exceptions seem to work correctly.
 * 
 */
public class PpmDriver {
	/**
	 * 
	 */
	private static String modFilename = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of the PPM file you would like to open?");
		String filename = scanner.nextLine();
		String processed = processInput(filename);
		processPPM(processed + ".ppm");
	}

	/**
	 * @param filename
	 *            name of alleged file
	 * @return a filename with a ppm extension
	 */
	private static String processInput(String filename) {
		if (filename.substring(filename.length() - 4, filename.length()).equals(".ppm")) {
			modFilename = filename.substring(0, filename.length() - 4);
			return modFilename;
		}
		modFilename = filename;
		return filename;
	}

	/**
	 * @param filename
	 *            is the modified filename that needs to be read in to the
	 *            system. This method will gather the information from the
	 *            system.
	 * 
	 */
	private static void processPPM(String filename) {
		File f = new File(filename);
		Scanner ppmScanner;
		try {
			ppmScanner = new Scanner(f);
			int[][] data;
			int line = -1;
			int dimen[] = new int[2];
			while (line <= 3) {
				if (line == -1) {
					try {
						if (ppmScanner.nextLine().equals("P3")) {
							line++;
						} else {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Does not start with P3");
						System.exit(0);
					}
				} else if (line == 0) {
					if (ppmScanner.hasNext("#")) {
						ppmScanner.nextLine();
					} else {
						dimen[line] = ppmScanner.nextInt() * 3;//account for three colors
						line++;
					}

				} else if (line == 1) {
					dimen[line] = ppmScanner.nextInt();
					line++;
				} else if (line == 2) {
					if (ppmScanner.hasNextLine())
						ppmScanner.nextLine();
					line++;
				} else if (line == 3) {
					ppmScanner.next();
					line++;
				} else {
					line = 4;
				}
			}
			data = new int[dimen[1]][dimen[0]];
			int datax = 0, datay = 0;
			ArrayList<Color> colorArrayList = new ArrayList<Color>();
			int red = -1, blue = -1, green = -1;
			while (ppmScanner.hasNext()) {

				if (datax < dimen[0] && datay < dimen[1]) {
					data[datay][datax] = Integer.parseInt(ppmScanner.next());
					if (red == -1) {
						red = data[datay][datax];
					} else if (green == -1) {
						green = data[datay][datax];
					} else {
						blue = data[datay][datax];
						colorArrayList.add(new Color(red, green, blue));
						red = -1;
						green = -1;
						blue = -1;
					}
					datax++;

				} else {
					datay++;
					datax = 0;
				}
			} // end while
			Color[][] colorArray = convertArrayList(colorArrayList, dimen[1], dimen[0] / 3);
			Ppm original = new Ppm(colorArray);
			printPPMs(original);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("There was an error finding the file. The program will now exit.");
			;
			System.exit(0);
		} catch (IOException e2) {
			System.out.println("There was an error reading the file. The program will now close");
			System.exit(0);
		} catch (NumberFormatException e3) {
			System.out
					.println("There were unexpected issues reading the file. A character does not belong in that file");
			System.exit(0);
		}

		System.out.println("Done");
	}

	/**
	 * @param colorArrayList
	 *            the numbers that will be turned into colors.
	 * @param width
	 *            the width of the picture
	 * @param height
	 *            the height of the picture
	 * @return the new Array of colors that can now be manipulated by the
	 *         filters. This method takes the numbers given from the picture and
	 *         turns them into colors.
	 */
	private static Color[][] convertArrayList(ArrayList<Color> colorArrayList, int width, int height) {
		Color[][] colorArray = new Color[width][height];
		int counter = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				colorArray[x][y] = colorArrayList.get(counter);
				counter++;
			}
		}
		return colorArray;
	}

	/**
	 * @param original
	 *            is the original ppm that will have the filters applied to it
	 *            This applies all the filters. Thought better than to use an
	 *            additional array to make it look cleaner.
	 */
	private static void printPPMs(Ppm original) {
		original.outputPpm(original.addFrame(100, Color.RED).getData(), modFilename + "_frame.ppm");
		original.outputPpm(original.addNoise().getData(), modFilename + "_noise.ppm");
		original.outputPpm(original.darken().getData(), modFilename + "_darken.ppm");
		original.outputPpm(original.flipHorizontal().getData(), modFilename + "_fliphorizontal.ppm");
		original.outputPpm(original.flipVertical().getData(), modFilename + "_flipvertical.ppm");
		original.outputPpm(original.greyscale().getData(), modFilename + "_greyscale.ppm");
		original.outputPpm(original.invert().getData(), modFilename + "_invert.ppm");
		original.outputPpm(original.lighten().getData(), modFilename + "_lighten.ppm");
		original.outputPpm(original.posterize().getData(), modFilename + "_posterize.ppm");
		original.outputPpm(original.soften().getData(), modFilename + "_soften.ppm");
		original.outputPpm(original.surprise().getData(), modFilename + "_surprise.ppm");

	}

}

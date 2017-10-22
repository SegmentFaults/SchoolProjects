
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Ppm {
	private Color[][] data;

	/**
	 * @param data
	 *            is all of the color data contained by the file.
	 */
	Ppm(Color[][] data) {
		this.data = data;
	};

	/**
	 * @returns all of the color data within the class
	 */
	public Color[][] getData() {
		return data;
	}

	/**
	 * 
	 * @return a PPM file that has the values divided by two so that it appears
	 *         much darker
	 */
	public Ppm darken() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				tempData[x][y] = new Color(data[x][y].getRed() / 2, data[x][y].getGreen() / 2,
						data[x][y].getBlue() / 2);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return a much brighter PPM by multiplying the RGB values by two to
	 *         create a brighter image
	 */
	public Ppm lighten() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				int tempR = data[x][y].getRed() * 2;
				int tempG = data[x][y].getGreen() * 2;
				int tempB = data[x][y].getBlue() * 2;
				if (tempR > 255) {
					tempR = 255;
				}
				if (tempG > 255) {
					tempG = 255;
				}
				if (tempB > 255) {
					tempB = 255;
				}
				tempData[x][y] = new Color(tempR, tempG, tempB);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return an averaged PPM where all of the values are equivalent to make it
	 *         look much more grey.
	 */
	public Ppm greyscale() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				int average = (data[x][y].getBlue() + data[x][y].getGreen() + data[x][y].getRed()) / 3;
				tempData[x][y] = new Color(average, average, average);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return a PPM where the values are inverted so that all of the values are
	 *         the exact opposite of what they were.
	 */
	public Ppm invert() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				int tempR = Math.abs(data[x][y].getRed() - 255);
				int tempG = Math.abs(data[x][y].getGreen() - 255);
				int tempB = Math.abs(data[x][y].getBlue() - 255);
				tempData[x][y] = new Color(tempR, tempG, tempB);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return a PPM where the image is flipped upside down.
	 */
	public Ppm flipVertical() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = data.length - 1; x >= 0; x--) {
			for (int y = 0; y < data[0].length; y++) {
				tempData[x][y] = new Color(data[Math.abs(x - data.length) - 1][y].getRed(),
						data[Math.abs(x - data.length) - 1][y].getGreen(),
						data[Math.abs(x - data.length) - 1][y].getBlue());
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return a horizontally flipped image.
	 */
	public Ppm flipHorizontal() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = data[0].length - 1; y >= 0; y--) {
				tempData[x][y] = new Color(data[x][Math.abs(y - data[0].length) - 1].getRed(),
						data[x][Math.abs(y - data[0].length) - 1].getGreen(),
						data[x][Math.abs(y - data[0].length) - 1].getBlue());
			}
		}

		newPpm = new Ppm(tempData);
		return newPpm;

	}

	/**
	 * @return assigns a random integer to each color value so that it is
	 *         randomly changed at an arbitrary rate.
	 */
	public Ppm addNoise() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				Random r = new Random();
				int randomInt;
				if (r.nextBoolean()) {// assign a positive value only half the
										// time.
					randomInt = r.nextInt(45);
				} else {
					randomInt = -r.nextInt(45);
				}
				int tempR = Math.abs(data[x][y].getRed() + randomInt);
				int tempG = Math.abs(data[x][y].getGreen() + randomInt);
				int tempB = Math.abs(data[x][y].getBlue() + randomInt);
				if (tempR > 255) {
					tempR = 255;
				} else if (tempR < 0) {
					tempR = 0;
				}
				if (tempG > 255) {
					tempG = 255;
				} else if (tempG < 0) {
					tempG = 0;
				}
				if (tempB > 255) {
					tempB = 255;
				} else if (tempB < 0) {
					tempB = 0;
				}
				tempData[x][y] = new Color(tempR, tempG, tempB);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return a PPM with only a few colors in it.
	 */
	public Ppm posterize() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				int red = data[x][y].getRed() / 64;
				int green = data[x][y].getGreen() / 64;
				int blue = data[x][y].getBlue() / 64;
				tempData[x][y] = new Color(red * 64, green * 64, blue * 64);
			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @return an image where all of its neighbors are averaged and the PPM's
	 *         values are based on those values.
	 */
	public Ppm soften() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		// list all edge cases. This is the longest part of the methods.
		// This takes it out of the programmers hands for explicitly listing
		// cases.
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				ArrayList<Color> listNeighbors = new ArrayList<Color>();
				if (x == 0 || y == 0 || x == data.length - 1 || y == data[0].length - 1) {
					for (int z = 0; z < data.length; z++) {
						for (int zz = 0; zz < data[0].length; zz++) {
							if (neighbors(x, y, z, zz)) {
								listNeighbors.add(
										new Color(data[z][zz].getRed(), data[z][zz].getGreen(), data[z][zz].getBlue()));
							}
						}

					}
				} else {// if not an edge piece
					listNeighbors.add(data[x - 1][y - 1]);// top left
					listNeighbors.add(data[x + 1][y - 1]);// top right
					listNeighbors.add(data[x][y - 1]);// top mid
					listNeighbors.add(data[x - 1][y]);// left mid
					listNeighbors.add(data[x + 1][y]);// right mid
					listNeighbors.add(data[x - 1][y + 1]);// bottom left
					listNeighbors.add(data[x][y + 1]);// bottom mid
					listNeighbors.add(data[x + 1][y + 1]);// bottom right
				}
				int red = 0;
				int green = 0;
				int blue = 0;
				for (int q = 0; q < listNeighbors.size(); q++) {
					red += listNeighbors.get(q).getRed();
					green += listNeighbors.get(q).getGreen();
					blue += listNeighbors.get(q).getBlue();
				}
				red = red / listNeighbors.size();
				green = green / listNeighbors.size();
				blue = blue / listNeighbors.size();
				tempData[x][y] = new Color(red, green, blue);

			}
		}
		newPpm = new Ppm(tempData);

		return newPpm;
	}

	/**
	 * @param width
	 *            the width of the frame added to each side (top, bottom, left,
	 *            right.
	 * @param c
	 *            the color of the frame.
	 * @return a PPM with a frame.
	 */
	public Ppm addFrame(int width, Color c) {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length + (width * 2)][data[0].length + (width * 2)];
		for (int x = 0; x < tempData.length; x++) {
			for (int y = 0; y < tempData[0].length; y++) {
				if (x < width || x > data.length + width) {
					tempData[x][y] = c;
				} else if (y < width || y > data[0].length + width) {
					tempData[x][y] = c;
				} else if (x >= data.length + width || y >= data[0].length + width) {
					tempData[x][y] = c;
				} else {
					tempData[x][y] = new Color(data[x - width][y - width].getRed(),
							data[x - width][y - width].getGreen(), data[x - width][y - width].getBlue());
				}

			}
		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @param xlist
	 *            of the pixel in question
	 * @param ylist
	 *            the y of the pixel in question
	 * @param zlist
	 *            the x of the pixel to check if it is a neighbor
	 * @param zzlist
	 *            the y of the pixel to check if it is a neighbor.
	 * @return if the pixels neighbor each other.
	 */
	private boolean neighbors(int xlist, int ylist, int zlist, int zzlist) {
		if (xlist == zlist) {
			if (ylist + 1 == zzlist || ylist - 1 == zzlist) {
				return true;
			}
		} else if (ylist == zzlist) {
			if (xlist + 1 == zlist || xlist - 1 == zlist) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 
	 * @return a Ppm with a red, blood moon style
	 */
	public Ppm surprise() {
		Ppm newPpm;
		Color[][] tempData = new Color[data.length][data[0].length];
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				int tempR = data[x][y].getRed();

				tempData[x][y] = new Color(tempR, 0, 0);
			}

		}
		newPpm = new Ppm(tempData);
		return newPpm;
	}

	/**
	 * @param datas
	 *            the color data that needs printed to a file.
	 * @param name
	 */
	public void outputPpm(Color[][] datas, String name) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(name);
			pw.print("P3\r\n");
			pw.println(datas[0].length + " " + datas.length);
			pw.println("255");
			for (int x = 0; x < datas.length; x++) {
				for (int y = 0; y < datas[0].length; y++) {
					pw.println(datas[x][y].getRed() + " " + datas[x][y].getGreen() + " " + datas[x][y].getBlue());
				}
			}
			pw.println();
			pw.close();
		} catch (FileNotFoundException e) {
			// Elegantly tells the program that the file couldn't be found.
			System.out.println("File could not be found. Closing the program");
			System.exit(0);
		}

	}
}

package generalpractice.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class UsingImages {

	private ArrayList<Character> dictionary;
	private int smallestRGB;
	private int bigestRGB;
	private float steps;

	public UsingImages() {
		// As I am using alpha = 0, all the RGB values are going to be negatives
		smallestRGB = new Color(0, 0, 0).getRGB();
		bigestRGB = new Color(255, 255, 255).getRGB();

		// any character that is not included in the dictionary is not recognized.
		dictionary = new ArrayList<>();
		dictionary.add(' ');
		dictionary.add('.');
		dictionary.add('!');
		dictionary.add(':');
		for (char i = '0'; i <= '9'; i++)
			dictionary.add(i);
		for (char i = 'A'; i <= 'Z'; i++)
			dictionary.add(i);
		for (char i = 'a'; i <= 'z'; i++)
			dictionary.add(i);

		steps = -((float) (bigestRGB - smallestRGB) / (float) dictionary.size());
		System.out.println("Encoding function works: " + testCorrectnesOfEncodingDecoding());

	}

	private boolean testCorrectnesOfEncodingDecoding() {
		System.out.println("BigestRGB: " + bigestRGB);
		System.out.println("SmallestRGB: " + smallestRGB);
		System.out.println("Steps size: " + (-steps));
		System.out.println("Total characters in dictionary: " + dictionary.size());
		System.out.println("Different colours: " + (int) (steps * dictionary.size() * -1));
		for (Character character : dictionary) {
			Color color = encode(character);
			Character decoded = decode(color.getRGB());
			// System.out.println(character + "--" + decoded);
			if (!character.equals(decoded))
				return false;
		}
		return true;
	}

	private static void printRGB(BufferedImage img) {
		for (int i = 0; i < img.getHeight(); i++) {
			for (int j = 0; j < img.getWidth(); j++) {
				Color c = new Color(img.getRGB(i, j));
				System.out.print(c.getRed() + " " + c.getGreen() + " " + c.getBlue() + " ");
			}
			System.out.println();
		}
	}

	// this function maps a number in between 0 and dictionary.size() to a number in between smallestRGB and biggestRGB
	public int mapIndexToRGB(int value) {
		return (int) ((float) value * steps);
	}

	// this function maps a float in between smallestRGB and biggestRGB to a number in between 0 and dictionary.size()
	public int mapRGBtoIndex(int value) {
		return (int) Math.round((float) value / steps);
	}

	// This function converts a Character to a Color
	private Color encode(Character c) {
		int index = dictionary.indexOf(c);
		if (index >= 0)
			return new Color(mapIndexToRGB(index));
		return Color.black;
	}

	// This function converts a RGB Color to a Character
	private Character decode(int RGB) {
		int index = mapRGBtoIndex(RGB);
		if ((index < 0) || (index >= dictionary.size()))
			return ' ';
		return dictionary.get(index);
	}

	// This function converts a String to a BufferedImage
	private BufferedImage encode(String message, int w, int h) {
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

		ArrayList<Color> encodedMessage = new ArrayList<>();
		for (int i = 0; i < message.length(); i++)
			encodedMessage.add(encode(message.charAt(i)));

		for (int i = 0; i < img.getHeight(); i++)
			for (int j = 0; j < img.getWidth(); j++) {
				// Im going to repeat the message until the end of the image
				int position = (h * i + j) % encodedMessage.size();
				Color c = encodedMessage.get(position);
				img.setRGB(i, j, c.getRGB());
			}
		return img;
	}

	// This function converts a BufferedImage to a String
	private String decode(BufferedImage img) {
		String message = "";
		for (int i = 0; i < img.getHeight(); i++)
			for (int j = 0; j < img.getWidth(); j++) {
				message += String.valueOf(decode(img.getRGB(i, j)));
			}
		return message;
	}

	public void Run() {
		try {
			// Open an image
			String path = "res/10x10.png";
			BufferedImage img = ImageIO.read(new File(path));
			printRGB(img);

			// Encode a message inside an image
			int width = 8;
			int height = 8;
			String message = "I am Rodrigo Ibanez and this is my encoded message: Hello World!";
			BufferedImage imgToSave = encode(message, width, height);
			
			// Save the image
			String pathToSave = "res/gen_10x10.png";
			ImageIO.write(imgToSave, "png", new File(pathToSave));

			// Decode the message in the image
			BufferedImage imgToDecode = ImageIO.read(new File(pathToSave));
			String decodedMessage = decode(imgToDecode);
			System.out.println(decodedMessage);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new UsingImages().Run();
	}

}

package helpers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DataLoader {
	
	public static BufferedImage getImage(String fileName) { 
		BufferedImage image = null;
		InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fileName);
		
		try 
		{
			image = ImageIO.read(is);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return image;
	}
	
	public static int[][] getMap2Data(String name)
	{
		File levelFile = new File("res/" + name + ".txt");
		if (levelFile.exists())
		{
			ArrayList<Integer> list = readFile(levelFile);
			return Utilities.listTo2D(list, 20, 30);
		}
		else
		{
			System.out.println("File " + name + " does not exist!");
			return null;
		}
	}
	
	private static ArrayList<Integer> readFile(File file)
	{
		ArrayList<Integer> list = new ArrayList<>();
		try 
		{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				list.add(Integer.parseInt(scanner.nextLine()));
			}
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return list;
	}

	public int[][] loadMap2() { 
		int[][] mapData = new int[30][18]; 
		try {
			InputStream is = getClass().getResourceAsStream("outside_scene.txt"); 
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
			
			int col = 0; 
			int row = 0; 
			while(col < 30 && row < 18) {
				String line = br.readLine(); 
				while(col < 30) {
					String[] numbers = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapData[col][row] = num; 
					col++;
				}
				if(col == 30) { 
					col = 0; 
					row++; 
				}
			}
			br.close();
		} catch(Exception e) { 
			
		}
		return mapData; 
	}
	
	public static Clip importAudio(String fileName) {
		Clip clip = null; 
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName));
			clip = AudioSystem.getClip();

		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clip; 
	}
}

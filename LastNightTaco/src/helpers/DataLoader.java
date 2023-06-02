package helpers;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

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

	public static void loadMap(String filePath) { 
		
		try { 
			InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(filePath); 
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		} 
		catch (Exception e) { 
			
		}
	}
	

}

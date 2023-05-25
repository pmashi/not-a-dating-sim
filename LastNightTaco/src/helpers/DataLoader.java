package helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

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

	
	

}
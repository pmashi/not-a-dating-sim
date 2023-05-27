package helpers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Utilities {
	
	public static BufferedImage getRotatedImage(BufferedImage image, int rotationAngle)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		
		BufferedImage newImage = new BufferedImage(width, height, image.getType());
		Graphics2D g2d = newImage.createGraphics();
		
		g2d.rotate(Math.toRadians(rotationAngle), width / 2, height / 2);
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
		
		return newImage;
	}
	
	public static BufferedImage buildImage(BufferedImage[] images)
	{
		int width = images[0].getWidth();
		int height = images[0].getHeight();
		
		BufferedImage newImage = new BufferedImage(width, height, images[0].getType());
		Graphics2D g2d = newImage.createGraphics();
		
		for(BufferedImage image : images)
		{
			g2d.drawImage(image, 0, 0, null);
		}
		g2d.dispose();
		return newImage;
	}
	
	public static int[][] listTo2D(ArrayList<Integer> list, int ySize, int xSize)
	{
		int[][] arr = new int[ySize][xSize];
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				int index = j * ySize + i;
				arr[i][j] = list.get(index);
			}
		}
		return arr;
	}
	
	public static int[]	arr2Dto1D (int[][] arr)
	{
		int[] newArr = new int[arr.length * arr[0].length]; 
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				int index = j * arr.length + i;
				newArr[index] = arr[i][j];
			}
		}
		return newArr;
	}
	
	public static int getHypoDistance(float x1, float y1, float x2, float y2)
	{
		float xDiff = Math.abs(x1 - x2);
		float yDiff = Math.abs(y1 - y2); 
		
		return (int) Math.hypot(xDiff, yDiff);
	}
}

package lwp;

import java.util.Random;


public class EyeCandyGradient extends EyeCandy {

	private int[][] gradient;
    private int[][] gradCopy;
	private int width, height;

	public EyeCandyGradient() {
		init();
	}

	@Override
	public final int[][] draw(int[][] matrix) {
		gradCopy = new int[width][height];
		
		for (int i = 0; i < height; i++) 
			for (int j = 0; j < width; j++)
				gradCopy[j][i] = gradient[j][i];
		
		return gradCopy;
	}
	

	@Override
	public void init() {
		width = MyWallpaper.getLCD_WIDTH();
		height = MyWallpaper.getLCD_HEIGHT();
		gradient = new int[width][height];
		
		drawGradient();
		ditherGradient();
	}

	private void drawGradient() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				gradient[j][i] = (int) (i * (255.0 / height));
		}

	}

	private void ditherGradient() {
		Random r = new Random();

		for (int i = 1; i < width - 1; i += 3) {
			for (int j = 1; j < height - 1; j += 3) {
				int original = gradient[i][j];
				for (int k = i - 1; k <= i + 1; k++)
					for (int l = j - 1; l <= j + 1; l++) {
						if (r.nextInt(100) <= 100 * (original / 255.0))
							gradient[k][l] = 0;
						else
							gradient[k][l] = 1;
					}
			}
		}
		
	}
}
package lwp;

import java.util.Random;

public class EyeCandyGradient extends EyeCandy {

	private int[][] gradient;
	private int[][] gr;
	private int width, height;

	public EyeCandyGradient() {
		init();
	}

	@Override
	public final int[][] draw(int[][] matrix) {
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				gr[i][j] = gradient[i][j];
		return gr;
	}

	@Override
	public void init() {
		width = MyWallpaper.getLCD_WIDTH();
		height = MyWallpaper.getLCD_HEIGHT();
		gradient = new int[width][height];
		gr = new int[width][height];
		gradient = drawGradient(gradient);
		gradient = ditherGradient(gradient);
	}

	private int[][] drawGradient(int[][] g) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++)
				g[j][i] = (int) (i * (255.0 / height));
		}

		return g;
	}

	private int[][] ditherGradient(int[][] g) {
		Random r = new Random();

		for (int i = 1; i < width - 1; i += 3) {
			for (int j = 1; j < height - 1; j += 3) {
				int original = g[i][j];
				for (int k = i - 1; k <= i + 1; k++)
					for (int l = j - 1; l <= j + 1; l++) {
						if (r.nextInt(100) <= 100 * (original / 255.0))
							g[k][l] = 0;
						else
							g[k][l] = 1;
					}
			}
		}
		return g;
	}
}

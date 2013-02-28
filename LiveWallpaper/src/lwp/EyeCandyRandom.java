package lwp;

import java.util.Random;

public class EyeCandyRandom extends EyeCandy {

	Random r;

	public EyeCandyRandom() {
		init();
	}

	@Override
	public int[][] draw(int[][] matrix) {

		for (int i = 0; i < MyWallpaper.getLCD_WIDTH(); i++)
			for (int j = 0; j < MyWallpaper.getLCD_HEIGHT(); j++) {
				if (r.nextBoolean())
					matrix[i][j] = 1;
			}

		return matrix;
	}

	@Override
	public void init() {
		r = new Random();
	}

}

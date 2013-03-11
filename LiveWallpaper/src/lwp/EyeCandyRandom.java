package lwp;

import java.util.Random;

public class EyeCandyRandom extends EyeCandy {

	Random r;

	public EyeCandyRandom() {
		init();
	}

	@Override
	public boolean[][] draw(boolean[][] matrix) {

		for (int i = 0; i < LCDLiveWallpaper.getLCD_WIDTH(); i++)
			for (int j = 0; j < LCDLiveWallpaper.getLCD_HEIGHT(); j++) {
				if (r.nextBoolean())
					matrix[i][j] = true;
			}

		return matrix;
	}

	@Override
	public void init() {
		r = new Random();
	}

}

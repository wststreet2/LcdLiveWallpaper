package lwp;

public class EyeCandyPI extends EyeCandy {

	static int pi_small[][] = {
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 } };

	public EyeCandyPI() {
		init();
	}

	@Override
	public int[][] draw(int[][] matrix) {
		// TODO Auto-generated method stub
		if (LCDLiveWallpaper.getLCD_WIDTH() >= 40) {
			drawLarge(matrix);
		} else {
			drawSmall(matrix);
		}
		return matrix;
	}

	private void drawSmall(int[][] matrix) {
		int startw = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 10;
		int starth = (LCDLiveWallpaper.getLCD_HEIGHT() / 2) - 9;

		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 17; j++) {
				matrix[i + startw][j + starth] = pi_small[j][i];
			}

	}

	private void drawLarge(int[][] matrix) {
		// TODO Auto-generated method stub

		int startw = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 20;
		int starth = (LCDLiveWallpaper.getLCD_HEIGHT() / 2) - 18;

		for (int i = 0; i < 40; i+=2)
			for (int j = 0; j < 34; j+=2) {
				matrix[i + startw][j + starth] = pi_small[j/2][i/2];
				matrix[i + startw + 1][j + starth] = pi_small[j/2][i/2];
				matrix[i + startw][j + starth + 1] = pi_small[j/2][i/2];
				matrix[i + startw + 1][j + starth + 1] = pi_small[j/2][i/2];
			}
	}

	@Override
	public void init() {

	}

}

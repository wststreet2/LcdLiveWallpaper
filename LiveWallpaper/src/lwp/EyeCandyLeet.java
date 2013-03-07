package lwp;

public class EyeCandyLeet extends EyeCandy {

	static int leet[][] = {
			{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,	1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,	0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,	0 },
			{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0,	0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,	0 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0,	0 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0,	0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};

	int width = 23;
	int height = 8;
	
	public EyeCandyLeet() {
		init();
	}

	@Override
	public int[][] draw(int[][] matrix) {
		// TODO Auto-generated method stub
		
		drawLeet(matrix);
		
		return matrix;
	}

	private void drawLeet(int[][] matrix) {
		int startw = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - width/2;
		int starth = (LCDLiveWallpaper.getLCD_HEIGHT() / 2) - height/2;

		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				matrix[i + startw][j + starth] = leet[j][i];
			}

	}


	@Override
	public void init() {

	}

}

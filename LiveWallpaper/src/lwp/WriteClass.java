package lwp;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteClass {
	private int[][] displayMatrix;
	private int cHeight = 7, cWidth = 5;
	private int touch = 0;

	private static boolean dispDate = false;
	private static boolean dispTime = false;
	
	public static void setTime(boolean val)
	{ 
	   dispTime = val;
	}
	
	public static void setDate(boolean val)
	{
		dispDate = val;
	}
	
	@SuppressLint("SimpleDateFormat")
	public int[][] drawDateTime(int[][] matrix) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df;
		String formattedDate = "";
		
		int start = 0;
		
		if(dispDate == true)
		{
			df = new SimpleDateFormat("dd/MM/yy");
			start = (MyWallpaper.getLCD_WIDTH() / 2) - 23;
			formattedDate = df.format(cal.getTime());
			matrix = writeLine(formattedDate, start, 33, matrix);
	    }
		
		if(dispTime == true)
		{
			df = new SimpleDateFormat("HH:mm");
			start = (MyWallpaper.getLCD_WIDTH() / 2) - 14;
			formattedDate = df.format(cal.getTime());
		}	
		
		return this.writeLine(formattedDate, start, 25, matrix);
	}

	public void incTouch() {
		touch++;
	}

	int[][] setCharacter(char c, int x, int lineNo, int[][] displayMatrix) {
		int i = 0;

		for (int j = lineNo - 7; j <= lineNo + 1; j++)
			for (int k = x - 1; k <= x + 5; k++) {
				displayMatrix[k][j] = 0;
			}

		switch (c) {
		case '0':

			for (i = lineNo - 1; i > lineNo - cHeight + 1; i--) {
				displayMatrix[x][i] = 1;
				displayMatrix[x + 4][i] = 1;
			}

			for (i = x + 1; i < x + cWidth - 1; i++) {
				displayMatrix[i][lineNo] = 1;
				displayMatrix[i][lineNo - 6] = 1;
			}

			displayMatrix[x + 1][lineNo - 2] = 1;
			displayMatrix[x + 2][lineNo - 3] = 1;
			displayMatrix[x + 3][lineNo - 4] = 1;

			break;

		case '1':
			displayMatrix[x + 1][lineNo] = 1;
			displayMatrix[x + 3][lineNo] = 1;

			for (i = lineNo; i >= lineNo - cHeight + 1; i--) {
				displayMatrix[x + 2][i] = 1;
			}

			displayMatrix[x + 1][lineNo - cHeight + 2] = 1;
			break;

		case '2':
			for (i = x; i < x + 5; i++)
				displayMatrix[i][lineNo] = 1;

			for (i = x + 1; i < x + cWidth - 1; i++) {
				displayMatrix[i][lineNo - 6] = 1;
			}

			displayMatrix[x + 1][lineNo - 1] = 1;
			displayMatrix[x + 2][lineNo - 2] = 1;
			displayMatrix[x + 3][lineNo - 3] = 1;
			displayMatrix[x + 4][lineNo - 4] = 1;
			displayMatrix[x + 4][lineNo - 5] = 1;
			displayMatrix[x + 4][lineNo - 5] = 1;
			displayMatrix[x][lineNo - 5] = 1;

			break;

		case '3':
			for (i = x; i < x + 5; i++)
				displayMatrix[i][lineNo - 6] = 1;

			for (i = x + 1; i < x + cWidth - 1; i++) {
				displayMatrix[i][lineNo] = 1;
			}

			displayMatrix[x][lineNo - 1] = 1;
			displayMatrix[x + 4][lineNo - 1] = 1;
			displayMatrix[x + 4][lineNo - 2] = 1;
			displayMatrix[x + 3][lineNo - 3] = 1;
			displayMatrix[x + 2][lineNo - 4] = 1;
			displayMatrix[x + 3][lineNo - 5] = 1;

			break;

		case '4':
			for (i = x; i < x + 5; i++) {
				displayMatrix[i][lineNo - 2] = 1;
			}

			for (i = lineNo; i >= lineNo - 6; i--) {
				displayMatrix[x + 3][i] = 1;
			}

			displayMatrix[x][lineNo - 3] = 1;
			displayMatrix[x + 1][lineNo - 4] = 1;
			displayMatrix[x + 2][lineNo - 5] = 1;

			break;

		case '5':
			for (i = x; i < x + 5; i++) {
				displayMatrix[i][lineNo - 6] = 1;
			}

			for (i = x; i < x + 4; i++) {
				displayMatrix[i][lineNo - 4] = 1;
			}

			for (i = x + 1; i < x + 4; i++) {
				displayMatrix[i][lineNo] = 1;
			}

			for (i = lineNo - 1; i >= lineNo - 3; i--) {
				displayMatrix[x + 4][i] = 1;
			}

			displayMatrix[x][lineNo - 5] = 1;
			displayMatrix[x][lineNo - 1] = 1;

			break;

		case '6':

			for (i = x + 1; i < x + 4; i++) {
				displayMatrix[i][lineNo] = 1;
				displayMatrix[i][lineNo - 3] = 1;
			}

			for (i = lineNo - 1; i >= lineNo - 4; i--) {
				displayMatrix[x][i] = 1;
			}

			displayMatrix[x + 4][lineNo - 1] = 1;
			displayMatrix[x + 4][lineNo - 2] = 1;
			displayMatrix[x + 1][lineNo - 5] = 1;
			displayMatrix[x + 2][lineNo - 6] = 1;
			displayMatrix[x + 3][lineNo - 6] = 1;

			break;

		case '7':
			for (i = x; i < x + 5; i++) {
				displayMatrix[i][lineNo - 6] = 1;
			}

			for (i = lineNo - 4; i >= lineNo - 5; i--) {
				displayMatrix[x + 4][i] = 1;
			}

			for (i = lineNo; i >= lineNo - 2; i--) {
				displayMatrix[x + 2][i] = 1;
			}

			displayMatrix[x + 3][lineNo - 3] = 1;

			break;

		case '8':
			for (i = x + 1; i < x + 4; i++) {
				displayMatrix[i][lineNo] = 1;
				displayMatrix[i][lineNo - 3] = 1;
				displayMatrix[i][lineNo - 6] = 1;
			}

			for (i = lineNo - 1; i >= lineNo - 2; i--) {
				displayMatrix[x][i] = 1;
				displayMatrix[x + 4][i] = 1;
			}

			for (i = lineNo - 4; i >= lineNo - 5; i--) {
				displayMatrix[x][i] = 1;
				displayMatrix[x + 4][i] = 1;
			}

			break;

		case '9':
			for (i = x + 1; i < x + 4; i++) {
				displayMatrix[i][lineNo - 3] = 1;
				displayMatrix[i][lineNo - 6] = 1;
			}

			for (i = lineNo - 2; i >= lineNo - 5; i--) {
				displayMatrix[x + 4][i] = 1;
			}

			displayMatrix[x][lineNo - 4] = 1;
			displayMatrix[x][lineNo - 5] = 1;

			displayMatrix[x + 1][lineNo] = 1;
			displayMatrix[x + 2][lineNo] = 1;
			displayMatrix[x + 3][lineNo - 1] = 1;

			break;

		case ':':
			displayMatrix[x + 1][lineNo - 1] = 1;
			displayMatrix[x + 1][lineNo - 2] = 1;
			displayMatrix[x + 1][lineNo - 4] = 1;
			displayMatrix[x + 1][lineNo - 5] = 1;

			displayMatrix[x + 1][lineNo - 1] = 1;
			displayMatrix[x + 1][lineNo - 2] = 1;
			displayMatrix[x + 1][lineNo - 4] = 1;
			displayMatrix[x + 1][lineNo - 5] = 1;

			break;

		case '/':
			for (i = 0; i < 5; i++)
				displayMatrix[x + i][lineNo - i] = 1;

			break;

		}
		return displayMatrix;
	}

	public int[][] writeLine(String s, int x, int lineNo, int[][] dispM)
	// lineNo e practic linia pe care va scrie, coordonata y cea mai de jos a
	// literei/numarului
	{
		displayMatrix = dispM;
		int i = 0;
		int spacing = 1;

		for (i = 0; i < s.length(); i++) {
			try {
				displayMatrix = setCharacter(s.charAt(i), x, lineNo,
						displayMatrix);
			} catch (Exception e) {
			}
			x = x + cWidth + spacing;
		}

		return displayMatrix;
	}
}

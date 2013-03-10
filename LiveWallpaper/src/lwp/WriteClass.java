package lwp;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressLint("SimpleDateFormat")
public class WriteClass {
	private int[][] displayMatrix;
	private int cHeight = 7, cWidth = 5;

	public static boolean dispDate;
	public static boolean dispTime;
	public static String clockType;
	public static boolean blackBinary;
	public static int watchSize;

	public static void setTime(boolean val) {
		dispTime = val;
	}

	public static void setDate(boolean val) {
		dispDate = val;
	}

	public static void setClockType(String cT) {
		clockType = cT;
	}

	public int[] getBinary(int number) {
		int[] b = new int[4];
		int i = 0;

		for (i = 0; i < 4; i++)
			b[i] = 0;

		i = 0;

		while (number > 0) // b[0] = lsb , b[3] = msb
		{
			b[i++] = number % 2;
			number = number / 2;
		}

		return b;
	}

	public int[][] drawH(int[][] mat, int d1, int d2, int x, int lineNo,
			char option) // option selects draw for hour / minute / second
	{
		int[] bin;
		int i = 0;
		int auxLineNo = lineNo;
		int auxX = x;
        int incr ;
        int blackWhite; // 0 - black , 1 - white
        
        if(blackBinary)
        {
        	blackWhite = 0;
        }
        else
        {
        	blackWhite = 1;
        }
        
        if(watchSize == 0)
        {
        	incr = 2;
        }
        else
        {
        	incr = 4;
        }
		
		
		if (d1 > 0) {
			bin = getBinary(d1);

			for (i = 0; i < 4; i++) {
				if (bin[i] == 1) {
					   
					 if(watchSize == 1)
					 {
						mat[auxX][auxLineNo - 1] = blackWhite;
						mat[auxX - 1][auxLineNo] = blackWhite;
						mat[auxX - 1][auxLineNo - 1] = blackWhite;
					 }
					 mat[auxX][auxLineNo] = blackWhite;
						
					
				}

				if (option == 'h') {
					auxLineNo -= incr;
					auxX += incr;
				
				} else if (option == 'm') {
					
					auxLineNo -= incr;
				} else if (option == 's') {
					auxLineNo -= incr;
					auxX -= incr;
				}

			}
		}

		auxLineNo = lineNo;
		auxX = x + incr;

		if (d2 > 0) {
			bin = getBinary(d2);

			for (i = 0; i < 4; i++) {
				if (bin[i] == 1) {
					
					if(watchSize == 1)
					 {
						mat[auxX][auxLineNo - 1] = blackWhite;
						mat[auxX - 1][auxLineNo] = blackWhite;
						mat[auxX - 1][auxLineNo - 1] = blackWhite;
					 }
					 mat[auxX][auxLineNo] = blackWhite;
					
				}

				if (option == 'h') {
					auxLineNo -= incr;
					auxX += incr;
				} else if (option == 'm') {
					auxLineNo -= incr;
				} else if (option == 's') {
					auxLineNo -= incr;
					auxX -= incr;
				}
			}
		}

		return mat;
	}

	public int[][] drawBinaryWatch(int[][] matrix){

		int i = 0, j = 0;
		int width , height ;
		int x, lineNo ; // left starting point at x , line at y = 40
		SimpleDateFormat df;
		String formattedDate = "";
		Calendar cal = Calendar.getInstance();
		df = new SimpleDateFormat("HH:mm:ss");
        
		
		
		if(watchSize == 0)
		{
			lineNo = 47;
			width = 27;
			height = 11;
			x = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 14;
			
		}
		else
		{
			lineNo = 58;
			width = 54;
			height = 22;
			x = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 27;
			
		}
		
		formattedDate = df.format(cal.getTime());

		String[] values = formattedDate.split(":");
        

		for (i = x; i < x + width; i++) {
			for (j = lineNo; j > lineNo - height; j--) {
				if (blackBinary == true)
					matrix[i][j] = 1;
				else
					matrix[i][j] = 0;

				if (i == x || i == x + width - 1)
					if (blackBinary == true) {
						matrix[i][j] = 0;
					} else {
						matrix[i][j] = 1;
					}

				if (j == lineNo || j == lineNo - height + 1)
					if (blackBinary == true) {
						matrix[i][j] = 0;
					} else {
						matrix[i][j] = 1;
					}
			}
		}

		int d = 0, d1 = 0, d2 = 0;
		// pt ore

		d = Integer.parseInt(values[0]);
		if (d > 9) {
			d2 = d % 10;
			d = d / 10;
			d1 = d; // most significant digit
		} else {
			d2 = d;
		}

		// matrix = drawH(matrix,d1,d2,x + 2, lineNo - 2, 'h');
		if(watchSize == 0)
		{
			matrix = drawH(matrix, d1, d2, x + 2, lineNo - 2, 'h');
			x = x + 12;
		}
		else
		{
			matrix = drawH(matrix, d1, d2, x + 4, lineNo - 4, 'h');
			x = x + 24;
		}

		

		// minute
		d = 0;
		d1 = 0;
		d2 = 0;
		d = Integer.parseInt(values[1]);

		if (d > 9) {
			d2 = d % 10;
			d = d / 10;
			d1 = d;
		} else {
			d2 = d;
		}

		// matrix = drawH(matrix,d1,d2,x , lineNo - 2,'m');
		if(watchSize == 0)
		{
			matrix = drawH(matrix, d1, d2, x, lineNo - 2, 'm');
			x = x + 10;
		}
		else
		{
			matrix = drawH(matrix, d1, d2, x, lineNo - 4, 'm');
			x = x + 20;
		}

		

		// secunde
		d = 0;
		d1 = 0;
		d2 = 0;
		d = Integer.parseInt(values[2]);
		if (d > 9) {
			d2 = d % 10;
			d = d / 10;
			d1 = d;
		} else {
			d2 = d;
		}
        
		if(watchSize == 0)
		{
			matrix = drawH(matrix, d1, d2, x, lineNo - 2, 's');
		}
		else
		{
			matrix = drawH(matrix, d1, d2, x, lineNo - 4, 's');
		}

		return matrix;
	}

	@SuppressLint("SimpleDateFormat")
	public int[][] drawDateTime(int[][] matrix) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df;
		String formattedDate = "";

		int start = 0;

			if (dispDate == true) {
				df = new SimpleDateFormat("dd/MM/yy");
				start = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 23;
				formattedDate = df.format(cal.getTime());
				matrix = writeLine(formattedDate, start, 33, matrix);
			}

			if (dispTime == true) {
				if (clockType.equalsIgnoreCase("Decimal")) {
					df = new SimpleDateFormat("HH:mm");
					start = (LCDLiveWallpaper.getLCD_WIDTH() / 2) - 14;
					formattedDate = df.format(cal.getTime());
					matrix = writeLine(formattedDate, start, 25, matrix);
				} else if (clockType.equalsIgnoreCase("Binary")) {
					matrix = drawBinaryWatch(matrix);
				}
			}
	

		return matrix;
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

package lwp;

public class WriteClass {
	private int[][] displayMatrix;
	private int cHeight = 7, cWidth = 5;

	void setCharacter(char c, int x, int lineNo) {
		int i = 0;

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

		}
	}

	public int[][] writeLine(String s, int x, int lineNo, int[][] dispM) // lineNo
																			// e
																			// practic
																			// linia
																			// pe
																			// care
																			// va
																			// scrie,
																			// coordonata
																			// y
																			// cea
																			// mai
																			// de
																			// jos
																			// a
																			// literei/numarului
	{
		displayMatrix = dispM;
		int i = 0;
		int spacing = 1;

		for (i = 0; i < s.length(); i++) {
			try {
				setCharacter(s.charAt(i), x, lineNo);
			} catch (Exception e) {
			}
			x = x + cWidth + spacing;
		}

		return displayMatrix;
	}
}

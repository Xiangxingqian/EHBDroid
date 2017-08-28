package ehb.instrumentation.codecoverage;

import com.app.test.AppDir;
import com.app.test.Constants;

import android.util.Log;

public class CoverageToolkit {
	
	/**
	 * ��ʼ��������ά���� bbb���洢��i�����е�j��������k����֧�Ƿ��Ѿ�isReached 0��ʾfalse�� 1��ʾtrue
	 * lll���洢��i�����е�j��������k����֧��lines
	 */
	public static int[][][] bbb = new int[AppDir.CLASSCOUNT][][];
	public static int[][][] lll = new int[AppDir.CLASSCOUNT][][];

	/**
	 * @return ���reach������
	 */
	public static int calculateLines() {
		int reachLines = 0;
		for (int i = 0; i < bbb.length; i++) {
			for (int j = 0; j < bbb[i].length; j++) {
				for (int k = 0; k < bbb[i][j].length; k++) {
					int total = bbb[i][j][k] == 0 ? 0 : lll[i][j][k];
					reachLines = reachLines + total;
				}
			}
		}
		return reachLines;
	}

	/**
	 * ��ʼ����ά����
	 * 
	 * @param i
	 *            ��i��class
	 * @param j
	 *            ����j��method
	 */
	public static void initbbblllij(int i, int j) {
		bbb[i - 1] = new int[j][];
		lll[i - 1] = new int[j][];
	}

	/**
	 * ��i��class��j��method����k��branch
	 * 
	 * @param i
	 *            ��i��class
	 * @param j
	 *            ��j��method
	 * @param k
	 *            ����k��branch
	 */
	public static void initbbblllijk(int i, int j, int k) {
		bbb[i - 1][j - 1] = new int[k];
		lll[i - 1][j - 1] = new int[k];
	}

	/**
	 * ���õ�i��class��j��method��k��branch: isReached��length
	 * 
	 * @param i
	 *            ��i��class
	 * @param j
	 *            ��j��method
	 * @param k
	 *            ��k��branch
	 * @param length
	 *            length of lines
	 */
	public static void instrumentData(int i, int j, int k, int length) {
		bbb[i - 1][j - 1][k - 1] = 1;
		lll[i - 1][j - 1][k - 1] = length;
	}

	/**
	 * ��ӡ���reach�Ľ��
	 */
	public static void printResult() {
		int calculateLines = calculateLines();
		Log.v(Constants.LogTag.countTag, "Reaching Lines: "+calculateLines);
	}

}

package main;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class MyWallpaper extends WallpaperService {

	private static final int LCD_WIDTH = 144;
	private static final int LCD_HEIGHT = 256;

	@Override
	public Engine onCreateEngine() {
		// TODO Auto-generated method stub
		return new MyWallpaperEngine();
	}

	private class MyWallpaperEngine extends Engine {
		private Handler mHandler = new Handler();
		private SurfaceHolder sh;
		private Canvas c = null;
		private Paint p = null;
		private int width = 0;
		private int height = 0;
		private int pixelWidth = 0;
		private int pixelHeight = 0;
		private boolean refresh = true;
		private int[][] displayMatrix;
		private int posx;

		private Runnable mDraw = new Runnable() {

			public void run() {
				drawFrame();
			}

		};

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			super.onSurfaceDestroyed(holder);
			mHandler.removeCallbacks(mDraw);
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			// TODO Auto-generated method stub
			super.onCreate(surfaceHolder);
			sh = surfaceHolder;
			p = new Paint();
			p.setARGB(0xFF, 0x00, 0x00, 0x00);
			p.setStrokeWidth(0.5f);
			p.setTextSize(100);
			posx = 0;
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			// TODO Auto-generated method stub
			super.onSurfaceChanged(holder, format, width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			super.onSurfaceCreated(holder);

			c = sh.lockCanvas();
			width = c.getWidth();
			height = c.getHeight();
			pixelWidth = width / LCD_WIDTH;
			pixelHeight = height / LCD_HEIGHT;
			initMatrix();
			try {
				sh.unlockCanvasAndPost(c);
			} catch (Exception e) {
			}
		}

		@Override
		public void onSurfaceRedrawNeeded(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			super.onSurfaceRedrawNeeded(holder);
			drawFrame();

		}

		private void drawFrame() {
			Random r = new Random();
			c = sh.lockCanvas();
			drawBg(c);
			drawMatrix();
			/*
			 * for (int i = 0; i < LCD_WIDTH; i++) for (int j = 0; j <
			 * LCD_HEIGHT; j++) { if (r.nextBoolean()) drawPixel(i, j); }
			 */
			try {
				sh.unlockCanvasAndPost(c);
			} catch (Exception e) {
			}
			mHandler.postDelayed(mDraw, 1000 / 5);
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			super.onTouchEvent(event);
			int touchX = (int) event.getX() * LCD_WIDTH / width;
			int touchY = (int) event.getY() * LCD_HEIGHT / height;
			Log.d("WallpaperExample", "" + touchX);
			Log.d("WallpaperExample", "" + touchY);
			for (int i = touchX - 5; i <= touchX + 5; i++)
				for (int j = touchY; j <= touchY + 5; j++)
					displayMatrix[i][j] = 1;
		}

		private void drawBg(Canvas c) {
			Paint bg = new Paint();
			bg.setARGB(0xFF, 0x88, 0xAA, 0x88);
			try {
				c.drawRect(0, 0, width, height, bg);
			} catch (Exception e) {
			}
		}

		private void initMatrix() {
			DisplayMetrics dm = new DisplayMetrics();
			displayMatrix = new int[LCD_WIDTH][LCD_HEIGHT];
			for (int i = 0; i < LCD_WIDTH; i++)
				for (int j = 0; j < LCD_HEIGHT; j++)
					displayMatrix[i][j] = 0;
		}

		private void drawPixel(int x, int y) {
			int margin = 0;
			try {
				c.drawRect((x * pixelWidth) + margin, (y * pixelHeight)
						+ margin, (x * pixelWidth) + pixelWidth - margin,
						(y * pixelHeight) + pixelHeight - margin, p);
			} catch (Exception e) {
			}
		}

		private void drawMatrix() {
			for (int i = 0; i < LCD_WIDTH; i++)
				for (int j = 0; j < LCD_HEIGHT; j++) {
					if (displayMatrix[i][j] != 0)
						drawPixel(i, j);
				}
		}
	}

}

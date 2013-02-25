package lwp;

import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import java.lang.String;

public class MyWallpaper extends WallpaperService {

	private static int LCD_WIDTH = 72;
	private static int LCD_HEIGHT = 128;

	@Override
	public Engine onCreateEngine() {
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
		private int[][] displayMatrix;
		private int framerate = 1000/2;
	   
		//added
		private int cWidth = 5;
		private int cHeight = 7;
		//add end

		private Runnable mDraw = new Runnable() {

			public void run() {
				drawFrame();
			}

		};

		private void drawBg(Canvas c) {
			Paint bg = new Paint();
			bg.setARGB(0xFF, 0x88, 0xAA, 0x88);
			try {
				c.drawRect(0, 0, width, height, bg);
			} catch (Exception e) {
			}
		}
        
		//added start
		
		void setCharacter(char c,int x, int lineNo)
		{
			int i = 0;
			
			switch(c)
			{
			case '0': 
				     
					  for(i = lineNo - 1; i >lineNo - cHeight + 1; i--)
					  {
						  displayMatrix[x][i] = 1;
						  displayMatrix[x+4][i] = 1;
					  }
					  
					  for(i = x + 1; i < x + cWidth - 1 ; i++)
					  {
						  displayMatrix[i][lineNo] = 1;
						  displayMatrix[i][lineNo - 6] = 1;
					  }
				      
					  displayMatrix[x + 1][lineNo - 2] = 1;
					  displayMatrix[x + 2][lineNo - 3] = 1;
					  displayMatrix[x + 3][lineNo - 4] = 1;
					  
				      break;
			
			case '1':
				     displayMatrix[x+1][lineNo] = 1;
				     displayMatrix[x+3][lineNo] = 1;
				      
				      for(i = lineNo; i >= lineNo - cHeight + 1; i--)
				      {
				    	  displayMatrix[x+2][i] = 1;
				      }
				      
				      displayMatrix[x+1][lineNo - cHeight + 2 ] = 1;
				      break;
				      
			case '2': 
				      for(i = x; i < x + 5; i++)
				    	  displayMatrix[i][lineNo] = 1;
				      
				      for(i = x + 1; i < x + cWidth - 1 ; i++)
				      {
						  displayMatrix[i][lineNo - 6] = 1;
					  }
				      
				      displayMatrix[x+1][lineNo -1] = 1;
				      displayMatrix[x+2][lineNo -2] = 1;
				      displayMatrix[x+3][lineNo -3] = 1;
				      displayMatrix[x+4][lineNo -4] = 1;
				      displayMatrix[x+4][lineNo -5] = 1;
				      displayMatrix[x+4][lineNo -5] = 1;
				      displayMatrix[x][lineNo - 5] = 1;
				      
				      break;
				      
			case '3':  for(i = x; i < x + 5; i++)
		    	  		 displayMatrix[i][lineNo - 6] = 1;
			
						for(i = x + 1; i < x + cWidth - 1 ; i++)
						{
							displayMatrix[i][lineNo] = 1;
						}
				        
						displayMatrix[x][lineNo - 1] = 1;
						displayMatrix[x+4][lineNo - 1] = 1;
						displayMatrix[x+4][lineNo - 2] = 1;
						displayMatrix[x+3][lineNo - 3] = 1;
						displayMatrix[x+2][lineNo - 4] = 1;
						displayMatrix[x+3][lineNo - 5] = 1;
						
				        break;
				        
			case '4':   for(i = x; i < x + 5; i++)
						{
				            displayMatrix[i][lineNo - 2] = 1;
						}
			            
			            for(i = lineNo; i >= lineNo - 6; i--)
			            {
			            	displayMatrix[x+3][i] = 1;
			            }
			            
			            displayMatrix[x][lineNo - 3] = 1;
			            displayMatrix[x+1][lineNo - 4] = 1;
			            displayMatrix[x+2][lineNo - 5] = 1;
				        
				        break;
				        
			case '5':   for(i = x; i < x + 5; i++)
					    {
					 		 displayMatrix[i][lineNo - 6] = 1;
				        }
				        
					    for(i = x; i < x + 4; i++)
					    {
							 displayMatrix[i][lineNo - 4] = 1;
					    }
					    
					    for(i = x+1; i < x + 4; i++)
						{
				            displayMatrix[i][lineNo] = 1;
						}
					    
					    for(i = lineNo - 1; i >= lineNo - 3; i--)
					    {
					    	displayMatrix[x+4][i] = 1;
					    }
					    
					    displayMatrix[x][lineNo - 5] = 1;
					    displayMatrix[x][lineNo - 1] = 1;
					     
				        break; 
				        
			case '6':
						for(i = x + 1; i < x + 4; i++)
						{
						   displayMatrix[i][lineNo] = 1;
						   displayMatrix[i][lineNo - 3] = 1;
						}
						
						for(i = lineNo - 1; i >= lineNo - 4; i--)
						{
						   displayMatrix[x][i] = 1;
						}
						
						displayMatrix[x + 4][lineNo - 1] = 1;
						displayMatrix[x + 4][lineNo - 2] = 1;
						displayMatrix[x + 1][lineNo - 5] = 1;
						displayMatrix[x + 2][lineNo - 6] = 1;
						displayMatrix[x + 3][lineNo - 6] = 1;
				 
				        break;
				        
			case '7':   
				        for(i = x; i < x + 5; i++)
				        {
				        	displayMatrix[i][lineNo - 6] = 1;
				        }
				        
				        for(i = lineNo - 4; i >= lineNo - 5; i--)
				        {
				            displayMatrix[x + 4][i] = 1;	
				        }
				        
				        for(i = lineNo; i >= lineNo - 2; i--)
				        {
				            displayMatrix[x+2][i] = 1;
				        }
				        
				        displayMatrix[x + 3][lineNo - 3] = 1;
				        
				        break;
				        
			case '8': 
				        for(i = x + 1; i < x + 4; i++)
				        {
				        	displayMatrix[i][lineNo] = 1;
				        	displayMatrix[i][lineNo - 3] = 1;
				        	displayMatrix[i][lineNo - 6] = 1;
				        }
				        
				        for(i = lineNo -1; i >= lineNo - 2; i--)
				        {
				        	displayMatrix[x][i] = 1;
				        	displayMatrix[x + 4][i] = 1;
				        }
				        
				        for(i = lineNo - 4; i >= lineNo - 5; i--)
				        {
				        	displayMatrix[x][i] = 1;
				        	displayMatrix[x + 4][i] = 1;
				        }
				
				        break;
				        
			case '9': 
				        for(i = x + 1; i < x + 4; i++)
				        {
				           displayMatrix[i][lineNo - 3] = 1;
				           displayMatrix[i][lineNo - 6] = 1;
				        }
				        
				        for(i = lineNo - 2; i >= lineNo - 5; i--)
				        {
				           displayMatrix[x+4][i] = 1;
				        }
				        
				        displayMatrix[x][lineNo - 4] = 1;
				        displayMatrix[x][lineNo - 5] = 1;
				        
				        displayMatrix[x + 1][lineNo] = 1;
				        displayMatrix[x + 2][lineNo] = 1;
				        displayMatrix[x + 3][lineNo - 1] = 1;
				        	
				        break;
			}
		}
		
		private void writeLine(String s,int x,int lineNo) // lineNo e practic linia pe care va scrie, coordonata y cea mai de jos a literei/numarului
		{
			int i = 0;
			int spacing = 2;
			
			for(i = 0; i < s.length(); i++)
			{
			   setCharacter(s.charAt(i),x,lineNo);
			   x = x + cWidth + spacing;
			}
		
		}
		
		//added end
		private void drawFrame() {
			Random r = new Random();
			c = sh.lockCanvas();
			drawBg(c);
			drawMatrix();
			initMatrix();	// Called just to clean the matrix
			//added
			int x = 5,lineNo = 10;
			String s = "01234";
			writeLine(s,x,lineNo);
			writeLine("56789",5,18);
			
			
			drawMatrix();
			//end add
			/*
			for (int i = 0; i < LCD_WIDTH; i++)
				for (int j = 0; j < LCD_HEIGHT; j++) {
					if (r.nextBoolean())
						drawPixel(i, j);
				}
			*/
			try {
				sh.unlockCanvasAndPost(c);
			} catch (Exception e) {
			}
			mHandler.postDelayed(mDraw, framerate);
		}

		private void drawMatrix() {
			for (int i = 0; i < LCD_WIDTH; i++)
				for (int j = 0; j < LCD_HEIGHT; j++) {
					if (displayMatrix[i][j] != 0)
						drawPixel(i, j);
				}
		}

		private void drawPixel(int x, int y) {
			int margin = 1;
			try {
			
				c.drawRect((x * pixelWidth) + margin, (y * pixelHeight)
						+ margin, (x * pixelWidth) + pixelWidth - margin,
						(y * pixelHeight) + pixelHeight - margin, p);
			} catch (Exception e) {
			}
		}

		@SuppressLint("NewApi")
		private void initMatrix() {
			final WindowManager w = (WindowManager) getApplicationContext()
					.getSystemService(Context.WINDOW_SERVICE);
			final Display d = w.getDefaultDisplay();
			final DisplayMetrics m = new DisplayMetrics();
			int currentapiVersion = android.os.Build.VERSION.SDK_INT;
			
			if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
				d.getRealMetrics(m);
			} else {
				d.getMetrics(m);
			}
			
			LCD_WIDTH = m.widthPixels / 10;
			LCD_HEIGHT = m.heightPixels / 10;
			displayMatrix = new int[LCD_WIDTH][LCD_HEIGHT];
			for (int i = 0; i < LCD_WIDTH; i++)
				for (int j = 0; j < LCD_HEIGHT; j++)
					displayMatrix[i][j] = 0;
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			sh = surfaceHolder;
			p = new Paint();
			p.setARGB(0xFF, 0x33, 0x33, 0x33);
			p.setStrokeWidth(0.5f);
			p.setTextSize(100);
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			initMatrix();
			c = sh.lockCanvas();
			width = c.getWidth();
			height = c.getHeight();
			pixelWidth = width / LCD_WIDTH;
			pixelHeight = height / LCD_HEIGHT;
			try {
				sh.unlockCanvasAndPost(c);
			} catch (Exception e) {
			}
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			mHandler.removeCallbacks(mDraw);
		}

		@Override
		public void onSurfaceRedrawNeeded(SurfaceHolder holder) {
			super.onSurfaceRedrawNeeded(holder);
			drawFrame();

		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);

			int touchX = (int) event.getX() * LCD_WIDTH / width;
			int touchY = (int) event.getY() * LCD_HEIGHT / height;
			try {
				for (int i = touchX - 5; i <= touchX + 5; i++)
					for (int j = touchY - 5; j <= touchY + 5; j++)
						displayMatrix[i][j] = 1;
			} catch (Exception e) {
			}
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			super.onVisibilityChanged(visible);
			if(visible)
				mHandler.postDelayed(mDraw, framerate);
			else
				mHandler.removeCallbacks(mDraw);
			
		}
	}
}

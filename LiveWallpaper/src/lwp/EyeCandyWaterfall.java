package lwp;

import java.util.Random;

import android.util.Log;

class wString{
	public short speed;
    public short length; 
	public short startpos; // start position 
	public short column;
	
	public wString(short s,short l, short st, short c)
	{
		speed = s;
		length = l;
		startpos = st;
		column = c;
	}
	
}

public class EyeCandyWaterfall extends EyeCandy{
	private boolean [][] waterfall;
	private boolean[][] waterfcopy;
	private int width, height;
	private wString [] assignedStrings;
	private short maxNrStrings;
	private short currNrStrings;
	
	public EyeCandyWaterfall()
	{
		init(); 
	}
	
	public void init()
	{
		width = LCDLiveWallpaper.getLCD_WIDTH();
		height = LCDLiveWallpaper.getLCD_HEIGHT();
		waterfall = new boolean [width][height];
		maxNrStrings = 70;
		assignedStrings = new wString[maxNrStrings];
		
		for(int i = 0; i < maxNrStrings; i++)
		{
			assignedStrings[i] = null;
		}
		currNrStrings = 0;
	}
	
	public boolean checkCol(short nrCol)
	{
		int i;
		
		for(i = 0; i < maxNrStrings; i++)
		{
			if(assignedStrings[i] != null)
			{
				if(assignedStrings[i].column == nrCol)
				{
					return false;   // the colomn is already in use
				}
			}
		}
		
		return true;   // free column
	}
	
	public boolean giveLife()
	{
		Random generator = new Random();
		int value = generator.nextInt(101);
		
		if(value >= 0 && value <= 80)
		{
			return true;
		}
		
		return false;
	}
	
	public void addNewString(wString s)
	{
	   int i = 0;
	   
	   for(i = 0; i < maxNrStrings; i++)
	   {
		   if(assignedStrings[i] == null)
		   {
			   assignedStrings[i] = s;
			   currNrStrings++;
			   break;
		   }
	   }
	}

	public void makeNewStr()
	{
		Random generator = new Random();
		wString seed; // s-ar putea sa existe sau nu dupa giveLife, asa ca i-am zis samanta
		
		if(giveLife())
		{
			int col = generator.nextInt(width);
			
			if(checkCol((short)col))
			{
			   short length = (short)( 4 + generator.nextInt(7));
               short speed = (short)(1+generator.nextInt(1) );
			   seed = new wString( speed,length , (short)-length, (short)col );
			   Log.d("mywallpaper,speed",String.valueOf(speed));
			   addNewString(seed);
			   Log.d("mywallpaper,nr of str",String.valueOf(currNrStrings));
			}
		}
		
		
		
	}
	
	public void putString(short col, short startline,short len)
	{
		// incape sa afiseze tot stringul mergand in jos , fara sa iasa din partea de jos a ecranului
		if(startline + len <= height )
		{
			for(int i = startline; i < startline + len ; i++)
			{
				waterfall[col][i]  = true;
			}
		}
		else  /// nu incape tot pe ecran , asa ca taie din el
		{
		   short outOfBounds = (short) (startline + len - height);
		   for (int i = startline; i < startline + len - outOfBounds; i++)
		   {
			   waterfall[col][i]  = true;
		   }
		}
	}
	
	public void updateTheStrings()
	{
		int i = 0;
		
		for(i = 0; i < maxNrStrings; i++)
		{
		   if(assignedStrings[i] != null)
		   {
			   assignedStrings[i].startpos += assignedStrings[i].speed;
			   if(assignedStrings[i].startpos < 0)
			   {
				 int visibleLength = assignedStrings[i].length + assignedStrings[i].startpos;
				 putString(assignedStrings[i].column,(short)0,(short)visibleLength);
			   }
			   else
			   {
				 putString(assignedStrings[i].column, assignedStrings[i].startpos, assignedStrings[i].length );  
			   }
			   
				 
			   if(assignedStrings[i].startpos >= height)
			   {
				 assignedStrings[i] = null; // inseamna ca a iesit de pe ecran , s-a terminat  
				 currNrStrings--;
			   }
			   
		   }
		}
	}
	
	public  final boolean[][] draw(boolean[][] matrix)
	{
		
		
        
		if(currNrStrings < maxNrStrings)
		{
			makeNewStr();
		}
		
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				waterfall[j][i] = false;   //clear waterfall
        
		updateTheStrings();
		
		return waterfall;
	}
	
	
	
	
	

}

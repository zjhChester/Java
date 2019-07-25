package 五一作业继承;

public class rectangle {
    protected int lenth;
	protected int width;
	
	rectangle(int lenth, int width)
	{
		this.lenth = lenth;
		this.width = width;
	}
	int area()
	{
		return lenth*width;
	}
}
	class rectangle3D extends rectangle
	{
		private int height;
		rectangle3D(int lenth, int width,int height)
	 {
		 super(lenth, width);
		 this.height = height;
	 }
		int V()
		{
			
			return lenth*width*height;
		}
	}  
 
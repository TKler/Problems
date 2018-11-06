package p90to120;
//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Microsoft.
//
//Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. 
//And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.
public class Problem120
{
	private static Problem120 _oddInstance;
	private static Problem120 _evenInstance;
	private static int _numberOfCalls = 0;
    
    private Problem120()
    {
    }
    
    public static Problem120 getInstance()
    {
    	if(_numberOfCalls % 2 == 0)
    		return getInstance(_evenInstance);
    	else
    		return getInstance(_oddInstance);
    		
    }

	private static Problem120 getInstance(Problem120 instance)
	{
		_numberOfCalls++;
		if(instance == null)
			instance = new Problem120();
		
		return instance;
	}
    
}

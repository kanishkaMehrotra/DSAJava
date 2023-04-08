package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeKeyValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TimeMap {

    HashMap<String ,ArrayList<Timebased>> hm;
    public TimeMap() {
       hm =new HashMap ();
    }
    
    public void set(String key, String value, int timestamp) {
        
      if (!hm.containsKey(key))
        hm.put(key,new ArrayList());
        hm.get(key).add(new Timebased(value,timestamp) );
        //System.out.println(hm);

    }
    
    public String get(String key, int timestamp) {
        
         System.out.println(timestamp);

        if(!hm.containsKey(key)) return "";
        
        ArrayList<Timebased> t=hm.get(key);

        return search (t,timestamp);
        
        
    }

    public String search (ArrayList<Timebased> t,int timestamp)
    {
        
        int s=0;
        int e=t.size()-1;
        String res="";
       // System.out.println("calling search"+t+" "+timestamp);
       // System.out.println("s "+s+" e "+e);

        while (s<=e)
        {
        int  mid=(s+e)/2;
        //System.out.println("mid "+mid);
        if(t.get(mid).timestamp<=timestamp)
         {
        res=t.get(s).value;
         s=mid+1;
         }
        else
         e=mid-1;
       // System.out.println("s "+s+" e "+e);   
        }
        return res;
    }
}


class Timebased
{
    String value; 
    int timestamp;

    public Timebased( String value, int timestamp)
    {
        this.value=value;
        this.timestamp=timestamp;
    }
    public String toString()
    {
        return value +" "+timestamp;
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
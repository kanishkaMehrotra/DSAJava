package practiceJavaInterviews;

import java.util.List;

public class ImmutableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s=new  Student(0, null);


	    ImmutableStudent student = new ImmutableStudent(1, "Alex");
	}
}
	public final class ImmutableStudent {

	    private final int id;
	    private final String name;
	   // private final Age age;

	    public ImmutableStudent(int id, String name) {
	    this.name = name;
	    this.id = id;
	   // this.age = age;
	    }

	    public int getId() {
	    return id;
	    }

	    public String getName() {
	    return name;
	    }

	
	    }
	}
  class Student //so that it cannot be inherited
	{
		private final int id;
		private final String Name;
		//List<String> subjects;
		public Student(int id, String name) {
			super();
			this.id = id;
			Name = name;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return Name;
		}
		
		
		
	}
	
	
}

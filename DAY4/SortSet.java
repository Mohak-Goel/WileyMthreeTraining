import java.util.*;


class User{
	
	int id;
	String name;
	
	User(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "User{"+id+",\""+name+"\"}";
	}
	
}

class Type{
	public Object object;
	
	Type(Object object){
		this.object = object;
	}
	@Override
	public String toString() {
		return object.toString()+", ";
	}
}

class SortByInteger implements Comparator<Type>{
	@Override
	public int compare(Type o1, Type o2) {
		
		if(o1.object instanceof Integer) {
			
			if(o2.object instanceof Integer)
				return (int)o1.object - (int)o2.object;
			
			else if(o2.object instanceof String || o2.object instanceof User)
				return -1;
			
			return 0;
        
		}
		else if(o1.object instanceof User)
		{
	        if(o2.object instanceof User){
	        	User a = (User)o1.object;
	        	User b = (User)o2.object;
	            return a.getId()-b.getId();
	        }else if(o2.object instanceof Integer){
	            return 1;
	        }
	        else if(o2.object instanceof String){
	            return -1;
	        }
	        return 0;
		}
		else if(o1.object instanceof String)
		{
	        if(o2.object instanceof String){
	            String str1 = (String)o1.object;
	            String str2 = (String)o2.object;
	            return str1.compareTo(str2);
	        }else if(o2.object instanceof Integer || o2.object instanceof User){
	            return 1;
	        }
	        return 0;
		}
		return 0;
	}
}

class SortByString implements Comparator<Type>{
	@Override
	public int compare(Type o1, Type o2) {
		
		if(o1.object instanceof String)
		{
	        if(o2.object instanceof String){
	            String str1 = (String)o1.object;
	            String str2 = (String)o2.object;
	            return str1.compareTo(str2);
	        }else if(o2.object instanceof Integer || o2.object instanceof User){
	            return -1;
	        }
	        return 0;
		}
		
		else if(o1.object instanceof User)
		{
	        if(o2.object instanceof User){
	        	User a = (User)o1.object;
	        	User b = (User)o2.object;
	            return a.getName().compareTo(b.getName());
	        }else if(o2.object instanceof String){
	            return 1;
	        }
	        else if(o2.object instanceof Integer){
	            return -1;
	        }
	        return 0;
		}
		else if(o1.object instanceof Integer) {
			
			if(o2.object instanceof Integer)
				return (int)o1.object - (int)o2.object;
			
			else if(o2.object instanceof String || o2.object instanceof User)
				return 1;
			
			return 0;
        
		}
		return 0;
	}
}

class SortByAllString implements Comparator<Type>{
	@Override
	public int compare(Type o1, Type o2) {
		
		if(o1.object instanceof Integer) {
			if(o2.object instanceof Integer)
				return (int)o1.object-(int)o2.object;
			else
				return 1;
		}
		if(o1.object instanceof User) {
			User a = (User)o1.object;
			if(o2.object instanceof User) {
				User b = (User)o2.object;
				return a.getName().compareTo(b.getName());
			}
			else if(o2.object instanceof String)
				return a.getName().compareTo(o2.object.toString());
			else
				return -1;
		}
		if(o1.object instanceof String) {
			if(o2.object instanceof User) {
				User b = (User)o2.object;
				return o1.object.toString().compareTo(b.getName());
			}
			else if(o2.object instanceof String)
				return o1.object.toString().compareTo(o2.object.toString());
			else
				return -1;
		}
		return 0;
	}
}

public class SortSet {

	public static void main(String[] args) {
		//Set<Type> set = new TreeSet<>(new SortByInteger());
		//Set<Type> set = new TreeSet<>(new SortByString());
		Set<Type> set = new TreeSet<>(new SortByAllString());
		set.add(new Type(new Integer(20)));
		set.add(new Type("Hi"));
		set.add(new Type("Hello"));
		set.add(new Type(new Integer(10)));
		set.add(new Type(new User(1, "Adam")));
		set.add(new Type(new User(2, "User2")));
		set.forEach(System.out::print);
	}

}

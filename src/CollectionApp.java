import java.util.*;

public class CollectionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set s=new HashSet();
		s.add(90);
		s.add(20);
		s.add(1);
		s.add(18);
		//s.add(10);
		s.add(11);
		System.out.println(s);
		List l=new ArrayList();
		l.add(11);
		l.add(20);
		l.add(748);
		l.add(67);
		System.out.println(l);
		for(Object n:l) {
			int i=(Integer)n;
			System.out.println("loop:"+i+1);
		}
		Iterator i=l.iterator();
		while(i.hasNext()) {
			int i1=(Integer)i.next();
			System.out.println("iterator of list:"+i1);
		}
		Iterator s1=s.iterator();
		while(s1.hasNext()) {
			int i2=(Integer)s1.next();
			System.out.println("iterator of set:"+i2);
		}
		ArrayList list=new ArrayList();
		if(list.isEmpty())
			System.out.println("Empty list");
		list.add(10);
		list.add(20);
		list.add(7);
		//System.out.println(list.contains(23));
		//list.forEach((e)->System.out.println(e));
		//System.out.println(list.get(2));
		ListIterator ite=list.listIterator();
		while(ite.hasNext()) {
			System.out.println(ite.next()+" ");
		}
		while(ite.hasPrevious()) {
			System.out.println(ite.previous()+" ");
		}
	}

}

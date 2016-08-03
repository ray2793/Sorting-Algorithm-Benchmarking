import java.util.Random;


public class MyBigObject implements Comparable<MyBigObject> {

	static Random rand = new Random(0);
	private int i;
	private double [] d;
	
	public MyBigObject() {
		i = rand.nextInt(500) + 100;
		d = new double [rand.nextInt(1000) + 100];
	}
	
	public MyBigObject(int size) {
		i = size;
		d = new double [rand.nextInt(1000) + 100];
	}
	
	@Override
	public int compareTo(MyBigObject other) {
		// TODO Auto-generated method stub
		if (this.i < other.i) return -1;
		if (this.i > other.i ) return 1;
		//otherwise determine by the size of the StringBuffer object
		if (this.d.length < other.d.length) return -1;
		if (this.d.length > other.d.length) return 1;
		//otherwise they are equal
		return 0;
	}
}

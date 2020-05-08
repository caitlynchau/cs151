package part3;

public class TVTester {
	
	public static void main(String[] args) {
		Television tv = new Television();
		
		tv.changeChannel(Channel.NBC);
		tv.changeChannel(Channel.FOOD);
		tv.changeChannel(Channel.ABC);
		tv.changeChannel(Channel.HBO);
		tv.changeChannel(Channel.MSNBC);
	}
}

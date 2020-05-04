package part3;

public enum Channel {
	NBC("NBC", 149),
	ABC ("ABC", 43),
	MSNBC("MSNBC", 13),
	FOOD("FOOD", 383),
	HBO("HBO", 204);
	
	private final String channelName;
	private final int channelNum;
	
	private Channel(String channelName, int channelNum) {
		this.channelName = channelName;
		this.channelNum = channelNum;
	}

}

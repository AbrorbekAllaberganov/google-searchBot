package newsJson;

import java.util.List;

public class NewsResponse{
	private Feed feed;
	private List<EntriesItem> entries;
	private double ts;

	public Feed getFeed(){
		return feed;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	public double getTs(){
		return ts;
	}
}
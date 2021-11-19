package wikiJson;

import java.util.List;

public class WikiResponse{
	private int total;
	private String html;
	private List<ResultsItem> results;
	private double ts;

	public int getTotal(){
		return total;
	}


	public String getHtml(){
		return html;
	}


	public List<ResultsItem> getResults(){
		return results;
	}

	public double getTs(){
		return ts;
	}
}
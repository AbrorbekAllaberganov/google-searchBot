package wikiJson;

import java.util.List;

public class ResultsItem{
	private String link;
	private List<AdditionalLinksItem> additionalLinks;
	private String description;
	private Cite cite;
	private String title;

	public String getLink(){
		return link;
	}

	public List<AdditionalLinksItem> getAdditionalLinks(){
		return additionalLinks;
	}

	public String getDescription(){
		return description;
	}

	public Cite getCite(){
		return cite;
	}

	public String getTitle(){
		return title;
	}
}
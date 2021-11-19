package newsJson;

import java.util.List;

public class EntriesItem{
	private String summary;
	private List<Integer> publishedParsed;
	private SummaryDetail summaryDetail;
	private String link;
	private List<LinksItem> links;
	private List<SubArticlesItem> subArticles;
	private TitleDetail titleDetail;
	private String id;
	private String published;
	private Source source;
	private String title;
	private boolean guidislink;

	public String getSummary(){
		return summary;
	}

	public List<Integer> getPublishedParsed(){
		return publishedParsed;
	}

	public SummaryDetail getSummaryDetail(){
		return summaryDetail;
	}

	public String getLink(){
		return link;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public List<SubArticlesItem> getSubArticles(){
		return subArticles;
	}

	public TitleDetail getTitleDetail(){
		return titleDetail;
	}

	public String getId(){
		return id;
	}

	public String getPublished(){
		return published;
	}

	public Source getSource(){
		return source;
	}

	public String getTitle(){
		return title;
	}

	public boolean isGuidislink(){
		return guidislink;
	}
}
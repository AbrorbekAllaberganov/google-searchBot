package newsJson;

import java.util.List;

public class Feed{
	private PublisherDetail publisherDetail;
	private List<Integer> updatedParsed;
	private SubtitleDetail subtitleDetail;
	private String link;
	private String generator;
	private String language;
	private RightsDetail rightsDetail;
	private GeneratorDetail generatorDetail;
	private String title;
	private String rights;
	private String subtitle;
	private String publisher;
	private List<LinksItem> links;
	private TitleDetail titleDetail;
	private String updated;

	public PublisherDetail getPublisherDetail(){
		return publisherDetail;
	}

	public List<Integer> getUpdatedParsed(){
		return updatedParsed;
	}

	public SubtitleDetail getSubtitleDetail(){
		return subtitleDetail;
	}

	public String getLink(){
		return link;
	}

	public String getGenerator(){
		return generator;
	}

	public String getLanguage(){
		return language;
	}

	public RightsDetail getRightsDetail(){
		return rightsDetail;
	}

	public GeneratorDetail getGeneratorDetail(){
		return generatorDetail;
	}

	public String getTitle(){
		return title;
	}

	public String getRights(){
		return rights;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public String getPublisher(){
		return publisher;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public TitleDetail getTitleDetail(){
		return titleDetail;
	}

	public String getUpdated(){
		return updated;
	}
}
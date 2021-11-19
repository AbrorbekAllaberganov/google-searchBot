package imageJson;

import java.util.List;

public class ImageResponse{
	private List<ImageResultsItem> image_results;
	private double ts;

	public List<ImageResultsItem> getImageResults(){
		return image_results;
	}

	public double getTs(){
		return ts;
	}
}
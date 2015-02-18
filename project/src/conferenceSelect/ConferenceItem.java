package conferenceSelect;

import android.widget.ImageView;

public class ConferenceItem {
	
	 	private String label;
	    private String imageLink;
	 
	    public ConferenceItem(String label, String imageLink) {
	        super();
	        this.label = label;
	        this.imageLink = imageLink;
	    }

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getImageLink() {
			return imageLink;
		}

		public void setImageLink(String imageLink) {
			this.imageLink = imageLink;
		}
	     

}

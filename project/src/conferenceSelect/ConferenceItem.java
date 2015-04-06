package conferenceSelect;

import android.widget.ImageView;

public class ConferenceItem {
		
		private String id;
	 	public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		private String label;
	    private String imageLink;
	 
	    public ConferenceItem(String id, String label, String imageLink) {
	        super();
	        this.id = id;
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

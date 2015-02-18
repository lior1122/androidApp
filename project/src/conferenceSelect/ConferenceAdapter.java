package conferenceSelect;

import java.util.ArrayList;
import utils.ImageDownloaderTask;

import utils.Utils;

import com.example.project.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ConferenceAdapter extends ArrayAdapter<ConferenceItem> {
	
	 private  Context context;
     private  ArrayList<ConferenceItem> itemsArrayList;
     
     public ConferenceAdapter(Context context, ArrayList<ConferenceItem> itemsArrayList) {
    	 
         super(context, R.layout.conference_item, itemsArrayList);

         this.context = context;
         this.itemsArrayList = itemsArrayList;
     }
     
     @Override
     public View getView(int position, View convertView, ViewGroup parent) {

         // 1. Create inflater 
         LayoutInflater inflater = (LayoutInflater) context
             .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

         // 2. Get rowView from inflater
         View rowView = inflater.inflate(R.layout.conference_item, parent, false);

         
         TextView labelView = (TextView) rowView.findViewById(R.id.tvLabel);
         ImageView iconView = (ImageView) rowView.findViewById(R.id.ivIcon);
         iconView.getLayoutParams().height = 200;
         iconView.getLayoutParams().width = 200;
         
         

         labelView.setText(itemsArrayList.get(position).getLabel());
         new ImageDownloaderTask(iconView).execute(itemsArrayList.get(position).getImageLink());

         return rowView;
     }

}

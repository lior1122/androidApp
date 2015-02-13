package adapters;

import pages.Agenda;
import pages.Info;
import pages.People;
import pages.Sponsers;
import pages.Wall;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class ViewPagerAdapter extends FragmentPagerAdapter {
	 private Info info;
	 private Agenda agenda;
	 private People people;
	 private Wall wall;
	 private Sponsers sponsers;
 
	final int PAGE_COUNT = 5;
	// Tab Titles
	private String tabtitles[] = new String[] { "Info", "Agenda", "People","Wall","Sponsers" };
	Context context;
 
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		info = new Info();
		agenda = new Agenda();
		people = new People();
		wall = new Wall();
		sponsers = new Sponsers();
	}
 
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
 
	@Override
	public Fragment getItem(int position) {
		switch (position) {

		case 0:
			return info;
		case 1:
			return agenda;
		case 2:
			return people;
		case 3:
			return wall;
		case 4:
			return sponsers;
		
		}
		return null;
	}
 
	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}
}
package my.app.main.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import my.app.main.client.ClientFactory;
import my.app.main.client.activity.AddStudentActivity;
import my.app.main.client.activity.MainPageActivity;
import my.app.main.client.place.AddStudentPlace;
import my.app.main.client.place.MainPagePlace;

public class ContentActivityMaper extends AppActivityMapper {

	public ContentActivityMaper(ClientFactory clientFactory) {
		super(clientFactory);
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MainPagePlace) return new MainPageActivity((MainPagePlace) place, clientFactory);
		else if (place instanceof AddStudentPlace) return new AddStudentActivity((AddStudentPlace) place, clientFactory);
		return null;
	}

}

package my.app.main.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import my.app.main.client.ClientFactory;
import my.app.main.client.activity.LeftMenuActivity;

public class LeftMenuActivityMapper extends AppActivityMapper {

	public LeftMenuActivityMapper(ClientFactory clientFactory) {
		super(clientFactory);
	}
	
	@Override
	public Activity getActivity(Place place) {
		return new LeftMenuActivity(clientFactory);
	}

}

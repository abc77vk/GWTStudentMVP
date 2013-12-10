package my.app.login.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {
	void registration(String login, String password, String name, Integer age,AsyncCallback<Boolean> callback);
}

package my.app.login.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	public void doLogin(String login,String password,AsyncCallback<Boolean> callback);
}

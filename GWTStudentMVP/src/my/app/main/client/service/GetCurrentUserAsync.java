package my.app.main.client.service;

import my.app.main.client.entity.StudentInfo;
import my.app.main.server.entity.Mark;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetCurrentUserAsync {
	
	void getStudentInfo (AsyncCallback<StudentInfo> asyncCallback);
	void logout(AsyncCallback<Void> asyncCallback);
	void addMark(String name,int age,AsyncCallback<Void> asyncCallback);
}

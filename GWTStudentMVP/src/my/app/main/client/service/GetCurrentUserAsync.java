package my.app.main.client.service;

import my.app.main.client.entity.StudentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetCurrentUserAsync {
	
	void getStudentInfo (AsyncCallback<StudentInfo> asyncCallback);
}

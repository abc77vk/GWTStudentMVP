package my.app.main.client.service;

import java.util.List;

import my.app.main.client.entity.MarkInfo;
import my.app.main.client.entity.StudentInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetCurrentUserAsync {
	
	void getStudentInfo (AsyncCallback<StudentInfo> asyncCallback);
	void logout(AsyncCallback<Void> asyncCallback);
	void addMark(String name,int age,AsyncCallback<Void> asyncCallback);
	void getMarks(AsyncCallback<List<MarkInfo>> asyncCallback);
}

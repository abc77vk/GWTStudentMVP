/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package my.app.main.client.ui;

import my.app.main.client.entity.StudentInfo;
import my.app.main.client.place.AddStudentPlace;
import my.app.main.client.place.MainPagePlace;
import my.app.main.client.service.GetCurrentUser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Label;

/**
 * Sample implementation of {@link LeftMenu}.
 */
public class LeftMenuImpl extends Composite implements LeftMenu {

	interface Binder extends UiBinder<Widget, LeftMenuImpl> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);
	@UiField Button button;
	@UiField Label nameOut;
	@UiField Label ageOut;
	@UiField Button button_1;
	@UiField Button button_2;
	@UiField Button button_3;

	private Presenter listener;

	public LeftMenuImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
	
	public void setInfo(StudentInfo info) {
		if (info == null) {
			nameOut.setText("User not found!");
			ageOut.setText("");
		} else {
			nameOut.setText(info.getName());
			ageOut.setText(info.getAge());
		}
	}
	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		listener.goTo(new AddStudentPlace("add_new_mark"));
	}
	@UiHandler("button_1")
	void onButton_1Click(ClickEvent event) {
	}
	@UiHandler("button_2")
	void onButton_2Click(ClickEvent event) {
		listener.goTo(new MainPagePlace("main"));
	}
	@UiHandler("button_3")
	void onButton_3Click(ClickEvent event) {
		GetCurrentUser.Util.getInstance().logout(new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.Location.replace("/LoginViewer.html");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}
		});
	}
}

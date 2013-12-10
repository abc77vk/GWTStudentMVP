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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link MainPageView}.
 */
public class MainPageViewImpl extends Composite implements MainPageView {

	interface Binder extends UiBinder<Widget, MainPageViewImpl> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);
	@UiField HTMLPanel content;
	@UiField Label output;
	@UiField Anchor anchor;

	private Presenter listener;

	public MainPageViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}


	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}


	@Override
	public void setName(String helloName) {
		
	}


	@Override
	public void setUserInfo(StudentInfo info) {
		if (info == null) {
			output.setText("User not found!");
			return;
		}
		output.setText("Name: " + info.getName() + " age: " + info.getAge());
	}
	@UiHandler("anchor")
	void onAnchorClick(ClickEvent event) {
		Window.alert("TEST");
		listener.goTo(new AddStudentPlace("add_new_mark"));
	}
}

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;

/**
 * Sample implementation of {@link MainPageView}.
 */
public class MainPageViewImpl extends Composite implements MainPageView {

	interface Binder extends UiBinder<Widget, MainPageViewImpl> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);
	@UiField Label outLable;

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
			return;
		}
		
		outLable.setText("Name : " + info.getName() + "| Age : " + info.getAge()  );
	}
}

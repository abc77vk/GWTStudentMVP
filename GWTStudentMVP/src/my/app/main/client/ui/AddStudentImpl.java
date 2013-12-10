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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link AddStudent}.
 */
public class AddStudentImpl extends Composite implements AddStudent {

	interface Binder extends UiBinder<Widget, AddStudentImpl> {
	}

	private static final Binder binder = GWT.create(Binder.class);
	@UiField
	TextBox nameInput;
	@UiField
	IntegerBox markInput;
	@UiField
	Label output;
	@UiField
	Button button;

	private Presenter listener;

	public AddStudentImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		String name = nameInput.getText();
		String mark = markInput.getText();

		if (name.isEmpty() || mark.isEmpty()) {
			output.setText("Please, fill all filds.");
		}

		// if(!mark.matches("^(100)|(\\d{1,2})$")) {
		// output.setText("Mark is integer number in range [0,100]");
		// }


//			Integer intMark = Integer.parseInt(mark);
//			if (intMark < 0 || intMark > 100) {
//				output.setText("Mark is integer number in range [0,100]");
//			}
		
	}
}

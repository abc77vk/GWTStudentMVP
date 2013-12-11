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

import java.util.List;

import my.app.main.client.entity.MarkInfo;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Sample implementation of {@link ShowMarks}.
 */
public class ShowMarksImpl extends Composite implements ShowMarks {

	interface Binder extends UiBinder<Widget, ShowMarksImpl> {
	}

	private static final Binder binder = GWT.create(Binder.class);
	@UiField ListBox list;

	private Presenter listener;
	
	static class MyCell extends AbstractCell<MarkInfo> {

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context, MarkInfo value, SafeHtmlBuilder sb) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public ShowMarksImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	

	@Override
	public void setName(String name) {
	}
	

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}



	@Override
	public void addItem(List<MarkInfo> items) {
		list.clear();
		for(MarkInfo mark : items) {
			list.addItem(mark.getName() + " - " + mark.getMark());
		}
		
	}




}

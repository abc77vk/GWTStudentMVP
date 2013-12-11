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
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.DataGrid;

/**
 * Sample implementation of {@link ShowMarks}.
 */
public class ShowMarksImpl extends Composite implements ShowMarks {

	interface Binder extends UiBinder<Widget, ShowMarksImpl> {
	}

	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	@UiField(provided = true)
	DataGrid<Object> dataGrid = new DataGrid<Object>();

	public ShowMarksImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	protected void onLoad() {
		// Create a DataGrid.

	    /*
	     * Set a key provider that provides a unique key for each contact. If key is
	     * used to identify contacts when fields (such as the name and address)
	     * change.
	     */
	    dataGrid = new DataGrid<ContactInfo>(ContactDatabase.ContactInfo.KEY_PROVIDER);
	    dataGrid.setWidth("100%");

	    /*
	     * Do not refresh the headers every time the data is updated. The footer
	     * depends on the current data, so we do not disable auto refresh on the
	     * footer.
	     */
	    dataGrid.setAutoHeaderRefreshDisabled(true);

	    // Set the message to display when the table is empty.
	    dataGrid.setEmptyTableWidget(new Label(constants.cwDataGridEmpty()));

	    // Attach a column sort handler to the ListDataProvider to sort the list.
	    ListHandler<ContactInfo> sortHandler =
	        new ListHandler<ContactInfo>(ContactDatabase.get().getDataProvider().getList());
	    dataGrid.addColumnSortHandler(sortHandler);

	    // Create a Pager to control the table.
	    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	    pager.setDisplay(dataGrid);

	    // Add a selection model so we can select cells.
	    final SelectionModel<ContactInfo> selectionModel =
	        new MultiSelectionModel<ContactInfo>(ContactDatabase.ContactInfo.KEY_PROVIDER);
	    dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager
	        .<ContactInfo> createCheckboxManager());

	    // Initialize the columns.
	    initTableColumns(selectionModel, sortHandler);

	    // Add the CellList to the adapter in the database.
	    ContactDatabase.get().addDataDisplay(dataGrid);

	    // Create the UiBinder.
	    Binder uiBinder = GWT.create(Binder.class);
	    return uiBinder.createAndBindUi(this);
	}

	@Override
	public void setName(String name) {
		dataGrid.
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
}

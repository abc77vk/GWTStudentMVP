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
package my.app.main.client;

import my.app.main.client.ui.AddStudent;
import my.app.main.client.ui.AddStudentImpl;
import my.app.main.client.ui.LeftMenu;
import my.app.main.client.ui.LeftMenuImpl;
import my.app.main.client.ui.MainPageView;
import my.app.main.client.ui.MainPageViewImpl;
import my.app.main.client.ui.ShowMarks;
import my.app.main.client.ui.ShowMarksImpl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

/**
 * Sample implementation of {@link ClientFactory}.
 */
public class ClientFactoryImpl implements ClientFactory {
  
	private static final EventBus eventBus = new SimpleEventBus();
	@SuppressWarnings("deprecation")
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final MainPageView view = new MainPageViewImpl();
	private static final AddStudent ADD_STUDENT_VIEW = new AddStudentImpl();
	private static final LeftMenu LEFT_MENU_VIEW = new LeftMenuImpl();
	private static final ShowMarks SHOW_MARKS_VIEW = new ShowMarksImpl();
	
	

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public MainPageView getSampleView() {
		return view;
	}

	@Override
	public AddStudent getAddStudent() {
		return ADD_STUDENT_VIEW;
	}

	@Override
	public LeftMenu getLeftMenu() {
		return LEFT_MENU_VIEW;
	}

	@Override
	public ShowMarks getShowMarks() {
		return SHOW_MARKS_VIEW;
	}

}

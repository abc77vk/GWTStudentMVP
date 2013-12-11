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
package my.app.main.client.activity;

import java.util.List;

import my.app.main.client.ClientFactory;
import my.app.main.client.entity.MarkInfo;
import my.app.main.client.place.ShowMarksPlace;
import my.app.main.client.service.GetCurrentUser;
import my.app.main.client.ui.ShowMarks;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Activities are started and stopped by an ActivityManager associated with a container Widget.
 */
public class ShowMarksActivity extends AbstractActivity implements ShowMarks.Presenter {
	/**
	 * Used to obtain views, eventBus, placeController.
	 * Alternatively, could be injected via GIN.
	 */
	private ClientFactory clientFactory;

	/**
	 * Sample property.
	 */
	private String name;

	public ShowMarksActivity(ShowMarksPlace place, ClientFactory clientFactory) {
		this.name = place.getName();
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		final ShowMarks view = clientFactory.getShowMarks();
		view.setName(name);
		
		GetCurrentUser.Util.getInstance().getMarks(new AsyncCallback<List<MarkInfo>>() {
			
			@Override
			public void onSuccess(List<MarkInfo> result) {
				view.addItem(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
				
			}
		});
		
		view.setPresenter(this);
		containerWidget.setWidget(view.asWidget());
	}


	/**
	 * @see ShowMarks.Presenter#goTo(Place)
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}

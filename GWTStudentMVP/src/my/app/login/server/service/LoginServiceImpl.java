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
package my.app.login.server.service;

import my.app.login.client.service.LoginService;
import my.app.main.server.entity.Student;
import my.app.main.server.ofy.OfyService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	private static final long serialVersionUID = 1L;

	@Override
	public Boolean doLogin(String login, String password) {
		Student student = OfyService.ofy().query(Student.class).filter("login", login).filter("password", password)
				.get();
		if (student == null) {
			return false;
		}
		
		this.getThreadLocalRequest().getSession().setAttribute("user", student);
		
		
		return true;
	}
}

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
package my.app.main.server.service;

import my.app.main.client.entity.StudentInfo;
import my.app.main.client.service.GetCurrentUser;
import my.app.main.server.entity.Student;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GetCurrentUserImpl extends RemoteServiceServlet implements GetCurrentUser {

	private static final long serialVersionUID = 1L;

	@Override
	public StudentInfo getStudentInfo() {
		Student student = (Student) this.getThreadLocalRequest().getSession().getAttribute("user");
		if (student == null) return null;
		return student.getStudentInfo();
	}
}
package my.app.login.client.ui;

import my.app.login.client.service.LoginService;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginFormUiBinder uiBinder = GWT.create(LoginFormUiBinder.class);

	@UiField
	Grid loginTable;
	@UiField
	Label loginLable;
	@UiField
	TextBox loginInput;
	@UiField
	Label passwordLable;
	@UiField
	PasswordTextBox passwordInput;
	@UiField
	Button loginButton;
	@UiField
	Label output;
	@UiField
	Button registrationButton;

	interface LoginFormUiBinder extends UiBinder<Widget, LoginView> {
	}

	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public LoginView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("loginButton")
	void onLoginButtonClick(ClickEvent event) {
		String login = loginInput.getText();
		String password = passwordInput.getText();
		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			output.setText("Please, fill all fields.");
			return;
		}

		LoginService.Util.getInstance().doLogin(login, password, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					output.setText("Login ok!");
					Window.Location.replace("/MainPage.html");
				} else {
					output.setText("User not found!!!");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				output.setText(caught.getMessage());

			}
		});

	}

	@UiHandler("registrationButton")
	void onRegistrationButtonClick(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new RegistrationView());
	}

}

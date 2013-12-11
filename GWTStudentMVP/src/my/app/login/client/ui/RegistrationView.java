package my.app.login.client.ui;

import my.app.login.client.service.RegistrationService;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class RegistrationView extends Composite {

	private static RegistrationUiBinder uiBinder = GWT.create(RegistrationUiBinder.class);
	@UiField
	ListBox ageComboBox;
	@UiField
	TextBox inputLogin;
	@UiField
	PasswordTextBox inputPassword;
	@UiField
	TextBox inputName;
	@UiField Button okButton;
	@UiField Button noButton;
	@UiField Label output;
	

	interface RegistrationUiBinder extends UiBinder<Widget, RegistrationView> {
	}
	
	@Override
	protected void onLoad() {
		for (int i = 15; i < 25; i++) {
			ageComboBox.addItem(String.valueOf(i));
		}
		
	}

	public RegistrationView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public RegistrationView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("noButton")
	void onNoButtonClick(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new LoginView());
	}
	@UiHandler("okButton")
	void onOkButtonClick(ClickEvent event) {
		String login = inputLogin.getText();
		String password = inputPassword.getText();
		String name = inputName.getText();
		
		if(login.isEmpty() || password.isEmpty() || name.isEmpty()) {
			output.setText("You must fill all fields");
		}
		
		int selectedItemNumber = ageComboBox.getSelectedIndex();
		Integer age = Integer.parseInt(ageComboBox.getItemText(selectedItemNumber));
		
		RegistrationService.Util.getInstance().registration(login, password, name, age, new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					inputLogin.setText("");
					inputPassword.setText("");
					inputName.setText("");
					ageComboBox.setSelectedIndex(0);
					output.setText("User created successfully.");
				} else {
					output.setText("This login is already used.");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}
}

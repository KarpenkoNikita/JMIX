package com.company.project_duma.view.registration;



import com.company.project_duma.entity.User;
import com.company.project_duma.entity.JobTitle;

import com.company.project_duma.security.ProjectDumaSecurityConfiguration;
import com.company.project_duma.view.login.LoginView;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import io.jmix.core.Metadata;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.component.textfield.JmixPasswordField;
import io.jmix.flowui.component.textfield.TypedTextField;

import io.jmix.flowui.view.*;
import io.jmix.securityflowui.password.PasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@AnonymousAllowed
@Route(value = "registration")
@ViewController("RegistrationView")
@ViewDescriptor("registration-view.xml")
@EditedEntityContainer("userDc")
public class RegistrationView extends StandardView {

    @ViewComponent
    private JmixSelect<JobTitle> jobTitleField; // Изменение на Select для enum


    @ViewComponent
    private TypedTextField<String> firstNameField;
    @ViewComponent
    private TypedTextField<String> lastNameField;
    @ViewComponent
    private TypedTextField<String> surNameField;
    @ViewComponent
    private TypedTextField<String> usernameField;
    @ViewComponent
    private TypedTextField<String> emailField;
    @ViewComponent
    private JmixPasswordField passwordField;




    @Autowired
    private PasswordValidation passwordValidation;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ViewNavigators viewNavigators;
    @Autowired
    private ProjectDumaSecurityConfiguration ProjectDumaSecurityConfiguration;
    @Autowired
    private Metadata metadata;
    @Autowired
    private Notifications notifications;



    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        jobTitleField.setItems(JobTitle.values());





    }



    @Subscribe("registerBtn")
    public void onRegisterBtnClick(final ClickEvent<Button> event) {
        // Создание нового пользователя
        User user = metadata.create(User.class);

        // Заполнение полей пользователя
        user.setUsername(usernameField.getValue());
        user.setPassword(passwordEncoder.encode(passwordField.getValue()));
        user.setFirstName(firstNameField.getValue());
        user.setLastName(lastNameField.getValue());
        user.setSurName(surNameField.getValue());
        user.setEmail(emailField.getValue());

        // Установка значений для jobTitle, location и room
        user.setJobTitle(jobTitleField.getValue());


        // Валидация пароля
        List<String> errors = passwordValidation.validate(user, passwordField.getValue());
        if (!errors.isEmpty()) {
            notifications.create(String.join("\n", errors))
                    .withPosition(Notification.Position.BOTTOM_END)
                    .show();
        } else {
            // Регистрация нового пользователя
            ProjectDumaSecurityConfiguration.register(user);
            navigateToLoginView();
        }
    }

    @Subscribe("alreadyRegisteredBtn")
    public void onAlreadyRegisteredBtnClick(final ClickEvent<Button> event) {
        navigateToLoginView();
    }

    private void navigateToLoginView() {
        viewNavigators.view(this, LoginView.class).navigate();
    }
}
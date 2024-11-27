package com.company.project_duma.view.company;

import com.company.project_duma.entity.Company;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "companies/:id", layout = MainView.class)
@ViewController(id = "pd_Company.detail")
@ViewDescriptor(path = "company-detail-view.xml")
@EditedEntityContainer("companyDc")
public class CompanyDetailView extends StandardDetailView<Company> {
}
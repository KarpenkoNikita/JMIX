package com.company.project_duma.view.company;

import com.company.project_duma.entity.Company;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "companies", layout = MainView.class)
@ViewController(id = "pd_Company.list")
@ViewDescriptor(path = "company-list-view.xml")
@LookupComponent("companiesDataGrid")
@DialogMode(width = "64em")
public class CompanyListView extends StandardListView<Company> {
}
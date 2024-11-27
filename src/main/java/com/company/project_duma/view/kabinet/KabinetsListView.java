package com.company.project_duma.view.kabinet;

import com.company.project_duma.entity.Kabinet;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "kabinets", layout = MainView.class)
@ViewController(id = "pd_Kabinet.list")
@ViewDescriptor(path = "kabinets-list-view.xml")
@LookupComponent("kabinetsDataGrid")
@DialogMode(width = "64em")
public class KabinetsListView extends StandardListView<Kabinet> {
}
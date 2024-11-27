package com.company.project_duma.view.adress;

import com.company.project_duma.entity.Adress;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "adresses", layout = MainView.class)
@ViewController(id = "pd_Adress.list")
@ViewDescriptor(path = "adress-list-view.xml")
@LookupComponent("adressesDataGrid")
@DialogMode(width = "64em")
public class AdressListView extends StandardListView<Adress> {
}
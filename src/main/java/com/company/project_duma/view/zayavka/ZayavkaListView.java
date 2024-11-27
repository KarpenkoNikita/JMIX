package com.company.project_duma.view.zayavka;

import com.company.project_duma.entity.Zayavka;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "zayavkas", layout = MainView.class)
@ViewController(id = "pd_Zayavka.list")
@ViewDescriptor(path = "zayavka-list-view.xml")
@LookupComponent("zayavkasDataGrid")
@DialogMode(width = "64em")
public class ZayavkaListView extends StandardListView<Zayavka> {
}
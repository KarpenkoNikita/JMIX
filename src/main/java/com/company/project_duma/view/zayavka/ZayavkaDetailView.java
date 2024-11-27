package com.company.project_duma.view.zayavka;

import com.company.project_duma.entity.Zayavka;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "zayavkas/:id", layout = MainView.class)
@ViewController(id = "pd_Zayavka.detail")
@ViewDescriptor(path = "zayavka-detail-view.xml")
@EditedEntityContainer("zayavkaDc")
public class ZayavkaDetailView extends StandardDetailView<Zayavka> {
}
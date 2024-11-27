package com.company.project_duma.view.kabinet;

import com.company.project_duma.entity.Kabinet;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "kabinets/:id", layout = MainView.class)
@ViewController(id = "pd_Kabinet.detail")
@ViewDescriptor(path = "kabinets-detail-view.xml")
@EditedEntityContainer("kabinetDc")
public class KabinetsDetailView extends StandardDetailView<Kabinet> {
}
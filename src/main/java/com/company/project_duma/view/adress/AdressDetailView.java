package com.company.project_duma.view.adress;

import com.company.project_duma.entity.Adress;
import com.company.project_duma.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "adresses/:id", layout = MainView.class)
@ViewController(id = "pd_Adress.detail")
@ViewDescriptor(path = "adress-detail-view.xml")
@EditedEntityContainer("adressDc")
public class AdressDetailView extends StandardDetailView<Adress> {
}
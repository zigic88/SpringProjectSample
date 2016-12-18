/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.stmiktime.stea.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

/**
 *
 * @author zigic
 */
public class SteaNavigator extends Navigator {

    public SteaNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    public static SteaNavigator getNavigator() {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        return (SteaNavigator) navigator;
    }

    public static void navigate(String path) {
        try {
            SteaNavigator.getNavigator().navigateTo(path);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(Strings.nullToEmpty(viewName)); //To change body of generated methods, choose Tools | Templates.
    }    
    
}

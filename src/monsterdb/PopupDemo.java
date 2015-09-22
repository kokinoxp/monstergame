/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterdb;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author dev
 */
public class PopupDemo extends JPopupMenu {

    JMenuItem anItem;
    public PopupDemo(){
        anItem = new JMenuItem("Click Me!");
        add(anItem);
    }

}


package com.gestaovenda.modelo.util;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Luiz & Pedro
 */
public abstract class AbstractMouseListener implements MouseInputListener{

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void mouseDragged(MouseEvent me) {}

    @Override
    public void mouseMoved(MouseEvent me) {}
    
}

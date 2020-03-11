/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForClass;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Tang Seakmeng
 */
public class CenterScreenJFrame {
    public static void CenteredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2 - 10;
        objFrame.setLocation(iCoordX, iCoordY); 
    } 
}

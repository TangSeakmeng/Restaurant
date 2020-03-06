/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForComponent;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Nemesis
 */
public class JPictureBox extends JPanel{
    
    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return the Icon
     */
    public Icon getIcon() {
        return Icon;
    }
    
    public String getIconAbsolutePath(){
        if(Icon==null) 
            return "";
        
        ImageIcon ImageIcon=(ImageIcon)Icon;
        
        String absolutePath = ImageIcon.toString().replaceFirst("file:/", "");
        absolutePath = absolutePath.replaceAll("%20", " ");

        return absolutePath;
    }
    
    /**
     * @param Icon the Icon to set
     */
    public void setIcon(Icon Icon) {
        
        this.Icon = Icon;
        if(Icon!=null){
            ImageIcon ImageIcon=(ImageIcon)Icon;
            image=ImageIcon.getImage();
        }else{
            image=null;
        }
        
        this.repaint();
    }

    /**
     * @return the ImageIcon
     */
    

    /**
     * @return the ImageMode
     */
    public mode getImageMode() {
        return ImageMode;
    }

    /**
     * @param ImageMode the ImageMode to set
     */
    public void setImageMode(mode ImageMode) {
        this.ImageMode = ImageMode;
    }

    private mode ImageMode;
    private Icon Icon;

    /**
     * @return the ImageMode
     */
    
    
     private Image image;
    /**
     * @return the ImgURL
     */
    

    /**
     * @param ImgURL the ImgURL to set
     */
    
    String []imgExt={".jpg",".png",".ico",".jpeg"};
    
    public enum mode{
        Normal,Center,Autosize,Strech,Zoom;
    }

    ImageIcon i=new ImageIcon();
    ImageIcon nullImage=new ImageIcon();
    
    public JPictureBox() {
        javax.swing.border.Border border=BorderFactory.createLineBorder(Color.black, 1);
        super.setBorder(border);
    }
    
    public void paint(Graphics g) {
        super.paintComponent(g);
        
        if(getImage()==null){
            Color transparent=new Color(0,0,0,0);
            g.setColor(transparent);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            return;
        }

        int x=0,y=0;

        if(getImageMode()==mode.Strech){
            x=this.getWidth();
            y=this.getHeight();
            g.drawImage(getImage(),0,0, x,y, this);
        }else if(getImageMode()==mode.Autosize){
            x=getImage().getWidth(this);
            y=getImage().getHeight(this);
            this.setSize(new Dimension(x,y));
            g.drawImage(getImage(),0,0, x,y, this);
        }else if(getImageMode()==mode.Center){
            x=(getWidth()-getImage().getWidth(this))/2;
            y=(getHeight()-getImage().getHeight(this))/2;

            g.drawImage(getImage(), x,y, this);
        }else if(getImageMode()==mode.Zoom){
            Dimension imageDim=new Dimension(getImage().getWidth(this),getImage().getHeight(this));
            Dimension panelDim=new Dimension(this.getWidth(),this.getHeight());
            Dimension scaledDim=getScaledDimension(imageDim, panelDim);

            x=(getWidth()-scaledDim.width)/2;
            y=(getHeight()-scaledDim.height)/2;

            g.drawImage(getImage(), x,y,scaledDim.width,scaledDim.height, this);
        }
        
        else{
            g.drawImage(getImage(), 0,0, this);
        }
    }
    
    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }
            
        return new Dimension(new_width, new_height);
    }
}

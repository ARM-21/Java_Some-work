package com.utilities_for_coursework;

import javax.swing.*;
import java.awt.*;

public class UseButton extends JButton {
   public UseButton(String value){
       setText(value);
        setPreferredSize(new Dimension(120,20));
//        setBorder(BorderFactory.createLineBorder(Color.cyan));
        setBackground(new Color(0xf0f0f0));
        setFocusable(false);


    }
}

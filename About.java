package note_it;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
About(){
	setTitle("About Note It Down Application");
	setBounds(100,100,700,500);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLayout(null);
	
	ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("notepad.png"));
//	ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
    setIconImage(icon.getImage());
//
//
    JLabel iconLabel= new JLabel(new ImageIcon(ClassLoader.getSystemResource("windows.png")));
    iconLabel.setBounds(150, 40, 400, 100);
    add(iconLabel);

//	image of about
	JLabel l3= new JLabel("<html>Note It Down <br>Conventional Notepad Version 2.0<br>All rights reserved<br><br>Note It Down is a word processing program,<br> which allows changing of text in a computer file.<br>Note It Down is a simple text editor for basic text-editing<br>program which enables computer users to create documents");
	l3.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
	l3.setBounds(150,130,500,300);
	add(l3);
}
public static void main(String args[]) {
	new About().setVisible(true); 
}
}

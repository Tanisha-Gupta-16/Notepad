package note_it;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;

//import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  Notepad extends JFrame implements ActionListener {
	JMenuBar menuBar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help ");
	
	JMenuItem newFile=new JMenuItem("New");
	JMenuItem openFile=new JMenuItem("Open");
	JMenuItem saveFile=new JMenuItem("Save");
	JMenuItem printFile=new JMenuItem("Print");
	JMenuItem exitFile=new JMenuItem("Exit");
	
	JMenuItem cut=new JMenuItem("Cut");
	JMenuItem copy=new JMenuItem("Copy");
	JMenuItem paste=new JMenuItem("Paste");
	JMenuItem selectAll=new JMenuItem("Select All");
	
	JMenuItem about =new JMenuItem("About");
	
	
	
	JTextArea textArea=new JTextArea();
	
    Notepad(){
    	setTitle("Note IT Down");
    	setBounds(100,100,800,600);
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//    	ImageIcon icon = new ImageIcon(getClass().getResource();
    	ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("notepad.png"));
        setIconImage(icon.getImage());

    	 // ImageIcon icon =new ImageIcon(getClass().getResource())
    	setJMenuBar(menuBar);
    	menuBar.add(file);
    	menuBar.add(edit);
    	menuBar.add(help );
    	
    	file.add(newFile);
    	file.add(openFile);
    	file.add(saveFile);
    	file.add(printFile);
    	file.add(exitFile);
    	
    	edit.add(cut);
    	edit.add(copy);
    	edit.add(paste);
    	edit.add(selectAll);
    	
    	 help.add(about); 
    	
    	JScrollPane scrollpane =new JScrollPane(textArea);
    	add(scrollpane);
    	textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
    	scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    textArea.setLineWrap(true); 
    textArea.setWrapStyleWord(true);
    
    scrollpane.setBorder(BorderFactory.createEmptyBorder());
    
    newFile.addActionListener(this);
    openFile.addActionListener(this);
    saveFile.addActionListener(this);
    printFile.addActionListener(this);
    exitFile.addActionListener(this);
    cut.addActionListener(this);
    copy.addActionListener(this);
    paste.addActionListener(this);
    selectAll.addActionListener(this);
    about.addActionListener(this);
    
    newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK ));
    openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK ));
    saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK ));
    printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK ));
    exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W , KeyEvent.CTRL_DOWN_MASK ));
    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK ));
    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK ));
    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK ));
    selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK ));
    about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK ));
    }
    public static void main(String[] args) throws Exception{
    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	new Notepad().setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getActionCommand().equals("New")) {
			textArea.setText(null);
		 }else if(e.getActionCommand().equals("Save")) {
			 JFileChooser fileChooser =new JFileChooser();
			 FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			 fileChooser.setAcceptAllFileFilterUsed(false);
			 fileChooser.addChoosableFileFilter(textFilter);
			 int action=fileChooser.showSaveDialog(null);
			 if(action!=JFileChooser.APPROVE_OPTION) {
				 return;
			 }else {
				 String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
				 if(!fileName.contains(".txt")) {
					 fileName=fileName+".txt";
				 }
				 try {
					 BufferedWriter writer = new  BufferedWriter(new FileWriter(fileName));
					 textArea.write(writer);
				 }catch(IOException ex) {
					 ex.printStackTrace();
				 }
			 }
		
	}
		 else if(e.getActionCommand().equals("Open")) {
			 JFileChooser fileChooser =new JFileChooser();
			 FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
			 fileChooser.setAcceptAllFileFilterUsed(false);
			 fileChooser.addChoosableFileFilter(textFilter);
			 int action=fileChooser.showSaveDialog(null);
			 if(action!=JFileChooser.APPROVE_OPTION) {
				 return;
			 }else {
				 String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
				 if(!fileName.contains(".txt")) {
					 fileName=fileName+".txt";
				 }
				 try {
					 BufferedWriter writer = new  BufferedWriter(new FileWriter(fileName));
					 textArea.write(writer);
				 }catch(IOException ex) {
					 ex.printStackTrace();
				 }
			 }
		
	}
		 
		 else if(e.getActionCommand().equals("Print")) {
			 try {
				
				 textArea.print();
			 }catch(PrinterException ex) {
				 Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE,null,ex);
			 }
	}
		 else if(e.getActionCommand().equals("Exit")) {
				System.exit(0);
			}
		 else if(e.getActionCommand().equals("Cut")) {
				textArea.cut();
			}
		 else if(e.getActionCommand().equals("Copy")) {
				textArea.copy();
			}
		 else if(e.getActionCommand().equals("Paste")) {
			 textArea.paste();
			}
		 else if(e.getActionCommand().equals("Select All")) {
				textArea.selectAll();
			}
		 else if(e.getActionCommand().equals("About")) {
				new About().setVisible(true);
			}
//		 
}}
 
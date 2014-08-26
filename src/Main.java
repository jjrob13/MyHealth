
import java.util.ArrayList;

import graphGenerators.MyHealthGraphs;

import javax.swing.ImageIcon;
import javax.swing.JFrame;





import Control.AccountControl;
import GUI.MainGUI;
import GUI.MyHealthRemake;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;


public class Main {

	public static void main(String[] args) 
	{		
		
		JFrame frame = new JFrame("MyHealth");
		frame.setResizable(false);
		ImageIcon heart = new ImageIcon(Main.class.getResource("/GUI/myHealthIcon.png"));
		frame.setIconImage(heart.getImage());
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/GUI/myHealthIcon.png")));
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(new MainGUI());
		//AccountControl account = new AccountControl();
		//account.retrieveFromDataBase("jjrob13");
		//MyHealthGraphs graphs = new MyHealthGraphs(account);
		//frame.getContentPane().add(graphs.getAllGraphs());
		
		frame.setSize(630, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setVisible(true);
		//frame.setResizable(false);

	}
	
	public static void print(Object ob){
		System.out.println(ob);
	}

}

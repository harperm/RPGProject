import javax.swing.*;

import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class Screen extends JFrame implements ActionListener
{
	JFrame f = new JFrame();
	JPanel map = new JPanel();
	JPanel gui = new JPanel(new BorderLayout(3,3));
	
	Color black = Color.BLACK;
	Color gray = Color.GRAY;
	Color white = Color.WHITE;
	Color green = Color.GREEN;
	Color blue = Color.BLUE;
	Color red = Color.RED;
	Color yellow = Color.YELLOW;
	Color orange = Color.ORANGE;
	
	//JPanel p1 = new JPanel();
	//JPanel p2 = new JPanel();
	//JPanel p3 = new JPanel();
	//JLabel l1 = new JLabel("Count: 0");
	
	public Screen(Character player, Map map)
	{
		init();
		//gui();
		//System.out.println(map.printMap(player));
		//l1.setText(map.printMap(player));
	}
	
	public void init()
	{
		f.setSize(800, 600);
		Container pane = f.getContentPane();
		pane.setLayout(new GridLayout(8,8));
		Color temp;
		
		for(int i=0;i<8;i++){
			if(i%2==0){
				temp = gray;
			}else{
				temp = green;
			}
			
			for(int j=0;j<8;j++){
				JPanel panel = new JPanel();
				panel.setBackground(temp);
				if(temp.equals(gray)){
					temp = green;
				}else{
					temp = gray;
				}
				pane.add(panel);
			}
		}
		
		/*
		JButton bCount = new JButton("");
		bCount.addActionListener(this);
		JPanel button = new JPanel();
		button.setBorder(new EmptyBorder(10,10,10,10));
		button.add(bCount);
		map.add(button, BorderLayout.SOUTH);
		*/
		f.setResizable(false);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Count")){
			//f.setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{
		Map test = new Map(7,5);
		Character player = new Character("test","warrior");
		new Screen(player,test);
	}
}

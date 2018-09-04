package de.tj.jgdlib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JGDWindow extends JFrame{
	
	private JPanel container;
	
	public JGDWindow() {
		container = new JPanel();
		container.setBounds(0, 0, 600, 400);
		container.setBackground(Color.WHITE);
		container.setLayout(null);
		setContentPane(container);
	}
	
	public void run() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(container.getBounds());
		setLocationRelativeTo(null);
		setTitle("JGDFrame");
		setResizable(false);
		
		//setVisible(true);
	}
	
	public JPanel getContainer() {
		return container;
	}
	
	public void size(int w, int h) {
		setSize(w, h);
		container.setBounds(0, 0, w, h);
	}
	
	public void shell(JGDShell shell) {
		setUndecorated(true);
		Color back = new Color(0, 0, 0, 0);
		setBackground(Color.BLACK);
		setBackground(back);
		JPanel shellBACK = new JPanel() {
			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D)g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				shell.drawShell(g2d, new Rectangle(0, 0, getWidth(), getHeight()));
			}
		};
		shellBACK.setBounds(0, 0, getWidth(), getHeight());
		container.add(shellBACK);
	}

}

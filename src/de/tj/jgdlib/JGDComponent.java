package de.tj.jgdlib;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public abstract class JGDComponent {
	
	private long updateRate;
	private JPanel container;
	private JPanel canvas;
	
	public int width, height, x, y, containerW, containerH;
	
	private Timer updateTimer;
	
	private JGDEvent event;
	
	private String currentEvent = "NULL";
	
	private JGDComponent instance;
	
	public JGDComponent(JPanel container, long updateRate) {
		instance = this;
		
		this.updateRate = updateRate;
		this.container = container;
		containerW = this.container.getWidth();
		containerH = this.container.getHeight();
		
		x = bounds().x;
		y = bounds().y;
		width = bounds().width;
		height = bounds().height;
		
		event = new JGDEvent();
		
		init();
		startUpdateTimer();
		eventlistener();
	}
	
	public abstract void drawComponent(Graphics2D g);
	public abstract boolean onEvent();
	public abstract void onUpdate();
	public abstract Rectangle bounds();
	
	private void init() {
		canvas = new Panel(){
			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D)g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				drawComponent(g2d);
			}
		};
		canvas.setBounds(0, 0, containerW, containerH);
		canvas.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if(inBounds()) {
		    		
		    	}
		    }
		});
		container.add(canvas);
	}
	
	private void refresh() {
		canvas.repaint();
	}
	
	private void event(String id, JGDComponent comp) {
		event.callEvent(id, comp);
		refresh();
	}
	
	public boolean isCurrentEvent(String id) {
		if(currentEvent.equalsIgnoreCase(id)) {
			return true;
		}
		return false;
	}
	
	private void startUpdateTimer() {
		updateTimer = new Timer();
		updateTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				onUpdate();
				refresh();
			}
		}, 0, updateRate);
	}
	
	private void eventlistener() {
		Timer eventtimer = new Timer();
		eventtimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(inBounds()) {
					event("HOVER_IN", instance);	
				}
				if(outBounds()) {
					event("HOVER_OUT", instance);
				}
			}
		}, 0, 100);
	}
	
	private class Panel extends JPanel implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
		
	}
	
	private boolean inBounds() {
		try {
			if(container.getMousePosition().x > x && container.getMousePosition().x < x+width) {
				if(container.getMousePosition().y > y && container.getMousePosition().y < y+height) {
					return true;
				}
			}
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	private boolean outBounds() {
		try {
			if((container.getMousePosition().x < x || container.getMousePosition().x > x+width) || (container.getMousePosition().y < y || container.getMousePosition().y > y+height)) {
				return true;
			}
			return false;
		}catch (Exception e) {
			return false;
		}
	}

	public void setCurrentEvent(String currentEvent) {
		this.currentEvent = currentEvent;
	}

}


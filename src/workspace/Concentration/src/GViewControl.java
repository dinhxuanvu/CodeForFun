/**
 * GViewControl.java
 *
 * File:
 *	$Id$
 *
 * Revisions:
 *	$Log$
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class GViewControl extends JFrame implements Observer
{
	public static int numMoves = 0;
	private JLabel topLabel;
	private ConcentrationModel model;
	private ArrayList<CardButton> buttons;
	
	private JButton resetButton;
	private JButton cheatButton;
	private JButton undoButton;
	
	private ButtonListener buttonListener;
	
	public GViewControl(ConcentrationModel model)
	{
		this.model = model;
		
		BorderLayout mainLayout = new BorderLayout();
		JPanel centerPanel = new JPanel();
		GridLayout center = new GridLayout(model.BOARD_SIZE,model.BOARD_SIZE,3,3);
		JPanel botPanel = new JPanel();
		GridLayout bottom = new GridLayout(1,5,25,25);
		botPanel.setLayout(bottom);		
		getContentPane().setLayout(mainLayout);

		
		buttonListener = new ButtonListener();
		buttons = new ArrayList<CardButton>();
		for (int i = 0; i<model.BOARD_SIZE*model.BOARD_SIZE;i++)
		{
			CardButton tmp = new CardButton(i);
			tmp.addActionListener(buttonListener);
			buttons.add(tmp);
		}
		
		for (CardButton c : buttons)
		{
			centerPanel.add(c);
		}
		
		JButton blankButton = new JButton("");
		JButton blank2Button = new JButton("");
		
		botPanel.add(blankButton);
		botPanel.add(blank2Button);
		blankButton.setVisible(false);
		blank2Button.setVisible(false);
		
		resetButton = new JButton("Reset");
		cheatButton = new JButton("Cheat");
		undoButton = new JButton("Undo");
		
		resetButton.addActionListener(buttonListener);
		cheatButton.addActionListener(buttonListener);
		undoButton.addActionListener(buttonListener);
		
		botPanel.add(resetButton);
		botPanel.add(cheatButton);
		botPanel.add(undoButton);
		centerPanel.setLayout(center);
		
		topLabel = new JLabel("Moves: " + numMoves + " Select the first card.");
		
		add(topLabel, BorderLayout.NORTH);
		add(botPanel, BorderLayout.SOUTH);
		add(centerPanel, BorderLayout.CENTER);
		
		setTitle("Concentration Game");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}
	
	public void update(Observable t, Object o)
	{
		
	}
	
	public int getWSize()
	{
		return (int)((this.getSize().height + this.getSize().width)/2);
	}
	
	class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
        	
            if (event.getSource().equals(cheatButton)) 
            {
                CheatFrame cframe = new CheatFrame(buttons, (int)(getWSize() *.75));
            }
            else if (event.getSource().equals(resetButton)) 
            {

            }
            else if (event.getSource().equals(undoButton))
            {
            	
            }
            else
            {
            	JButton source;
            	for (CardButton c : buttons)
            	{
            		if (event.getSource().equals(c))
            		{
            			source = c;
            		}
            	}
            	
            }
        }
    }
	
	public static void main(String[] args)
	{
		GViewControl con = new GViewControl(new ConcentrationModel());
	}
}
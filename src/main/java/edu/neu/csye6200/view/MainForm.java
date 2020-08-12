package edu.neu.csye6200.view;

import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;

import javax.swing.*;

public class MainForm {
	public JPanel panel;
	private JXTaskPaneContainer taskPaneContainer;
	public JXTaskPane systemAdminPanel;
	private JPanel splitTargetPanel;
	private JScrollPane splitNavigationPane;

	public static void main(String[] args) {
		JFrame frame = new JFrame("MainForm");
		frame.setContentPane(new MainForm().panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private void createUIComponents() {
//		systemAdminPanel.add(new AbstractAction() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//
//			{
//				putValue("text","task pane item 2 : an action");
//			}
//		});
	}
}

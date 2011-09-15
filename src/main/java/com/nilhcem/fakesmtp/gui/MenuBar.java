package com.nilhcem.fakesmtp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public final class MenuBar extends Observable {
	private final JMenuBar menuBar = new JMenuBar();

	public MenuBar() {
		menuBar.add(createFileMenu());
		menuBar.add(createEditMenu());
		menuBar.add(createHelpMenu());
	}

	public JMenuBar get() {
		return menuBar;
	}

	// creates the file menu
	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(exit);
		return fileMenu;
	}

	// creates the edit menu
	private JMenu createEditMenu() {
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');

		JMenuItem mailsLocation = new JMenuItem("Messages location");
		mailsLocation.setMnemonic('l');
		mailsLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged();
				notifyObservers();
			}
		});

		editMenu.add(mailsLocation);
		return editMenu;
	}

	// creates the help menu
	private JMenu createHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');

		JMenuItem about = new JMenuItem("About");
		about.setMnemonic('A');
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuBar.getParent(),
					String.format("Fake SMTP Server v1.0%nhttps://github.com/nilhcem"),
					"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		helpMenu.add(about);
		return helpMenu;
	}
}

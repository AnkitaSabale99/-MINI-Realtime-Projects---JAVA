
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Another name for a commputer chip?");
			radioButton[0].setText("Wxecutr");
			radioButton[1].setText("Micro chip");
			radioButton[2].setText("Splitter");
			radioButton[3].setText("select");
		}
		if (current == 1) {
			label.setText("Que2: Examples of System program includes  ");
			radioButton[0].setText("operating system");
			radioButton[1].setText("trace program");
			radioButton[2].setText("compiler");
			radioButton[3].setText("All of above");
		}
		if (current == 2) {
			label.setText("Que3: A program in execution is called");
			radioButton[0].setText("Process");
			radioButton[1].setText("instruction");
			radioButton[2].setText("procedure");
			radioButton[3].setText("algorithm");
		}
		if (current == 3) {
			label.setText("Que4: Macro processor is inbuilt function of?");
			radioButton[0].setText("Assembler");
			radioButton[1].setText("Loader");
			radioButton[2].setText("Linker");
			radioButton[3].setText("Editor");
		}
		if (current == 4) {
			label.setText("Que5:  Which bus is biderectional?");
			radioButton[0].setText(" data bus");
			radioButton[1].setText("control bus");
			radioButton[2].setText("Address bus");
			radioButton[3].setText("multiplexed bus");
		}
		if (current == 5) {
			label.setText("Que6: RAM is also called ");
			radioButton[0].setText("volatile memory");
			radioButton[1].setText("virtual memory");
			radioButton[2].setText("non volatile memory");
			radioButton[3].setText("cache memory");
		}
		if (current == 6) {
			label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 7) {
			label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
			radioButton[0].setText("Configuration");
			radioButton[1].setText("Criteria");
			radioButton[2].setText("SessionManagement");
			radioButton[3].setText("Session");
		}
		if (current == 8) {
			label.setText("Que9: SessionFactory is a thread-safe object.");
			radioButton[0].setText("true");
			radioButton[1].setText("false");
			radioButton[2].setText("don't know");
			radioButton[3].setText("false");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radioButton[0].setText("Attached()");
			radioButton[1].setText("Detached()");
			radioButton[2].setText("Persistent()");
			radioButton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}


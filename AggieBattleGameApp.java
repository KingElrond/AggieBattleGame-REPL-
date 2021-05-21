import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AggieBattleGameApp {
	
	private JFrame frame;
	private Creature[] agg;
	private Creature a1,a2,a3,a4,a5,a6,a7,a8;
	private String[] aggStr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AggieBattleGameApp window = new AggieBattleGameApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AggieBattleGameApp() {
		createAGGarr();
		initialize();
	}
	
	public void createAGGarr() {
		agg = new Creature[8];
	     a1 = new MedinaSaur();  
	     a2 = new Ghoully();
	     a3 = new CharChimp();
	     a4 = new DreamReaper();
	     a5 = new Aquados();
	     a6 = new Finality();
	     a7 = new Iceguin();
	     a8 = new Memorra();
	     aggStr = new String[8];
	     agg[0]=a1;
	     agg[1]=a2;
	     agg[2]=a3;
	     agg[3]=a4;
	     agg[4]=a5;
	     agg[5]=a6;
	     agg[6]=a7;
	     agg[7]=a8;
	     int c = 0;
	     for(Creature tempCreat : agg)
	     {
	    	 aggStr[c] = tempCreat.getName();
	    	 c++;
	     }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 969, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(12dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(329dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("AGGIE BATTLE GAME HD");
		frame.getContentPane().add(lblNewLabel, "4, 2, 1, 6");
		
		JLabel lblNewLabel_1 = new JLabel("Player 1");
		frame.getContentPane().add(lblNewLabel_1, "2, 8");
		
		JLabel lblNewLabel_2 = new JLabel("Player 2");
		frame.getContentPane().add(lblNewLabel_2, "6, 8");
		
		JComboBox comboBox = new JComboBox(aggStr);
		frame.getContentPane().add(comboBox, "2, 10, fill, default");
		
		JComboBox comboBox_1 = new JComboBox(aggStr);
		frame.getContentPane().add(comboBox_1, "6, 10, fill, default");
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "4, 12");
		
	}

}

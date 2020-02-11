
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UpdateFrame extends JFrame implements ActionListener, ItemListener{
	JFrame j1 = new JFrame("Book Update");
	frame m = new frame();
	Container con;
	JTextField text1,credit, ep, mp, hp;
	JTextArea area1, area2;
	JPanel p1,p2,p3,p4,p4_1,p4_2,p4_3,p4_4,p4_5,p4_6,p5,p5_1,p5_2,p5_3,p5_4,p5_5,p5_6,p6,p6_1,p6_2,p6_3,p6_4,p7,p8, p8_1,p9,p10, layout1,layout2,layout3, layout4,layout5;
	JList list1;
	JComboBox bookname, booktype;
	Vector type,bookList, num;
	JScrollPane scroll1, scroll2;
	JCheckBox ck1,ck2,ck3;
	JLabel label1,label2,label3,card, eprice, mprice, hprice;
	JButton bt1, bt2, bt3, bt4, bt5, updatebt;
	JButton btarr[] = new JButton[10];
	JToggleButton tgb1;
	DecimalFormat twoDecimal = new DecimalFormat("0.00");
	JMenuBar mb;
	JMenu bookmenu;
	JMenuItem fulllist, clear;
	public	void createscreen(){
		//Construct First Panel
		
		mb = new JMenuBar();
		bookmenu = new JMenu("Book List");
		fulllist = new JMenuItem("fulllist");
		fulllist.addActionListener(this);
		fulllist.setMnemonic('F');
		clear = new JMenuItem("clear");
		clear.addActionListener(this);
		clear.setMnemonic('C');
		bookmenu.add(fulllist);
		bookmenu.add(clear);
		mb.add(bookmenu);
		setJMenuBar(mb);

		p1 = new JPanel();
		num = new Vector();
		m.bl.createList();
		bookList = new Vector();
		for(int i=0; i < m.bl.bkList.length;i++) {
			bookList.add(m.bl.bkList[i].getStrBookTitle());
	
		}
		bookname = new JComboBox(bookList);
		bookname.addItemListener(this);
		p1.add(bookname);
		
		//Construct Second Panel
		p2 = new JPanel();
		type = new Vector();
		type.add("Adventure");
		type.add("Horror");
		type.add("Romance");
		type.add("Sci-Fi");
		booktype = new JComboBox(type);
		
		
		p2.setBorder(new TitledBorder("Cureent(change to) Book Type"));
		p2.add(booktype);
		
		  
		//Construct Third Panel
		p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.setBorder(new TitledBorder("Add Stoy Summary"));
		area1 = new JTextArea();
		scroll1 = new JScrollPane(area1);
		p3.add(scroll1);
		
		//Construct Fourth Panel
		p4 = new JPanel();
		p4.setBorder(new TitledBorder("Book Formats Available"));
		p4.setLayout(new GridLayout(3,2));
		p4_1 = new JPanel();
		p4_1.setLayout(new BorderLayout());
		ck1 = new JCheckBox("ePub");
		ck1.addItemListener(this);
		p4_1.add(ck1);
		
		p4_2 = new JPanel();
		p4_2.setLayout(new BorderLayout());
		ck2 = new JCheckBox("mobi");
		ck2.addItemListener(this);
		p4_2.add(ck2);
		p4_3 = new JPanel();
		p4_3.setLayout(new BorderLayout());
		ck3 = new JCheckBox("Hard Copy");
		p4_3.add(ck3);
		ck3.addItemListener(this);
		p4_4 = new JPanel();
		p4_5 = new JPanel();
		p4_6 = new JPanel();
		p4.add(p4_1);
		p4.add(p4_4);
		p4.add(p4_2);
		p4.add(p4_5);
		p4.add(p4_3);
		p4.add(p4_6);
		
		//5th Column Structure
		p5 = new JPanel();
		p5_1 = new JPanel();
		p5_2 = new JPanel();
		p5_3 = new JPanel();
		p5_4 = new JPanel();
		p5_5 = new JPanel();
		p5_6 = new JPanel();
		p5.setBorder(new TitledBorder("Price"));
		p5.setLayout(new GridLayout(3,2));
		
		
		
		p5_1.setLayout(new BorderLayout());
		p5_2.setLayout(new BorderLayout());
		p5_3.setLayout(new BorderLayout());
		p5_4.setLayout(new BorderLayout());
		p5_5.setLayout(new BorderLayout());
		p5_6.setLayout(new BorderLayout());
		eprice = new JLabel("ePub Price:");
		p5_1.add(eprice, BorderLayout.EAST);
		ep = new JTextField();
		p5_2.add(ep);
		ep.setBackground(Color.green);
		mprice = new JLabel("Mobi Price:");
		p5_3.add(mprice, BorderLayout.EAST);
		mp = new JTextField();
		mp.setBackground(Color.yellow);
		p5_4.add(mp);
		
		hprice = new JLabel("HardCopy Price:");
		p5_5.add(hprice, BorderLayout.EAST);
		hp = new JTextField();
		p5_6.add(hp);
		
		p5.add(p5_1);
		p5.add(p5_2);
		p5.add(p5_3);
		p5.add(p5_4);
		p5.add(p5_5);
		p5.add(p5_5);
		p5.add(p5_6);
		//6th Column structure
		
		p6 = new JPanel();
		p6.setLayout(new BorderLayout());
		updatebt = new JButton("Update All");
		p6.add(updatebt);
		updatebt.addActionListener(this);
		
		
		//7th Column Structure
		
		p7 = new JPanel();
		p7.setLayout(new BorderLayout());
		area2 = new JTextArea();
		scroll2 = new JScrollPane(area2);
				
		area2.setBackground(Color.ORANGE);
		p7.add(scroll2);
		
		
		
		//8th Colum Structure
		
		
		layout1 = new JPanel();
		layout1.setLayout(new GridLayout(1,3));
		layout1.add(p1);
		layout1.add(p2);
		layout1.add(p3);
		layout2 = new JPanel();
		layout2.setLayout(new GridLayout(1,2));
		layout2.add(p4);
		layout2.add(p5);
		layout3 = new JPanel();
		layout3.setLayout(new GridLayout(1,2));
		layout3.add(p6);
		layout3.add(p7);
		layout4 = new JPanel();
		layout4.setLayout(new GridLayout(3,1));
		layout4.add(layout1);
		layout4.add(layout2);
		layout4.add(layout3);
		
		con = getContentPane();
		con.add(layout4);
		
		if(bookname.getSelectedIndex() !=-1) {
			
			
				area1.setText(m.bl.bkList[bookname.getSelectedIndex()].getStrBookComment());
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(0)) {
					ck1.setSelected(true);
				}
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(1)) {
					ck2.setSelected(true);
				}
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(2)) {
					ck3.setSelected(true);
				}
				
				ep.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(0)));
				
				mp.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(1)));
				hp.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(2)));
				}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			if(e.getSource() == fulllist) {
				String ep="", mp="", hp="", text ="";
				for(int i = 0; i <m.bl.bkList.length;i++) {
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(0)) {
					ep ="ePub";
				}
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(1)) {
					mp ="mobi";
				}
				if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(2)) {
					hp ="Hard Copy";
				}
				
				text += m.bl.bkList[i].getStrBookTitle() + "\\" + ep + " \\" + mp + " \\" +  hp +" \\" +m.bl.bkList[i].getChBookType() +"\n";
						
				}
				area2.setText(text);
					
			}else if(e.getSource() == clear) {
				
				area2.setText("");
			}
		}else if(e.getSource() == updatebt) {
			if(booktype.getSelectedIndex() ==0) {
				m.bl.bkList[bookname.getSelectedIndex()].setChBookType('a');
			}else if(booktype.getSelectedIndex() ==1) {
				m.bl.bkList[bookname.getSelectedIndex()].setChBookType('h');
			}else if(booktype.getSelectedIndex() ==2) {
				m.bl.bkList[bookname.getSelectedIndex()].setChBookType('r');
			}else if(booktype.getSelectedIndex() ==3) {
				m.bl.bkList[bookname.getSelectedIndex()].setChBookType('s');
			}
			
			m.bl.bkList[bookname.getSelectedIndex()].setStrBookComment(area1.getText());
			if(ck1.isSelected()) {
			m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(0, true);
			}else {
				m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(0, false);
			}if(ck2.isSelected()) {
				m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(1, true);
				}else {
					m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(1, false);
			}
			if(ck3.isSelected()) {
				m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(2, true);
				}else {
					m.bl.bkList[bookname.getSelectedIndex()].setBoolBookFormatAvail(2, false);
				}
			m.bl.bkList[bookname.getSelectedIndex()].setDoubBookPrice(0, Double.parseDouble(ep.getText()));
			m.bl.bkList[bookname.getSelectedIndex()].setDoubBookPrice(1, Double.parseDouble(mp.getText()));
			m.bl.bkList[bookname.getSelectedIndex()].setDoubBookPrice(2, Double.parseDouble(hp.getText()));
			JOptionPane.showMessageDialog(this, "Update Complete", "Confirmation", JOptionPane.INFORMATION_MESSAGE );
		}
		
	}@Override
	public void itemStateChanged(ItemEvent e)  {
			if(m.bl.bkList[bookname.getSelectedIndex()].getChBookType() =='a') {
				booktype.setSelectedIndex(0);
			}else if(m.bl.bkList[bookname.getSelectedIndex()].getChBookType() =='h') {
				booktype.setSelectedIndex(1);
			}else if(m.bl.bkList[bookname.getSelectedIndex()].getChBookType() =='r') {
				booktype.setSelectedIndex(2);
			}else if(m.bl.bkList[bookname.getSelectedIndex()].getChBookType() =='s') {
				booktype.setSelectedIndex(3);
			}
			if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(0)) {
				ck1.setSelected(true);
			}else {
				ck1.setSelected(false);
			}
			if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(1)) {
				ck2.setSelected(true);
			}else {
				ck2.setSelected(false);
			}
			if(m.bl.bkList[bookname.getSelectedIndex()].getBoolBookFormatAvail(2)) {
				ck3.setSelected(true);
			}else {
				ck3.setSelected(false);
			}
			area1.setText(m.bl.bkList[bookname.getSelectedIndex()].getStrBookComment());
			ep.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(0)));
			
			mp.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(1)));
			hp.setText(String.valueOf(m.bl.bkList[bookname.getSelectedIndex()].getDoubBookPrice(2)));
		}
		
		
	
	


}

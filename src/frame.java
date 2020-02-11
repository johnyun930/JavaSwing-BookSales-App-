
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class frame extends JFrame implements ActionListener, ItemListener, ListSelectionListener, MouseListener {
	
	Container con;
	JTextField text1;
	JPanel p1,p2,p3,p4,p4_1,p4_2,p4_3,p4_4,p4_5,p4_6,p5,p6,p6_1,p6_2,p6_3,p6_4,p7,p8, p8_1,p9,p10, layout1,layout2,layout3, layout4,layout5;
	JList list1, list2;
	JComboBox combo1, combo2;
	Vector  type,bookList, explain, title,imagelist, copy, pay;
	JScrollPane scroll1, scroll2, scroll3;
	JRadioButton rd1,rd2,rd3;
	JLabel label1,label2,label3,card,label4;
	JButton bt1, bt2, bt3, bt4, bt5;
	JButton btarr[] = new JButton[10];
	ImageIcon lab2;
	double price;
	ImageIcon lab3 = new ImageIcon();
	JToggleButton tgb1;
	BookInfo[] info;
	boolean repeat;
	BookList bl = new BookList();
	String book, bookcover, msg;
	String password = "1234";
	DecimalFormat twoDecimal = new DecimalFormat("0.00");
	Vector<Double> check;
	Vector<Integer> num;
	JPasswordField pwt, credit;
	ButtonGroup btype;
	
	UpdateFrame upt;
	
	public	void createscreen(){
		//Construct First Panel
		
		p1 = new JPanel();
		check = new Vector();
		type = new Vector();
		type.add("Please Select type of Book");
		type.add("All Types");
		type.add("Adventure");
		type.add("Horror");
		type.add("Romance");
		type.add("Sci-Fi");
		combo1 = new JComboBox(type);
		combo1.addItemListener(this);
		p1.add(combo1);
		
		
		//Construct Second Panel
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		title = new Vector();
		list1 = new JList(title);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list1.addListSelectionListener(this);
		scroll3 = new JScrollPane(list1);
		p2.setBorder(new TitledBorder("Book Titles Available"));
		p2.add(scroll3);
		
		  
		//Construct Third Panel
		p3 = new JPanel();
	
		p3.setLayout(new BorderLayout());
		p3.setBorder(new TitledBorder("Cover/Story Summary"));
		label1 = new JLabel();
		label1.setOpaque(true);
		label1.addMouseListener(this);
		label1.setBackground(Color.yellow);
		scroll1 = new JScrollPane(label1);
	
		
		p3.add(scroll1);
		
		//Construct Fourth Panel
		p4 = new JPanel();
		p4.setBorder(new TitledBorder("Format/Price"));
		p4.setLayout(new GridLayout(3,2));
		p4_1 = new JPanel();
		p4_1.setLayout(new BorderLayout());
		rd1 = new JRadioButton("ePub", false);
		p4_1.add(rd1);
		p4_2 = new JPanel();
		p4_2.setLayout(new BorderLayout());
		rd2 = new JRadioButton("mobi", false);
		p4_2.add(rd2);
		p4_3 = new JPanel();
		p4_3.setLayout(new BorderLayout());
		rd3 = new JRadioButton("Hard Copy", false);
		p4_3.add(rd3);
		p4_4 = new JPanel();
		p4_4.setLayout(new BorderLayout());
		p4_5 = new JPanel();
		p4_5.setLayout(new BorderLayout());
		p4_6 = new JPanel();
		p4_6.setLayout(new BorderLayout());
		 btype = new ButtonGroup();
		btype.add(rd1);
		btype.add(rd2);
		btype.add(rd3);
		rd1.setEnabled(false);
		rd2.setEnabled(false);
		rd3.setEnabled(false);
		
		rd1.addItemListener(this);
		rd2.addItemListener(this);
		rd3.addItemListener(this);
		//rd1.add
		copy= new Vector();
		for(int k = 1; k<=5; k++){
			copy.add(k + "copy(copies");
		}
		combo2 = new JComboBox(copy);
		
		combo2.setEnabled(false);
		p4_6.add(combo2);
		p4.add(p4_1);
		p4.add(p4_4);
		p4.add(p4_2);
		p4.add(p4_5);
		p4.add(p4_3);
		p4.add(p4_6);
		
		//5th Column Structure
		p5 = new JPanel();
		p5.setLayout(new BorderLayout());
		ImageIcon ic = new ImageIcon("images/buyLogo1.GIF");
		tgb1 = new JToggleButton(ic);
		tgb1.addActionListener(this);
		p5.add(tgb1);
		
		//6th Column structure
		p6 = new JPanel();
		p6.setLayout(new GridLayout(4,1));
		p6.setBorder(new TitledBorder("For Employee Use only"));
		p6.setBackground(Color.red);
		
		
		label2 = new JLabel();
		label2.setText("Use Keypad to enter password for setting");
		
		p6_2 = new JPanel();
		p6_2.setLayout(new GridLayout(2,5));
		for(int i=0; i<btarr.length;i++)
		{	
			btarr[i] = new JButton(String.valueOf(i));
			btarr[i].addActionListener(this);
			p6_2.add(btarr[i]);
		}
		p6_3 = new JPanel();
		p6_3.setLayout(new GridLayout(1,2));
		bt1 = new JButton("Enter");
		bt2 = new JButton("Reset");
		p6_3.setBackground(Color.red);
		p6_3.add(bt1);
		bt1.addActionListener(this);
		p6_3.add(bt2);
		bt2.addActionListener(this);
		p6_4 = new JPanel(new BorderLayout());
		pwt = new JPasswordField();
		pwt.setEchoChar('*');
		pwt.setEnabled(false);
		pwt.setBackground(Color.LIGHT_GRAY);
		p6_4.add(pwt);
		p6.add(label2);
		p6.add(p6_2);
		p6.add(p6_3);
		p6.add(p6_4);
		
		
		//7th Column Structure
		
		p7 = new JPanel();
		p7.setBorder(new TitledBorder("Your Selection"));
		p7.setLayout(new BorderLayout());
		pay = new Vector();
		list2 = new JList(pay);
		list2.addListSelectionListener(this);
		
		scroll2 = new JScrollPane(list2);
		p7.add(scroll2);
		
		
		//8th Colum Structure
		
		
		p8 = new JPanel();
		p8.setLayout(new GridLayout(5,1));
		bt3 = new JButton("clear");
		p8.add(bt3);
		bt3.addActionListener(this);
		bt4 = new JButton("clear All");
		p8.add(bt4);
		bt4.addActionListener(this);
		p8_1 = new JPanel();
		label3 = new JLabel("Total:");
		

		p8_1.setLayout(new GridLayout(2,1));
		p8_1.add(label3);
		p8_1.setBackground(Color.cyan);
		p8.add(p8_1);
		layout5 = new JPanel();
		layout5.setLayout(new GridLayout(1,2));
		card = new JLabel("Enter Credit Card#");
		card.setHorizontalAlignment(SwingConstants.RIGHT);
		layout5.add(card);
		credit = new JPasswordField();
		credit.setEchoChar('@');
		
		layout5.add(credit);
		p8.add(layout5);
		bt5 = new JButton("Submit");
		bt5.addActionListener(this);
		
		p8.add(bt5);
		p9 = new JPanel();
		
		
		p10 = new JPanel();
		
	
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
		layout3.setLayout(new GridLayout(1,3));
		layout3.add(p6);
		layout3.add(p7);
		layout3.add(p8);
		
		layout4 = new JPanel();
		layout4.setLayout(new GridLayout(3,1));
		
		layout4.add(layout1);
		
		layout4.add(layout2);
		layout4.add(layout3);
		
		con = getContentPane();
		con.add(layout4);
		upt = new UpdateFrame();
		 upt.setTitle("Book Update");
		 upt.createscreen();
		upt.setSize(900,600);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
   if(list1.getSelectedIndex() != -1){
		lab2 = new ImageIcon("images/"+bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookCover());
		label1.setIcon(lab2);
		label1.repaint();
		   rd1.setEnabled(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(0));
		   rd2.setEnabled(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(1));
		   rd3.setEnabled(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(2));
		   
		   if(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(0)) {
			   rd1.setSelected(true);
		   }else if(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(1)) {
			   rd2.setSelected(true);
		   }else if(bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(2)) {
			   rd3.setSelected(true);
		   }
		}
	}
		
		
@Override
public void itemStateChanged(ItemEvent e) {
	
	if(e.getSource() instanceof JComboBox) {
		bl.createList();
		   title = new Vector();
			num = new Vector();
	
	if(combo1.getSelectedIndex()==1) {
		for(int i=0;i<bl.bkList.length;i++) {
		title.add(bl.bkList[i].getStrBookTitle());
		num.add(i);
		}
	}else if(combo1.getSelectedIndex()==2){
		for(int i=0;i<bl.bkList.length;i++) {
		if(bl.bkList[i].getChBookType()=='a')
			title.add(bl.bkList[i].getStrBookTitle());
			num.add(i);
         System.out.println(i);
		}
	}else if(combo1.getSelectedIndex()==3){
		for(int i=0;i<bl.bkList.length;i++) {
		if(bl.bkList[i].getChBookType()=='h') {
			title.add(bl.bkList[i].getStrBookTitle());
			num.add(i);
		}
		}
	}else if(combo1.getSelectedIndex()==4){
		for(int i=0;i<bl.bkList.length;i++) {
		if(bl.bkList[i].getChBookType()=='r') {
			title.add(bl.bkList[i].getStrBookTitle());
			num.add(i);
		}
		}
	}else if(combo1.getSelectedIndex()==5){
			for(int i=0;i<bl.bkList.length;i++) {
				if(bl.bkList[i].getChBookType()=='s') {
					title.add(bl.bkList[i].getStrBookTitle());
					num.add(i);
				}
				}
			}
		list1.setListData(title);
	}else if(rd3.isSelected()){
		combo2.setEnabled(true);
	}
}
		
public boolean check(String ans, Vector r) {
	
	boolean var = true;
	
	for(int i=0; i < r.size(); i++ ) 
	{
		if(ans.equals(String.valueOf(r.elementAt(i)))) {
			var = false;
			break;
		}
	}
	
	return var;
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == bt1) {
		if(password.equals(pwt.getText())) {
			upt.setVisible(true);
			pwt.setText("");
			
		}else {
			JOptionPane.showMessageDialog(this, "WRONGPASSWORD Please re-enter", "Not Allowed", JOptionPane.ERROR_MESSAGE);
			pwt.setText("");
		}
	}else if(e.getSource() == bt2) {
		pwt.setText("");
	}else if(e.getSource()==tgb1) {
		if(list1.getSelectedIndex() !=-1) {
		
			
			
		if(!bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(0)&&!bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(1)&&!bl.bkList[num.elementAt(list1.getSelectedIndex())].getBoolBookFormatAvail(2)) {
				JOptionPane.showMessageDialog(this, "This title is NOT available in any format, Please Select Another", "Not Allowed", JOptionPane.ERROR_MESSAGE);
		}			
		else if(rd1.isSelected()) {
			if(check(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookTitle() + " (for ePub)", pay)){
			pay.add(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookTitle() + " (for ePub)");
			check.addElement(bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(0));
			price += bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(0);
			label3.setText("Total: $" + String.valueOf(twoDecimal.format(price)));
			list2.setListData(pay);
			}else {
				JOptionPane.showMessageDialog(this, "Book Title already Selected for this format\n Please re-select another book or format", "Duplicate", JOptionPane.ERROR_MESSAGE);
			}
		}else if(rd2.isSelected()) {
			if(check(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookTitle() + " (for mobi)", pay)){
			pay.addElement(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookTitle() + " (for mobi)");
			check.addElement(bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(1));
			price += bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(1);
			label3.setText("Total: $" + String.valueOf(twoDecimal.format(price)));
			list2.setListData(pay);
			}else {
				JOptionPane.showMessageDialog(this, "Book Title already Selected for this format\n Please re-select another book or format", "Duplicate", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(rd3.isSelected()) {
			pay.addElement(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookTitle()  + "(" + (combo2.getSelectedIndex() + 1) + ") (for Hardcopy)");
			check.addElement(bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(2)*(combo2.getSelectedIndex() + 1));
			price += (bl.bkList[num.elementAt(list1.getSelectedIndex())].getDoubBookPrice(2) * (combo2.getSelectedIndex() + 1));
			label3.setText("Total: $" + String.valueOf(twoDecimal.format(price)));
			list2.setListData(pay);
		}
		
			
	
		
		
		}
		else {
			 JOptionPane.showMessageDialog(this, "Please Select a BookTitle", "No Selection", JOptionPane.ERROR_MESSAGE);
		}
	}else if(e.getSource() == bt3) {
		if(list2.getSelectedIndex() != -1) {
			pay.removeElementAt(list2.getSelectedIndex());
			price -= check.elementAt(list2.getSelectedIndex());
			check.remove(list2.getSelectedIndex());
			label3.setText("Total: $" + twoDecimal.format(price));
			list2.setListData(pay);
		}
	}else if(e.getSource() == bt4) {
		int res = JOptionPane.showConfirmDialog(this, "Are you Sure", "Warming", JOptionPane.WARNING_MESSAGE);
		if(res == JOptionPane.YES_OPTION) {
			pay = new Vector();
			list2.setListData(pay);
			price = 0;
			label3.setText("Total: " + twoDecimal.format(price));
		}
	}else if(e.getSource() == bt5) {
		int res = JOptionPane.showConfirmDialog(this, "Are you Sure", "Warming", JOptionPane.WARNING_MESSAGE);
		if(res == JOptionPane.YES_OPTION) {
		if(pay.size()==0) {
			JOptionPane.showMessageDialog(this, "No Books selected, Please select a Book titler", "Not Allowed", JOptionPane.ERROR_MESSAGE);
			
		}else if(credit.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Please Enter a VALID Credit Card", "Not Allowed", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, label3.getText() + " has been charged to your card, Thank you", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			pay.removeAllElements();
			label3.setText("Total: ");
			credit.setText("");
			list2.setListData(pay);
		}
		}
	}

	else {
		pwt.setText(pwt.getText() + e.getActionCommand());
	}
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	if(list1.getSelectedIndex() != -1) {
	 label1.setIcon(null);
	   label1.setText(bl.bkList[num.elementAt(list1.getSelectedIndex())].getStrBookComment());
	   label1.repaint();
	}
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	if(list1.getSelectedIndex() != -1) {
	label1.setText("");
	   label1.setIcon(lab2);
	   label1.repaint();
	}
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


	
	
	


		
	
		
	
	}



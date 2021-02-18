import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.toedter.calendar.JDateChooser;

public class FillDetails implements ActionListener{
	
	JLabel head,inst,l1,l2,l3,l4,l5,l6,l7,l8,l9,showPath;
	JFrame jf;
	JTextField t1,t2,t3,t5,t6;
	JButton choose,generate,reset;
	JDateChooser t4,t7,t8;
	
	private String path;
	private String ins[]= {"Enter the details carefully","Once ID card generated, cannot be corrected",
			"Upload photograph in jpg or png format"};
	
	
	public FillDetails()
	{
		jf=new JFrame("ID Card Generator");
		
		head=new JLabel("ID Card Generator");
		head.setFont(new Font("Verdana",Font.BOLD,35));
		head.setForeground(new Color(218, 8, 8 ));
		head.setBounds(261, 13, 386, 73);
		
		Font font=new Font("Verdana",Font.BOLD,18);
		Font text=new Font("Verdana",Font.BOLD,15);
		
		inst=new JLabel();
		inst.setBounds(0, 100, 899, 25);
		inst.setHorizontalAlignment(SwingConstants.CENTER);
		inst.setForeground(Color.RED);
		inst.setFont(font);
		
		InnerClass ic=new InnerClass();
		ic.start();
		
		l1=new JLabel("Student Name:");
		l1.setFont(font);
		l1.setBounds(15, 155, 154, 25);
		
		t1=new JTextField();
		t1.setBounds(178, 158, 194, 27);
		t1.setFont(text);
		t1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l2=new JLabel("Father Name:");
		l2.setFont(font);
		l2.setBounds(443, 155, 154, 25);
		
		t2=new JTextField();
		t2.setBounds(620, 158, 194, 27);
		t2.setFont(text);
		t2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l3=new JLabel("Roll No:");
		l3.setFont(font);
		l3.setBounds(15, 195, 154, 25);
		
		t3=new JTextField();
		t3.setBounds(178, 198, 194, 27);
		t3.setFont(text);
		t3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l4=new JLabel("Date of Birth:");
		l4.setFont(font);
		l4.setBounds(443, 195, 154, 25);
		
		t4=new JDateChooser();
		t4.setBounds(620, 198, 194, 27);
		t4.setDateFormatString("dd/MM/yyyy");
		t4.setFont(text);
		t4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l5=new JLabel("Course");
		l5.setFont(font);
		l5.setBounds(15, 235, 154, 25);
		
		t5=new JTextField();
		t5.setBounds(178, 238, 194, 27);
		t5.setFont(text);
		t5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l6=new JLabel("Branch");
		l6.setFont(font);
		l6.setBounds(443, 235, 154, 25);
		
		t6=new JTextField();
		t6.setBounds(620, 238, 194, 27);
		t6.setFont(text);
		t6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l7=new JLabel("Valid From");
		l7.setFont(font);
		l7.setBounds(15, 275, 154, 25);
		
		t7=new JDateChooser();
		t7.setBounds(178, 278, 194, 27);
		t7.setDateFormatString("dd/MM/yyyy");
		t7.setFont(text);
		t7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l8=new JLabel("Upto");
		l8.setFont(font);
		l8.setBounds(443, 275, 154, 25);
		
		t8=new JDateChooser();
		t8.setBounds(620,278,194,27);
		t8.setDateFormatString("dd/MM/yyyy");
		t8.setFont(text);
		t8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		l9=new JLabel("Student Photograph:");
		l9.setFont(font);
		l9.setBounds(15, 315, 225, 25);
		
		choose=new JButton("Choose file:");
		choose.setBounds(240, 320, 100, 20);
		
		showPath=new JLabel("No File Chosen");
		showPath.setBounds(360, 320, 500,25);
		
		
		generate=new JButton("Generate");
		generate.setBounds(700, 411, 130, 30);
		generate.setBackground(new Color(35, 155, 86 ));
		generate.setFont(new Font("SansSerif",Font.BOLD,18));
		generate.setForeground(Color.white);
		
		reset=new JButton("Reset");
		reset.setBounds(560, 411, 130, 30);
		reset.setBackground(new Color(174, 214, 241));
		reset.setFont(new Font("SansSerif",Font.BOLD,18));
		reset.setForeground(Color.white);
		
		choose.addActionListener(this);
		reset.addActionListener(this);
		generate.addActionListener(this);
		
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addControls()
	{
		jf.add(head);jf.add(inst);jf.add(l2);jf.add(l1);jf.add(l3);jf.add(l4);jf.add(l5);
		jf.add(l6);jf.add(l7);jf.add(l8);jf.add(l9);jf.add(showPath);
		jf.add(t1);jf.add(t2);jf.add(t4);jf.add(t3);jf.add(t5);jf.add(t6);jf.add(t7);jf.add(t8);
		jf.add(choose);jf.add(generate);jf.add(reset);
		
		jf.setVisible(true);
		jf.setBounds(500, 200, 899, 511);
		jf.getContentPane().setBackground(new Color(249, 231, 159));
	}
	
	public static void main(String args[])
	{
		FillDetails fd=new FillDetails();
		fd.addControls();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==choose)
		{
			JFileChooser file=new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","jpeg","png","gif");
			file.addChoosableFileFilter(filter);
			int result=file.showSaveDialog(null);
			if(result==JFileChooser.APPROVE_OPTION)
			{
				File selectedFile=file.getSelectedFile();
				 path=selectedFile.getAbsolutePath();
				 showPath.setText(path);
			}
		}
		if(e.getSource()==reset)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setCalendar(null);
			t5.setText("");
			t6.setText("");
			t7.setCalendar(null);
			t8.setCalendar(null);
			
		}
		if(e.getSource()==generate)
		{
			boolean valid=validate();
			if(!valid)
			{
				JOptionPane.showMessageDialog(null,"Fill all fields","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				jf.dispose();
				PrintCard id=new PrintCard(t1.getText(),t2.getText(),t3.getText(),t4.getDate(),t5.getText(),
						t6.getText(),t7.getDate(),t8.getDate(),path);
				//jf.dispose();
				//id.generateID();
			}
		}
		
	}
	
	private boolean validate()
	{
		if(t1.getText()==""||t2.getText()==""||t3.getText()==""||t5.getText()==""||t6.getText()=="" 
				|| t4.getDate()==null|| t7.getDate()==null||t8.getDate()==null||path==null)
			return false;
		
		return true;	
	}
	
	class InnerClass extends Thread
	{
		public void run()
		{
			int ind=0;
			while(true)
			{
				inst.setText(ins[ind]);
				ind++;
				ind=ind%ins.length;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

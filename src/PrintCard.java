import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PrintCard {

	private JFrame j;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,photo,logo;
	JPanel panel ;
	
	private String sName,fName,rollNo,course,branch,path;
	public String logoPath="images\\chitkara_logo.jpg";
	String dob,from,upto;
	DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//PrintCard window = new PrintCard();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public PrintCard(String sName, String fName, String rollNo, Date dob, String course, String branch, Date from,
			Date upto,String path) {
		super();
		this.sName = sName;
		this.fName = fName;
		this.dob = format.format(dob);
		this.rollNo = rollNo;
		this.course = course;
		this.branch = branch;
		this.from = format.format(from);
		this.upto = format.format(upto);
		this.path=path;
		initialize();
		j.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
j=new JFrame("ID Card");

panel= new JPanel();
panel.setBorder(new LineBorder(new Color(0, 0, 0)));
panel.setBackground(new Color(255, 250, 250));
panel.setBounds(12, 0, 566, 282);
j.getContentPane().add(panel);
panel.setLayout(null);
		
		logo=new JLabel();
		logo.setBounds(50, 15, 500, 90);
		ImageIcon logoImg=resizeImage(logoPath,logo);
		logo.setIcon(logoImg);
		
		photo=new JLabel();
		photo.setBounds(34, 116, 134, 150);
		ImageIcon imgPhoto=resizeImage(path,photo);
		photo.setIcon(imgPhoto);
		photo.setBorder(BorderFactory.createLineBorder(Color.black));
		
		Font font=new Font("Verdana",Font.BOLD,16);
		l1=new JLabel("Name: "+sName);
		l1.setBounds(200, 125, 400, 24);
		l1.setFont(font);
		
		l2=new JLabel("Father Name: "+fName);
		l2.setBounds(200, 150, 400, 24);
		l2.setFont(font);
		
		l3=new JLabel("D.O.B: "+dob);
		l3.setBounds(200, 175, 400, 24);
		l3.setFont(font);
		
		l4=new JLabel("Roll No: "+rollNo);
		l4.setBounds(200, 200, 400, 24);
		l4.setFont(font);
		
		l5=new JLabel("Course: "+course);
		l5.setBounds(200, 225, 180, 24);
		l5.setFont(font);
		
		l6=new JLabel("Branch: "+branch);
		l6.setBounds(390, 225, 180, 24);
		l6.setFont(font);
		
		l7=new JLabel("Valid From:"+from);
		l7.setBounds(180, 250, 200, 24);
		l7.setFont(new Font("Verdana", Font.BOLD, 14));
		l7.setForeground(Color.RED);
		
		l8=new JLabel("Upto:"+upto);
		l8.setBounds(390, 250, 164, 24);
		l8.setFont(new Font("Verdana", Font.BOLD, 14));
		l8.setForeground(Color.RED);
		
		j.getContentPane().setLayout(null);
		
		panel.add(l1);panel.add(l2);panel.add(l3);panel.add(l4);panel.add(l5);panel.add(l6);panel.add(l7);panel.add(l8);
		panel.add(logo);panel.add(photo);
		
		j.setBounds(300, 200, 608, 368);
		j.setVisible(true);
		j.getContentPane().setBackground(new Color(242, 244, 244 ));
		
		btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printRecord(panel);
			}
		});
		btnNewButton.setBounds(245, 287, 97, 25);
		j.getContentPane().add(btnNewButton);
		
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private ImageIcon resizeImage(String imgPath,JLabel label)
	{
		ImageIcon myImage=new ImageIcon(imgPath);
		Image img=myImage.getImage();
		Image newImg=img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		return image;
	}
	
	private void printRecord(JPanel j)
	{
		PrinterJob pj=PrinterJob.getPrinterJob();
		
		pj.setJobName("Print");
		pj.setPrintable(new Printable() {
			public int print(Graphics graphics,PageFormat pageformat,int pageIndex)throws PrinterException{
				if(pageIndex>0)
					return Printable.NO_SUCH_PAGE;
				Graphics2D graphics2D=(Graphics2D)graphics;
				graphics2D.translate(pageformat.getImageableX()*2, pageformat.getImageableY()*2);
				
				graphics2D.scale(0.5, 0.5);
				
				panel.paint(graphics2D);
				
				return Printable.PAGE_EXISTS;
			}
		});
		boolean returningResult=pj.printDialog();
		if(returningResult)
		{
			try
			{
				pj.print();
			}catch(PrinterException pe)
			{
				JOptionPane.showMessageDialog(null, "Print Error", pe.getMessage(),JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}

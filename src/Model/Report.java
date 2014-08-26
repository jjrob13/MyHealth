package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import javax.swing.SwingConstants;



public class Report extends JPanel implements Printable{

	private static final long serialVersionUID = 1L;
	private String reportHeader;
	String title;
public Report(String username, String title, JPanel graphs){
	
	//get Date
	DateFormat dateFormat = new SimpleDateFormat("EEEE, MMMMM dd, yyyy");
	Date date = new Date();
	
	//create title
	this.title = title + " for " + dateFormat.format(date);
	
	//Set layout for page
	this.setLayout(new BorderLayout());
	this.setBackground(Color.WHITE);
	
	//Create and format header
	reportHeader = username + "'s " + this.title;
	JLabel header = new JLabel(reportHeader);
	header.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
	Font font = header.getFont();
	header.setFont(new Font(font.getName(), Font.BOLD, font.getSize() + 12));
	header.setHorizontalAlignment(SwingConstants.CENTER);
	this.add(header, BorderLayout.NORTH);
	this.add(graphs, BorderLayout.CENTER);
	
	
	}

//Call this method to print the report
public void printReport(){
	PrinterJob job = PrinterJob.getPrinterJob();
	job.setPrintable(this);
	job.setJobName(title);

	boolean toPrint = job.printDialog();
	
	if(toPrint)
	{
		try {
			job.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

private BufferedImage panelToImage()
{
	this.setVisible(true);
	JFrame tempFrame = new JFrame();

	tempFrame.setBackground(Color.WHITE);
	tempFrame.setUndecorated(true);
	tempFrame.getContentPane().add(this);
	tempFrame.pack();
	
	BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
	this.paint(image.getGraphics());
	
	tempFrame.dispose();
	
	return image;
}




@Override
public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
		throws PrinterException {
	if(pageIndex > 0)
	{
		return NO_SUCH_PAGE;
	}
	pageFormat.setOrientation(PageFormat.LANDSCAPE);
	
	Graphics2D g2d = (Graphics2D) graphics;
	g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	
	java.awt.Rectangle tClipBounds = g2d.getClipBounds();
	

	if (tClipBounds != null) {
	// Shrink/stretch the image to fit within the page.
	
	g2d.scale(.6, .8);
	g2d.translate(270, 175);
	}
	
	
	enableDoubleBuffering(false);

	g2d.drawImage(panelToImage(), 0, 0, null);
	
	enableDoubleBuffering(true);

	
	return PAGE_EXISTS;
}


public void enableDoubleBuffering(boolean bEnable){
	RepaintManager repaintManager = RepaintManager.currentManager(this);
	repaintManager.setDoubleBufferingEnabled( bEnable );
}


}

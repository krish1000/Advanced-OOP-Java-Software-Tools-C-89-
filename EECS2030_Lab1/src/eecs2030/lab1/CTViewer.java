package eecs2030.lab1;

import java.awt.Component;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CTViewer extends JFrame implements ActionListener, WindowListener {

	public class RangeVerifier extends InputVerifier implements ActionListener {

		private NumberFormat format;
		private int min;
		private int max;
		private int value;

		public RangeVerifier(NumberFormat format, int min, int max, int value) {
			this.format = format;
			this.min = min;
			this.max = max;
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		private int parseValue(JTextField tf) throws ParseException {
			return this.format.parse(tf.getText()).intValue();
		}

		public boolean verify(JComponent input) {
			boolean result = false;
			try {
				int level = this.parseValue((JTextField) input);
				result = !(level < this.min || level > this.max);
			} catch (ParseException x) {

			}
			return result;
		}

		public boolean shouldYieldFocus(JComponent source) {
			boolean result = verify(source);
			JTextField tf = (JTextField) source;
			if (!result) {
				tf.setText("" + this.value);
			} else {
				try {
					this.value = this.parseValue(tf);
					tf.setText("" + this.value);
				} catch (ParseException x) {

				}
			}
			return result;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField source = (JTextField) e.getSource();
			shouldYieldFocus(source); // ignore return value
			source.selectAll();
		}
	}

	private static final long serialVersionUID = -5014881134408541953L;

	private static final int CT_HEIGHT = 512;
	private static final int CT_WIDTH = 512;

	private JMenuItem open;
	private JFileChooser fc;

	JTextField levelTextField;
	JTextField widthTextField;
	JButton updateButton;
	
	private JLabel ct;

	private List<Hounsfield> ctData;
	private BufferedImage ctImage;
	private byte[] ctImageData;
	private HounsfieldWindow ctWindow;

	private void initCT() {
		this.ctWindow = new HounsfieldWindow();
		this.ctData = new ArrayList<>();
		this.ctImageData = new byte[512 * 512];
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		int[] nBits = { 8 };
		ColorModel cm = new ComponentColorModel(cs, nBits, false, true, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
		SampleModel sm = cm.createCompatibleSampleModel(CTViewer.CT_WIDTH, CTViewer.CT_HEIGHT);
		DataBufferByte db = new DataBufferByte(this.ctImageData, CTViewer.CT_WIDTH * CTViewer.CT_HEIGHT);
		WritableRaster raster = Raster.createWritableRaster(sm, db, null);
		this.ctImage = new BufferedImage(cm, raster, false, null);
	}
	
	private JTextField makeTextField(int min, int max, int value) {
		JTextField tf = new JTextField(8);
		tf.setText("" + value);
		NumberFormat levelFormat = NumberFormat.getIntegerInstance();
		levelFormat.setMinimumIntegerDigits(1);
		levelFormat.setMaximumIntegerDigits(4);
		RangeVerifier v = new RangeVerifier(levelFormat, min, max, value);
		tf.setInputVerifier(v);
		tf.addActionListener(v);
		return tf;
	}

	public CTViewer() {
		this.initCT();

		this.fc = new JFileChooser();
		URL currentDir = CTViewer.class.getResource("/");
		File projectDir = (new File(currentDir.getFile())).getParentFile();
		File imageDir = new File(projectDir.toString() + "/images");
		this.fc.setCurrentDirectory(imageDir);
		this.fc.setFileFilter(new FileNameExtensionFilter("RAW CT", "raw"));

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		this.open = new JMenuItem("Open...");
		this.open.addActionListener(this);
		menu.add(this.open);

		this.setJMenuBar(menuBar);

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

		// create the panel for the level textfield
		JPanel levelPanel = new JPanel();
		levelPanel.setBorder(BorderFactory.createTitledBorder("Window level"));
		this.levelTextField = makeTextField(Hounsfield.MIN_VALUE, Hounsfield.MAX_VALUE, 
				this.ctWindow.getLevel());
		levelPanel.add(this.levelTextField);
		
		// create the panel for the width textfield
		JPanel widthPanel = new JPanel();
		widthPanel.setBorder(BorderFactory.createTitledBorder("Window width"));
		this.widthTextField = makeTextField(0, Hounsfield.MAX_VALUE - Hounsfield.MIN_VALUE, 
				this.ctWindow.getWidth());
		widthPanel.add(this.widthTextField);
		
		// create the panel for the update button
		JPanel updatePanel = new JPanel();
		updatePanel.setBorder(BorderFactory.createTitledBorder("Update"));
		this.updateButton = new JButton("Update image");
		this.updateButton.setActionCommand("UPDATE");
		this.updateButton.addActionListener(this);
		updatePanel.add(this.updateButton);
		
		// Create the label that displays the ct image
		this.ct = new JLabel();
		this.ct.setIcon(new ImageIcon(this.ctImage));
		this.ct.setHorizontalAlignment(JLabel.CENTER);
		this.ct.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.ct.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// put everything together
		this.getContentPane().add(levelPanel);
		this.getContentPane().add(widthPanel);
		this.getContentPane().add(updatePanel);
		this.getContentPane().add(this.ct);

		// Display the window.
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.open) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				this.readCT(file);
			}
		}
		else if (e.getSource() == this.updateButton) {
			try {
				int level = Integer.parseInt(this.levelTextField.getText());
				int width = Integer.parseInt(this.widthTextField.getText());
				this.ctWindow.setLevel(level);
				this.ctWindow.setWidth(width);
				this.updateImage();
			}
			catch (NumberFormatException ex) {
				// ignore
			}
		}
	}

	private void readCT(File f) {
		Path path = FileSystems.getDefault().getPath(f.getPath());
		try {
			byte[] data = Files.readAllBytes(path);
			ByteBuffer b = ByteBuffer.wrap(data, 0, data.length);
			// b.order(ByteOrder.LITTLE_ENDIAN);
			IntBuffer values = b.asIntBuffer();
			List<Hounsfield> ctNew = new ArrayList<>(512 * 512);
			while (values.hasRemaining()) {
				Hounsfield hv = new Hounsfield(values.get());
				ctNew.add(hv);
			}
			if (ctNew.size() != 512 * 512) {
				JOptionPane.showMessageDialog(this,
						"The file: " + path.toString()
								+ " has an unexpected size; are you sure the raw data has 512x512x4 bytes?",
						"Unexpected number of pixels", JOptionPane.ERROR_MESSAGE);
			}
			this.ctData = ctNew;
			this.updateImage();
		} catch (IOException x) {
			JOptionPane.showMessageDialog(this, "There was an error reading the file: " + path.toString(),
					"File read error", JOptionPane.ERROR_MESSAGE);

		} catch (IllegalArgumentException x) {
			JOptionPane.showMessageDialog(this,
					"The file: " + path.toString()
							+ " contains an unexpected Hounsfield value; are you sure the raw data is a CT scan?",
					"Unexpected Hounsfield value", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void updateImage() {
		WritableRaster r = this.ctImage.getRaster();
		DataBuffer b = r.getDataBuffer();
		int i = 0;
		for (Hounsfield hv : this.ctData) {
			byte gray = (byte) (this.ctWindow.map(hv) * 255.0);
			b.setElem(i++, gray);
		}
		this.ctImage.setData(r);
		this.ct.setIcon(new ImageIcon(this.ctImage));
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		CTViewer viewer = new CTViewer();
		viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CTViewer.createAndShowGUI();
			}
		});
	}
}

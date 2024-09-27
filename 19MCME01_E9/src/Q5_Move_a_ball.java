import java.awt.*; // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; // Using Swing's components and containers

@SuppressWarnings("serial")
public class Q5_Move_a_ball extends JFrame {
	// Define constants for the various dimensions
	public static final int CANVAS_WIDTH = 400;
	public static final int CANVAS_HEIGHT = 180;
	public static final Color LINE_COLOR = Color.BLACK;
	public static final Color CANVAS_BACKGROUND = Color.CYAN;

	// Center of the circle position on the canvas
	private int x = (CANVAS_WIDTH / 2) - 30;
	private int y = CANVAS_HEIGHT / 4;

	// Radius of the circle
	private int radius = CANVAS_WIDTH / 8;
	private DrawCanvas canvas;

	// Constructor to set up the GUI components and event handlers
	public Q5_Move_a_ball() {
		// Set up a panel for the buttons
		JPanel btnPanel = new JPanel(new FlowLayout());

		JButton btnLeft = new JButton("Move Left ");
		btnPanel.add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				x -= 10;
				canvas.repaint();
				requestFocus(); // change the focus to JFrame to receive KeyEvent
			}
		});
		JButton btnUp = new JButton("Move Up");
		btnPanel.add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				y -= 10;
				canvas.repaint();
				requestFocus(); // change the focus to JFrame to receive KeyEvent
			}
		});
		JButton btnRight = new JButton("Move Right");
		btnPanel.add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				x += 10;
				canvas.repaint();
				requestFocus(); // change the focus to JFrame to receive KeyEvent
			}
		});
		JButton btnDown = new JButton("Move Down");
		btnPanel.add(btnDown);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				y += 10;
				canvas.repaint();
				requestFocus(); // change the focus to JFrame to receive KeyEvent
			}
		});

		// Set up a custom drawing JPanel
		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, 140));
		btnPanel.setPreferredSize(new Dimension(CANVAS_WIDTH, 100));

		// Add both panels to this JFrame's content-pane

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.SOUTH);

		//Set up KeyEvent
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				switch (evt.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					x -= 10;
					repaint();
					break;
				case KeyEvent.VK_RIGHT:
					x += 10;
					repaint();
					break;
				case KeyEvent.VK_UP:
					y -= 10;
					repaint();
					break;
				case KeyEvent.VK_DOWN:
					y += 10;
					repaint();
					break;
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
		setTitle("Move a Ball");
		pack(); // pack all the components in the JFrame
		setVisible(true); // show it
		requestFocus(); // set the focus to JFrame to receive KeyEvent
	}

	class DrawCanvas extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(CANVAS_BACKGROUND);
			g.setColor(Color.RED);
			g.fillOval(x, y, radius, radius);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Q5_Move_a_ball(); // Let the constructor do the job
			}
		});
	}
}
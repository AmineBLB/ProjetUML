package simpledraw;

import enregistrement.JsonEnregistrement;
import enregistrement.XmlEnregistrement;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;

/**
 * simpledraw.Main Frame of SimpleDraw
 * @author Rémi Bastide
 * @version 1.0
 */

public class MainFrame
	extends JFrame {
	JToggleButton mySelectButton = new JToggleButton("Select");
	JToggleButton myLineButton = new JToggleButton("Line");
	JToggleButton myCircleButton = new JToggleButton("Circle");
	JButton myExportXMLButton = new JButton("Export XML");
	JButton myExportJSONButton = new JButton("Export JSON");
	DrawingPanel myDrawingPanel = new DrawingPanel();



	/**Construct the frame*/
	public MainFrame() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			jbInit();
			myExportXMLButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.print("Bouton clické");
					List<Shape> mShapes;
					XmlEnregistrement enregistrement = new XmlEnregistrement();
					mShapes = Drawing.getMyShapes();
					for (Shape sh : mShapes)
						sh.accept(enregistrement);

					enregistrement.export();
				}
			});
			myExportJSONButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.print("Bouton clické");
					List<Shape> mShapes;
					JsonEnregistrement js = new JsonEnregistrement();

					mShapes = Drawing.getMyShapes();
					for (Shape sh : mShapes)
						sh.accept(js);

					js.export();
				}
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**Component initialization*/
	private void jbInit() throws Exception {
		getContentPane().setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		mySelectButton.setSelected(true);
		mySelectButton.setToolTipText("Select and move shapes");
		myCircleButton.setToolTipText("Draw a simpledraw.Circle");
		myLineButton.setToolTipText("Draw a simpledraw.Line");
		myExportXMLButton.setToolTipText("Export XML");
		myExportJSONButton.setToolTipText("Export JSON");

		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.add(mySelectButton, null);
		buttonPanel.add(myLineButton, null);
		buttonPanel.add(myCircleButton, null);
		buttonPanel.add(myExportXMLButton, null);
		buttonPanel.add(myExportJSONButton, null);
		getContentPane().add(myDrawingPanel, BorderLayout.CENTER);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(mySelectButton);
		buttonGroup.add(myLineButton);
		buttonGroup.add(myCircleButton);
		//buttonGroup.add(myExportXMLButton);

		setSize(new Dimension(400, 300));
		setTitle("Simple Draw");

		mySelectButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateSelectionTool();
			}
		}
		);

		myLineButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateLineTool();
			}
		}
		);

		myCircleButton.addActionListener(
			new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myDrawingPanel.activateCircleTool();
			}
		}
		);

		myExportXMLButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//myDrawingPanel.activateGroupingTool();
					}
				}
		);
	}

	/**Overridden so we can exit when window is closed*/
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}
}

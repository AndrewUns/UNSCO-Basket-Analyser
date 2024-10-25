
/**
 *
 * @author Andrew Unsworth
 */

import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class IBFileDialog {

// -------------------------------- Fields --------------------------------

	private JFileChooser filer;
	private JFrame framer;
	private String selection;
	private File path;
	//private SerFilter filter = new SerFilter();

// ------------------------------- Constants ------------------------------

	private final String saveTitle	= new String("Save file as...");
	private final String openTitle	= new String("Open file...");
	

// ------------------------------ Constructor -----------------------------

	public IBFileDialog() {
		filer = new JFileChooser();
		framer = new JFrame();
		selection = new String();
		path = new File("/");
		//filer.setFileFilter(filter);
	}	




// -------------------------------- Methods -------------------------------

/********************************************************************************/
/*										*/
/*			open() - displays the 'open' file dialog		*/
/*										*/
/********************************************************************************/

	public synchronized String open() {

	// set the dialog title to open
	filer.setDialogTitle(openTitle);

	// show the dialog and get user selections
	filer.showOpenDialog(framer);
	
	// get the selected file and directory then convert them to a string
	path = filer.getSelectedFile();
	selection = path.toString();

	return selection;
	}

/********************************************************************************/
/*										*/
/*			save() - displays the 'save' file dialog		*/
/*										*/
/********************************************************************************/

	public synchronized String save() {

	// set the dialog title to save
	filer.setDialogTitle(saveTitle);

	// show dialog and get user selections
	filer.showSaveDialog(framer);

	// get selected file and directory then convert them to a string
	path = filer.getSelectedFile();
	selection = path.toString();

	return selection;

	}

}

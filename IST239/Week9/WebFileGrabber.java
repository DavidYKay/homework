import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class WebFileGrabber extends JFrame{
	public static final int MAX_BUFFER_SIZE = 1024; //1 Kb of data
	private URL url;
	private JTextField jtfURL = new JTextField();
	private JTextField jtfSaveDir = new JTextField();
	private JButton jbtDownload = new JButton("Download");
	private JButton jbtBrowseSave = new JButton("Browse");
	private JProgressBar jpbProgress = new JProgressBar();
	private JFileChooser chooser = new JFileChooser();
	private File saveDirectory;
	
	public WebFileGrabber(){
		JPanel urlPanel = new JPanel(new BorderLayout());
		urlPanel.add(new JLabel("URL of file "), BorderLayout.WEST);
		urlPanel.add(jtfURL, BorderLayout.CENTER);
		urlPanel.add(jbtDownload, BorderLayout.EAST);
		
		JPanel filePanel = new JPanel(new BorderLayout());
		filePanel.add(new JLabel("Directory to save file"), BorderLayout.WEST);
		filePanel.add(jtfSaveDir, BorderLayout.CENTER);
		filePanel.add(jbtBrowseSave, BorderLayout.EAST);
		
		JPanel progressPanel = new JPanel(new BorderLayout());
		progressPanel.add(jpbProgress);
		jpbProgress.setStringPainted(true);
		
		progressPanel.setBorder(new TitledBorder("Progress"));
		
		jtfURL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					url = new URL(jtfURL.getText().trim());
					jtfURL.setBackground(Color.WHITE);
				}catch(MalformedURLException urlEx){
					url = null;
					jtfURL.setBackground(Color.RED);
				}
			}
		});
		
		jtfSaveDir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				saveDirectory = new File(jtfSaveDir.getText());
				if (!(saveDirectory.isDirectory())){
					jtfSaveDir.setBackground(Color.RED);
					saveDirectory = null;
				}
				else{
					jtfSaveDir.setBackground(Color.WHITE);
				}
			}
		});
		
		jbtBrowseSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(jbtBrowseSave) == JFileChooser.APPROVE_OPTION){
					saveDirectory = chooser.getSelectedFile();
					jtfSaveDir.setText(saveDirectory.getAbsolutePath());
					jtfSaveDir.setBackground(Color.WHITE);
				}
				else{
					//Ignore
				}
			}
		});
		
		jbtDownload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (url == null){
					JOptionPane.showMessageDialog(null, "Please set the URL to download from", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(saveDirectory == null){
					JOptionPane.showMessageDialog(null, "Please set the directory to save the file to", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				FileDownloader dl = new FileDownloader(url);
				new Thread(dl).start();
			}
		});
		
		setLayout(new GridLayout(3, 1, 0, 0));
		add(progressPanel);
		add(urlPanel);
		add(filePanel);
	}
	
	class FileDownloader implements Runnable{
		private URL url;
		
		public FileDownloader(URL url){
			this.url = url;
		}
		
		public String getFileName(String fileName){
			int dirSplitIndex = fileName.lastIndexOf("/");
			fileName = fileName.substring(dirSplitIndex + 1);
			
			return fileName;
		}

		public void run() {
			try{
				jpbProgress.setString("Connecting");
				jpbProgress.setIndeterminate(true);
				
				URLConnection connection = url.openConnection();
				long fileLength = connection.getContentLength();
				if (fileLength < 0){
					throw new IOException("Invalid file size");
				}
				String fileName = getFileName(url.getFile());
				
				FileOutputStream out = new FileOutputStream(new File(saveDirectory.getAbsolutePath() + "/" + fileName));
				DataInputStream in = new DataInputStream(connection.getInputStream()); 
				byte[] buffer;
				
				jpbProgress.setIndeterminate(false);
				jpbProgress.setString(null);
				long readIn = 0;
				while(readIn < fileLength){
					long progress = (readIn * 100 / fileLength);
					jpbProgress.setValue((int) progress);
					if (fileLength - readIn > MAX_BUFFER_SIZE){
						buffer = new byte[MAX_BUFFER_SIZE];
					}
					else{
						buffer = new byte[(int)(fileLength - readIn)];
					}
					
					int read = in.read(buffer);
					if (read == -1){
						throw new EOFException("End of file reached unexpectedly");
					}
					
					readIn += read;
					out.write(buffer, 0, read);
					
				}
				
				jpbProgress.setValue(100);
				out.close();
				in.close();
			
			}catch(IOException ioe){
				//TODO add proper Exception Handling
				ioe.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		JFrame frame = new WebFileGrabber();
		frame.setTitle("Web File Downloader");
		frame.setSize(600, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}

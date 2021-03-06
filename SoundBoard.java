import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SoundBoard extends JFrame 
{
	//Frame Size
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1000;
	
	//Font setup for all text in the app
	private Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14); 
	
	//Initialize the ImageIcons for each person
	private ImageIcon branson = new ImageIcon("branson.png");
	private ImageIcon alexis = new ImageIcon("alexis.png");
	private ImageIcon pryce = new ImageIcon("pryce.png");
	private ImageIcon logan = new ImageIcon("logan.png");
	private ImageIcon hamzah = new ImageIcon("hamzah.png");
	private ImageIcon ryan = new ImageIcon("ryan.png");
	
	//Creates the frame that will be output
	public SoundBoard() throws IOException
	{
		setTitle("Soundboard and Station Calculator");
		setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Re-scale images to fit buttons properly	
		Image b = branson.getImage();
		Image newb = b.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		branson = new ImageIcon(newb);
		
		Image a = alexis.getImage();
		Image newa = a.getScaledInstance(110, 100, Image.SCALE_SMOOTH);
		alexis = new ImageIcon(newa);
		
		Image p = pryce.getImage();
		Image newp = p.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		pryce = new ImageIcon(newp);
		
		Image l = logan.getImage();
		Image newl = l.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		logan = new ImageIcon(newl);
		
		Image h = hamzah.getImage();
		Image newh = h.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		hamzah = new ImageIcon(newh);
		
		Image r = ryan.getImage();
		Image newr = r.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
		ryan = new ImageIcon(newr);
		
		JPanel basePanel = new JPanel(new GridLayout(2,1));
		
		JPanel soundPanel = new JPanel(new GridLayout(4,2));
		JLabel voiceChoiceInfo = new JLabel("Pick the voice you would like to hear:");
		voiceChoiceInfo.setFont(font);
		//List holding the names of the people to choose from.
		String[] voiceList = {"Branson", "Alexis", "Pryce", "Logan", "Hamzah", "Ryan"};
		JComboBox<String> voiceChoice = new JComboBox<String>();
		voiceChoice.setFont(font);
		
		//loop through and add the list to the JComboBox.
		for(int i=0; i < voiceList.length; i++)
		{
			voiceChoice.addItem(voiceList[i]);
		}
		
		//Add the lines that will be available to hear
		JButton line1 = new JButton("Winter is Coming!");
		line1.setFont(font);
		
		line1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile; //the audio file to be played
				AudioInputStream audioStream; //converts the file into an input stream for audio output 
				AudioFormat format; //holds the format of the audioFile
				DataLine.Info info; //holds the info of the format
				Clip audioClip; //clip that will played
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(branson);
					} catch (Exception e) {
						// If there is an error the error sound will play
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// if the error sound file cannot be found it will print the stack trace for the exception
							e1.printStackTrace();
						}
					}
					
					
					
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanWinter.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line1.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line2 = new JButton("You know nothing Jon Snow");
		line2.setFont(font);
		
		line2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(branson);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanJonSnow.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line2.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton line3 = new JButton("UGHHH! SPOILERS!!");
		line3.setFont(font);
		
		line3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(branson);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanSpoilers.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line3.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line4 = new JButton("Bend the knee!");
		line4.setFont(font);
		
		line4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(branson);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanBend.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line4.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line5 = new JButton("King of the North!");
		line5.setFont(font);
		
		line5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(branson);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanKing.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line5.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton line6 = new JButton("I drink and I know things!");
		line6.setFont(font);
		
		line6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
				if (voiceChoice.getSelectedItem().equals("Branson"))
				{
					audioFile = new File("bransonDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(branson);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Alexis"))
				{
					audioFile = new File("alexisDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(alexis);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				else if (voiceChoice.getSelectedItem().equals("Pryce"))
				{
					audioFile = new File("pryceDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(pryce);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Logan"))
				{
					audioFile = new File("loganDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(logan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Hamzah"))
				{
					audioFile = new File("hamzahDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(hamzah);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else if (voiceChoice.getSelectedItem().equals("Ryan"))
				{
					audioFile = new File("ryanDrink.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
						line6.setIcon(ryan);
					} catch (Exception e) {
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				else
				{
					audioFile = new File("error.wav");
					try {
						audioStream = AudioSystem.getAudioInputStream(audioFile);
						format = audioStream.getFormat();
						info = new DataLine.Info(Clip.class, format);
						audioClip = (Clip) AudioSystem.getLine(info);
						audioClip.open(audioStream);
						audioClip.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		//Add components to the panel
		soundPanel.add(voiceChoiceInfo);
		soundPanel.add(voiceChoice);
		soundPanel.add(line1);
		soundPanel.add(line2);
		soundPanel.add(line3);
		soundPanel.add(line4);
		soundPanel.add(line5);
		soundPanel.add(line6);
		//Add panel to panel that will be placed into the frame
		basePanel.add(soundPanel);
		//Panel that will hold calculator components
		JPanel calculatorBasePanel = new JPanel(new GridLayout(1,2));
		//Left Panel of calculator panel will have a label and two dropdown boxes
		JPanel pickerPanel = new JPanel(new GridLayout(3,1));
		
		JLabel pickStationInfo = new JLabel("Pick two stations:");
		pickStationInfo.setFont(font);
		JComboBox<String> station1box = new JComboBox<String>();
		station1box.setFont(font);
		JComboBox<String> station2box = new JComboBox<String>();
		station2box.setFont(font);
		//Reads from the Mesonet.txt file and puts the stations ID's in the dropdown boxes
		File file = new File("Mesonet.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String strg;
		
		while ((strg = br.readLine()) != null)
		{
			station1box.addItem(strg.substring(0, 4));
			station2box.addItem(strg.substring(0, 4));
		}
		
		br.close();
		//add components to the left panel
		pickerPanel.add(pickStationInfo);
		pickerPanel.add(station1box);
		pickerPanel.add(station2box);
		//Right panel of the calculator panel will contain a button panel and an ouput JTextField
		JPanel outputPanel = new JPanel(new GridLayout(2,1));
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JTextField output = new JTextField();
		output.setEditable(false);
		output.setFont(font);
		
		
		// Create the calculator buttons and add action listeners
		JButton difference = new JButton("Calc difference");
		difference.setFont(font);
		
		difference.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = station1box.getSelectedItem().toString();
				String id2 = station2box.getSelectedItem().toString();
				int id1value = 0;
				int id2value = 0;
				//Loop to calculate the ASCHII sums of each station ID.
				for (int i = 0; i < id1.length(); i ++)
				{
					id1value += id1.charAt(i);
					id2value += id2.charAt(i);
				}
				// Find the difference in the two stations ASCHII sums (Always positive)
				int difference = Math.abs(id1value - id2value);
				
				output.setText("" + difference);				
			}
			
		});
		
		JButton sum = new JButton("Calc sum");
		sum.setFont(font);
		
		sum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = station1box.getSelectedItem().toString();
				String id2 = station2box.getSelectedItem().toString();
				int id1value = 0;
				int id2value = 0;
				
				for (int i = 0; i < id1.length(); i ++)
				{
					id1value += id1.charAt(i);
					id2value += id2.charAt(i);
				}
				
				int sum = id1value + id2value;
				
				output.setText("" + sum);				
			}
			
		});
		
		JButton product = new JButton("Calc product");
		product.setFont(font);
		
		product.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = station1box.getSelectedItem().toString();
				String id2 = station2box.getSelectedItem().toString();
				int id1value = 0;
				int id2value = 0;
				for (int i = 0; i < id1.length(); i ++)
				{
					id1value += id1.charAt(i);
					id2value += id2.charAt(i);
				}
				
				int product = id1value * id2value;
				
				output.setText("" + product);				
			}
			
		});
		
		JButton quotient = new JButton("Calc quotient");
		quotient.setFont(font);
		
		quotient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id1 = station1box.getSelectedItem().toString();
				String id2 = station2box.getSelectedItem().toString();
				int id1value = 0;
				int id2value = 0;
				
				for (int i = 0; i < id1.length(); i ++)
				{
					id1value += id1.charAt(i);
					id2value += id2.charAt(i);
				}
				//The output value must be a double now since we are dividing
				double quotient = (double) id1value / id2value;	
				
				output.setText("" + quotient);				
			}
		});
		//Add buttons to panel
		buttonPanel.add(difference);
		buttonPanel.add(sum);
		buttonPanel.add(product);
		buttonPanel.add(quotient);
		//Add components to Panel to be placed in the base panel
		outputPanel.add(buttonPanel);
		outputPanel.add(output);
		//Add components to calculator base panel
		calculatorBasePanel.add(pickerPanel);
		calculatorBasePanel.add(outputPanel);
		//Add calculator panel to the panel that will be placed in the frame
		basePanel.add(calculatorBasePanel);
		//Add panel to the frame
		add(basePanel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		new SoundBoard();
	}
}

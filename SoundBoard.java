import java.awt.Dimension;
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
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 1200;
	
	private ImageIcon branson = new ImageIcon("branson.png");
	private ImageIcon alexis = new ImageIcon("alexis.png");
	private ImageIcon pryce = new ImageIcon("pryce.png");
	
	public SoundBoard() throws IOException
	{
		this.setTitle("SoundBoard");
		setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image b = branson.getImage();
		Image newb = b.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		branson = new ImageIcon(newb);
		
		Image a = alexis.getImage();
		Image newa = a.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		alexis = new ImageIcon(newa);
		
		Image p = pryce.getImage();
		Image newp = p.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		pryce = new ImageIcon(newp);
		
		
		JPanel basePanel = new JPanel(new GridLayout(2,1));
		
		JPanel soundPanel = new JPanel(new GridLayout(4,2));
		JLabel voiceChoiceInfo = new JLabel("Pick the voice you would like to hear:");
		String[] voiceList = {"Branson", "Alexis", "Pryce"};
		JComboBox<String> voiceChoice = new JComboBox<String>();
		
		for(int i=0; i < voiceList.length; i++)
		{
			voiceChoice.addItem(voiceList[i]);
		}
		
		JButton line1 = new JButton("Winter is Coming!");
		
		line1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				File audioFile;
				AudioInputStream audioStream;
				AudioFormat format;
				DataLine.Info info;
				Clip audioClip;
				
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line2 = new JButton("You know nothing Jon Snow");
		
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		JButton line3 = new JButton("UGHHH! SPOILERS!!");
		
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line4 = new JButton("Bend the knee!");
		
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line5 = new JButton("King of the North!");
		
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
		
		JButton line6 = new JButton("I drink and I know things!");
		
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						audioFile = new File("error.wav");
						try {
							audioStream = AudioSystem.getAudioInputStream(audioFile);
							format = audioStream.getFormat();
							info = new DataLine.Info(Clip.class, format);
							audioClip = (Clip) AudioSystem.getLine(info);
							audioClip.open(audioStream);
							audioClip.start();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		soundPanel.add(voiceChoiceInfo);
		soundPanel.add(voiceChoice);
		soundPanel.add(line1);
		soundPanel.add(line2);
		soundPanel.add(line3);
		soundPanel.add(line4);
		soundPanel.add(line5);
		soundPanel.add(line6);
		
		basePanel.add(soundPanel);
		
		JPanel calculatorBasePanel = new JPanel(new GridLayout(1,2));
		
		JPanel pickerPanel = new JPanel(new GridLayout(3,1));
		
		JLabel pickStationInfo = new JLabel("Pick two stations:");
		JComboBox<String> station1box = new JComboBox<String>();
		JComboBox<String> station2box = new JComboBox<String>();
		
		File file = new File("Mesonet.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String strg;
		
		while ((strg = br.readLine()) != null) {
			station1box.addItem(strg.substring(0, 4));
			station2box.addItem(strg.substring(0, 4));
		}
		
		br.close();
		
		pickerPanel.add(pickStationInfo);
		pickerPanel.add(station1box);
		pickerPanel.add(station2box);
		
		JPanel outputPanel = new JPanel(new GridLayout(2,1));
		JPanel buttonPanel = new JPanel(new GridLayout(2,2));
		JTextField output = new JTextField();
		output.setEditable(false);
		
		JButton difference = new JButton("Calc difference");
		difference.addActionListener(new ActionListener() {

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
				
				int difference = id1value - id2value;
				
				if (difference < 0) {
					difference = -1 * difference;
				}
				
				output.setText("" + difference);				
			}
			
		});
		
		JButton sum = new JButton("Calc sum");
		
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
				
				int quotient = id1value / id2value;
				
				output.setText("" + quotient);				
			}
			
		});
		
		buttonPanel.add(difference);
		buttonPanel.add(sum);
		buttonPanel.add(product);
		buttonPanel.add(quotient);
		outputPanel.add(buttonPanel);
		outputPanel.add(output);
		
		calculatorBasePanel.add(pickerPanel);
		calculatorBasePanel.add(outputPanel);
		
		basePanel.add(calculatorBasePanel);
		
		add(basePanel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		new SoundBoard();
	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot extends JFrame implements ActionListener {

	private JTextArea chatArea = new JTextArea();
	private JTextField chatBox =new JTextField();
	
	public Bot() {
	
		JFrame frame= new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(600, 600);
		frame.setTitle("ChatBox");
		frame.add(chatArea);
		frame.add(chatBox);
		
		//For the Text Area
		chatArea.setSize(550, 450);
		chatArea.setLocation(2, 2);
		chatArea.append("Ajamy: Hello this is Ajamy, I know you are bored so I am here to entertain you! \n");

		
		//For Text Field
		
		chatBox.setSize(540,30);
		chatBox.setLocation(2, 500);
		chatBox.addActionListener(this);
	
}
	
	private void botReply(String string)  {
		
	    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.schedule(new Runnable() {
	        @Override
	        public void run() {
	    		chatArea.append("Ajamy: "+string+"\n");
	        }
	    }, 1, TimeUnit.SECONDS);
	
		
		
	}


 public static void main (String args[]) {
	 
	 new Bot();
	 
 }
 
 public void hiReply() {
	
	 this.botReply("Hello");
 }
 
 public void unknownWord() {
	 int random = (int)(Math.random() * 4 +1);
		if (random==1) {
		this.botReply("I don't know what this is");
		}
		else if (random==2) {
			this.botReply("My vocabulary doesn't contain this word");
		}
		else if (random ==3) {			
			this.botReply("Please repeat what you said clearly");
		}
		else if (random ==4) {			
			this.botReply("I do not understand");
		}

	 
 }
 
 public void howaAreYou() {
	 
	 this.botReply("I am fine what about you?");
	 
	 
	 
 }


@Override
public void actionPerformed(ActionEvent arg0) {

	String text = chatBox.getText();
	String checkText=text.toLowerCase();
	chatArea.append("YOU: " + text + "\n");
	chatBox.setText("");
	
	if (checkText.length()==1) {
		this.botReply("I have no reply to " + checkText );
	}
	
	else if (checkText.contains("hi")) {
		this.hiReply();
	}
	
	else if (checkText.contains("How are you")) {
		
		this.botReply("I am fine ");
		
	}
	else {
		this.unknownWord();
	}
	
	
}
 }

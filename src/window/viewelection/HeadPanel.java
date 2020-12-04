package window.viewelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HeadPanel extends JPanel implements ItemListener, ActionListener {

    private JComboBox<String> electionsComboBox;
    private JLabel electionsCbJLabel;
    private JLabel electionTitleJlabel;
    private JButton closeBtn;
    private JButton viewBtn;
    private JButton printBtn;

    //Creating Instnce of HeadPanelListener
    private HeadPanelListner headPanelListner;

    public HeadPanel(){
        Dimension dm = getPreferredSize();
        dm.height = 90;
        setPreferredSize(dm);
        setBorder(BorderFactory.createEtchedBorder());

        //Setting Layout to Null , we Add Components  using setBounds
        setLayout(null);

        //Initializing Jpanel Components

        electionsComboBox = new JComboBox();
        electionsCbJLabel = new JLabel("Select Election:");
        electionTitleJlabel = new JLabel("Election Title");
        closeBtn = new JButton("Close");
        viewBtn = new JButton("View");
        printBtn = new JButton("Print");

        //Removing Focus Painted From Buttons..
        closeBtn.setFocusPainted(false);
        viewBtn.setFocusPainted(false);
        printBtn.setFocusPainted(false);

        //Adding Listener To Buttons
        closeBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        printBtn.addActionListener(this);

        //Adding Items To Combo Box
        electionsComboBox.addItem("Select");
        electionsComboBox.addItem("E12523");
        electionsComboBox.addItem("E11585");
        electionsComboBox.addItem("E15826");


        //Adding Item Listner to Combo Box
        electionsComboBox.addItemListener(this);

        //Adding Items to the Panel
        add(electionsCbJLabel);
        add(electionsComboBox);
        add(electionTitleJlabel);
        add(closeBtn);
        add(viewBtn);
        add(printBtn);

        //Settingg their Location in JPanel
        electionsCbJLabel.setBounds(30,15,114,25);
        electionsComboBox.setBounds(155,15,85,25);
        closeBtn.setBounds(515,15,80,25);
        electionTitleJlabel.setBounds(30,50,350,25);
        viewBtn.setBounds(320,15,70,25);
        printBtn.setBounds(515,50,80,25);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String s =(String)e.getItem();
        if(s.equals("E12523")){
            electionTitleJlabel.setText("President Election at GKV");

        }
        else
            electionTitleJlabel.setText("Election Expired!");
    }


    //Function for Action Listner
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton)e.getSource();
        if(clickedBtn.equals(viewBtn)){
            if(headPanelListner!=null){
                headPanelListner.ButtonClicked("viewBtn");
            }
        }
        else if(clickedBtn.equals(printBtn)){
            if(headPanelListner!=null){
                headPanelListner.ButtonClicked("printBtn");

            }
        }
        else if(clickedBtn.equals(closeBtn)){
            if(headPanelListner!=null){
                headPanelListner.ButtonClicked("closeBtn");
            }
        }
    }
    public void setButtonClicked(HeadPanelListner listner){
        this.headPanelListner = listner;
    }
}
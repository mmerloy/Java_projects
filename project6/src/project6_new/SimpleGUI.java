package project6_new;


import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class SimpleGUI extends JFrame 
{

    
	private static final long serialVersionUID = 1L;
	private final JTextField input = new JTextField("", 5);

    public SimpleGUI() 
    {
        super("��� � ��������");
        JLabel label = new JLabel("������:");
        JButton button = new JButton("������ ������");

        Container container = this.getContentPane(); // �������� ������ ��������

        // ����������� ����������������� ������������
        // � ������������� ����������� �� ������
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        /*
         * ������ ��� ��������� ������������ GridLayout ���������� ����������
         * ����� � �������� � �������. ������ 2 ��������� - ���������� �����
         * �������� �� ����������� � ���������
         */
        //container.setLayout(new GridLayout(3, 2, 2, 2));


        // addActionListener - ��� �������� ��������� ������.
        button.addActionListener(new ButtonEventListener());
        button.setEnabled(false);
        input.setColumns(10);
        container.add(label);
        container.add(input);
        container.add(button);


        // DL - ��������� ��� ����������� ����������� ��� ��������� ����������� �� ���������� � ��������� ���������.
        // trim ����� ��������� ������� ������� � ������ � ����� ������.
        input.getDocument().addDocumentListener(new DocumentListener() 
        {
           
        	public void check() 
            {
                //
                button.setEnabled(input.getText().trim().length() != 0);
            }

            // 	����������, ����� ����� ����������� � �������������� ��������.
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                //System.out.println("insertUpdate");
                check();
            }

            // 	����������, ����� ����� ��������� �� ��������������� ���������.
            @Override
            public void removeUpdate(DocumentEvent e) 
            {
                //System.out.println("removeUpdate");
                check();
            }
            // ���������� ��� ��������� ����� ���������� ������ � �������������� ���������.
            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                //System.out.println("changedUpdate");
                check();
            }
        }
        );
    }


    // ���������� � ���������� ���������� ActionListener
    // implements - ���������� ���������� � ��� �����, � ������� ������������� ������ ������ ��� ���������� �����������.
    class ButtonEventListener implements ActionListener 
    {
        // ���, ����������� ������ � ����������
        public void actionPerformed(ActionEvent e) 
        {
            String message = "";
            String[] texts = {"��", "���", "��������", "������� ������",
                    "� �� ��� �������", "�� � ���� ������", "������� �����������",
                    "���������", "������ �����������", "����������� �� ����� �������"};

            message += "���� ������: " + input.getText() + "\n";
            Random random = new Random();
            int numInt = random.nextInt(10);
            message += "��� �����: ";
            message += texts[numInt];
            // ��� ������ � ����������� ��������� -  JOptionPane (����������� �� JComponent)
            // showMessageDialog - ���������� ���� � ���������� � ����� ���������
            //parent - ������������ ����.
            //message - ������������ � ���� ����� ���������. 
            //title - ��������� ����.
            //messageType - ��� ����������� ����
            //PLAIN_MESSAGE - ����������� ���������� ���� ��� ������ ���������� ��� ������.
      
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        SimpleGUI app = new SimpleGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ����� �� ���������� � ������� ������ ������ �� �������.
        app.setLocationRelativeTo(null);
        app.setSize(350, 100);
        //app.pack(); ����������� ������ ����
        //��������� ����
        app.setVisible(true);
    }
}
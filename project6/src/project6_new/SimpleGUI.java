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
        super("Шар с ответами");
        JLabel label = new JLabel("Вопрос:");
        JButton button = new JButton("Задать вопрос");

        Container container = this.getContentPane(); // получили панель контента

        // Определение последовательного расположения
        // с выравниванием компонентов по центру
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        /*
         * Первые два параметра конструктора GridLayout определяют количество
         * строк и столбцов в таблице. Вторые 2 параметра - расстояние между
         * ячейками по горизонтали и вертикали
         */
        //container.setLayout(new GridLayout(3, 2, 2, 2));


        // addActionListener - это механизм обратного вызова.
        button.addActionListener(new ButtonEventListener());
        button.setEnabled(false);
        input.setColumns(10);
        container.add(label);
        container.add(input);
        container.add(button);


        // DL - Интерфейс для регистрации наблюдателя для получения уведомлений об изменениях в текстовом документе.
        // trim метод позволяет удалить пробелы в начале и конце строки.
        input.getDocument().addDocumentListener(new DocumentListener() 
        {
           
        	public void check() 
            {
                //
                button.setEnabled(input.getText().trim().length() != 0);
            }

            // 	Вызывается, когда текст вставляется в прослушиваемый документ.
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                //System.out.println("insertUpdate");
                check();
            }

            // 	Вызывается, когда текст удаляется из прослушиваемого документа.
            @Override
            public void removeUpdate(DocumentEvent e) 
            {
                //System.out.println("removeUpdate");
                check();
            }
            // Вызывается при изменении стиля некоторого текста в прослушиваемом документе.
            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                //System.out.println("changedUpdate");
                check();
            }
        }
        );
    }


    // обращаемся к реализации интерфейса ActionListener
    // implements - Реализация интерфейса — это класс, в котором расписываются методы одного или нескольких интерфейсов.
    class ButtonEventListener implements ActionListener 
    {
        // код, реализующий методы в интерфейсе
        public void actionPerformed(ActionEvent e) 
        {
            String message = "";
            String[] texts = {"Да", "Нет", "Возможно", "Будущее неясно",
                    "А ты как думаешь", "Ни в коем случае", "Хорошие перспективы",
                    "Бесспорно", "Весьма сомнительно", "Перспективы не очень хорошие"};

            message += "Твой вопрос: " + input.getText() + "\n";
            Random random = new Random();
            int numInt = random.nextInt(10);
            message += "Мой ответ: ";
            message += texts[numInt];
            // Для вывода в графический интерфейс -  JOptionPane (унаследован от JComponent)
            // showMessageDialog - Диалоговое окно с заголовком и типом сообщения
            //parent - родительское окно.
            //message - отображаемый в окне текст сообщения. 
            //title - заголовок окна.
            //messageType - тип диалогового окна
            //PLAIN_MESSAGE - стандартное диалоговое окно для вывода информации без значка.
      
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        SimpleGUI app = new SimpleGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Выход из приложения с помощью метода выхода из системы.
        app.setLocationRelativeTo(null);
        app.setSize(350, 100);
        //app.pack(); оптимальный размер окна
        //открываем окно
        app.setVisible(true);
    }
}
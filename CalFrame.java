import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

public class CalFrame extends CalLogic
{
	
   int f_one, f_two, f_thr, f_fou, f_fiv;
   JTabbedPane tabpane;
   JButton b[], bReset, bOk;      //��ư ���� 
   private String tempString;
   private JTextField jfsum, jtext;
   JButton jtf;
   JDialog info;
   public String friendName;
   int index;
   int sctindex;
   String curPaneTitle;
   int datascore;
   String dataString = new String("");
   int finalScore = 0;
   int test;
   int love;   //�������� ��� ���� 
   JFrame jf2,jf4;
   JPanel jf3;
   ImageIcon jf2_background;

   public CalFrame()
   {
      //��ư�� �� �׸����� ��ü ����
      ImageIcon ic[] = new ImageIcon[10];
      for (int i = 0; i<10; i++)
         ic[i] = new ImageIcon("b" + String.valueOf(i) + ".png");

	  JFrame jf4 = new JFrame("������ ����");
	  jf4.setLayout(new GridLayout(1,2,10,10));
	  jf4.setSize(1200, 800);
      jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JFrame jf = new JFrame("������ ����");
      jf.setLayout(new BorderLayout(5, 10));
      jf.setSize(600, 800);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();   
      
      tabpane = new JTabbedPane();

	  JPanel container = new JPanel();
	  container.setLayout(new BorderLayout(10, 10));
      JPanel namepanel = new JPanel();
      JPanel textpanel = new JPanel();
      textpanel.setLayout(new GridLayout(3, 1));
      jfsum = new JTextField(jf.getWidth());
      jfsum.setHorizontalAlignment(JTextField.LEFT);

      //������ Ȯ���ϱ� ��ư 
      jtf = new JButton("������ Ȯ���ϱ�");
      jtf.setFont(new Font("���", Font.BOLD, 20));
      jtf.setBackground(new Color(255, 217, 250));
      //������ Ȯ���ϱ� ��ư ������ �� �̺�Ʈ 
      jtf.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         int sum = f_one + f_two + f_thr + f_fou + f_fiv;
         if (sum>90)
            love = 100;
         else if (sum>70)
            love = love;
         else if (sum>50)
            love = love * 9 / 10;
         else if (sum>30)
            love = love * 6 / 10;
         else
            love = love * 4 / 10;

         //���ȭ�� �����ӿ� �� ���� ���� 
         JLabel jl2 = new JLabel(friendName + "�԰��� �������� " + love + "�Դϴ�.");
         jl2.setFont(new Font("���",Font.BOLD, 30));
         jl2.setHorizontalAlignment(JLabel.CENTER);
         jf2.add("North",jl2);
         jf2.setVisible(true);
         jf2.add(new JLabel(new ImageIcon("16.png")));
      }
         });

      //���ȭ�� ������ ���� 
      jf2 = new JFrame();
      jf2.setSize(600, 400);
      jf2.setLayout(new BorderLayout());
      jf2.setVisible(false);
      jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf2.add("Center", new MyPanel());

      //ģ�� �̸� �Է��ϴ� namepanel ����
      JLabel nameLabel = new JLabel("ģ���� �̸��� �Է����ּ���:");
      jtext = new JTextField("", 20);
      JButton namebutton = new JButton("Ȯ��");

      //Ȯ�� ��ư ������ �� �̺�Ʈ �߻�
	  
      namebutton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         friendName = jtext.getText();
         System.out.println(friendName);
      }
         });
      //namepanel�� ���̱�
      namepanel.add(nameLabel);
      namepanel.add(jtext);
      namepanel.add(namebutton);


     //���� �г� ����

     jf3 = new JPanel();
      
     jf3.setLayout(new BorderLayout());
     JPanel helperMain = new JPanel();
     JPanel helper = new JPanel();
     jf3.add("North",helperMain);
     jf3.add(helper);
     helper.setLayout(new GridLayout(2, 3, 5, 5));

     JLabel helpLabelMain = new JLabel("<html><h2><em>&hearts;Step1&hearts;</em> ģ���� �̸��� �Է��ѵ� <strong>ok</strong>��ư Ŭ��</h2><h2><em>&hearts;Step2&hearts;</em> �� ���� ���� �� ���ڸ� �Է��ϰ� <strong>�������� ok</strong>��ư Ŭ��</h2><h2><em>&hearts;Step3&hearts;</em> 1~6���� ��� �Է��� ������Ȯ���ϱ� Ŭ��</html>");
     helperMain.setBackground(Color.ORANGE);
     helperMain.add(helpLabelMain);

     JLabel helpLabel1 = new JLabel("<html><h2>1������</h2>��ü�� 20%����<br />0��: 0��<br /> 1~4��: �⺻���� 5���� <br/>1ȸ �߰��� ���� 2���߰�<br /> 5���̻�: 20��</html>");
     JLabel helpLabel2 = new JLabel("<html><h2>2������</h2>��ü�� 30%����<br />0��: 0��<br /> 1~2��: 15��<br /> 3~4��: 20��<br />5���̻�: 30��</html>");
     JLabel helpLabel3 = new JLabel("<html><h2>3������</h2>��ü�� 20%����<br />0��: 0��<br /> 1~4��: Ƚ���� ����<br /> 5���̻�: 20��<br /></html>");
     JLabel helpLabel4 = new JLabel("<html><h2>4������</h2>��ü�� 10%����<br />0��: 0��<br /> 1~4��: Ƚ�� * 2<br /> 5���̻�: 10��</html>");
     JLabel helpLabel5 = new JLabel("<html><h2>5������</h2>��ü�� 20%����<br />0~5��: 1��*Ƚ��<br /> 5�� �̻�: 5+ (Ƚ��)/3<br />45���̻�: 20��</html>");
     JLabel helpLabel6 = new JLabel("<html><h2>���� ������</h2>1~5�������� �� ���� ���� �ٸ�<br /> 90���̻�: ������100<br />71~89��: ������71~89<br />51~70��: 6������ 90%��ȯ<br />31~50��: 6������ 60%��ȯ<br />30������: 6������ 40%��ȯ</html>");
 
     helper.add(helpLabel1);
     helper.add(helpLabel2);
     helper.add(helpLabel3);
     helper.add(helpLabel4);
     helper.add(helpLabel5);
     helper.add(helpLabel6);




      //textpanel�� ���̱�
      textpanel.add(jfsum);
      textpanel.add(jtf);
      textpanel.add(namepanel);

      textpanel.add(namepanel, "NORTH");
      textpanel.add(jtf, "CENTER");
      textpanel.add(jfsum, "SOUTH");


      //1�� ����
      ImageIcon ic1 = new ImageIcon("one.png");
      JLabel j1 = new JLabel(ic1);
      //2�� ����
      ImageIcon ic2 = new ImageIcon("two.png");
      JLabel j2 = new JLabel(ic2);
      //3�� ����
      ImageIcon ic3 = new ImageIcon("three.png");
      JLabel j3 = new JLabel(ic3);
      //4�� ����
      ImageIcon ic4 = new ImageIcon("four.png");
      JLabel j4 = new JLabel(ic4);
      //5�� ����
      ImageIcon ic5 = new ImageIcon("five.png");
      JLabel j5 = new JLabel(ic5);
      //6�� ����
      ImageIcon ic6 = new ImageIcon("six.png");
      JLabel j6 = new JLabel(ic6);

      //�ǿ� �� ���� ���̱�
      tabpane.setPreferredSize(new Dimension(10, 30));
      tabpane.addTab("1������", j1);
      tabpane.addTab("2������", j2);
      tabpane.addTab("3������", j3);
      tabpane.addTab("4������", j4);
      tabpane.addTab("5������", j5);
      tabpane.addTab("6������", j6);

      //��ư�� �� �׸��巹�̾ƿ� ����
      GridLayout gl = new GridLayout(4, 3, 5, 5);

      //��ư ��ü ���� �� �̺�Ʈ ���
      b = new JButton[10];
      for (int i = 0; i<10; i++)
      {
         b[i] = new JButton(ic[i]);
         b[i].setBackground(new Color(250, 250, 250));
         b[i].addActionListener(new MyListener());//��ư���� �׼Ǹ�����
      }

      //ok,reset��ư ��ü ���� �� �̺�Ʈ ���
      bReset = new JButton("Reset");
      bOk = new JButton("OK");
      bReset.addActionListener(new MyListener());
      bOk.addActionListener(new MyListener());
      bReset.setBackground(new Color(250, 250, 250));
      bOk.setBackground(new Color(250, 250, 250));


      //��ư ���̱�
      panel3.setLayout(gl);
      for (int i = 1; i<10; i++)
         panel3.add(b[i]);

      panel3.add(bReset);
      panel3.add(b[0]);
      panel3.add(bOk);


      //�ǿ� ������ ���
      tabpane.addChangeListener(new MyListener());

      //container�� panel ���̱�
      container.add(textpanel, BorderLayout.NORTH);
      container.add(tabpane, BorderLayout.CENTER);
      container.add(panel3, BorderLayout.SOUTH);

	  //jf.add(container);
      //jf.setVisible(true);

	  jf4.add(container);
	  jf4.add(jf3);
	  jf4.setVisible(true);
   }

   ////////////////////���� change�� list selection�� �̿��� ���� �̺�Ʈ/////////////////////////////////////////////////////

   public class MyListener implements ActionListener, ChangeListener {
      public void actionPerformed(ActionEvent e) {
         for (int i = 0; i<10; i++) {
            if (e.getSource() == b[i]) {
               dataString += i; //���⿡ �Է¹������ڸ� string���·� �ٿ����ϴ�.
               jfsum.setText(jfsum.getText() + i);
               datascore = Integer.parseInt(dataString);//string�� ������ ��ȯ�߽��ϴ�.
               System.out.println("�Է°� = " + datascore);
            }
            if (dataString.length() >= 4) {
               jfsum.setText("");
               JOptionPane.showMessageDialog(null, "�Է��� �ʹ� �����߽��ϴ�. ��������� �Է��Ͻ��� ������ 0�� �帳�ϴ�. ");
               dataString = "";
               datascore = 0;
               jfsum.setText("");
            }

         }

         if (e.getSource() == bOk) {//���ڹ�ư �����ٰ� ok��ư ������ Qustion�Լ� ȣ��
            if (dataString.length() == 0) {
               JOptionPane.showMessageDialog(null, "�ƹ��͵� �Է����� �ʾҽ��ϴ�. �ٽ� �Է¾��Ͻø� 0���Դϴ�.");
               datascore = 0;
            }
            else {
               test = Question(sctindex, datascore);
               System.out.println((sctindex + 1) + "�� �׸� ������" + test);
               dataString = "";
               jfsum.setText("");
               if (sctindex == 0)
                  f_one = test;
               else if (sctindex == 1)
                  f_two = test;
               else if (sctindex == 2)
                  f_thr = test;
               else if (sctindex == 3)
                  f_fou = test;
               else if (sctindex == 4)
                  f_fiv = test;
               else if (sctindex == 5)
               {
                  love = test;

               }

               /*
               System.out.println("������� ȯ������: \n"
               + "1�� �׸�: " + f_one + "\n"
               + "2�� �׸�: " + f_two + "\n"
               + "3�� �׸�: " + f_thr + "\n"
               + "4�� �׸�: " + f_fou + "\n"
               + "5�� �׸�: " + f_fiv + "\n"
               + "������ �� : " + love);
               */

            }
         }

         if (e.getSource() == bReset) {
            dataString = "";
            jfsum.setText("");
         }


      }




      public void stateChanged(ChangeEvent che) {//�� ����� �۾� ���� �ڵ�
         sctindex = tabpane.getSelectedIndex();

         curPaneTitle = tabpane.getTitleAt(sctindex);
         System.out.println(curPaneTitle + "�� ������");
      }

   }

   class MyPanel extends JPanel {
      protected void paintComponent(Graphics g) {

         g.setColor(Color.YELLOW);
         int xstar1[] = { 60,40,5,30,20,60 };
         int xstar1_2[] = { 60,80,115,90,100,60 };
         int ystar[] = { 60,90,90,115,150,130 };


         int xstar2[] = { 170,150,115,140,130,170 };//110 ����
         int xstar2_2[] = { 170,190,225,200,210,170 };

         int xstar3[] = { 280,260,225,250,240,280 };
         int xstar3_2[] = { 280,300,335,310,320,280 };

         int xstar4[] = { 390,370,335,360,350,390 };
         int xstar4_2[] = { 390,410,445,420,430,390 };

         int xstar5[] = { 500,480,445,470,460,500 };
         int xstar5_2[] = { 500,520,555,530,540,500 };

         if (love> 0)
            g.fillPolygon(xstar1, ystar, 6);
         if (love > 10)
            g.fillPolygon(xstar1_2, ystar, 6);
         if (love > 30)
            g.fillPolygon(xstar2, ystar, 6);
         if (love > 40)
            g.fillPolygon(xstar2_2, ystar, 6);
         if (love > 50)
            g.fillPolygon(xstar3, ystar, 6);
         if (love > 60)
            g.fillPolygon(xstar3_2, ystar, 6);
         if (love > 70)
            g.fillPolygon(xstar4, ystar, 6);
         if (love > 80)
            g.fillPolygon(xstar4_2, ystar, 6);
         if (love > 90)
            g.fillPolygon(xstar5, ystar, 6);
         if (love == 100)
            g.fillPolygon(xstar5_2, ystar, 6);


      }
   }
}
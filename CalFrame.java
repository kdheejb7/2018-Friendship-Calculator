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
   JButton b[], bReset, bOk;      //버튼 구현 
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
   int love;   //우정도를 담는 변수 
   JFrame jf2,jf4;
   JPanel jf3;
   ImageIcon jf2_background;

   public CalFrame()
   {
      //버튼에 들어갈 그림들의 객체 생성
      ImageIcon ic[] = new ImageIcon[10];
      for (int i = 0; i<10; i++)
         ic[i] = new ImageIcon("b" + String.valueOf(i) + ".png");

	  JFrame jf4 = new JFrame("우정도 계산기");
	  jf4.setLayout(new GridLayout(1,2,10,10));
	  jf4.setSize(1200, 800);
      jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JFrame jf = new JFrame("우정도 계산기");
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

      //우정도 확인하기 버튼 
      jtf = new JButton("우정도 확인하기");
      jtf.setFont(new Font("고딕", Font.BOLD, 20));
      jtf.setBackground(new Color(255, 217, 250));
      //우정도 확인하기 버튼 눌렀을 때 이벤트 
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

         //결과화면 프레임에 들어갈 내용 구현 
         JLabel jl2 = new JLabel(friendName + "님과의 우정도는 " + love + "입니다.");
         jl2.setFont(new Font("고딕",Font.BOLD, 30));
         jl2.setHorizontalAlignment(JLabel.CENTER);
         jf2.add("North",jl2);
         jf2.setVisible(true);
         jf2.add(new JLabel(new ImageIcon("16.png")));
      }
         });

      //결과화면 프레임 설계 
      jf2 = new JFrame();
      jf2.setSize(600, 400);
      jf2.setLayout(new BorderLayout());
      jf2.setVisible(false);
      jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf2.add("Center", new MyPanel());

      //친구 이름 입력하는 namepanel 구현
      JLabel nameLabel = new JLabel("친구의 이름을 입력해주세요:");
      jtext = new JTextField("", 20);
      JButton namebutton = new JButton("확인");

      //확인 버튼 눌렀을 때 이벤트 발생
	  
      namebutton.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
         friendName = jtext.getText();
         System.out.println(friendName);
      }
         });
      //namepanel에 붙이기
      namepanel.add(nameLabel);
      namepanel.add(jtext);
      namepanel.add(namebutton);


     //도움말 패널 설계

     jf3 = new JPanel();
      
     jf3.setLayout(new BorderLayout());
     JPanel helperMain = new JPanel();
     JPanel helper = new JPanel();
     jf3.add("North",helperMain);
     jf3.add(helper);
     helper.setLayout(new GridLayout(2, 3, 5, 5));

     JLabel helpLabelMain = new JLabel("<html><h2><em>&hearts;Step1&hearts;</em> 친구의 이름을 입력한뒤 <strong>ok</strong>버튼 클릭</h2><h2><em>&hearts;Step2&hearts;</em> 각 탭을 누른 뒤 숫자를 입력하고 <strong>숫자판의 ok</strong>버튼 클릭</h2><h2><em>&hearts;Step3&hearts;</em> 1~6번을 모두 입력후 우정도확인하기 클릭</html>");
     helperMain.setBackground(Color.ORANGE);
     helperMain.add(helpLabelMain);

     JLabel helpLabel1 = new JLabel("<html><h2>1번문제</h2>전체의 20%비중<br />0개: 0점<br /> 1~4번: 기본점수 5점에 <br/>1회 추가시 마다 2점추가<br /> 5번이상: 20점</html>");
     JLabel helpLabel2 = new JLabel("<html><h2>2번문제</h2>전체의 30%비중<br />0번: 0점<br /> 1~2번: 15점<br /> 3~4번: 20점<br />5번이상: 30점</html>");
     JLabel helpLabel3 = new JLabel("<html><h2>3번문제</h2>전체의 20%비중<br />0번: 0점<br /> 1~4번: 횟수의 제곱<br /> 5번이상: 20점<br /></html>");
     JLabel helpLabel4 = new JLabel("<html><h2>4번문제</h2>전체의 10%비중<br />0번: 0점<br /> 1~4번: 횟수 * 2<br /> 5번이상: 10점</html>");
     JLabel helpLabel5 = new JLabel("<html><h2>5번문제</h2>전체의 20%비중<br />0~5번: 1점*횟수<br /> 5번 이상: 5+ (횟수)/3<br />45번이상: 20점</html>");
     JLabel helpLabel6 = new JLabel("<html><h2>최종 우정도</h2>1~5번문제의 총 점에 따라 다름<br /> 90점이상: 우정도100<br />71~89점: 우정도71~89<br />51~70점: 6번값의 90%반환<br />31~50점: 6번값의 60%반환<br />30점이햐: 6번값의 40%반환</html>");
 
     helper.add(helpLabel1);
     helper.add(helpLabel2);
     helper.add(helpLabel3);
     helper.add(helpLabel4);
     helper.add(helpLabel5);
     helper.add(helpLabel6);




      //textpanel에 붙이기
      textpanel.add(jfsum);
      textpanel.add(jtf);
      textpanel.add(namepanel);

      textpanel.add(namepanel, "NORTH");
      textpanel.add(jtf, "CENTER");
      textpanel.add(jfsum, "SOUTH");


      //1번 문제
      ImageIcon ic1 = new ImageIcon("one.png");
      JLabel j1 = new JLabel(ic1);
      //2번 문제
      ImageIcon ic2 = new ImageIcon("two.png");
      JLabel j2 = new JLabel(ic2);
      //3번 문제
      ImageIcon ic3 = new ImageIcon("three.png");
      JLabel j3 = new JLabel(ic3);
      //4번 문제
      ImageIcon ic4 = new ImageIcon("four.png");
      JLabel j4 = new JLabel(ic4);
      //5번 문제
      ImageIcon ic5 = new ImageIcon("five.png");
      JLabel j5 = new JLabel(ic5);
      //6번 문제
      ImageIcon ic6 = new ImageIcon("six.png");
      JLabel j6 = new JLabel(ic6);

      //탭에 각 문제 붙이기
      tabpane.setPreferredSize(new Dimension(10, 30));
      tabpane.addTab("1번문제", j1);
      tabpane.addTab("2번문제", j2);
      tabpane.addTab("3번문제", j3);
      tabpane.addTab("4번문제", j4);
      tabpane.addTab("5번문제", j5);
      tabpane.addTab("6번문제", j6);

      //버튼이 들어갈 그리드레이아웃 생성
      GridLayout gl = new GridLayout(4, 3, 5, 5);

      //버튼 객체 생성 및 이벤트 등록
      b = new JButton[10];
      for (int i = 0; i<10; i++)
      {
         b[i] = new JButton(ic[i]);
         b[i].setBackground(new Color(250, 250, 250));
         b[i].addActionListener(new MyListener());//버튼마다 액션리스너
      }

      //ok,reset버튼 객체 생성 및 이벤트 등록
      bReset = new JButton("Reset");
      bOk = new JButton("OK");
      bReset.addActionListener(new MyListener());
      bOk.addActionListener(new MyListener());
      bReset.setBackground(new Color(250, 250, 250));
      bOk.setBackground(new Color(250, 250, 250));


      //버튼 붙이기
      panel3.setLayout(gl);
      for (int i = 1; i<10; i++)
         panel3.add(b[i]);

      panel3.add(bReset);
      panel3.add(b[0]);
      panel3.add(bOk);


      //탭에 리스더 등록
      tabpane.addChangeListener(new MyListener());

      //container에 panel 붙이기
      container.add(textpanel, BorderLayout.NORTH);
      container.add(tabpane, BorderLayout.CENTER);
      container.add(panel3, BorderLayout.SOUTH);

	  //jf.add(container);
      //jf.setVisible(true);

	  jf4.add(container);
	  jf4.add(jf3);
	  jf4.setVisible(true);
   }

   ////////////////////탭은 change나 list selection을 이용한 스윙 이벤트/////////////////////////////////////////////////////

   public class MyListener implements ActionListener, ChangeListener {
      public void actionPerformed(ActionEvent e) {
         for (int i = 0; i<10; i++) {
            if (e.getSource() == b[i]) {
               dataString += i; //여기에 입력받은숫자를 string형태로 붙였습니다.
               jfsum.setText(jfsum.getText() + i);
               datascore = Integer.parseInt(dataString);//string을 정수로 변환했습니다.
               System.out.println("입력값 = " + datascore);
            }
            if (dataString.length() >= 4) {
               jfsum.setText("");
               JOptionPane.showMessageDialog(null, "입력을 너무 많이했습니다. 양심적으로 입력하시지 않으면 0점 드립니다. ");
               dataString = "";
               datascore = 0;
               jfsum.setText("");
            }

         }

         if (e.getSource() == bOk) {//숫자버튼 누르다가 ok버튼 누르면 Qustion함수 호출
            if (dataString.length() == 0) {
               JOptionPane.showMessageDialog(null, "아무것도 입력하지 않았습니다. 다시 입력안하시면 0점입니다.");
               datascore = 0;
            }
            else {
               test = Question(sctindex, datascore);
               System.out.println((sctindex + 1) + "번 항목 점수는" + test);
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
               System.out.println("현재까지 환산점수: \n"
               + "1번 항목: " + f_one + "\n"
               + "2번 항목: " + f_two + "\n"
               + "3번 항목: " + f_thr + "\n"
               + "4번 항목: " + f_fou + "\n"
               + "5번 항목: " + f_fiv + "\n"
               + "우정도 합 : " + love);
               */

            }
         }

         if (e.getSource() == bReset) {
            dataString = "";
            jfsum.setText("");
         }


      }




      public void stateChanged(ChangeEvent che) {//탭 변경시 작업 내용 코딩
         sctindex = tabpane.getSelectedIndex();

         curPaneTitle = tabpane.getTitleAt(sctindex);
         System.out.println(curPaneTitle + "를 선택함");
      }

   }

   class MyPanel extends JPanel {
      protected void paintComponent(Graphics g) {

         g.setColor(Color.YELLOW);
         int xstar1[] = { 60,40,5,30,20,60 };
         int xstar1_2[] = { 60,80,115,90,100,60 };
         int ystar[] = { 60,90,90,115,150,130 };


         int xstar2[] = { 170,150,115,140,130,170 };//110 더함
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
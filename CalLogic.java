import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalLogic 
{      
   
   public CalLogic(){
   }

   public int Question(int getindex, int answer){//getindex�� �����ε���, answer���� datascore�� �μ��� �ִ´�.
      
     if(getindex ==0){////////////////1�� ���� �濪��///////////////////////
         if(answer == 0){
            return 0;
         }
         else if(answer >= 1 && answer <= 4){
            return 5 + 2 * answer;
         }
         else{
            return 20;
         }      
      }

      else if(getindex ==1){////////////////2�� ���� ���� Ƚ��///////////////////////
         if(answer== 0){
            return  0;
         }
         else if(answer >= 1 && answer <= 2){
            return  15;
         }
         else if(answer >= 3 && answer <= 4){
            return  20;
         }
         else{
            return  30;
         }
      }

      else if(getindex ==2){////////////////3�� ���� ���� ì���� Ƚ��//////////////////////
         if(answer == 0){
            return 0;
         }
         else if(answer >= 1 && answer <= 4){
            return answer * answer;
         }
         else{
            return 20;
         }
      }

      else if(getindex ==3){////////////////4�� ���� ��ȭ���� ����//////////////////////
         if(answer >= 0 && answer <= 4){
            return 2 * answer;
         }
         else{
            return 10;
         }
      }     

      else if(getindex ==4){////////////////5�� ���� �� ���� ���� Ƚ��///////////////////////
         if(answer >= 0 && answer <= 5){
            return answer;
         }
         else if(answer < 45){
            return 5 + answer/3;
         }

       else
          return 20;
      }
	  else if (getindex ==5)
	  {
		  return answer;
	  }

      return 0;
   }
}
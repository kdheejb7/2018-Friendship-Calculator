import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalLogic 
{      
   
   public CalLogic(){
   }

   public int Question(int getindex, int answer){//getindex는 탭의인덱스, answer에는 datascore를 인수로 넣는다.
      
     if(getindex ==0){////////////////1번 문제 흑역사///////////////////////
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

      else if(getindex ==1){////////////////2번 문제 여행 횟수///////////////////////
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

      else if(getindex ==2){////////////////3번 문제 생일 챙겨준 횟수//////////////////////
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

      else if(getindex ==3){////////////////4번 문제 인화사진 개수//////////////////////
         if(answer >= 0 && answer <= 4){
            return 2 * answer;
         }
         else{
            return 10;
         }
      }     

      else if(getindex ==4){////////////////5번 문제 밥 같이 먹은 횟수///////////////////////
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
package com.quiz;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.quiz.bean.Difficulty;
import com.quiz.bean.QuestionType;
import com.quiz.bean.Quiz;
import com.quiz.bean.QuizBean;
import com.quiz.bean.Topic;
import com.quiz.dao.QuestionDAO;
import com.quiz.dao.QuizDAO;
import com.quiz.dao.UserDAO;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
  
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Who are you? Enter the number: \n 1. Professor \n 2. Student\n input your answer(1,2):");
        int input = Integer.parseInt(scan.nextLine());
    	if(input==1) {
    		System.out.print("Enter your userId:");
             String userid = scan.nextLine();
             System.out.print("Enter your password:");
             String pass = scan.nextLine();
    		 UserDAO userDAO = new UserDAO();
    		 boolean isValidUser = userDAO.isValidUser(userid,pass);
    		 if(isValidUser) {
    				System.out.print("Which operation you want to perform? Enter the number: \n 1. Create new Quiz \n 2. Create a topic\n 3. Create a question\\n input your answer( Allowed choices 1, 2 or 3):");
    			     int option = Integer.parseInt(scan.nextLine());
    			     switch(option) {
    			     case 1: 
    			    	  System.out.print("Enter quiz name:");
    			             String quizName = scan.nextLine();
    			             QuizDAO quizDAO = new QuizDAO();
    			             quizDAO.createQuiz(quizName);
    			             System.out.println("Quiz created successfully!Exiting...");
    			             break;
    			     case 2:
    			    	 System.out.print("Enter topic name:");
			             String topic = scan.nextLine();
			              quizDAO = new QuizDAO();
			             quizDAO.createTopic(topic);
			             System.out.println("Topic created successfully!Exiting...");
	    			         break;
    			     case 3:
    			    	 quizDAO = new QuizDAO();
			             List<Topic> topicList = quizDAO.getTopics();
			             System.out.println("Listed topics are:");
			             for(Topic topicinput:topicList) {
			            	 System.out.println(topicinput.getId() +". "+topicinput.getTopicName());
			             }
    			    	 System.out.print("Enter topic number:");
			             int topicId = Integer.parseInt(scan.nextLine());
			             
			             System.out.println("Listed difficulties are:");
					             
			             List<Difficulty> difficultyList = quizDAO.getDifficulties();
			             for(Difficulty difficultyinput:difficultyList) {
			            	 System.out.println(difficultyinput.getId() +". "+difficultyinput.getName());
			             }
    			    	 System.out.print("Enter difficulty number:");
			             int difficultyId = Integer.parseInt(scan.nextLine());
			            
			             
			             System.out.println("Listed quizes are:");
					       
			             List<Quiz> quizList = quizDAO.getQuizList();
			             for(Quiz quizinput:quizList) {
			            	 System.out.println(quizinput.getId() +". "+quizinput.getName());
			             }
    			    	 System.out.print("Enter quiz number:");
			             int quizId = Integer.parseInt(scan.nextLine());
			            
			             System.out.println("Listed question types are:");
						    
			             List<QuestionType> qList = quizDAO.getQuestionType();
			             for(QuestionType qinput:qList) {
			            	 System.out.println(qinput.getId() +". "+qinput.getType());
			             }
    			    	 System.out.print("Enter question type number:");
			             int questionTypeId = Integer.parseInt(scan.nextLine());
			            
			             System.out.print("Enter question detail:");
			             String questionDescription = scan.nextLine();
			             
			             System.out.println("Enter choice detail:");
			             String[] choice = new String[4];
			             System.out.print("1. ");
			             choice [0] = scan.nextLine();
			             System.out.print("2. ");
			             choice [1] = scan.nextLine();
			             System.out.print("3. ");
			             choice [2] = scan.nextLine();
			             System.out.print("4. ");
			             choice [3] = scan.nextLine();
			             System.out.print("Enter sequence# of correct answer: ");
			             int correctanswer = Integer.parseInt(scan.nextLine());
			             
			             QuestionDAO questionDAO = new QuestionDAO();
			             questionDAO.createQuestion( questionDescription,  quizId,  questionTypeId,  difficultyId,  topicId, choice,  correctanswer);
			              
			             break;
			            default:
			            	System.out.println("Invalid entry!!!");
    			     }
    	        
    		 }else {
    			 System.out.println("Sorry! We failed to recognize you.");
    			 
    			 
    		 }
    	} else if(input==2) {
    		//student
    	     System.out.println("Listed quizes are:");
    	     QuizDAO quizDAO = new QuizDAO();
             List<Quiz> quizList = quizDAO.getQuizList();
             for(Quiz quizinput:quizList) {
            	 System.out.println(quizinput.getId() +". "+quizinput.getName());
             }
	    	 System.out.print("Enter quiz number you want to play:");
             int quizId = Integer.parseInt(scan.nextLine());
        	List<QuizBean> quizlist = quizDAO.getQuiz(quizId);
        	System.out.println("Quiz Starting now... ");
        	int scoredmcq = 0;
        	int totalmcq = 0;
        	int totalopenq = 0;
        	if(quizlist.size()==0)
        		System.out.println("Sorry this quiz does not contain any question, please contact your professor.");
        	else {
        	for(QuizBean quizBean: quizlist) {
        		if(quizBean.getQuestionType() == 1) {
        			totalmcq++;
                  	 System.out.println(quizBean.getDescription() + "\n 1. "+ quizBean.getOption()[0] +"\t 2. "+ quizBean.getOption()[1]+ "\n 3. "+ quizBean.getOption()[2] +"\t 4. "+ quizBean.getOption()[3] );
                  	 System.out.print("Enter your choice:");
                     int answer = Integer.parseInt(scan.nextLine());
                     if(answer == quizBean.getCorrectAnswer()) {
                    	 scoredmcq++;
                     }
               	}
               		else if(quizBean.getQuestionType() == 2) {
               			totalopenq++;	
               		 System.out.println(quizBean.getDescription());
               	     String answeropen =scan.nextLine();
               		} else {
               			System.out.println("Invalid entry! Bye!!!");
               		}
       	           
        		}
        	
        	
        	System.out.println(" Total question asked: " +quizlist.size()+ "\n Total MCQ: "+ totalmcq+"\n You scored: "+scoredmcq+"\n Total open questions asked(Will be scored later): "+totalopenq);
        	System.out.println(" Quiz Over, Thank you!");
        		
        	}
    	}else {
    		System.out.println("Invalid entry, try again!");
    	}
    	
    }
     
  
}

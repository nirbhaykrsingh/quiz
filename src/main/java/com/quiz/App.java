package com.quiz;

import java.util.List;

import com.quiz.bean.QuizBean;
import com.quiz.dao.QuestionDAO;
import com.quiz.dao.QuizDAO;
import com.quiz.dao.UserDAO;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
  // UserDAO userDAO = new UserDAO();
  // boolean isValidUser = userDAO.isValidUser("Nirbhay", "welcome");
    	
    	QuizDAO quizDAO = new QuizDAO();
    	List<QuizBean> quizlist = quizDAO.getQuiz("Quiz1");
    	//String choice[] = new String[] {"Coffee","Language","Both","None"};
  //  QuestionDAO questionDAO = new QuestionDAO();
   // questionDAO.createQuestion("Who was Mahatma Gandhi?", 1, 2, 1, 1, choice, 3);
    	for(QuizBean quizBean: quizlist)
    		 System.out.println(quizBean.getDescription() + " "+ quizBean.getCorrectAnswer());
    }
        
}

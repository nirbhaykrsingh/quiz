package com.quiz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.quiz.bean.QuizBean;

public class QuizDAO extends DAO{

	public QuizDAO() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

public void createQuiz(String quizName) throws SQLException, ClassNotFoundException{
        stat.execute("insert into quiz values(quiz_seq_id.nextval,'"+quizName+"')");
}

public void createTopic(String topicName) throws SQLException, ClassNotFoundException{
    stat.execute("insert into topic values(topic_seq_id.nextval,'"+topicName+"')");
}
public List<QuizBean> getQuiz(String quizName) throws SQLException {
	 rs = stat.executeQuery("select distinct  questiontype, description,difficulty.name as difficulty ,topic.name as topic,Null as option1, Null as option2,Null as option3, null as option4, "
	 		+ "null as correctanswer  from question, mcqquestiontype, difficulty,topic where question.difficulty=difficulty.id  and question.topic=topic.id and "
	 		+ "quiz = (select id from quiz where name='"+quizName+"') and questiontype=2 union  select distinct  questiontype,"
	 				+ " description,difficulty.name as difficulty, topic.name as topic,option1,option2,option3,option4, correctanswer from question,"
	 				+ " mcqquestiontype, difficulty, topic where question.difficulty=difficulty.id and  question.topic=topic.id and quiz = (select id from"
	 				+ " quiz where name='"+quizName+"') and question.id=mcqquestiontype .questionid and question.questiontype=1;");
	 List<QuizBean> quizList= new ArrayList<QuizBean>();
	 while(rs.next()){
	 QuizBean quizBean = new QuizBean();
	 quizBean.setDescription(rs.getString("description"));
	 quizBean.setQuestionType(rs.getInt("questionType"));
	 quizBean.setDifficulty(rs.getString("difficulty"));
	 quizBean.setTopic(rs.getString("topic"));
	 if(quizBean.getQuestionType() ==1) {
		 String []option = new String[] {rs.getString("option1"),rs.getString("option2"),rs.getString("option3"),rs.getString("option4")};
		 quizBean.setOption(option);
	 quizBean.setCorrectAnswer(rs.getString("correctanswer"));
	 }
	 quizList.add(quizBean); 
	 }
	 return quizList;
}
}

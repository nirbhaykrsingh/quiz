package com.quiz.bean;

public class QuizBean {
int questionType=0;
String description = null;
String difficulty = null;
String topic = null; 
String option[] = null;
String correctAnswer = null;
public int getQuestionType() {
	return questionType;
}
public void setQuestionType(int questionType) {
	this.questionType = questionType;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDifficulty() {
	return difficulty;
}
public void setDifficulty(String difficulty) {
	this.difficulty = difficulty;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public String[] getOption() {
	return option;
}
public void setOption(String[] option) {
	this.option = option;
}
public String getCorrectAnswer() {
	return correctAnswer;
}
public void setCorrectAnswer(String correctAnswer) {
	this.correctAnswer = correctAnswer;
}


}
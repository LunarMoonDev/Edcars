package Utility;

import java.sql.Connection;

import Model.faqsBean;

public class faqsInsertionBeanFactory {
	public static void getBean(Connection connection, String question, String answer){
		faqsBean bean = new faqsBean();
		bean.setAnswerFaqs(answer);
		bean.setQuestionFaqs(question);
		bean.insert(connection);
	}
}

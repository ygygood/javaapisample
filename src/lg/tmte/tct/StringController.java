package lg.tmte.tct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringController {
	
	public void start() {
		dateToString();
	}
	// ���Խ� 
	public void regexStr() {
		String str = "abcdefg123456!@#$%^ABCDE";
		String regexDigit = "[0-9]";
		String regexSp = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String regexUpper = "[A-Z]";
		
		//���� ���ڿ� ����
		System.out.println(str.replaceAll(regexDigit,""));
		
		//Ư������ ����
		System.out.println(str.replaceAll(regexSp,""));
		
		//�빮�� ����
		System.out.println(str.replaceAll(regexUpper, ""));
		
		//���ڿ��� ���� �ִ��� Ȯ��
		String regexDigitCheck = "^[0-9]+$";
		System.out.println(str.matches(regexDigitCheck));  // true
	}
	/* ��¥��� */
	public void dateToString() {
		String dateStr = "2020-06-29";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = transFormat.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 2);
			System.out.println(date);			// Mon Jun 29 00:00:00 KST 2020
			System.out.println(cal.getTime());	// Wed Jul 01 00:00:00 KST 2020
			String strDate = transFormat.format(cal.getTime());
			System.out.println(strDate);		//	2020-07-01
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* ���ڿ� �� */
	public void compareToString() {
		String str1 = "a";
		String str2 = "b";
		if(str1.compareTo(str2)>0)	System.out.println(str1);
		else if(str1.compareTo(str2)==0)	System.out.println("same");
		else System.out.println(str2);
	}
	/* char[] to String */
	public void copyCharArrToString() {
		char[] chars = {'b','c','a'};
		System.out.println(String.copyValueOf(chars));
	}
	public static void main(String[] args) {
		new StringController().start();
	}
}


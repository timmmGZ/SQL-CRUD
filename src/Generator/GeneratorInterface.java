package Generator;

import java.util.Date;
import java.util.Random;

public interface GeneratorInterface {
	static final Random RANDOM = new Random();
	static final int ZERO = '0';
	static final Date TODAY = new Date();
	static final int YEAR_BACK = 60;
	static final int YEARS_COUNT = 40;
	static final int MONTH_START = 1;
	static final int MONTHS_IN_YEAR = 12;
	static final int DAY_START = 1;
	static final int DAYS_IN_MONTH = 28;
	final static String[] FOR_NAME = { "Zhao", "Qian", "Sun", "Li", "Zhou", "Wu", "Zheng", "Chen", "Zhu", "Wei", "Jiang",
			"Shen", "Han", "Yang", "Qin", "You", "Xu", "He", "Lu", "Shi", "Zhang", "Kong", "Cao", "Yan", "Hua", "Jin",
			"Tao", "Jiang", "Qi", "Xie", "Zhuo", "Yu", "Bai", "Shui", "Dou", "Yun", "Su", "Pan", "Ga", "Xi", "Fan",
			"Peng", "Lang", "Lu", "Wei", "Chang", "Ma", "Miao", "Feng", "Hua", "Fang", "Ren", "Yuan", "Liu", "Bao",
			"Tang", "Fei", "Lian", "Xue", "Lei", "He", "Mi", "Tang", "Teng", "Xin", "Luo", "Bi", "An", "Le", "Fu", "Pi",
			"Kang", "Bo", "Gu", "Meng", "Ping", "Huang", "Mu", "Xiao", "Yi", "Yao", "Zhan", "Wang", "Mao", "Di", "Bei",
			"Ming", "Jian", "Ji", "Fu", "Cheng", "Dai", "Tan", "Song", "Pang", "Xiong", "Shu", "Qu", "Xiang", "Dong",
			"Liang", "Du", "Lan", "Min" };

	
	final String SUBJECT_NAME[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l" };
	final String DEPARTMENT_NAME[] = { "IT", "Art", "History", "Physics", "Chemistry", "Management", "Polity",
			"Biology", "Music", "Math" };

}

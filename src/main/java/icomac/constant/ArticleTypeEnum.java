package icomac.constant;

/**
 * ArticleTypeEnum
 * 
 * @author IComac
 * @date 2019-04-13
 */
public enum ArticleTypeEnum {
	
	JAVA(1),
	DUBBO(2),
	SPRING(4),
	MYBATIS(8);
	
	private int code;
	
	ArticleTypeEnum(int code) {
		// TODO 自动生成的构造函数存根
		this.code = code;
	}
	
	public int code() {
		return code;
	}
	
	public static ArticleTypeEnum find(int code) {
		for(ArticleTypeEnum at : ArticleTypeEnum.values()) {
			if (at.code == code) {
				return at;
			}
		}
		return null;
	}
}

//package pars;

public class index {
	public static void main(String[] args) {
		parser p =new parser();
		postfix pf=new postfix();
		pf.post(p.parse());
	}

}

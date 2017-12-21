package inter;

import lexer.*; import symbols.*;

public class Op extends Expr {
	public Op(Token tok, Type p)  { super(tok, p); }

	/**
	 * 调用gen来生成一个项，生成一个指令把这个项
	 * 赋值给一个新的临时名字，并返回这个临时名字
	 */
	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit( t.toString() + " = " + x.toString() );
		return t;
	}
}
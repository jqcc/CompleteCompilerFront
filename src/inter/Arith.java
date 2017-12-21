package inter;

import lexer.*; import symbols.*;

/**
 * 双目运算符
 * 
 */
public class Arith extends Op {
	public Expr expr1, expr2;

	/**
	 * 类型转换检查
	 * @param tok
	 * @param x1 表达式1
	 * @param x2 表达式2
	 */
	public Arith(Token tok, Expr x1, Expr x2)  {
		super(tok, null); expr1 = x1; expr2 = x2;
		type = Type.max(expr1.type, expr2.type);
		// 简单类型检查，但没有做类型转换代码
		if (type == null ) error("type error");
	}

	public Expr gen() {
		return new Arith(op, expr1.reduce(), expr2.reduce());
	}

	public String toString() {
		return expr1.toString()+" "+op.toString()+" "+expr2.toString();
	}
}

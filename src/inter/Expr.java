package inter;

import lexer.*; import symbols.*;

public class Expr extends Node {
	public Token op;
	public Type type;

	Expr(Token tok, Type p) { op = tok; type = p; }
	
	/**
	 * 返回一个项，该项可以成为一个三地址指令的右部。给定一个表达式E=E1+E2
	 * 方法gen返回一个项x1+x2，其中x1和x2分别是存放E1和E2值的地址。如果
	 * 这个对象是一个地址，就可以返回this值。Expr的子类通常会重新实现gen
	 * @return
	 */
	public Expr gen() { return this; }
	
	/**
	 * 把一个表达式计算成为一个单一的地址。也就是说，塌返回一个常量、标识符、
	 * 或者一个临时名字。给定一个表达式E，方法reduce返回一个存放E的值的临
	 * 时变量t。如果这个对象是一个地址，那么this仍然是正确的返回值。
	 * @return
	 */
	public Expr reduce() { return this; }

	public void jumping(int t, int f) { emitjumps(toString(), t, f); }

	/**
	 * 布尔表达式生成跳转代码
	 * @param test
	 * @param t ture时出口的标号
	 * @param f false时出口的标号
	 */
	public void emitjumps(String test, int t, int f) {
		if( t != 0 && f != 0 ) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		}
		else if( t != 0 ) emit("if " + test + " goto L" + t);
		else if( f != 0 ) emit("iffalse " + test + " goto L" + f);
		else ; // 不生成指令，因为t和f都直接穿越
	}
	public String toString() { return op.toString(); }
}

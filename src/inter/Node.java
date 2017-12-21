package inter;

import lexer.*;

public class Node {
	int lexline = 0; // 本结点对应的构造在源程序中的行号

	Node() { lexline = Lexer.line; }

	void error(String s) { throw new Error("near line "+lexline+": "+s); }

	// 生成三地址码
	static int labels = 0;
	public int newlabel() { return ++labels; }
	/**
	 * 输出一个label标号
	 * @param i 标号的值
	 */
	public void emitlabel(int i) { System.out.print("L" + i + ":"); }
	/**
	 * 输出一个字符串
	 * @param s 要输出的值
	 */
	public void emit(String s) { System.out.println("\t" + s); }
}